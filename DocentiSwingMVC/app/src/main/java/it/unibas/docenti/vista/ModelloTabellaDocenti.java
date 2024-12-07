package it.unibas.docenti.vista;

import it.unibas.docenti.modello.Docente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter

public class ModelloTabellaDocenti extends AbstractTableModel {

    private List<Docente> listaDocenti = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaDocenti.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Docente docente = this.listaDocenti.get(rowIndex);
        if (columnIndex == 0) {
            return docente.getNome();
        }
        if (columnIndex == 1) {
            return docente.getCognome();
        }
        if (columnIndex == 2) {
            return docente.getArgomentoPrincipale();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nome";
        }
        if (column == 1) {
            return "Cognome";
        }
        if (column == 2) {
            return "Argomento";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

}
