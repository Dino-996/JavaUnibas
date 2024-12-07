package it.unibas.aule.vista;

import it.unibas.aule.modello.Accesso;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter
public class ModelloTabellaAccessi extends AbstractTableModel {

    private List<Accesso> listaAccessi = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaAccessi.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Accesso accesso = this.listaAccessi.get(rowIndex);
        if (columnIndex == 0) {
            return accesso.getMatricola();
        }
        if (columnIndex == 1) {
            return accesso.getNomeStudente();
        }
        if (columnIndex == 2) {
            if (accesso.getMinutiPermanenza() > 1) {
                return accesso.getMinutiPermanenza() + " minuti";
            } else {
                return accesso.getMinutiPermanenza() + " minuto";
            }
        }
        if (columnIndex == 3) {
            return accesso.getMotivazione();
        }
        if (columnIndex == 4) {
            DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).localizedBy(Locale.ITALY);
            return dtf.format(accesso.getData());
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
            return "Matricola";
        }
        if (column == 1) {
            return "Studente";
        }
        if (column == 2) {
            return "Permanenza";
        }
        if (column == 3) {
            return "Motivazione";
        }
        if (column == 4) {
            return "Data e ora";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
