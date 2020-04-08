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
import com.evolutionary.problem.real.multimodal.MultiModalFunc;
import com.evolutionary.solver.EAsolver;
import com.evolutionary.solverUtils.EAsolverArray;

/**
 * Created on 19/jan/2016, 12:08:40
 *
 * @author zulu - computer
 */
public class PeeksFuncsCall extends AbstractStatistics {

    int numOptimal = 1;

    public PeeksFuncsCall() {
        super("Number of avaluations to all Peeks found");
        this.higherIsBetter = false;
    }

    /**
     * calculate the statistic
     *
     * @param s solver
     * @return value
     */
    @Override
    public double execute(EAsolver s) {
        if (!(s.parents.getIndividual(0) instanceof MultiModalFunc)) {
            return 0;
        }

        if (s instanceof EAsolverArray) {
            return executeArray((EAsolverArray) s);
        }
        double value = s.report.getLastValue(this);
        MultiModalFunc problem = (MultiModalFunc) s.parents.getIndividual(0);
        if (s.hallOfFame.size() >= problem.getNumGlobalOptima() && s.hallOfFame.get(0).isOptimum()) {
            if (value == 0) {
                value = s.numEvaluations;
            }
        }
        return value;

    }

    public double executeArray(EAsolverArray s) {
        if (!(s.parents.getIndividual(0) instanceof MultiModalFunc)) {
            return 0;
        }
        EAsolver[] arrayOfSolvers = s.arrayOfSolvers;
        int solversCompleted = 0;
        double evals = 0;
        for (EAsolver solver : arrayOfSolvers) {
            MultiModalFunc problem = (MultiModalFunc) s.parents.getIndividual(0);
            if (s.hallOfFame.size() >= problem.getNumGlobalOptima() && s.hallOfFame.get(0).isOptimum()) {
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
