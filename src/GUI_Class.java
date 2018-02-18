
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldough
 */
public class GUI_Class extends JFrame {
    
    private JRadioButton iterativeRadioButton, recursiveRadioButton;
    private JButton computeButton;
    private JTextField enterNField, resultField, efficiencyField;
    
    public GUI_Class() {
        initComponents();
    }
    
    //Set up the GUI display
    private void initComponents() {
        setTitle("Project 3");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        
        //Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonGroup algorithmButtonGroup = new ButtonGroup();
        iterativeRadioButton = new JRadioButton("Iterative");
        iterativeRadioButton.setSelected(true);
        algorithmButtonGroup.add(iterativeRadioButton);
        recursiveRadioButton = new JRadioButton("Recursive");
        algorithmButtonGroup.add(recursiveRadioButton);
        buttonPanel.add(iterativeRadioButton);
        buttonPanel.add(recursiveRadioButton);
        
        //Input monetary amount panel
        Dimension dim = new Dimension(100,20);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        enterNField = new JTextField();
        enterNField.setPreferredSize(dim);
        enterNField.setEditable(true);
        computeButton = new JButton("Compute");
        computeButton.setPreferredSize(dim);
        buttonPanel.add(computeButton);
        inputPanel.add(enterNField);
        inputPanel.add(computeButton);
       
        computeButton.addActionListener(e -> computeButtonClicked());
        
        //Result output panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultField = new JTextField();
        resultField.setPreferredSize(dim);
        resultField.setEditable(false);
        resultPanel.add(resultField);
        efficiencyField = new JTextField();
        efficiencyField.setPreferredSize(dim);
        efficiencyField.setEditable(false);
        resultPanel.add(efficiencyField);
       
        
        add(buttonPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void computeButtonClicked() {
        
    }
    
    public static void main(String arg[]) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new GUI_Class();
        });
    }
}
