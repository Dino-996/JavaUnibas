package it.unibas.auto.vista;

import it.unibas.auto.modello.StatisticheCompravenditaAuto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Setter;

@Setter
public class ModelloTabellaCompravendita extends AbstractTableModel {

    private List<StatisticheCompravenditaAuto> listaStatisticheCompravenditaAuto = new ArrayList<>();

    @Override
    public int getRowCount() {
        return this.listaStatisticheCompravenditaAuto.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StatisticheCompravenditaAuto statisitcheCompravenditaAuto = listaStatisticheCompravenditaAuto.get(rowIndex);
        if (columnIndex == 0) {
            return statisitcheCompravenditaAuto.getAnno();
        }
        if (columnIndex == 1) {
            return statisitcheCompravenditaAuto.getOccorrenze();
        }
        if (columnIndex == 2) {
            return statisitcheCompravenditaAuto.getMedia() + " €";
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Anno";
        }
        if (column == 1) {
            return "Numero operazioni";
        }
        if (column == 2) {
            return "Importo medio";
        }
        return "";
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
