//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     Biosystems & Integrative Sciences Institute                         ::
//::     Faculty of Sciences University of Lisboa                            ::
//::     http://www.fc.ul.pt/en/unidade/bioisi                               ::
//::                                                                         ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2015   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package com.evolutionary.operator.recombination.real;

import com.evolutionary.operator.recombination.Recombination;
import com.evolutionary.population.Population;
import com.evolutionary.problem.Individual;
import com.evolutionary.problem.real.RealVector;
import java.util.Collections;
import java.util.List;

/**
 * Created on 2/out/2015, 8:38:28
 *
 * @author zulu - computer
 */
public class MuAXSingle extends Recombination {

    double EXPAND = 0.5;

    @Override
    public Individual[] recombine(Individual... parents) {
        return executeAX((RealVector) parents[0], (RealVector) parents[1]);
    }

    public Population execute(Population offspring) {
        //clean population  
        Population newPopulation = offspring.getCleanClone();
        //individuals in the population
        List<Individual> lst = offspring.getGenomes();
        Collections.shuffle(lst, random);
        //iterate offspring population
        while (!lst.isEmpty()) {
            //select random first parent
            Individual indiv1 = lst.remove(random.nextInt(lst.size())).getClone();
            //Recombination or clone ?
            if (lst.isEmpty() || random.nextDouble() >= pCrossover) {
                //clone of parent
                newPopulation.addIndividual(indiv1, indiv1.getNumberOfCopies());
                continue;
            }// END: if
            //select random second parent
            Individual indiv2 = lst.remove(random.nextInt(lst.size())).getClone();
            //select max recombinations 

            Individual[] desc = recombine(indiv1, indiv2);

            //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            newPopulation.addIndividual(desc[0], 1);

            newPopulation.addIndividual(desc[1], 1);

        }// END: population
        return newPopulation;
    }

    public Individual[] executeAX(RealVector i0, RealVector i1) {
        //get genome values      
        final double[] v0 = i0.getGenome();
        final double[] v1 = i1.getGenome();
        //calculate new genes
        for (int i = 0; i < v0.length; i++) {
            //get a break point in the line of expansion
            double alpha = uniform(-EXPAND * i0.getNumberOfCopies(), 1 + EXPAND * i1.getNumberOfCopies());
            //Crossover individuals           
            double aux = alpha * v0[i] + (1.0 - alpha) * v1[i];
            v1[i] = (1.0 - alpha) * v0[i] + alpha * v1[i];
            v0[i] = aux;
        }
        //set gene values - Nomarlize values outside of boundaries
        i0.setDoubleValues(v0);
        i1.setDoubleValues(v1);
        //return descendants 
        return new RealVector[]{i0, i1};
    }

    ///////////////////////////////////////////////////////////////////////////
    @Override
    public String getInformation() {
        StringBuilder buf = new StringBuilder();
        buf.append(toString());
        buf.append("\nMultiset Aritmetic Uniform Crossover ");
        buf.append("\nRange[-" + EXPAND + "," + (1.0 + EXPAND) + "]");
        buf.append("\nParameters <PROBABILITY><EXPANSION>");
        buf.append("\n<PROBABILITY> to perform crossover");
        buf.append("\n<EXPANSION> expansion factor");
        return buf.toString();
    }

    @Override
    public String getParameters() {
        return pCrossover + " " + EXPAND;
    }

    //----------------------------------------------------------------------------------------------------------
    /**
     * update parameters od the operator
     *
     * @param params parameters separated by spaces
     * @throws RuntimeException not good values to parameters
     */
    @Override
    public void setParameters(String params) throws RuntimeException { //update parameters by string values
        //split string by withe chars
        String[] aParams = params.split("\\s+");
        try {
            pCrossover = Double.parseDouble(aParams[0]);
        } catch (Exception e) {
        }
        try {
            EXPAND = Double.valueOf(aParams[1]);
        } catch (Exception e) {
        }
    }//----------------------------------------------------------------------------------------------------------

    /**
     * Generate a random number from a uniform random variable.
     *
     * @param min min of the random variable.
     * @param max max of the random variable.
     * @return a double.
     */
    public double uniform(double min, double max) {
        if (min > max) {
            return max + (min - max) * random.nextDouble();
        }
        return min + (max - min) * random.nextDouble();
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201905151223L;

    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2019  :::::::::::::::::::
}
