/**
 * 
 * @filename GUI_Class.java
 * @author ldough
 * @date 2/18/2018
 * This program implements a GUI that allows a user to choose between
 * iterative and recursive implementations of the same algorithm, computes the
 * value of the expression, and returns an efficiency value that documents
 * how many iterations or recursive calls the algorithm needed to perform the
 * calculation.
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.*;

public class GUI_Class extends JFrame implements WindowListener {
    
    //Create text fields, ratdio buttons, and compute button
    private JRadioButton iterativeRadioButton, recursiveRadioButton;
    private JButton computeButton;
    private JTextField enterNField, resultField, efficiencyField;
    
    //Call constructor that just initializes GUI components
    public GUI_Class() {
        initComponents();
    }
    
    //Set up the GUI display
    private void initComponents() {
        setTitle("Project 3");
        setSize(350, 180);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(this);
        setLocationByPlatform(true);
        
        //Radio Button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        ButtonGroup algorithmButtonGroup = new ButtonGroup();
        iterativeRadioButton = new JRadioButton("Iterative");
        iterativeRadioButton.setSelected(true);
        algorithmButtonGroup.add(iterativeRadioButton);
        recursiveRadioButton = new JRadioButton("Recursive");
        algorithmButtonGroup.add(recursiveRadioButton);
        c.gridwidth = 2;
        buttonPanel.add(iterativeRadioButton, getConstraints(0,0));
        buttonPanel.add(recursiveRadioButton, getConstraints(0,1));
        c.anchor = GridBagConstraints.LINE_END;
        
        //Input panel for number of iterations and compute button
        Dimension dim = new Dimension(100,20);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        enterNField = new JTextField();
        enterNField.setPreferredSize(dim);
        enterNField.setEditable(true);
        computeButton = new JButton("Compute");
        computeButton.setPreferredSize(dim);
        buttonPanel.add(computeButton);
        inputPanel.add(new JLabel("Enter n: "));
        inputPanel.add(enterNField);
        inputPanel.add(computeButton);
        
        //Sole button listener for action to be performed
        computeButton.addActionListener(e -> computeButtonClicked());
        
        //Result output panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(new JLabel("Result: "));
        resultField = new JTextField();
        resultField.setPreferredSize(dim);
        resultField.setEditable(false);
        resultPanel.add(resultField);
        resultPanel.add(new JLabel("Efficiency: "));
        efficiencyField = new JTextField();
        efficiencyField.setPreferredSize(dim);
        efficiencyField.setEditable(false);
        resultPanel.add(efficiencyField);
       
        //Add components to the GUI and set visible
        add(buttonPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10, 10, 0, 10);
        c.gridx = x;
        c.gridy = y;
        return c;
    }
    
    //Read radio to determine which method to use, perform calculation and 
    //display results.  Reset count to 0 before each run.
    public void computeButtonClicked() {
        int n = Integer.parseInt(enterNField.getText());
        if (recursiveRadioButton.isSelected()) {
            Sequence.count = 0;
            long result = Sequence.computeRecursive(n);
            int count = Sequence.getEfficiency();
            resultField.setText(String.valueOf(result));
            efficiencyField.setText(String.valueOf(count));
        } 
        else {
            Sequence.count = 0;
            long result = Sequence.computeIterative(n);
            int count = Sequence.getEfficiency();
            resultField.setText(String.valueOf(result));
            efficiencyField.setText(String.valueOf(count));
        }
    }
    
    //Method to be run on windowClose action to make output file
    public void createOutput() throws IOException {
        String dirString = "C:/Users/Admin/Documents/NetBeansProjects/CMIS_242_Proj3";
        Path dirPath = Paths.get(dirString);
        if (Files.notExists(dirPath)) {
            Files.createDirectories(dirPath);
        }
        String fileName = "Efficiency.txt";
        Path filePath = Paths.get(dirString, fileName);
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
        File outputFile = filePath.toFile();
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(outputFile)))) {
            for (int i = 1; i < 11; i ++) {
                Sequence.count = 0;
                long recurResult = Sequence.computeRecursive(i);
                int recurCount = Sequence.getEfficiency();
                Sequence.count = 0;
                Sequence.computeIterative(i);
                int iterCount = Sequence.getEfficiency();
                out.printf("%s, %s, %s%n", recurResult, iterCount, recurCount);
            }
            out.close();
        }
    }
        
    //Main method which runs the GUI
    public static void main(String arg[]) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new GUI_Class();
        });
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //This is the key method for the Window evetns and the only listener
    @Override
    public void windowClosing(WindowEvent e) {
        try {
            createOutput();
        }
        catch (IOException ex) {
            System.out.printf("Failed to create output file.\n%s\n", ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
