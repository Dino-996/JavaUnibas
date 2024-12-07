package it.unibas.libri.vista;

import it.unibas.libri.modello.DettagliPrestito;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter

public class ModelloTabellaDettagliPrestito extends AbstractTableModel {

    private List<DettagliPrestito> listaDettagliPrestito = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaDettagliPrestito.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DettagliPrestito dettagli = this.listaDettagliPrestito.get(rowIndex);
        if (columnIndex == 0) {
            return dettagli.getAutore();
        }
        if (columnIndex == 1) {
            return dettagli.getTotaleLibriNoleggiati();
        }
        if (columnIndex == 2) {
            return dettagli.getTotaleLibriNoleggiatiDaRestituire();
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Autore";
        }
        if (column == 1) {
            return "Totale libri noleggiati";
        }
        if (column == 2) {
            return "Totale libri da restituire";
        }
        return "";
    }

}
