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
 * Created on 2/fev/2020, 8:26:53
 *
 * @author zulu - computer
 */
/**
 * F6: F06_Shubert Variable ranges: x_i in [−10, 10]^n, i=1,2,...,n No. of global
 * peaks: n*3^n No. of local peaks: many
 */
public class F06_Shubert extends Func {

    public F06_Shubert() {
        this(new BoundsFn.ConstantBoundsFn( 2, new ClosedInterval.Double( -10.0, 10.0 ) ));
    }
    

    public F06_Shubert(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        double result = 1, sum = 0;
        for (int i = 0; i < this.getDimension(); i++) {
            sum = 0;
            for (int j = 1; j < 6; j++) {
                sum = sum + j * Math.cos((j + 1) * x[i] + j);
            }
            result = result * sum;
        }
        return -result;
    }
    
     @Override
    public double getOptimumValue() {
        return 2709.093505;
    }

    @Override
    public double getNicheRadius() {
        return 0.5;
    }

    @Override
    public int getNumGlobalOptima() {
        return 81;
    }
}//Shubert
