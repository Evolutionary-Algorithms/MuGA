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
public class ModifiedRastrigin extends MultiModalFunc {
      /* Modified Rastrigin -- All Global Optima */
    static final double[] MPPF92 = {3, 4};
    static final double[] MPPF98 = {1, 2, 1, 2, 1, 3, 1, 4};
    static final double[] MPPF916 = {1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 3, 1, 1, 1, 4};

    public ModifiedRastrigin() {
        super(2, 0, 1, Optimization.MAXIMIZE);
    }

    @Override
    protected double evaluate(double[] x) {
        double result = 0;
        for (int i = 0; i < this.getDimension(); i++) {
            if (this.getDimension() == 2) {
                result = result + 10 + 9 * Math.cos(2 * Math.PI * MPPF92[i] * x[i]);
            }
            if (this.getDimension() == 8) {
                result = result + 10 + 9 * Math.cos(2 * Math.PI * MPPF98[i] * x[i]);
            }
            if (this.getDimension() == 16) {
                result = result + 10 + 9 * Math.cos(2 * Math.PI * MPPF916[i] * x[i]);
            }
        }
        return -result;
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final double OPTIMUM_VALUE = -2.0;
    private static final int NUM_OPTIMUMS = 12;
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
    private static final long serialVersionUID = 202002040627L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2020  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
