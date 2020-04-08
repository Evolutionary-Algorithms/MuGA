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
 * Created on 2/fev/2020, 8:27:53
 *
 * @author zulu - computer
 */
/**
 * F4: F04_Himmelblau Variable ranges: x, y in [−6, 6 No. of global peaks: 4 No. of
 * local peaks: 0.
 */
public class F04_Himmelblau extends Func {

    public F04_Himmelblau() {
        this(new BoundsFn.ConstantBoundsFn( 2, new ClosedInterval.Double( -6.0, 6.0 ) ));
    }
    
    

    public F04_Himmelblau(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        return 200.0 - (x[0] * x[0] + x[1] - 11.0) * (x[0] * x[0] + x[1] - 11.0)
                - (x[0] + x[1] * x[1] - 7.0) * (x[0] + x[1] * x[1] - 7.0);
    }
    @Override
    public double getOptimumValue() {
        return 200;
    }

    @Override
    public double getNicheRadius() {
        return 0.01;
    }

    @Override
    public int getNumGlobalOptima() {
        return 4;
    }
}//Himmelblau
