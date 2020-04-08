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
 * Created on 2/fev/2020, 8:24:45
 *
 * @author zulu - computer
 */
/**
 * F7: F07_Vincent Variable range: x_i in [0.25, 10]^n, i=1,2,...,n No. of global
 * optima: 6^n No. of local optima: 0.
 */
public class F07_Vincent extends Func {

    public F07_Vincent() {
        this(new BoundsFn.ConstantBoundsFn( 2, new ClosedInterval.Double( 0.25, 10.0 ) ) );
    }
    
    

    public F07_Vincent(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        double result = 0;
        for (int i = 0; i < this.getDimension(); i++) {
            if (x[i] <= 0) {
                throw new IllegalArgumentException();
            }
            result = result + Math.sin(10 * Math.log(x[i]));
        }
        return result / (1.0 * this.getDimension());
    }
    
      @Override
    public double getOptimumValue() {
        return 1.0;
    }

    @Override
    public double getNicheRadius() {
        return 0.2;
    }

    @Override
    public int getNumGlobalOptima() {
        return 216;
    }
}//vincent
