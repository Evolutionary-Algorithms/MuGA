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
import com.evolutionary.problem.real.cec2013.CFunc;
import com.evolutionary.problem.real.cec2013.ClosedInterval;
import com.evolutionary.problem.real.cec2013.Func;
import java.util.ArrayList;

/**
 * Created on 3/fev/2020, 0:18:53
 *
 * @author zulu - computer
 */
public class F12_CF4 extends CFunc {

    public F12_CF4() {
        this(new BoundsFn.ConstantBoundsFn(2, new ClosedInterval.Double(-5, 5)));
    }
    
    

    public F12_CF4(BoundsFn boundsFn) {
        super(boundsFn, 8);

        for (int i = 0; i < nofunc_; ++i) {
            sigma_[i] = 1.0;
            bias_[i] = 0.0;
            weight_[i] = 0.0;
        }
        sigma_[0] = 1.0;
        sigma_[1] = 1.0;
        sigma_[2] = 1.0;
        sigma_[3] = 1.0;
        sigma_[4] = 1.0;
        sigma_[5] = 2.0;
        sigma_[6] = 2.0;
        sigma_[7] = 2.0;
        lambda_[0] = 4.0;
        lambda_[1] = 1.0;
        lambda_[2] = 4.0;
        lambda_[3] = 1.0;
        lambda_[4] = 1.0 / 10.0;
        lambda_[5] = 1.0 / 5.0;
        lambda_[6] = 1.0 / 10.0;
        lambda_[7] = 1.0 / 40.0;
        /* load optima */
        if (this.getDimension() == 2 || this.getDimension() == 3 || this.getDimension() == 5
                || this.getDimension() == 10 || this.getDimension() == 20) {
            String fname;
            fname = "data/CF4_M_D" + this.getDimension() + "_opt.dat";
            loadOptima(fname);
            fname = "data/CF4_M_D" + this.getDimension() + ".dat";
            loadRotationMatrix(fname);
        } else {
            initOptimaRandomly();
            //TODO: make dimension independent rotation matrices
            /* M_ Identity matrices */
            initRotmatIdentity();
        }
        /* Initialise functions of the composition */
        funcs_ = new ArrayList< Func>();

        funcs_.add(new FRastrigin(boundsFn));
        funcs_.add(new FRastrigin(boundsFn));
        funcs_.add(new FEF8F2(boundsFn));
        funcs_.add(new FEF8F2(boundsFn));
        funcs_.add(new FWeierstrass(boundsFn));
        funcs_.add(new FWeierstrass(boundsFn));
        funcs_.add(new FGriewank(boundsFn));
        funcs_.add(new FGriewank(boundsFn));

        CalculateFMaxi();
    }

    @Override
    public double doEvaluate(double[] x) {
        return this.evaluateInner_(x);
    }

    @Override
    public double getOptimumValue() {
        return 0;
    }

    @Override
    public double getNicheRadius() {
        return 0.01;
    }

    @Override
    public int getNumGlobalOptima() {
        return 8;
    }

}//CF1
