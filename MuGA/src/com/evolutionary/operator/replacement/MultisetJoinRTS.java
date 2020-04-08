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
public class MultisetJoinRTS extends Replacement {

    double windowSize = 0.25;

    @Override
    public Population execute(Population parents, Population offspring) {
        //size of population
        int SIZE = parents.getMaximumSize();
        //join population  
        parents.addAll(offspring.getIndividualsList());
        //list of individuals - no duplicates
        List<Individual> inds = new ArrayList<>(new HashSet<>(parents.getGenomes()));
        Collections.shuffle(inds);
        //new population  
        parents.clear();
        //clear similars 
        while (inds.size() > SIZE) {
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            //get pair of individuals that are most similar
            double dist, minDist =Double.POSITIVE_INFINITY;
            int pivot = random.nextInt(inds.size());
            int similar = 1;
            
            //size of tournament
            int tournamentSize = (int) (inds.size() * windowSize);
            for (int t = 0; t < tournamentSize; t++) {
                int selected = random.nextInt(inds.size());
                dist = inds.get(pivot).distanceTo(inds.get(selected));
                if (pivot != selected && dist < minDist) {
                    minDist = dist;
                    similar = selected;
                }                
            }
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            //Join most similar
            int copies = inds.get(pivot).getNumberOfCopies()
                    + inds.get(similar).getNumberOfCopies();
            //preserve individual at index1
            if (inds.get(pivot).compareTo(inds.get(similar)) > 0) {
                inds.get(pivot).setNumberOfCopies(copies);
                inds.remove(similar);
            } else {//preserve individual at index2
                inds.get(similar).setNumberOfCopies(copies);
                inds.remove(pivot);
            }
        }
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        // convert list of individuals to population
        for (Individual ind : inds) {
            if (parents instanceof SimplePopulation) {
                parents.addIndividual(ind, 1);
            } else {
                parents.addIndividual(ind, ind.getNumberOfCopies());
            }
        }
        return parents;
    }

    //----------------------------------------------------------------------------------------------------------
    @Override
    public String getParameters() {
        return windowSize + "";
    }

    /**
     * update parameters of the operator
     *
     * @param params parameters separated by spaces
     * @throws RuntimeException not good values to parameters
     */
    @Override
    public void setParameters(String params) throws RuntimeException {
        try {
            windowSize = Double.parseDouble(params);
        } catch (Exception e) {
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201904171215L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2019  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
