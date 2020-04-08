/** ****************************************************************************
 * Version: 1.0
 * Last modified on: 4 March, 2013
 * Developers: Michael G. Epitropakis, Xiaodong Li.
 *      email: mge_(AT)_cs_(DOT)_stir_(DOT)_ac_(DOT)_uk
 *           : xiaodong_(DOT)_li_(AT)_rmit_(DOT)_edu_(DOT)_au
 * ************************************************************************** */
package com.evolutionary.problem.real.cec2013;

import com.evolutionary.problem.real.RealVector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Func extends RealVector {

   transient private List< ClosedInterval.Double> bounds;

    public Func(BoundsFn boundsFn) {
        super(boundsFn.getDimension(), boundsFn.getBound(0).lower,boundsFn.getBound(0).upper , Optimization.MAXIMIZE);
        List< ClosedInterval.Double> l = new ArrayList< ClosedInterval.Double>();
        for (int i = 0; i < boundsFn.getDimension(); ++i) {
            l.add(boundsFn.getBound(i));
        }

        bounds = Collections.unmodifiableList(l);
    }

    public final double evaluate(double[] x) {
        return evaluateCommon(x, true);
    }

    public final double evaluate(ArrayList<Double> x) {
        double[] xx = new double[x.size()];
        for (int i = 0; i < x.size(); i++) {
            xx[i] = x.get(i).doubleValue();
        }
        return evaluateCommon(xx, true);
    }

    private final double evaluateCommon(double[] x, boolean checkBounds) {
        if (checkBounds && !isInBounds(x)) {
            throw new IllegalArgumentException();
        }

        return doEvaluate(x);
    }

    final double cfuncEvaluate(double[] x) {

        return evaluateCommon(x, false);
    }

    public final int getDimension() {
        return bounds.size();
    }

    public boolean isInBounds(double[] x) {
        if (x.length != getDimension()) {
            return false;
        }

        for (int i = 0; i < x.length; ++i) {
            if (!bounds.get(i).contains(x[i])) {
                return false;
            }
        }
        return true;
    }

    public List< ClosedInterval.Double> getBounds() {
        return bounds;
    }

    

    @Override
    public boolean isOptimum() {
        return false;
    }
    
    protected abstract double doEvaluate(double[] x);
    
    public abstract double getOptimumValue();
    public abstract double getNicheRadius();
    public abstract int getNumGlobalOptima();
    
}
