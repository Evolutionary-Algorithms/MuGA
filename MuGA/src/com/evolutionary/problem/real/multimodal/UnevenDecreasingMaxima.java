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

/**
 * Created on 04/02/2020, 14:09:54 
 * @author zulu - computer
 */
public class UnevenDecreasingMaxima extends MultiModalFunc{

    public UnevenDecreasingMaxima() {
        super(1, 0.0, 1.0, Individual.Optimization.MAXIMIZE);
    }
     @Override
    protected double evaluate(double[] x) {
        double tmp1 = -2 * Math.log(2.0) * ((x[0] - 0.08) / 0.854) * ((x[0] - 0.08) / 0.854);
        double tmp2 = Math.sin(5 * Math.PI * (Math.pow(x[0], 3.0 / 4.0) - 0.05));
        return Math.exp(tmp1) * Math.pow(tmp2, 6);
    }
    

 //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final double OPTIMUM_VALUE = 1.0;
    private static final int NUM_OPTIMUMS = 1;
    private static final double NICHE_RADIUS = 0.01;

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    @Override
    public double getOptimumValue() {
        return OPTIMUM_VALUE;
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @Override
    public double getNicheRadius() {
        return NICHE_RADIUS;
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @Override
    public int getNumGlobalOptima() {
        return NUM_OPTIMUMS;
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202002041409L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2020  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}