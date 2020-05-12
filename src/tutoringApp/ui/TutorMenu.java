/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoringApp.ui;

import business.Tutor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * 
 */
public class TutorMenu extends JFrame{
    
    private JButton availabilityButton;
    private JButton reportsButton;
    private JButton appointmentButton;
    private JButton logoutButton;
    private JLabel tutorLabel;
    
    public TutorMenu(){
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        
        setTitle("Tutoring Center App");
        setSize(500, 300);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        add(initComponents(), BorderLayout.CENTER);
        
        setVisible(true);  
    }

    private JPanel initComponents() {
        
        availabilityButton = new JButton();
        reportsButton = new JButton();
        appointmentButton = new JButton();
        logoutButton = new JButton();
        tutorLabel = new JLabel();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        
        Dimension d = new Dimension(150,35);
        availabilityButton.setText("Set Availability");
        availabilityButton.setPreferredSize(d);
        reportsButton.setText("Reports");
        reportsButton.setPreferredSize(d);
        appointmentButton.setText("View Appointments");
        appointmentButton.setPreferredSize(d);
        logoutButton.setText("Logout");
        logoutButton.setPreferredSize(d);
        tutorLabel.setText("Tutor Menu");
        tutorLabel.setPreferredSize(d);
        tutorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tutorLabel.setVerticalAlignment(SwingConstants.CENTER);
        Font font = new Font("Calibri", Font.BOLD, 20);
        tutorLabel.setFont(font);
        
        availabilityButton.addActionListener((ActionEvent) -> {
            
            Tutor tutor = new Tutor();
            TableFrame availability = new  TableFrame(tutor);
        });
        reportsButton.addActionListener((ActionEvent) -> {
            //todo
            StudentTutorReport frame = new StudentTutorReport();
        });
        appointmentButton.addActionListener((ActionEvent) -> {
            //todo
            ViewAppointment frame = new ViewAppointment();
        });
        logoutButton.addActionListener((ActionEvent) -> {
            
            super.dispose();
            doLogoutButton();
        });
        
        JPanel menuPanel = new JPanel();
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(tutorLabel,
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        buttonPanel.add(availabilityButton, 
                getConstraints(0, 1, GridBagConstraints.LINE_END));
        buttonPanel.add(reportsButton, 
                getConstraints(0, 2, GridBagConstraints.LINE_END));
        buttonPanel.add(appointmentButton, 
                getConstraints(0, 3, GridBagConstraints.LINE_END));
        buttonPanel.add(logoutButton,
                getConstraints(0, 4, GridBagConstraints.LINE_END));
        
        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(buttonPanel, BorderLayout.CENTER);
        
        return menuPanel; 
    }
    
    private void doLogoutButton() {
        JOptionPane.showMessageDialog(rootPane, "Logged Out Successfully",
                "Logout", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        
    }
    
    private GridBagConstraints getConstraints(int x, int y, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        c.anchor = anchor;
        return c;
    }
    
}
