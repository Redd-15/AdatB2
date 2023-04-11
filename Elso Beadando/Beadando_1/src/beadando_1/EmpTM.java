package beadando_1;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class EmpTM extends DefaultTableModel {
	
public EmpTM (Object FieldNames[], int rows){
	super(FieldNames, rows);
}

public boolean isCellEditable(int row, int col) {
	return false;
}

public Class<?> getColumnClass(int index) {
	return(String.class);
}
}
