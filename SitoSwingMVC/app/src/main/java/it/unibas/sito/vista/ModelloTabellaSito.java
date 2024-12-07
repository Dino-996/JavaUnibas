package it.unibas.sito.vista;

import it.unibas.sito.modello.SitoWeb;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter

public class ModelloTabellaSito extends AbstractTableModel {

    private List<SitoWeb> listaSitiWeb = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaSitiWeb.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SitoWeb sito = this.listaSitiWeb.get(rowIndex);
        if (columnIndex == 0) {
            return sito.getNome();
        }
        if (columnIndex == 1) {
            return sito.getIndirizzo();
        }
        if (columnIndex == 2) {
            return sito.getListaPagine().size() + " pagine";
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
            return "Nome";
        }
        if (column == 1) {
            return "Indirizzo";
        }
        if (column == 2) {
            return "Pagine";
        }
        return "";
    }

}
