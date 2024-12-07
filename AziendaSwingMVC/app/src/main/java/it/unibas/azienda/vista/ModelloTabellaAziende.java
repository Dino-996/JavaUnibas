package it.unibas.azienda.vista;

import it.unibas.azienda.modello.Azienda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter

public class ModelloTabellaAziende extends AbstractTableModel {

    private List<Azienda> listaAziende = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaAziende.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Azienda azienda = this.listaAziende.get(rowIndex);
        if (columnIndex == 0) {
            return azienda.getDenominazione();
        }
        if (columnIndex == 1) {
            return azienda.getPartitaIVA();
        }
        if (columnIndex == 2) {
            return azienda.getSedeSociale();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Denominazione";
        }
        if (column == 1) {
            return "Partita IVA";
        }
        if (column == 2) {
            return "Sede sociale";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
