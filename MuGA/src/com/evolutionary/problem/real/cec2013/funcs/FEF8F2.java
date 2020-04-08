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
 * Created on 2/fev/2020, 8:12:02
 *
 * @author zulu - computer
 */
/* FEF8F2 function */
public class FEF8F2 extends Func {

    public FEF8F2() {
        this(new BoundsFn.ConstantBoundsFn(2, new ClosedInterval.Double(-5.0, 5.0)));
    }

    public FEF8F2(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] xx) {
        double result = 0.0;
        double x = 0, y = 0, f = 0, f2 = 0;

        for (int i = 0; i < this.getDimension() - 1; ++i) {
            x = xx[i] + 1;
            y = xx[i + 1] + 1;

            f2 = 100.0 * (x * x - y) * (x * x - y) + (1.0 - x) * (1.0 - x);
            f = 1.0 + f2 * f2 / 4000.0 - Math.cos(f2);

            result += f;
        }
        /* do not forget the (dim-1,0) case! */
        x = xx[this.getDimension() - 1] + 1;
        y = xx[0] + 1;

        f2 = 100.0 * (x * x - y) * (x * x - y) + (1.0 - x) * (1.0 - x);
        f = 1.0 + f2 * f2 / 4000.0 - Math.cos(f2);

        result += f;

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
}//FEF8F2
