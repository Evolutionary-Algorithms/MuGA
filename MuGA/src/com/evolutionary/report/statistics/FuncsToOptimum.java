//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::     Antonio Manso                        Luis Correia                   ::
//::     manso@ipt.pt                   Luis.Correia@ciencias.ulisboa.pt     ::
//::                                                                         ::
//::     Biosystems & Integrative Sciences Institute                         ::
//::     Faculty of Sciences University of Lisboa                            ::
//::                                                                         ::
//::     Instituto Politécnico de Tomar                                      ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                             (c) 2019    ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package com.evolutionary.report.statistics;

import com.evolutionary.problem.Individual;
import com.evolutionary.solver.EAsolver;
import com.evolutionary.solverUtils.EAsolverArray;

/**
 * Created on 19/jan/2016, 12:08:40
 *
 * @author zulu - computer
 */
public class FuncsToOptimum extends AbstractStatistics {

    public FuncsToOptimum() {
        super("Number of evaluations to optima");
        higherIsBetter = false;
    }

    /**
     * calculate the statistic
     *
     * @param s solver
     * @return value
     */
    @Override
    public double execute(EAsolver s) {
        if (s instanceof EAsolverArray) {
            return executeArray((EAsolverArray) s);
        }
        double value = s.report.getLastValue(this);
        Individual best = s.hallOfFame.iterator().next();
        if (best.isOptimum()) {
            if (value == 0) {
                return s.numEvaluations;
            } else {
                return value;
            }
        }
        return 0;
    }

    public double executeArray(EAsolverArray s) {
        EAsolver[] arrayOfSolvers = s.arrayOfSolvers;
        int solversCompleted = 0;
        double evals = 0;
        for (EAsolver solver : arrayOfSolvers) {
            if (solver.hallOfFame.get(0).isOptimum()) {
                evals += execute(solver);
                solversCompleted++;
            }
        }

        return solversCompleted > 0 ? evals / solversCompleted : 0;
    }

    @Override
    public String getInformation() {
        return "Number of calls to the evaluation function\n to find an optimal solution\n";
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201601191208L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2016  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
