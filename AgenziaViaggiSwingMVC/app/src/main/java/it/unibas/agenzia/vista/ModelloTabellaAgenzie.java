package it.unibas.agenzia.vista;

import it.unibas.agenzia.modello.Agenzia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

/**
 *
 * @author David
 */
@Setter
public class ModelloTabellaAgenzie extends AbstractTableModel {

    private List<Agenzia> listaAgenzie = new ArrayList<>();

    /**
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return this.listaAgenzie.size();
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return 3;
    }

    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Agenzia agenzia = this.listaAgenzie.get(rowIndex);
        if (columnIndex == 0) {
            return agenzia.getCodiceUnivoco();
        }
        if (columnIndex == 1) {
            return agenzia.getNome();
        }
        if (columnIndex == 2) {
            return agenzia.getCitta();
        }
        return "";
    }

    /**
     *
     * @param column
     * @return
     */
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice univoco";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Citta'";
        }
        return "";
    }
   
    /**
     *
     */
    public void aggiornaTabella() {
        super.fireTableDataChanged();
    }
}
