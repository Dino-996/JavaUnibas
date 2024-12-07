package it.unibas.auto.vista;

import it.unibas.auto.modello.Auto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter
public class ModelloTabellaAuto extends AbstractTableModel {

    private List<Auto> listaAuto = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaAuto.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto auto = this.listaAuto.get(rowIndex);
        if (columnIndex == 0) {
            return auto.getTarga();
        }
        if (columnIndex == 1) {
            return auto.getModello();
        }
        if (columnIndex == 2) {
            return auto.getAnnoPrimaImmatricolazione();
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
            return "Targa";
        }
        if (column == 1) {
            return "Modello";
        }
        if (column == 2) {
            return "Anno immatricolazione";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

}
