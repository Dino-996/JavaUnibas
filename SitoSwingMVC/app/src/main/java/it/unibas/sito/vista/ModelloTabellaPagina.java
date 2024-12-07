package it.unibas.sito.vista;

import it.unibas.sito.modello.DettagliPagina;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter

public class ModelloTabellaPagina extends AbstractTableModel {

    private List<DettagliPagina> listaDettagliPagina = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaDettagliPagina.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DettagliPagina dettagli = this.listaDettagliPagina.get(rowIndex);
        if (columnIndex == 0) {
            return dettagli.getGiornoSettimana();
        }
        if (columnIndex == 1) {
            return dettagli.getNumeroPagineModificareQuelGiorno();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0) { 
            return "Giorno della settimana";
        }
        if(column == 1) { 
            return "Numero pagine modificate";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

}
