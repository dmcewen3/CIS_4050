
//import the necessary packages
package tutoringApp.ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;

public class StudentMenu extends JFrame {
    
    
    private JButton schedulingButton;
    private JButton reportsButton;
    private JButton logoutButton;
    private JLabel studentLabel;
    
    //constructor class "LoginFrame"
    public StudentMenu() {
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
        
        schedulingButton = new JButton();
        reportsButton = new JButton();
        logoutButton = new JButton();
        studentLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        
        // set button dimensions and default text
        Dimension d = new Dimension(150,35);
        schedulingButton.setText("Scheduling");
        schedulingButton.setPreferredSize(d);
        reportsButton.setText("Reports");
        reportsButton.setPreferredSize(d);
        logoutButton.setText("Logout");
        logoutButton.setPreferredSize(d);
        studentLabel.setText("Student Menu");
        studentLabel.setPreferredSize(d);
        studentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        studentLabel.setVerticalAlignment(SwingConstants.CENTER);
        Font font = new Font("Calibri", Font.BOLD, 20);
        studentLabel.setFont(font);
        
    
        
        
        //action listener for the StudentMenu buttons
        schedulingButton.addActionListener((ActionEvent) -> {
            //todo button action logic
            
        });
        reportsButton.addActionListener((ActionEvent) -> {
            //todo button action logic
        });
        logoutButton.addActionListener((ActionEvent) -> {
            //todo button action logic
        });
        
        //declaration containing panel
        JPanel menuPanel = new JPanel();

        
        
        
        //JButton panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(studentLabel,
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        buttonPanel.add(schedulingButton, 
                getConstraints(0, 1, GridBagConstraints.LINE_END));
        buttonPanel.add(reportsButton, 
                getConstraints(0, 2, GridBagConstraints.LINE_END));
        buttonPanel.add(logoutButton,
                getConstraints(0, 3, GridBagConstraints.LINE_END));
        
        

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


