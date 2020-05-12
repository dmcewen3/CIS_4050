/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoringApp.ui;


//import the necessary packages/classes

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

//Declaration class "ReportMenu"

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class StudentTutorReport extends JFrame {
    
    //declaration instance variables class "ReportMenu"
    private JButton doneButton;
    private JLabel reportLabel;
    private JTextArea reportText;
    
    
    //constructor class "ReportMenu"
    public StudentTutorReport() {
        //attempt to set system look and feel
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        /*
          set window size, title, location, default close opertation,
          initiate window components, and make visible
        */
        setTitle("Tutoring Center App");
        setSize(500, 300);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        setLayout(new BorderLayout());
        add(initComponents(), BorderLayout.CENTER);
        
        setVisible(true);        
    }
    
    //private method to create and return frame components
    private JPanel initComponents() {
        
        //declare instance variables for frame components
        
        doneButton = new JButton();
        reportLabel = new JLabel();
        reportText = new JTextArea();
   
       
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        
        // set button dimensions and default text
        Dimension d = new Dimension(150,35);
        Dimension td = new Dimension(250,100);
        Font font = new Font("Calibri", Font.BOLD, 20);
        reportLabel.setText("Past Appointment History");
        reportLabel.setFont(font);
        reportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        reportLabel.setVerticalAlignment(SwingConstants.CENTER);
       
        doneButton.setPreferredSize(d);
        doneButton.setText("Done");
        //reportBox.setPreferredSize(d);
        reportText.setPreferredSize(td);
    
        
        
        //action listener for the ReportMenu buttons
 
        doneButton.addActionListener((ActionEvent) -> {
            //todo button action logic
            this.dispose();
        });
        
        
        //declaration containing panel
        JPanel menuPanel = new JPanel();

        //JLabel panel
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BorderLayout());
        labelPanel.setBorder(new EmptyBorder(30, 0, 0, 0));
        labelPanel.add(reportLabel, BorderLayout.CENTER);
        
        //JComboBox panel
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new GridBagLayout());
        boxPanel.add(reportText, 
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        
        //JButton panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBorder(new EmptyBorder(0,0,50,0));
        buttonPanel.add(doneButton,
                getConstraints(0,0, GridBagConstraints.LINE_END));
                
        
        
        

        // add panels to containing panel
        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(labelPanel, BorderLayout.NORTH);
        menuPanel.add(boxPanel, BorderLayout.CENTER);
        menuPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        //return components
        return menuPanel;       
    }
    
    //private method to create GridBagConstraints "dynamic"
    private GridBagConstraints getConstraints(int x, int y, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        c.anchor = anchor;
        return c;
    }
    
    
    
    
}

