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
package com.evolutionary.stopCriteria;

import com.evolutionary.Genetic;
import com.evolutionary.solver.EAsolver;

/**
 * Created on 3/out/2015, 18:46:24
 *
 * @author zulu - computer
 */
public class MaxTime extends StopCriteria {

    //time of simulation begins
    private long startTime = -1;

    public MaxTime() {
    }

    public MaxTime(double value) {
        this.stopValue = value;
        startTime = -1;
    }

    public double completedRatio(EAsolver solver) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return this.stopValue / elapsedTime;
    }

    @Override
    public boolean isDone(EAsolver solver) {
        if (startTime < 0) {
            startTime = System.currentTimeMillis();
            return false;
        }
        return System.currentTimeMillis() - startTime > this.stopValue;

    }

    public String getInformation() {
        StringBuilder buf = new StringBuilder(getSimpleName() + "\n");
        buf.append("Terminates with evolution time");
        buf.append("\nParameter <VALUE> : number of miliseconds ");
        return buf.toString();
    }

    @Override
    public Genetic getClone() {
        OptimumFound stop = new OptimumFound();
        stop.stopValue = stopValue;
        return stop;
    }

    //----------------------------------------------------------------------------------------------------------
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201510031846L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2015  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
