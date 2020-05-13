
//import the necessary packages/classes
package tutoringApp.ui;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//Declaration class "ReportMenu"
public class ReportMenu extends JFrame {
    
    //declaration instance variables class "ReportMenu"
    private JButton submitButton;
    private JLabel reportLabel;
    private JLabel reportTypeLabel;
    private JComboBox reportBox;
    private DefaultTableModel tableModel;
    private JTable table;
    private Object[][] data;
    private String[] columnNames = {"Appointment Number", "Tutor","CRN","Time Slot"};
    
    
    //constructor class "ReportMenu"
    public ReportMenu() {
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
        String reportType[] = {"Student","Tutor", "Administrator"};
        submitButton = new JButton();
        reportLabel = new JLabel();
        reportTypeLabel = new JLabel();
        reportBox = new JComboBox(reportType);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        
        // set button dimensions and default text
        Dimension d = new Dimension(150,35);
        Font font = new Font("Calibri", Font.BOLD, 20);
        reportLabel.setText("Get Report");
        reportLabel.setFont(font);
        reportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        reportLabel.setVerticalAlignment(SwingConstants.CENTER);
        reportTypeLabel.setText("Report Type:");
        submitButton.setPreferredSize(d);
        submitButton.setText("Submit");
        reportBox.setPreferredSize(d);
    
        
        
        //action listener for the ReportMenu buttons
 
        submitButton.addActionListener((ActionEvent) -> {
            //todo button action logic
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
        data = FrameUtil.getAllApoointments();
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        JScrollPane pane = new JScrollPane(table);
        boxPanel.add(pane);
        
        //JButton panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBorder(new EmptyBorder(0,0,50,0));
        buttonPanel.add(submitButton,
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

