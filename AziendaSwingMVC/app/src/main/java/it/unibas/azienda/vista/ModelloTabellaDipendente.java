package it.unibas.azienda.vista;

import it.unibas.azienda.modello.Dipendente;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter

public class ModelloTabellaDipendente extends AbstractTableModel {

    private List<Dipendente> listaDipendenti = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaDipendenti.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dipendente dipendente = this.listaDipendenti.get(rowIndex);
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        if (columnIndex == 0) {
            return dipendente.getCodiceFiscale();
        }
        if (columnIndex == 1) {
            return dipendente.getNome();
        }
        if (columnIndex == 2) {
            return dipendente.getCognome();
        }
        if (columnIndex == 3) {
            return dtf.format(dipendente.getDataAssunzione());
        }
        if (columnIndex == 4) {
            return dipendente.getRegioneResidenza();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice fiscale";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Cognome";
        }
        if (column == 3) {
            return "Data assunzione";
        }
        if (column == 4) {
            return "Regione di residenza";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

}
