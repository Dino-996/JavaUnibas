package it.unibas.fitness.vista;

import it.unibas.fitness.modello.DettagliCorso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter
public class ModelloTabellaDettagliCorso extends AbstractTableModel {

    public List<DettagliCorso> listaDettagliCorso = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaDettagliCorso.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DettagliCorso corso = this.listaDettagliCorso.get(rowIndex);
        if (columnIndex == 0) {
            return corso.getDifficolta();
        }
        if (columnIndex == 1) {
            return corso.getOccorrenze();
        }
        if (columnIndex == 2) {
            return corso.getMedia();
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Double.class;
        }
        return Integer.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Difficoltà";
        }
        if (column == 1) {
            return "Numero di lezioni";
        }
        if (column == 2) {
            return "Durata media";
        }
        return "";
    }
}
