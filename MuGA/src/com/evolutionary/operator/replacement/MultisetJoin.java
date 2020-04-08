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
public class MultisetJoin extends Replacement {

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
            double dist, minDist = inds.get(0).distanceTo(inds.get(1));
            int index1 = 0;
            int index2 = 1;
            for (int i = 0; i < inds.size(); i++) {
                for (int j = i + 1; j < inds.size(); j++) {
                    dist = inds.get(i).distanceTo(inds.get(j));
                    if (dist < minDist) {
                        minDist = dist;
                        index1 = i;
                        index2 = j;
                    }
                }
            }
            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            //Join most similar
            int copies = inds.get(index1).getNumberOfCopies()
                    + inds.get(index2).getNumberOfCopies();
            //preserve individual at index1
            if (inds.get(index1).compareTo(inds.get(index2)) > 0) {
                inds.get(index1).setNumberOfCopies(copies);
                inds.remove(index2);
            } else {//preserve individual at index2
                inds.get(index2).setNumberOfCopies(copies);
                inds.remove(index1);
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

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201904171215L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2019  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
