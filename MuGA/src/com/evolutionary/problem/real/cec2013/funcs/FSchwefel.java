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

/**
 * Created on 2/fev/2020, 8:10:56
 *
 * @author zulu - computer
 */
/* Schwefel's function */
public class FSchwefel extends Func {

    public FSchwefel() {
        this(new BoundsFn.ConstantBoundsFn(2, new ClosedInterval.Double(-5.0, 5.0)));
    }

    public FSchwefel(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        double sum1 = 0.0, sum2 = 0.0;

        for (int i = 0; i < this.getDimension(); ++i) {
            sum2 = 0.0;
            for (int j = 0; j <= i; ++j) {
                sum2 += x[j];
            }
            sum1 += sum2 * sum2;
        }
        return sum1;
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
}//FSchwefel
