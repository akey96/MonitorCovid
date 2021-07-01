package cargarregistros.gui;

import cargarregistros.utils.FormatoFecha;
import cargarregistros.utils.FormatoSintomas;
import monitor.Registro;
import monitor.Registros;
import monitor.Sintoma;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaJPanel extends JPanel {
    JTable table;
    JScrollPane tableScollPanel;
    DefaultTableModel dataTable;
    Registros registros;

    public TablaJPanel(Registros registros){
        this.registros = registros;
        dataTable = new DefaultTableModel();
        table = new JTable(dataTable);
        tableScollPanel = new JScrollPane(table);
        dataTable.addColumn("Fecha");
        dataTable.addColumn("Sintomas");
        FormatoFecha formatoFecha = new FormatoFecha();
        FormatoSintomas formatoSintomas = new FormatoSintomas();
        for(Registro r: registros){
            String fecha = formatoFecha.dateToString(r.getFecha());
            String sintomasPaciente = formatoSintomas.formatoSintomas(r.getSintomas());
            dataTable.addRow(new Object[]{fecha, sintomasPaciente });
        }
        add(tableScollPanel);
    }

    public void clear(){
        int rowCount = dataTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dataTable.removeRow(i);
        }

    }

    public void actualizarTabla(){
        clear();
        for (Registro r: registros){
            String data = "";
            System.out.println(r.getSintomas().toString());
            FormatoFecha f = new FormatoFecha();
            for (Sintoma s: r.getSintomas()){
                data += s.toString() +", ";
            }
            addRow(new String[]{f.dateToString(r.getFecha()),  data });
        }
    }

    public void addRow(String[] row){
        dataTable.addRow(row);
    }

    public void paintComponent(Graphics g){
        tableScollPanel.setBounds(0, 0, 600,230);
    }
}
