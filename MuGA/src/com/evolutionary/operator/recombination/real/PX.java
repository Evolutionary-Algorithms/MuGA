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
import com.evolutionary.problem.Individual;
import com.evolutionary.problem.real.RealVector;

/**
 * Created on 2/out/2018, 8:38:28
 *
 * @author zulu - computer
 */
public class PX extends Recombination {

    double EXPAND = 0.5;

    @Override
    public Individual[] recombine(Individual... parents) {
        return executePX((RealVector) parents[0], (RealVector) parents[1]);
    }

    protected double getAlpha(Individual i1, Individual i2) {
        if (random.nextDouble() < 0.3) {
            double beta = random.nextDouble() * random.nextDouble();
            return (1 + EXPAND * 2) * beta - EXPAND;
        } else {
            return uniform(-EXPAND, 1 + EXPAND);
        }
    }

    protected double[] reflect(RealVector ind, double[] x) {
//        for (int i = 0; i < x.length; i++) {
//            if( x[i] < ind.getMinValue()){
//                x[i] = ind.getMinValue() + Math.abs(x[i] - ind.getMinValue());
//            }
//            if( x[i] > ind.getMaxValue()){
//                x[i] = ind.getMaxValue() + Math.abs(x[i] - ind.getMaxValue());
//            }                        
//        }
        return x;
    }

    public Individual[] executePX(RealVector x1, RealVector x2) {
        if (x1.compareTo(x2) > 0) {
            RealVector aux = x1;
            x1 = x2;
            x2 = aux;
        }
        //get genome values      
        final double[] v0 = x1.getGenome();
        final double[] v1 = x2.getGenome();
        double alpha;
        //calculate new genes
        for (int i = 0; i < v0.length; i++) {
            //get a break point in the line of expansion
            alpha = getAlpha(x1, x2);
            //Crossover individuals           
            double aux = alpha * v0[i] + (1.0 - alpha) * v1[i];
            //Crossover individuals           
            alpha = uniform(-EXPAND, 1 + EXPAND);
            v1[i] = alpha * v0[i] + (1.0 - alpha) * v1[i];
            v0[i] = aux;
        }
        //set gene values - Nomarlize values outside of boundaries
        x1.setDoubleValues(reflect(x1, v0));
        x2.setDoubleValues(reflect(x2, v1));
        //return descendants 
        return new RealVector[]{x1, x2};
    }

    ///////////////////////////////////////////////////////////////////////////
    @Override
    public String getInformation() {
        StringBuilder buf = new StringBuilder();
        buf.append(toString());
        buf.append("\nAritmetic Uniform Crossover ");
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
