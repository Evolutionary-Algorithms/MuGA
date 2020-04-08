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

/**
 * Created on 04/02/2020, 06:27:26
 *
 * @author zulu - computer
 */
public class SixHumpCameBack extends MultiModalFunc {

    public SixHumpCameBack() {
        super(2, -1.9, 1.9, Optimization.MAXIMIZE);
    }

    @Override
    protected double evaluate(double[] x) {
       return -((4.0 - 2.1 * x[0] * x[0] + Math.pow(x[0], 4.0) / 3.0) * x[0] * x[0]
                + x[0] * x[1] + (4.0 * x[1] * x[1] - 4.0) * x[1] * x[1]);
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final double OPTIMUM_VALUE = 1.031628453;
    private static final int NUM_OPTIMUMS = 2;
    private static final double NICHE_RADIUS = 0.5;

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
    private static final long serialVersionUID = 202002040627L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2020  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
