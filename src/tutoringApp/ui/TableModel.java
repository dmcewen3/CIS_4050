package tutoringApp.ui;


import javax.swing.table.AbstractTableModel;

class TableModel extends AbstractTableModel {
     String[] columnNames = {"Time Slot",
                        "M",
                        "T",
                        "W",
                        "Th",
                        "F",
                        "Sa",
                        "Su"};
    
    Object[][] data =  {
    {"9:30", "Efren Ledezma",
     "Cody Wright", "Tom Thomas", "David McEwen","Ben Karabinus",
    "",""},
    {"11:00", "Steve Smith",
     "Sally Johnson", "Tom Thomas", "Sally Strothers","Ben Karabinus",
    "",""},
    {"12:30", "Steve Smith",
     "Sally Johnson", "Tom Thomas", "Sally Strothers","Ben Karabinus",
    "",""},
    {"2:00", "Steve Smith",
     "Sally Johnson", "Tom Thomas", "Sally Strothers","Ben Karabinus",
    "",""},
    {"3:30", "Steve Smith",
     "Sally Johnson", "Tom Thomas", "John Smith","David McEwen",
    "",""}
};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
   
}