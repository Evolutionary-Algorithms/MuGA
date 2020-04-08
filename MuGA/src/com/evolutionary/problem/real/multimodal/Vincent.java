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
public class Vincent extends MultiModalFunc {

    public Vincent() {
        super(2, 0.25, 10, Optimization.MAXIMIZE);
    }

    @Override
    protected double evaluate(double[] x) {
        double result = 0;
        for (int i = 0; i < this.getDimension(); i++) {
            if (x[i] <= 0) {
                throw new IllegalArgumentException();
            }
            result = result + Math.sin(10 * Math.log(x[i]));
        }
        return result / (1.0 * this.getDimension());
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final double OPTIMUM_VALUE = 1.0;
    private static final int NUM_OPTIMUMS = 36;
    private static final double NICHE_RADIUS =0.2;        

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
