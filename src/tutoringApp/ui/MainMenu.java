
//import the necessary packages
package tutoringApp.ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

//declaration class "LoginFrame"

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import business.Student;
import business.Tutor;

public class MainMenu extends JFrame {
    
    //private JTextField usernameField;
    //private JTextField passwordField;
    private JButton studentButton;
    private JButton tutorButton;
    private JButton adminButton;
    
    //constructor class "LoginFrame"
    public MainMenu() {
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
        //usernameField = new JTextField();
        //passwordField = new JTextField();
        studentButton = new JButton();
        tutorButton = new JButton();
        adminButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        
        // set button dimensions and default text
        Dimension d = new Dimension(150,35);
        studentButton.setText("Student");
        studentButton.setPreferredSize(d);
        tutorButton.setText("Tutor");
        tutorButton.setPreferredSize(d);
        adminButton.setText("Administrator");
        adminButton.setPreferredSize(d);
    
        
        
        //action listener for the mainMenu buttons
        studentButton.addActionListener((ActionEvent) -> {
            //todo button action logic
            Student student = new Student();
            LoginFrame login = new LoginFrame(student);
            this.dispose();
        });
        tutorButton.addActionListener((ActionEvent) -> {
            //todo button action logic
            Tutor tutor = new Tutor();
            LoginFrame login = new LoginFrame(tutor);
            this.dispose();
        });
        
        adminButton.addActionListener((ActionEvent) -> {
            //todo button action logic
//            LoginFrame login = new LoginFrame();
//            this.dispose();
        });
        
        //declaration containing panel
        JPanel menuPanel = new JPanel();

        

        //JTextField panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(studentButton, 
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        buttonPanel.add(tutorButton, 
                getConstraints(0, 1, GridBagConstraints.LINE_END));
        buttonPanel.add(adminButton,
                getConstraints(0, 2, GridBagConstraints.LINE_END));
        
        

        // add panel to containing panel
        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(buttonPanel, BorderLayout.CENTER);
        
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

