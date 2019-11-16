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
package GUI;

import GUI.solver.UIexperiment;
import GUI.statistics.StatisticsChartExperiment;
import com.evolutionary.Genetic;
import com.evolutionary.report.html.WwwExperimentReport;
import com.evolutionary.solver.EAsolver;
import com.evolutionary.solverUtils.EAExperiment;
import com.evolutionary.solverUtils.FileSimulation;
import com.evolutionary.solverUtils.FileSolver;
import com.utils.MyFile;
import com.utils.MyString;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author zulu
 */
public class StatisticsSimulations extends javax.swing.JFrame {

    //main meno of this frame
    JFrame mainMenu;
    EAExperiment simulation = new EAExperiment();
    UIexperiment uiSolver = new UIexperiment();

    StatisticsChartExperiment statsPanel;

    int selectedSolverIndex = -1;
    JFileChooser fileChooserSimulation;

    /**
     * Creates new form ExploreSolver
     */
    public StatisticsSimulations(JFrame mainMenu) {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        this.setLocationRelativeTo(mainMenu);
        this.mainMenu = mainMenu;
         this.setTitle(Genetic.VERSION);
        initMyComponents();
    }

    public void initMyComponents() {

        pleaseWait.setVisible(false);
        DefaultListModel<String> model = new DefaultListModel<>();
        lstSolvers.setModel(model);
        fileChooserSimulation = new JFileChooser();
        fileChooserSimulation.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooserSimulation.setSelectedFile(new File(txtPathSimulation.getText()));
        fileChooserSimulation.setFileFilter(new FileNameExtensionFilter("Muga Evolution", FileSolver.FILE_EXTENSION_MUGA));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLeft = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btOpen1 = new javax.swing.JButton();
        btDeleteSolvers = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSolvers = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSolver = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btSeriesColor = new javax.swing.JButton();
        txtSolverName = new javax.swing.JTextField();
        btUpdateSolver = new javax.swing.JButton();
        pnTop = new javax.swing.JPanel();
        btOpen = new javax.swing.JButton();
        txtPathSimulation = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        SaveSimulation = new javax.swing.JButton();
        SaveHTML = new javax.swing.JButton();
        btMenu = new javax.swing.JButton();
        tpSolver = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        pleaseWait = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btOpen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons/File_Open-24.png"))); // NOI18N
        btOpen1.setText("Add Solver");
        btOpen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpen1ActionPerformed(evt);
            }
        });
        jPanel6.add(btOpen1);

        btDeleteSolvers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons/Delete-24.png"))); // NOI18N
        btDeleteSolvers.setText("Delete Solver");
        btDeleteSolvers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteSolversActionPerformed(evt);
            }
        });
        jPanel6.add(btDeleteSolvers);

        lstSolvers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstSolvers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSolversValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstSolvers);

        txtSolver.setEditable(false);
        txtSolver.setColumns(20);
        txtSolver.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtSolver.setRows(5);
        jScrollPane1.setViewportView(txtSolver);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btSeriesColor.setText("Color");
        btSeriesColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeriesColorActionPerformed(evt);
            }
        });

        txtSolverName.setText("name");

        btUpdateSolver.setText("set");
        btUpdateSolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateSolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btSeriesColor, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSolverName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btUpdateSolver, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btSeriesColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSolverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btUpdateSolver))
        );

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
        );

        getContentPane().add(pnLeft, java.awt.BorderLayout.WEST);

        pnTop.setLayout(new java.awt.BorderLayout());

        btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons/File_Open_file-24.png"))); // NOI18N
        btOpen.setText("Open Simulation");
        btOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenActionPerformed(evt);
            }
        });
        pnTop.add(btOpen, java.awt.BorderLayout.WEST);

        txtPathSimulation.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        txtPathSimulation.setText("simulation/");
        pnTop.add(txtPathSimulation, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout());

        SaveSimulation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons/File_Save-24.png"))); // NOI18N
        SaveSimulation.setText("Save Simulation");
        SaveSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveSimulationActionPerformed(evt);
            }
        });
        jPanel4.add(SaveSimulation);

        SaveHTML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons/File_Save-24.png"))); // NOI18N
        SaveHTML.setText("Save HTML");
        SaveHTML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveHTMLActionPerformed(evt);
            }
        });
        jPanel4.add(SaveHTML);

        btMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons/Main_Menu-32.png"))); // NOI18N
        btMenu.setText("Menu");
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });
        jPanel4.add(btMenu);

        pnTop.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(pnTop, java.awt.BorderLayout.NORTH);
        getContentPane().add(tpSolver, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        lblMessage.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(51, 7, 251));
        jPanel2.add(lblMessage);

        pleaseWait.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons/loading2.gif"))); // NOI18N
        pleaseWait.setText("please wait");
        jPanel2.add(pleaseWait);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        mainMenu.setLocationRelativeTo(this);
        this.dispose();
        mainMenu.setVisible(true);

    }//GEN-LAST:event_btMenuActionPerformed

    public void updateSelectedSolver() {
        if (selectedSolverIndex >= 0 && !txtSolver.getText().equalsIgnoreCase(simulation.solvers.get(selectedSolverIndex).toString())) {
            EAsolver solver = FileSolver.loadSolver(txtSolver.getText(), "");
            if (solver != null && !solver.getSolverName().equals(simulation.solvers.get(selectedSolverIndex).getSolverName())) {
                simulation.solvers.get(selectedSolverIndex).setSolverName(solver.getSolverName());
                displaySolvers();
            }
        }
    }

    private void displaySolvers() {
        showMesage("display  solvers ");
        //change the name of duplicated solvernames
        for (int i = 0; i < simulation.solvers.size(); i++) {
            for (int j = i + 1; j < simulation.solvers.size(); j++) {
                if (simulation.solvers.get(i).getSolverName().equalsIgnoreCase(simulation.solvers.get(j).getSolverName())) {
                    simulation.solvers.get(j).setSolverName(simulation.solvers.get(j).getSolverName() + "(" + j + ")");
                }
            }
        }

        DefaultListModel lst = new DefaultListModel();
        DefaultListModel old = (DefaultListModel) lstSolvers.getModel();
        boolean update = false;
        for (int i = 0; i < simulation.solvers.size(); i++) {
            if (old.size() > i && !old.getElementAt(i).toString().equalsIgnoreCase(simulation.solvers.get(i).getSolverName())) {
                update = true;
            }
            lst.addElement(simulation.solvers.get(i).getSolverName());
        }
        if (update || lst.size() != old.size()) {
            showMesage("update display  solvers ");
            lstSolvers.setModel(lst);
            lstSolvers.setSelectedIndex(selectedSolverIndex);
        }
        //update statiostics

    }


    private void btDeleteSolversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteSolversActionPerformed
        if (lstSolvers.getSelectedIndex() >= 0) {
            removeSolversToSimulation(simulation.solvers.get(lstSolvers.getSelectedIndex()));
        }
    }//GEN-LAST:event_btDeleteSolversActionPerformed

