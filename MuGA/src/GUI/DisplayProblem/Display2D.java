//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     Biosystems & Integrative Sciences Institute                         ::
//::     Faculty of Sciences University of Lisboa                            ::
//::     http://www.fc.ul.pt/en/unidade/bioisi                               ::
//::                                                                         ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2016   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package GUI.DisplayProblem;

import com.evolutionary.population.Population;
import com.evolutionary.problem.Individual;
import com.evolutionary.problem.real.RealVector;
import com.utils.MyNumber;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.util.List;

/**
 * Created on 7/mar/2016, 16:38:37
 *
 * @author zulu - computer
 */
public class Display2D extends DisplayPopulation {

    public static int GAP = 15;
    public static int SIZE_IND = 6;
    public static Color FUNC_COLOR = Color.BLUE;
    public static Color IND_COLOR = Color.RED;
    public static boolean FILL = true;

    double[] funcPoints; //function surface
    double minFunValue; // minimum of function value
    double maxFunValue; // minimum of function value
    RealVector function = null; // 

    public String toString() {
        return "Display 2D";
    }

    public boolean isValid(Individual ind) {
        return (ind instanceof RealVector)
                && ind.getNumGenes() == 1;
    }

    public double[] getValues(Individual ind) {

        if (ind instanceof RealVector) {
            return ((RealVector) ind).getGenome();
        }
        return null;
    }

    /**
     * display population of the solver
     *
     * @param pop
     * @param gr
     * @param bounds
     */
    @Override
    public void showPopulation(Population pop, Graphics gr, Rectangle bounds) {
        try {

            int round = Math.min(bounds.width, bounds.height) / 100 + 1;
            bounds = new Rectangle(bounds.x + GAP * 4, bounds.y + GAP, bounds.width - GAP * 5, bounds.height - GAP * 5);
            gr.setColor(Color.WHITE);
            gr.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, round, round);
            gr.setColor(Color.BLACK);
            gr.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, round, round);
            Graphics2D g2d = (Graphics2D) gr;
            g2d.setStroke(new BasicStroke(2f));

            List<Individual> inds = pop.getGenomes();
            g2d.setStroke(new BasicStroke(2f));
            drawSpace(gr, (RealVector) inds.get(0), bounds);
            g2d.setStroke(new BasicStroke(1f));
            double minValue = getMin(inds.get(0));
            double maxValue = getMax(inds.get(0));
            double stepX = bounds.getWidth() / (maxValue - minValue);
            double stepY = bounds.height / (maxFunValue - minFunValue);
            double x, y;
            RealVector real;
            gr.setColor(IND_COLOR);
            for (Individual ind : inds) {
                real = (RealVector) ind;
                x = bounds.x + (real.getGenome()[0] - minValue) * stepX;
                y = bounds.height + bounds.y - real.getFitness() * stepY;
                if (FILL) {
                    gr.setColor(IND_COLOR);
                    gr.fillOval((int) x - SIZE_IND, (int) y - SIZE_IND, SIZE_IND * 2, SIZE_IND * 2);
                    gr.setColor(Color.BLACK);
                    gr.drawOval((int) x - SIZE_IND, (int) y - SIZE_IND, SIZE_IND * 2, SIZE_IND * 2);
                } else {
                    gr.setColor(IND_COLOR);
                    gr.drawOval((int) x - SIZE_IND, (int) y - SIZE_IND, SIZE_IND * 2, SIZE_IND * 2);
                }

            }

        } catch (Exception e) {
        }
    }

    public void drawSpace(Graphics gr, RealVector ind, Rectangle bounds) {
        computeSpace(ind, bounds);
        double minValue = getMin(ind);
        double maxValue = getMax(ind);
        gr.setColor(FUNC_COLOR);
        //gr.drawString(ind.getSimpleName() + ind.getParameters(), 20, 50);
        double stepX = bounds.getWidth() / (funcPoints.length - 1);
        double stepY = bounds.height / (maxFunValue - minFunValue);
        double x1, y1, x2, y2;
        for (int x = 0; x < funcPoints.length - 1; x++) {
            x1 = bounds.x + x * stepX;
            y1 = bounds.height + bounds.y - funcPoints[x] * stepY;
            x2 = bounds.x + (x + 1) * stepX;
            y2 = bounds.height + bounds.y - funcPoints[x + 1] * stepY;
            gr.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }

        gr.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        gr.setColor(Color.BLACK);
//        gr.drawString(String.format("%4.2f",minValue), bounds.x, bounds.y + bounds.height + 2*GAP);
//        gr.drawString(String.format("%4.2f",maxValue), bounds.x + bounds.width, bounds.y + bounds.height + 2*GAP);
//
//        gr.drawString(String.format("%4.2f",maxFunValue), bounds.x - 2*GAP, bounds.y);
//        gr.drawString(String.format("%4.2f",minFunValue), bounds.x - 2*GAP, bounds.y + bounds.height);

        stepX = (maxValue - minValue) / 10;
        int pixels = bounds.width / 10;
        for (int i = 1; i <= 10; i++) {            
            gr.drawString(String.format("%4.2f", minValue + i * stepX), bounds.x + pixels * i, bounds.y + bounds.height + 2*GAP);            
            gr.drawLine(bounds.x + pixels * i, bounds.height + bounds.y, bounds.x + pixels * i, bounds.height + bounds.y + GAP/2);
        }

        stepY = (maxFunValue - minFunValue) / 10;
        pixels = bounds.height / 10;
        for (int i = 0; i <= 10; i++) {            
            gr.drawString(String.format("%4.2f", maxFunValue - stepY * i), 0, bounds.y + pixels * i);            
            gr.drawLine(bounds.x - GAP/2, bounds.y + pixels * i, bounds.x, bounds.y + pixels * i);
        }

    }

    public void computeSpace(RealVector ind, Rectangle bounds) {
        if (function == null || bounds.width > funcPoints.length * 3) {
            function = ind;
            minFunValue = Double.POSITIVE_INFINITY;
            maxFunValue = Double.NEGATIVE_INFINITY;
            funcPoints = new double[bounds.width + 1];
            //pixel dimension in real world
            double minValue = getMin(ind);
            double maxValue = getMax(ind);
            double x;
            double dimpixel = (maxValue - minValue) / bounds.width;
            for (int i = 0; i < funcPoints.length; i++) {
                x = minValue + i * dimpixel;
                funcPoints[i] = ind.getFuncValue(x);
                if (funcPoints[i] > maxFunValue) {
                    maxFunValue = funcPoints[i];
                }
                if (funcPoints[i] < minFunValue) {
                    minFunValue = funcPoints[i];
                }
            }

        }
    }

    private double getMin(Individual ind) {
        if (ind instanceof RealVector) {
            return ((RealVector) ind).getMinValue();
        }
        return 0;
    }

    private double getMax(Individual ind) {
        if (ind instanceof RealVector) {
            return ((RealVector) ind).getMaxValue();
        }
        return 1;
    }

    @Override
    protected void displayIndividual(Graphics gr, Individual ind, int px, int py, int sizex, int sizey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected void drawInformation(Graphics gr, int px, int py) {

    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201603071638L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2016  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
