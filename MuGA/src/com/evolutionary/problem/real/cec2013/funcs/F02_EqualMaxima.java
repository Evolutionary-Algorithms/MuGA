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
 * Created on 2/fev/2020, 8:28:56
 *
 * @author zulu - computer
 */
/**
 * F2: Equal Maxima Variable ranges: x in [0, 1] No. of global peaks: 5 No. of
 * local peaks: 0.
 */
public class F02_EqualMaxima extends Func {

    public F02_EqualMaxima() {
        this(new BoundsFn.ConstantBoundsFn( 1, new ClosedInterval.Double(0.0, 1.0) ));
    }
    
    

    public F02_EqualMaxima(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        double s = Math.sin(5.0 * Math.PI * x[0]);
        return Math.pow(s, 6);
    }
    public double getOptimumValue() {
        return 1.0;
    }

    public double getNicheRadius() {
        return 0.01;
    }

    public int getNumGlobalOptima() {
        return 5;
    }
}//EqualMaxima
