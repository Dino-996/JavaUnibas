package it.unibas.agenzia.vista;

import it.unibas.agenzia.modello.DettagliPacchettoVacanza;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

/**
 *
 * @author David
 */
@Setter
public class ModelloTabellaDettagliPacchetto extends AbstractTableModel {

    List<DettagliPacchettoVacanza> listaDettagliPacchettoVacanza = new ArrayList<>();

    /**
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return this.listaDettagliPacchettoVacanza.size();
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return 2;
    }

    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DettagliPacchettoVacanza dettagli = this.listaDettagliPacchettoVacanza.get(rowIndex);
        if (columnIndex == 0) {
            return dettagli.getTipologia();
        }
        if (columnIndex == 1) {
            return dettagli.getDataPartenza();
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
            return "Tipologia";
        }
        if (column == 1) {
            return "Prima data di viaggio";
        }
        return "";
    }

    /**
     *
     */
    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
