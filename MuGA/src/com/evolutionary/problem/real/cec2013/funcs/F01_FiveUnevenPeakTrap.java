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
 * Created on 2/fev/2020, 8:29:40
 *
 * @author zulu - computer
 */
/**
 * F1: Five-Uneven-Peak Trap Variable ranges: x in [0, 30] No. of global peaks:
 * 2 No. of local peaks: 3.
 */
public class F01_FiveUnevenPeakTrap extends Func {

    

    public F01_FiveUnevenPeakTrap() {
        this(new BoundsFn.ConstantBoundsFn(1, new ClosedInterval.Double(0.0, 30.0)));
    }

    public F01_FiveUnevenPeakTrap(BoundsFn boundsFn) {
        super(boundsFn);
    }

    @Override
    protected double doEvaluate(double[] x) {
        double result = -1.0;
        if (x[0] >= 0 && x[0] < 2.5) {
            result = 80 * (2.5 - x[0]);
        } else if (x[0] >= 2.5 && x[0] < 5.0) {
            result = 64 * (x[0] - 2.5);
        } else if (x[0] >= 5.0 && x[0] < 7.5) {
            result = 64 * (7.5 - x[0]);
        } else if (x[0] >= 7.5 && x[0] < 12.5) {
            result = 28 * (x[0] - 7.5);
        } else if (x[0] >= 12.5 && x[0] < 17.5) {
            result = 28 * (17.5 - x[0]);
        } else if (x[0] >= 17.5 && x[0] < 22.5) {
            result = 32 * (x[0] - 17.5);
        } else if (x[0] >= 22.5 && x[0] < 27.5) {
            result = 32 * (27.5 - x[0]);
        } else if (x[0] >= 27.5 && x[0] <= 30) {
            result = 80 * (x[0] - 27.5);
        }

        return result;
    }
    
    public double getOptimumValue() {
        return 200;
    }

    public double getNicheRadius() {
        return 0.01;
    }

    public int getNumGlobalOptima() {
        return 2;
    }

}// F01_FiveUnevenPeakTrap
