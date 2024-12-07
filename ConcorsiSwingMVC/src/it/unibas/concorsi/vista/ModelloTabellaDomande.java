package it.unibas.concorsi.vista;

import it.unibas.concorsi.modello.Domanda;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter
public class ModelloTabellaDomande extends AbstractTableModel {

    private List<Domanda> listaDomande = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaDomande.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Domanda domanda = listaDomande.get(rowIndex);
        if (columnIndex == 0) {
            return domanda.getCodiceFiscale();
        }
        if (columnIndex == 1) {
            return domanda.getSessoRichiedente();
        }
        if (columnIndex == 2) {
            DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.ITALY);
            return dtf.format(domanda.getDataPresentazioneDomanda());
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice fiscale";
        }
        if (column == 1) {
            return "Sesso";
        }
        if (column == 2) {
            return "Data presentazione";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
