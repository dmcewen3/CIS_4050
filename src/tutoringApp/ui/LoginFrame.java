
//import the necessary packages
package tutoringApp.ui;
import business.Student;
import business.Tutor;
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
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;


//declaration class "LoginFrame"
public class LoginFrame extends JFrame {
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private Object user;
    
    //constructor class "LoginFrame"
    public LoginFrame( Object user) {
        
        this.user = user;
        
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
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        submitButton = new JButton();
        

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        
        
        //set component dimensions and default values
        Dimension shortField = new Dimension(150, 20);
        usernameField.setPreferredSize(shortField);
        usernameField.setMinimumSize(shortField);        
        passwordField.setPreferredSize(shortField);
        passwordField.setMinimumSize(shortField);        
        submitButton.setText("Submit");
        
        //action listener for the submit button
        submitButton.addActionListener((ActionEvent) -> {
            doSubmitButton(this.user);
            
        });
        
        //declaration containing panel
        JPanel loginPanel = new JPanel();

        

        //JTextField panel
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        textPanel.add(new JLabel("Username:"), 
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        textPanel.add(usernameField,
                getConstraints(1, 0, GridBagConstraints.LINE_START));
        textPanel.add(new JLabel("Password:"), 
                getConstraints(0, 1, GridBagConstraints.LINE_END));
        textPanel.add(passwordField,
                getConstraints(1, 1, GridBagConstraints.LINE_END));
        
        // JButton panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);

        // add panels to containing panel
        loginPanel.setLayout(new BorderLayout());
        loginPanel.add(textPanel, BorderLayout.CENTER);
        loginPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        //return components
        return loginPanel;       
    }
    
    
    private void doSubmitButton(Object user){
        
        if (user instanceof Student) {
            this.dispose();
            StudentMenu frame = new StudentMenu();
        }else if (user instanceof Tutor){
            this.dispose();
            TutorMenu frame = new TutorMenu();
        }
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