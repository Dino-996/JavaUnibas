package it.unibas.libri.vista;

import it.unibas.libri.modello.Utente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter

public class ModelloTabellaUtenti extends AbstractTableModel {

    private List<Utente> listaUtenti = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaUtenti.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0) {
            return "Username";
        }
        if(column == 1) {
            return "Nome";
        }
        if(column == 2) {
            return "Cognome";
        }
        if(column == 3) {
            return "Libri presi in prestito";
        }
        if(column == 4) {
            return "Libri da restituire";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Utente utente = this.listaUtenti.get(rowIndex);
        if (columnIndex == 0) {
            return utente.getNomeUtenteUnivoco();
        }
        if (columnIndex == 1) {
            return utente.getNome();
        }
        if (columnIndex == 2) {
            return utente.getCognome();
        }
        if (columnIndex == 3) {
            return utente.getListaPrestiti().size();
        }
        if (columnIndex == 4) {
            return utente.getListaPrestitiDaRestituire().size();
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
