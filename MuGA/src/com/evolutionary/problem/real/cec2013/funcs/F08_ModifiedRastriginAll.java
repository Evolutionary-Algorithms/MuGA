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
 * Created on 2/fev/2020, 8:21:02
 *
 * @author zulu - computer
 */
/**
 * F8: Modified Rastrigin - All Global Optima Variable ranges: x_i in [0, 1]^n,
 * i=1,2,...,n No. of global peaks: \prod_{i=1}^n k_i No. of local peaks: 0.
 */
public class F08_ModifiedRastriginAll extends Func {

    /* Modified Rastrigin -- All Global Optima */
    static final double[] MPPF92 = {3, 4};
    static final double[] MPPF98 = {1, 2, 1, 2, 1, 3, 1, 4};
    static final double[] MPPF916 = {1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 3, 1, 1, 1, 4};

    public F08_ModifiedRastriginAll() {
        this(new BoundsFn.ConstantBoundsFn( 2, new ClosedInterval.Double( 0.0, 1.0 ) ));
    }
    
    

    public F08_ModifiedRastriginAll(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        double result = 0;
        for (int i = 0; i < this.getDimension(); i++) {
            if (this.getDimension() == 2) {
                result = result + 10 + 9 * Math.cos(2 * Math.PI * MPPF92[i] * x[i]);
            }
            if (this.getDimension() == 8) {
                result = result + 10 + 9 * Math.cos(2 * Math.PI * MPPF98[i] * x[i]);
            }
            if (this.getDimension() == 16) {
                result = result + 10 + 9 * Math.cos(2 * Math.PI * MPPF916[i] * x[i]);
            }
        }
        return -result;
    }
    
      @Override
    public double getOptimumValue() {
        return 186.7309088;
    }

    @Override
    public double getNicheRadius() {
        return 0.01;
    }

    @Override
    public int getNumGlobalOptima() {
        return 18;
    }

}//ModifiedRastriginAll
