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

import com.evolutionary.population.Population;
import com.evolutionary.population.SimplePopulation;
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
public class ClearingRandom extends Replacement {

    @Override
    public Population execute(Population parents, Population offspring) {
        //size of population
        int SIZE = parents.getMaximumSize();
        //join population  
        parents.addAll(offspring.getIndividualsList());
        //SET of individuals - eliminate duplicates 
        List<Individual> inds = new ArrayList<>(new HashSet<>(parents.getGenomes()));        
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        // join  similars individuals
        // while there are excess of genomes
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        double dist, minDist;
        int similar, pivot;
        while (inds.size() > SIZE) {
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            // 1 - get pair of similar individuals 
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::            
            // 1.1 - select random  pivot
            pivot = random.nextInt(inds.size());
            // 1.2 - select most similar to pivot
            similar = -1;
            minDist = Double.POSITIVE_INFINITY;
            for (int index = 0; index < inds.size(); index++) {
                //2.1 calculate distance between  pivot and current individual
                dist = inds.get(pivot).distanceTo(inds.get(index));
                //update minimal distance
                if (pivot != index && dist < minDist) {
                    minDist = dist;
                    similar = index;
                }
            }
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            //2 - Join most similar
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            // 2.1 - increase copies of the best            
            int copies = inds.get(pivot).getNumberOfCopies()
                    + inds.get(similar).getNumberOfCopies();
            // 2.2 - kill the looser            
            if (inds.get(pivot).compareTo(inds.get(similar)) > 0) {
                inds.get(pivot).setNumberOfCopies(copies);
                inds.remove(similar);
            } else {
                inds.get(similar).setNumberOfCopies(copies);
                inds.remove(pivot);
            }
        }
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        // convert list of individuals to population
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        //new population  
        parents.clear();
        // add individuals
        for (Individual ind : inds) {
            if (parents instanceof SimplePopulation) {
                parents.addIndividual(ind, 1); // add a single copie
            } else {
                // add all copies
                parents.addIndividual(ind, ind.getNumberOfCopies()); 
            }
        }
        return parents;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201904171215L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2019  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
