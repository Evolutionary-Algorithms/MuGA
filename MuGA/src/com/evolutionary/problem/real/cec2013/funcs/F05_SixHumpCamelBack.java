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
 * Created on 2/fev/2020, 8:27:22
 *
 * @author zulu - computer
 */
/**
 * F5: Six-Hump Camel Back Variable ranges: x in [−1.9, 1.9]; y in [−1.1, 1.1]
 * No. of global peaks: 2 No. of local peaks: 2.
 */
public class F05_SixHumpCamelBack extends Func {

    public F05_SixHumpCamelBack() {
        super(new BoundsFn.ConstantBoundsFn( 2, new ClosedInterval.Double( -1.9, 1.9 ) ));
    }
    

    public F05_SixHumpCamelBack(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        return -((4.0 - 2.1 * x[0] * x[0] + Math.pow(x[0], 4.0) / 3.0) * x[0] * x[0]
                + x[0] * x[1] + (4.0 * x[1] * x[1] - 4.0) * x[1] * x[1]);
    }
    
   
     @Override
    public double getOptimumValue() {
        return 1.031628453;
    }

    @Override
    public double getNicheRadius() {
        return 0.5;
    }

    @Override
    public int getNumGlobalOptima() {
        return 2;
    }

}//SixHumpCamelBack
