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
 * Created on 2/fev/2020, 8:28:25
 *
 * @author zulu - computer
 */
/**
 * F3: Uneven Decreasing Maxima Variable ranges: x in [0, 1] No. of global
 * peaks: 1 No. of local peaks: 4.
 */
public class F03_UnevenDecreasingMaxima extends Func {

    public F03_UnevenDecreasingMaxima() {
        this(new BoundsFn.ConstantBoundsFn( 1, new ClosedInterval.Double(0.0, 1.0) ));
    }
  
    public F03_UnevenDecreasingMaxima(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        double tmp1 = -2 * Math.log(2.0) * ((x[0] - 0.08) / 0.854) * ((x[0] - 0.08) / 0.854);
        double tmp2 = Math.sin(5 * Math.PI * (Math.pow(x[0], 3.0 / 4.0) - 0.05));
        return Math.exp(tmp1) * Math.pow(tmp2, 6);
    }
    public double getOptimumValue() {
        return 1.0;
    }

    public double getNicheRadius() {
        return 0.01;
    }

    public int getNumGlobalOptima() {
        return 1;
    }
}// F03_UnevenDecreasingMaxima
