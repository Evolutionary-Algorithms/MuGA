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
 * Created on 04/02/2020, 13:54:27
 *
 * @author zulu - computer
 */
public class FiveUnevenPeakTrap extends MultiModalFunc {

    public FiveUnevenPeakTrap() {
        super(1, 0.0, 30.0, Optimization.MAXIMIZE);
    }

    @Override
    protected double evaluate(double[] x) {
        double result = -1.0;
        if (x[0] >= 0 && x[0] < 2.5) {
            result = 80 * (2.5 - x[0]);
        } else if (x[0] >= 2.5 && x[0] < 5.0) {
            result = 64 * (x[0] - 2.5);
        } else if (x[0] >= 5.0 && x[0] < 7.5) {
            result = 64 * (7.5 - x[0]);
        } else if (x[0] >= 7.5 && x[0] < 12.5) {
            result = 28 * (x[0] - 7.5);
        } else if (x[0] >= 12.5 && x[0] < 17.5) {
            result = 28 * (17.5 - x[0]);
        } else if (x[0] >= 17.5 && x[0] < 22.5) {
            result = 32 * (x[0] - 17.5);
        } else if (x[0] >= 22.5 && x[0] < 27.5) {
            result = 32 * (27.5 - x[0]);
        } else if (x[0] >= 27.5 && x[0] <= 30) {
            result = 80 * (x[0] - 27.5);
        }

        return result;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final double OPTIMUM_VALUE = 200;
    private static final int NUM_OPTIMUMS = 2;
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
    private static final long serialVersionUID = 202002041354L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2020  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
