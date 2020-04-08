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
package com.evolutionary.problem.real.cec2013.funcs;

import com.evolutionary.problem.real.cec2013.BoundsFn;
import com.evolutionary.problem.real.cec2013.ClosedInterval;
import com.evolutionary.problem.real.cec2013.Func;

/* Ackley's function */
public class FAckley extends Func {

    public FAckley() {
        this(new BoundsFn.ConstantBoundsFn(2, new ClosedInterval.Double(-5.0, 5.0)));
    }

    public FAckley(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        double sum1 = 0.0, sum2 = 0.0, result;
        for (int i = 0; i < this.getDimension(); ++i) {
            sum1 += x[i] * x[i];
            sum2 += Math.cos(2.0 * Math.PI * x[i]);
        }
        sum1 = -0.2 * Math.sqrt(sum1 / this.getDimension());
        sum2 /= this.getDimension();
        result = 20.0 + Math.E - 20.0 * Math.exp(sum1) - Math.exp(sum2);
        return result;
    }

    @Override
    public double getOptimumValue() {
        return 1;
    }

    @Override
    public double getNicheRadius() {
        return 0.01;
    }

    @Override
    public int getNumGlobalOptima() {
        return 1;
    }
}//FAckley
