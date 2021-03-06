//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2019   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package com.evolutionary.operator.replacement;

import com.evolutionary.Genetic;
import com.evolutionary.population.MultiPopulation;
import com.evolutionary.population.Population;
import com.evolutionary.problem.Individual;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created on 17/abr/2019, 12:15:55
 *
 * @author zulu - computer
 */
public class ClearingBest extends Replacement {

    @Override
    public Population execute(Population parents, Population offspring) {
        //size of population
        int SIZE = parents.getMaximumSize();
        //join population  
        parents.addAll(offspring.getIndividualsList());
        //list of individuals - no duplicates
        List<Individual> inds;
        if (parents instanceof MultiPopulation) {
            inds = parents.getGenomes();
        } else {
            //list of individuals - no duplicates - HASH SET
            inds = new ArrayList<>(new HashSet<>(parents.getGenomes()));
        }

        //sort descending
        Collections.shuffle(inds, random); // randomize elements
        Collections.sort(inds);    // sort is stable so shuffle is necessary
        Collections.reverse(inds); // descencding order
        //new population  
        parents.clear();
        //clear similars 
        while (parents.getPopulationSize() < SIZE) {
            //select winner
            Individual winner = inds.remove(0); // best in the list (sorted list)
            // add winner to population            
            parents.addIndividual(winner, winner.getNumberOfCopies());
            //remove similar 
            if (parents.getPopulationSize() + inds.size() > SIZE) {
                //remove most similar
                removeMostSimilar(inds, winner);
            } else {
                //insert the remains individuals
                for (Individual ind : inds) {
                    parents.addIndividual(ind, ind.getNumberOfCopies());
                }
                break;
            }
        }

        return parents;
    }

    public void removeMostSimilar(List<Individual> pop, Individual winner) {
        //most similar is the first    
        Individual similar = pop.get(0);
        double dist, minDist = winner.distanceTo(similar);
        //calculate most similar
        for (int i = 1; i < pop.size(); i++) {
            dist = similar.distanceTo(pop.get(i));
            if (dist <= minDist) {// distance is smaller  (and is worst because pop is sorted)
                //save most similar  
                minDist = dist;
                similar = pop.get(i);
            }
        }
        //remove most similar
        pop.remove(similar);
    }

    @Override
    public String getInformation() {
        StringBuilder txt = new StringBuilder(Genetic.getFullName(this));

        txt.append("\nReplaces a generation using Clearing \n");
        txt.append("\n");
        txt.append("\n//join pupulations, Shuffle and sort by descending order");
        txt.append("\nallPop =  parents + offspring");
        txt.append("\nallPop.shuffle()");
        txt.append("\nallPop.sortDescending()");
        txt.append("\n");
        txt.append("\nnewPop = empty population");
        txt.append("\n");
        txt.append("\n//selecet  parents.size genotypes");
        txt.append("\nWhile newPop.size < parents.size ");
        txt.append("\n    winner = allPop.removeFirst()");
        txt.append("\n    newPop.add(winner)");        
        txt.append("\n    if newPop.size + allPop.size > parent.size");
        txt.append("\n        looser =  allPop.mostSimilar(winner)");
        txt.append("\n        allPop.remove(looser)");
        txt.append("\n");
        txt.append("\nreturn newPop");

        return txt.toString();
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201904171215L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2019  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
