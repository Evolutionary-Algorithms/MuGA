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
 * Created on 2/fev/2020, 8:09:22
 *
 * @author zulu - computer
 */
/* Weierstrass's function */
public class FWeierstrass extends Func {

    public FWeierstrass() {
        this(new BoundsFn.ConstantBoundsFn(2, new ClosedInterval.Double(-5.0, 5.0)));
    }

    public FWeierstrass(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        double result = 0.0, sum = 0.0, sum2 = 0.0, a = 0.5, b = 3.0;
        int k_max = 20;

        for (int j = 0; j <= k_max; ++j) {
            sum2 += Math.pow(a, j) * Math.cos(2.0 * Math.PI * Math.pow(b, j) * (0.5));
        }
        for (int i = 0; i < this.getDimension(); ++i) {
            sum = 0.0;
            for (int j = 0; j <= k_max; ++j) {
                sum += Math.pow(a, j) * Math.cos(2.0 * Math.PI * Math.pow(b, j) * (x[i] + 0.5));
            }
            result += sum;
        }
        return result - sum2 * this.getDimension();
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
}//FWeierstrass
