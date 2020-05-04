//import the necessary packages/classes
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
import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

//Declaration class "MakeRemoveAppiontment"
public class MakeRemoveAppointment extends JFrame {
    
    //Declaration instance variables class "MakeRemoveAppointment"
    private JLabel appointmentLabel;
    private JLabel subjectLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JComboBox subjectBox;
    private JComboBox dateBox;
    private JComboBox timeBox;
    private JButton availabilityButton;
    private JButton appointmentButton;
    private JButton submitButton;

    //constructor class "MakeRemoveAppointment"
    public MakeRemoveAppointment() {
        //attempt to set system look and feel
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        /*
          set window size, title, location, default close opertation,
          initiate window components, and make visible
         */
        setTitle("Tutoring Center App");
        setSize(600, 300);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(initComponents(), BorderLayout.CENTER);

        setVisible(true);
    }

    //private method to create and return frame components
    private JPanel initComponents() {

        //declare instance variables for frame components
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(
        FormatStyle.SHORT);
        String date = dtf.format(currentDate);
        
        //array to populate date comboBox "test data"
        String dates [] = {date};
        
        //array to populate classes comboBox "test data"
        String classes[] = {"CIS", "ACC", "MKT", "FIN", "MGT"};
        
        //array to populate times combBox "testData"
        String times[] = {"8:00","9:00","10:00","11:00"};
        
        subjectBox = new JComboBox(classes);
        dateBox = new JComboBox(dates);
        timeBox = new JComboBox(times);
        appointmentLabel = new JLabel();
        subjectLabel = new JLabel();
        dateLabel = new JLabel();
        timeLabel = new JLabel();
        availabilityButton = new JButton();
        appointmentButton = new JButton();
        submitButton = new JButton();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // set component dimensions and default text
        Dimension bd = new Dimension(150, 35);//button dimensions
        Dimension bxd = new Dimension(150, 35);//comboBox dimensions
        appointmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        appointmentLabel.setVerticalAlignment(SwingConstants.CENTER);
        appointmentLabel.setText("Make/Remove Appointment");
        Font font = new Font("Calibri", Font.BOLD, 20);
        appointmentLabel.setFont(font);
        subjectLabel.setText("Subject:");
        dateLabel.setText("Date:");
        timeLabel.setText("Subject");
        availabilityButton.setText("View Aavailability");
        availabilityButton.setPreferredSize(bd);
        appointmentButton.setText("Remove Appointment");
        appointmentButton.setPreferredSize(bd);
        submitButton.setText("Submit");
        submitButton.setPreferredSize(bd);
        subjectBox.setPreferredSize(bxd);
        dateBox.setPreferredSize(bxd);
        timeBox.setPreferredSize(bxd);

        //action listener for the StudentMenu buttons
        availabilityButton.addActionListener((ActionEvent) -> {
        //todo button action logic
        });
        appointmentButton.addActionListener((ActionEvent) -> {
        //todo button action logic
        });
        submitButton.addActionListener((ActionEvent) -> {
        //todo button action logic
        });
        
        //declaration containing panel
        JPanel menuPanel = new JPanel();
        
        //Jlabel Panel
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BorderLayout());
        labelPanel.add(appointmentLabel, BorderLayout.CENTER);
        
        

        //JComboBox panel
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new GridBagLayout());
        boxPanel.add(subjectLabel,
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        boxPanel.add(subjectBox,
                getConstraints(1, 0, GridBagConstraints.LINE_END));
        boxPanel.add(dateLabel,
                getConstraints(0, 1, GridBagConstraints.LINE_END));
        boxPanel.add(dateBox,
                getConstraints(1, 1, GridBagConstraints.LINE_END));
        boxPanel.add(timeLabel,
                getConstraints(0, 2, GridBagConstraints.LINE_END));
        boxPanel.add(timeBox,
                getConstraints(1, 2, GridBagConstraints.LINE_END));
        //JButton Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(availabilityButton,
                getConstraints(0, 0, GridBagConstraints.LINE_END));
        buttonPanel.add(appointmentButton,
                getConstraints(0, 1, GridBagConstraints.LINE_END));
        buttonPanel.add(submitButton,
                getConstraints(0, 2, GridBagConstraints.LINE_END));

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