//    private void initStatisticsPanels() {
//        //remove all tabs from GUI
//        tpSolver.removeAll();
//        //create new Tabs
//
//        statsPanel = new StatisticsChartExperiment(simulation.solvers);
//
//        //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: SETUP
//        tpSolver.addTab("Experiment", pnSetupSolver);
//        //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: STATISTICS
//        JTabbedPane tpStats = new JTabbedPane();
//        int totalTabs = statsPanel.getTabs().getTabCount();
//        for (int i = 0; i < totalTabs; i++) {
//            tpStats.addTab(statsPanel.getTabs().getTitleAt(0), statsPanel.getTabs().getComponentAt(0));
//        }
//        //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: STATISTICS
//        tpSolver.addTab("Evolution", tpStats);
//        tpSolver.setSelectedComponent(tpStats);
//
//        this.revalidate();
//        this.repaint();
//    }
    private void addSolversToSimulation(ArrayList<EAsolver> fileSolvers) {
        if (fileSolvers.isEmpty()) { // no solvers to load
            return; // no solvers loaded   
        }
//        for (EAsolver solver : fileSolvers) {
//            solver.loadReport();
//        }
        simulation.solvers.addAll(fileSolvers);
        displaySolvers();
        lstSolvers.setSelectedIndex(simulation.solvers.size() - 1);
        tpSolver.removeAll();
        showMesage("create StatisticsChartExperiment");
        statsPanel = new StatisticsChartExperiment(simulation.solvers);

        tpSolver.addTab("Evolution", statsPanel.getTabs());
        showMesage("create getBoxAndWhiskerCharts");
        JTabbedPane result = simulation.getBoxAndWhiskerTabs();
        //display final result
        tpSolver.addTab("Result", result);
        tpSolver.setSelectedComponent(result);
        showMesage("create getRankCharts");
        JTabbedPane rank = simulation.getRankTabs();
        //display final result
        tpSolver.addTab("Rank", rank);
        lstSolvers.setSelectedIndex(simulation.solvers.size() - 1);
        lstSolversValueChanged(null);
    }

    private void removeSolversToSimulation(EAsolver solvers) {

        simulation.solvers.remove(solvers);
        displaySolvers();
        lstSolvers.setSelectedIndex(simulation.solvers.size() - 1);
        tpSolver.removeAll();
        showMesage("create StatisticsChartExperiment");
        statsPanel = new StatisticsChartExperiment(simulation.solvers);

        tpSolver.addTab("Evolution", statsPanel.getTabs());
        showMesage("create getBoxAndWhiskerCharts");
        JTabbedPane result = simulation.getBoxAndWhiskerTabs();
        //display final result
        tpSolver.addTab("Result", result);
        tpSolver.setSelectedComponent(result);
        showMesage("create getRankCharts");
        JTabbedPane rank = simulation.getRankTabs();
        //display final result
        tpSolver.addTab("Rank", rank);
        lstSolvers.setSelectedIndex(simulation.solvers.size() - 1);
        lstSolversValueChanged(null);
    }

    private void showMesage(final String msg) {

        System.out.println(MyString.toString(new Date()) + ":" + msg);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                lblMessage.setText(MyString.toString(new Date()) + ":" + msg);
            }
        });
    }

    private void btOpen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpen1ActionPerformed
        int returnVal = fileChooserSimulation.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            (new Thread(() -> {
                pleaseWait.setVisible(true);
                try {
                    pleaseWait.setText("Loading " + fileChooserSimulation.getSelectedFile().getAbsolutePath());
                    ArrayList<EAsolver> list = FileSimulation.loadSimulation(fileChooserSimulation.getSelectedFile().getPath());                    
                    addSolversToSimulation(list);
                    txtPathSimulation.setText(fileChooserSimulation.getSelectedFile().getPath());
                } catch (Exception ex1) {
                    JOptionPane.showMessageDialog(this, "Error " + ex1.getMessage());
                }
                pleaseWait.setVisible(false);
            })).start();
        }

    }//GEN-LAST:event_btOpen1ActionPerformed

    private void lstSolversValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSolversValueChanged
        //updateSelectedSolver();
        showMesage("lst solvers value Changed ");
        if (lstSolvers.getSelectedIndex() >= 0) {
            txtSolver.setText(simulation.solvers.get(lstSolvers.getSelectedIndex()).toString());
            selectedSolverIndex = lstSolvers.getSelectedIndex();
            if (statsPanel != null) {
                btSeriesColor.setBackground(statsPanel.getColorIndex(lstSolvers.getSelectedIndex()));
            }
            txtSolverName.setText(simulation.solvers.get(lstSolvers.getSelectedIndex()).getSolverName());
        } else {
            txtSolver.setText("");
            selectedSolverIndex = -1;
        }
    }//GEN-LAST:event_lstSolversValueChanged

    private void btOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpenActionPerformed
        int returnVal = fileChooserSimulation.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            (new Thread(() -> {
                pleaseWait.setVisible(true);
                try {
                    pleaseWait.setText("Loading " + fileChooserSimulation.getSelectedFile().getAbsolutePath());
                    ArrayList<EAsolver> list = FileSimulation.loadSimulation(fileChooserSimulation.getSelectedFile().getPath());
                    simulation.solvers.clear();
                    addSolversToSimulation(list);
                    txtPathSimulation.setText(fileChooserSimulation.getSelectedFile().getPath());
                } catch (Exception ex1) {
                    JOptionPane.showMessageDialog(this, "Error " + ex1.getMessage());
                }
                pleaseWait.setVisible(false);
            })).start();

        }
    }//GEN-LAST:event_btOpenActionPerformed

    private void SaveHTMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveHTMLActionPerformed

        JFileChooser fileChooser = new JFileChooser(txtPathSimulation.getText());
        //:::::::::: FILE NAME ::::::::::::::::::::::::::::::::::::::::::::::::
        String path = MyFile.getPath(txtPathSimulation.getText());
        String name = MyFile.getFileNameOnly(txtPathSimulation.getText());
        if (name.isEmpty()) {
            name = MyFile.getFileNameOnly("simulation");
        }
        name += "." + FileSolver.FILE_EXTENSION_CONFIG;
        File defaultFile = new File(path + name);
        defaultFile.getParentFile().mkdirs();
        fileChooser.setSelectedFile(defaultFile);
        //:::::::::: FILE NAME ::::::::::::::::::::::::::::::::::::::::::::::::
        fileChooser.setCurrentDirectory(new File(txtPathSimulation.getText()));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Muga Evolution", FileSolver.FILE_EXTENSION_MUGA));
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            WwwExperimentReport.save(simulation, fileChooser.getSelectedFile().getAbsolutePath(), this);
            txtPathSimulation.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_SaveHTMLActionPerformed

    private void btSeriesColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeriesColorActionPerformed
        Color initialBackground = statsPanel.getColorIndex(lstSolvers.getSelectedIndex());
        Color background = JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
        if (background != null) {
            btSeriesColor.setBackground(background);
            btUpdateSolverActionPerformed(evt);

        }
    }//GEN-LAST:event_btSeriesColorActionPerformed

    private void btUpdateSolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateSolverActionPerformed
        statsPanel.setColorIndex(btSeriesColor.getBackground(), lstSolvers.getSelectedIndex());
        if (!simulation.solvers.get(lstSolvers.getSelectedIndex()).getSimpleName().equals(txtSolverName.getText())) {
            statsPanel.setNameIndex(txtSolverName.getText(), lstSolvers.getSelectedIndex());
            simulation.solvers.get(lstSolvers.getSelectedIndex()).setSolverName(txtSolverName.getText());
        }
        displaySolvers();
    }//GEN-LAST:event_btUpdateSolverActionPerformed

    private void SaveSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveSimulationActionPerformed
 
        fileChooserSimulation.setFileFilter(new FileNameExtensionFilter("Muga Evolution", FileSolver.FILE_EXTENSION_MUGA));
        int returnVal = fileChooserSimulation.showSaveDialog(this);
        if (returnVal == fileChooserSimulation.APPROVE_OPTION) {
            simulation.saveAs(fileChooserSimulation.getSelectedFile().getAbsolutePath());
            
        }
    }//GEN-LAST:event_SaveSimulationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatisticsSimulations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticsSimulations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticsSimulations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticsSimulations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticsSimulations(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SaveHTML;
    private javax.swing.JButton SaveSimulation;
    private javax.swing.JButton btDeleteSolvers;
    private javax.swing.JButton btMenu;
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btOpen1;
    private javax.swing.JButton btSeriesColor;
    private javax.swing.JButton btUpdateSolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JList<String> lstSolvers;
    private javax.swing.JLabel pleaseWait;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnTop;
    private javax.swing.JTabbedPane tpSolver;
    private javax.swing.JTextField txtPathSimulation;
    private javax.swing.JTextArea txtSolver;
    private javax.swing.JTextField txtSolverName;
    // End of variables declaration//GEN-END:variables

}
