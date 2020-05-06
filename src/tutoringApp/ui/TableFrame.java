//import the necessary packages/classes
package tutoringApp.ui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//Declaration class "TableFrame"
public class TableFrame extends JFrame {
    
    //Declaration instance variables class "TableFrame"
    private TableModel tableModel;
    private JTable availabilityTable;
    private JButton doneButton;
    

    //constructor class "TableFrame"
    public TableFrame() {
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
        setSize(700, 350);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        availabilityTable = buildAvailabilityTable();
        add(new JScrollPane(availabilityTable),BorderLayout.CENTER);
        add(buildButtonPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }
    
    
    
    private JTable buildAvailabilityTable() {
        
        //create customerTableModel
        tableModel = new TableModel();
        
        //instantiate customerTableModel
        availabilityTable = new JTable(tableModel);
        
        //set selection mode, select one list index object at a time
        availabilityTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        availabilityTable.setBorder(null);
        //return customer table
        return availabilityTable;
    }
    
    private JPanel buildButtonPanel() {
        
        //create button panel
        JPanel buttonPanel = new JPanel();
       //create button
       doneButton = new JButton();
       doneButton.setText("Done");
       buttonPanel.add(doneButton);
       
       return buttonPanel;
        
        
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
