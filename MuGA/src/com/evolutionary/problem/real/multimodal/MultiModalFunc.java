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
package com.evolutionary.problem.real.multimodal;

import com.evolutionary.problem.Individual;
import com.evolutionary.problem.real.RealVector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 04/02/2020, 05:58:48
 *
 * @author zulu - computer
 */
public abstract class MultiModalFunc extends RealVector {

    public static double NUMBER_PRECISION = 1.0E-3;

//    protected MultiModalFunc(int size, double min, double max, Optimization type) {
//        this(size, new double[]{min}, new double[]{max}, type);
//    }
    protected MultiModalFunc(int size, double min, double max, Optimization type) {
        super(size, min, max, type);
    }
    
    
    public int getDimension(){
        return getNumGenes();
    }

    @Override
    public boolean isOptimum() {
        return Math.abs(getOptimumValue() - getFitness()) < getNumberPrecision();
    }

    public abstract double getOptimumValue();

    public abstract double getNicheRadius();

    public abstract int getNumGlobalOptima();
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202002040558L;

    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2020  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
    public static double getNumberPrecision() {
        return NUMBER_PRECISION;
    }

    public static void setNumberPrecision(double precision) {
        NUMBER_PRECISION = precision;
    }
//
//    public static List<Individual> getGlobalOptima(List<Individual> pop, double optimum, double precision, double nicheRadius) {
//        List<Individual> peeks = new ArrayList<>();
//        Collections.sort(pop);
//        Collections.reverse(pop);
//        //for all the individuals
//        for (int i = 0; i < pop.size(); i++) {
//            //if is an optimum
//            if (Math.abs(pop.get(i).getFitness() - optimum) < precision) {
//                boolean found = false;
//                for (int j = 0; j < peeks.size(); j++) {
//                    if (peeks.get(i).distanceTo(pop.get(i)) < nicheRadius) {
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found) {
//                    peeks.add(pop.get(i));
//                }
//            }
//        }
//        return peeks;
//    }

    public List<Individual> getPeeks(List<Individual> pop) {
        return getGlobalOptimas(pop, getOptimumValue(), NUMBER_PRECISION, getNicheRadius());
    }

    public static List<Individual> getGlobalOptimas(List<Individual> pop, double optimum, double precision, double nicheRadius) {
        List<Individual> peeks = new ArrayList<>();
        //for all the individuals
        for (int index = 0; index < pop.size(); index++) {
            //if is an optimum
            if (Math.abs(pop.get(index).getFitness() - optimum) < precision) {
                boolean found = false;
                //compare to current peeks
                for (int indexPeek = 0; indexPeek < peeks.size(); indexPeek++) {
                    //peek already found?
                    if (peeks.get(indexPeek).distanceTo(pop.get(index)) < nicheRadius) {
                        //this individual is better than the peek
                        if (peeks.get(indexPeek).compareTo(pop.get(index)) <= 0) {
                            //replace peek
                            peeks.set(indexPeek, pop.get(index));
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    peeks.add(pop.get(index));
                }
            }
        }
        return peeks;
    }

    @Override
    public String getInformation(){//------------------------------------------ get information
        // public String getInfo() {
        StringBuilder txt = new StringBuilder(super.getProblemDefinition());
        txt.append("\n\nMULTIMODAL INFORMATION\n");
        txt.append("\nNumber precision   \t: " + NUMBER_PRECISION);
        txt.append("\nOptimum Value      \t: " + getOptimumValue());
        txt.append("\nNumbero of Optimums\t: " + getNumGlobalOptima());
        txt.append("\nNicheRadius        \t: " + getNicheRadius());

        return txt.toString();
    }
}
