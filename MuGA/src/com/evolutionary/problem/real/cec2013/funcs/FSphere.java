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
 * Created on 2/fev/2020, 8:10:26
 *
 * @author zulu - computer
 */
/* Sphere function */
public class FSphere extends Func {
    
     public FSphere() {
        this(new BoundsFn.ConstantBoundsFn(2, new ClosedInterval.Double(-5.0, 5.0)));
    }

    public FSphere(BoundsFn boundsFn) {
        super(boundsFn);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected double doEvaluate(double[] x) {
        double result = 0.0;
        for (int i = 0; i < this.getDimension(); ++i) {
            result += x[i] * x[i];
        }
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
}//FSphere
