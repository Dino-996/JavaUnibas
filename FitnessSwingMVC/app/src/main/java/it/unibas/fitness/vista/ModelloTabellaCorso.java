package it.unibas.fitness.vista;

import it.unibas.fitness.modello.Corso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter
public class ModelloTabellaCorso extends AbstractTableModel {

    public List<Corso> listaCorsi = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaCorsi.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Corso corso = this.listaCorsi.get(rowIndex);
        if (columnIndex == 0) {
            return corso.getNomeCorso();
        }
        if (columnIndex == 1) {
            return corso.getNomeIstruttore();
        }
        if (columnIndex == 2) {
            return corso.getCostoMensile() + " €";
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
            return "Corso";
        }
        if (column == 1) {
            return "Istruttore";
        }
        if (column == 2) {
            return "Prezzo mensile";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

}
