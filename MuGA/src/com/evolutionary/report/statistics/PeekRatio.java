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

import com.evolutionary.problem.real.multimodal.MultiModalFunc;
import com.evolutionary.solver.EAsolver;

/**
 * Created on 15/mar/2016, 16:24:09
 *
 * @author zulu - computer
 */
public class PeekRatio extends AbstractStatistics {

    public PeekRatio() {
        super("Peek Ratio");
        higherIsBetter = true;
    }

    /**
     * calculate the statistic
     *
     * @param s solver
     * @return value
     */
    public double execute(EAsolver s) {
        if (s.parents.getIndividual(0) instanceof MultiModalFunc && s.hallOfFame.get(0).isOptimum()) {
            MultiModalFunc problem = (MultiModalFunc) s.parents.getIndividual(0);
            return s.hallOfFame.size() / (double)problem.getNumGlobalOptima();
        }
        return 0;
    }

    @Override
    public String getInformation() {
        return "Peek Ratio"
                + "\nRatio of Peeks found";
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201603151624L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2016  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
