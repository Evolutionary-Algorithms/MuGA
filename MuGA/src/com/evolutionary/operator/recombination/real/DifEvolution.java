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
//::                                                               (c)2020   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package com.evolutionary.operator.recombination.real;

import com.evolutionary.operator.recombination.Recombination;
import com.evolutionary.population.Population;
import com.evolutionary.problem.Individual;
import com.evolutionary.problem.real.RealVector;
import static com.evolutionary.solver.DE.getUniqueIndex;
import com.evolutionary.solver.differentialEvolution.DEBest1Bin;
import com.evolutionary.solver.differentialEvolution.DEStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 04/02/2020, 15:29:10
 *
 * @author zulu - computer
 */
public class DifEvolution extends Recombination {

   transient static ArrayList<DEStrategy> strategies = DEStrategy.getStrategies();
    public static double FACTOR = -1; //random [0.5 , 1]
    public static double CROSSOVER = 0.9;
    public static int STRATEGY = 0;
    //strategy
    transient DEStrategy deStrategy = new DEBest1Bin();

    //dimension of change [0,1]  
    double F = FACTOR;
    //probability of crossover [0,1]
    double CR = CROSSOVER;

    public Population execute(Population offspring) {
        //set random generator
        deStrategy.init(random);
        //best individuls

        List<RealVector> parents = (List<RealVector>) (Object) solver.parents.getGenomes();
        //clean population  
        Population newPopulation = offspring.getCleanClone();
        //individuals in the population
        List<RealVector> lst = (List<RealVector>) (Object) offspring.getGenomes();
        Collections.shuffle(lst, random);
        for (RealVector ind : lst) {
            ind = ind.getClone();
            //random best individual
            RealVector best = (RealVector) solver.hallOfFame.get(random.nextInt(solver.hallOfFame.size()));
            double f = F;
            double cr = CR;
            if (f < 0) {
                f = 0.1 + random.nextDouble();
            }
            if (cr < 0) {
                cr = random.nextDouble();
            }
            evolve(deStrategy, f, cr, ind, best, parents);
            newPopulation.addIndividual(ind);
        }
        return newPopulation;
    }

    public static void evolve(DEStrategy deStrategy, double F, double CR, RealVector currentInd, RealVector bestInd, List<RealVector> pop) {
        try {
            //base vetor
            double[] x = currentInd.getGenome();
            //select individuals
            int[] index = getUniqueIndex(4, pop.size(), currentInd.random);
            double[][] g = new double[4][];
            g[0] = pop.get(index[0]).getGenome();
            g[1] = pop.get(index[1]).getGenome();
            g[2] = pop.get(index[2]).getGenome();
            g[3] = pop.get(index[3]).getGenome();
            double[] best = bestInd.getGenome();
            deStrategy.apply(F, CR, x.length, x, best, g);
            currentInd.setDoubleValues(x);
            currentInd.evaluate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Individual[] recombine(Individual... parents) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202002041529L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2020  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
