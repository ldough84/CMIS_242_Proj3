
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

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
        inputPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        enterNField = new JTextField();
        enterNField.setPreferredSize(dim);
        enterNField.setEditable(true);
        computeButton = new JButton("Compute");
        computeButton.setPreferredSize(dim);
        buttonPanel.add(computeButton);
        inputPanel.add(new JLabel("Enter n: "));
        inputPanel.add(enterNField);
        inputPanel.add(computeButton);
       
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
    
    public void computeButtonClicked() {
        int n = Integer.parseInt(enterNField.getText());
        if (recursiveRadioButton.isSelected()) {
            Sequence.count = 0;
            Integer result = Sequence.computeRecursive(n);
            int count = Sequence.getEfficiency();
            resultField.setText(String.valueOf(result));
            efficiencyField.setText(String.valueOf(count));
        } 
        else {
            Sequence.count = 0;
            Integer result = Sequence.computeIterative(n);
            int count = Sequence.getEfficiency();
            resultField.setText(String.valueOf(result));
            efficiencyField.setText(String.valueOf(count));
        }
    }
    
    public static void main(String arg[]) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new GUI_Class();
        });
    }
}
