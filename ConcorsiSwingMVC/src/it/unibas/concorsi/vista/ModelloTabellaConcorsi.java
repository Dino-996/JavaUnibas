package it.unibas.concorsi.vista;

import it.unibas.concorsi.modello.Concorso;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter
public class ModelloTabellaConcorsi extends AbstractTableModel {

    private List<Concorso> listaConcorsi = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaConcorsi.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Concorso concorso = this.listaConcorsi.get(rowIndex);
        if (columnIndex == 0) {
            return concorso.getCodice();
        }
        if (columnIndex == 1) {
            return concorso.getDescrizione();
        }
        if (columnIndex == 2) {
            return concorso.getNumeroPosti();
        }
        if (columnIndex == 3) {
            DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.ITALY);
            return df.format(concorso.getDataConcorso());
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 2) {
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
            return "Descrizione";
        }
        if (column == 2) {
            return "Posti";
        }
        if (column == 3) {
            return "Data";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
