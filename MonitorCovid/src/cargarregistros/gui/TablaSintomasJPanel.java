package cargarregistros.gui;

import cargarregistros.utils.FormatoFecha;
import cargarregistros.utils.FormatoSintomas;
import monitor.Registro;
import monitor.Registros;
import monitor.Sintoma;
import monitor.Sintomas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaSintomasJPanel extends JPanel {
    JTable table;
    JScrollPane tableScollPanel;
    DefaultTableModel dataTable;
    Registros registros;

    public TablaSintomasJPanel(){
        this.registros = registros;
        dataTable = new DefaultTableModel();
        table = new JTable(dataTable);
        tableScollPanel = new JScrollPane(table);
        dataTable.addColumn("Sintomas");
//        FormatoFecha formatoFecha = new FormatoFecha();
//        FormatoSintomas formatoSintomas = new FormatoSintomas();
//        for(Registro r: registros){
//            String fecha = formatoFecha.dateToString(r.getFecha());
//            String sintomasPaciente = formatoSintomas.formatoSintomas(r.getSintomas());
//            dataTable.addRow(new Object[]{fecha, sintomasPaciente });
//        }
        add(tableScollPanel);

    }

    public void addRow(String[] row){

        dataTable.addRow(row);
    }

    public void clear(){

        int rowCount = dataTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dataTable.removeRow(i);
        }
    }

    public void addRowSintomas(Sintomas sintomasSeleccionados){
        clear();
        for (Sintoma s: sintomasSeleccionados){
            addRow(new String[]{ s.toString() });
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        tableScollPanel.setBounds(0, 0, 600,200);
    }
}
