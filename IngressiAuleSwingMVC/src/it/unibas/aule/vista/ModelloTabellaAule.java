package it.unibas.aule.vista;

import it.unibas.aule.modello.Aula;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter
public class ModelloTabellaAule extends AbstractTableModel {

    private List<Aula> listaAule = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaAule.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aula aula = this.listaAule.get(rowIndex);
        if (columnIndex == 0) {
            return aula.getCodiceUnivoco();
        }
        if (columnIndex == 1) {
            return aula.getNomeAula();
        }
        if (columnIndex == 2) {
            return aula.getPianoAula();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Piano";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
