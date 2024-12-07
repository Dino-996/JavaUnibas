package it.unibas.docenti.vista;

import it.unibas.docenti.modello.DettagliPrenotazione;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter

public class ModelloTabellaPrenotazioni extends AbstractTableModel {

    private List<DettagliPrenotazione> listaDettagliPrenotazione = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaDettagliPrenotazione.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DettagliPrenotazione dettagliPrenotazione = this.listaDettagliPrenotazione.get(rowIndex);
        if (columnIndex == 0) {
            return dettagliPrenotazione.getGiorno();
        }
        if (columnIndex == 1) {
            return dettagliPrenotazione.getNumeroPrenotazioni() + " prenotazioni";
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Giorno";
        }
        if (column == 1) {
            return "Numero di prenotazioni";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

}
