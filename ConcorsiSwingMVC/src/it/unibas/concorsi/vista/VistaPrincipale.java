package it.unibas.concorsi.vista;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.tabellaConcorsi.setModel(new ModelloTabellaConcorsi());
        this.inizializzaComponenti();
        this.inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.campoRegione.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneDomanda.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneVisualizzaDomanda());
    }
    
    private void inizializzaComponenti() {
        this.campoRegione.setText("Basilicata");
    }

    public void aggiornaTabella() {
        List<Concorso> listaFiltrata = (List<Concorso>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        ModelloTabellaConcorsi modelloTabella = (ModelloTabellaConcorsi) this.tabellaConcorsi.getModel();
        modelloTabella.setListaConcorsi(listaFiltrata);
        modelloTabella.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        javax.swing.JPanel pannello = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoRegione = new javax.swing.JTextField();
        bottoneCerca = new javax.swing.JButton();
        radioDataCrescente = new javax.swing.JRadioButton();
        javax.swing.JRadioButton radioPostiDecrescente = new javax.swing.JRadioButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaConcorsi = new javax.swing.JTable();
        bottoneDomanda = new javax.swing.JButton();

        pannello.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca concorso"));

        jLabel1.setText("Regione:");

        bottoneCerca.setText("jButton2");

        buttonGroup1.add(radioDataCrescente);
        radioDataCrescente.setText("Data crescente");

        buttonGroup1.add(radioPostiDecrescente);
        radioPostiDecrescente.setSelected(true);
        radioPostiDecrescente.setText("Posti decrescente");

        jLabel2.setText("Criterio di ordinamento:");

        javax.swing.GroupLayout pannelloLayout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(pannelloLayout);
        pannelloLayout.setHorizontalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoRegione)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bottoneCerca))
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioDataCrescente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioPostiDecrescente)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pannelloLayout.setVerticalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoRegione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(radioDataCrescente)
                    .addComponent(radioPostiDecrescente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaConcorsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabellaConcorsi);

        bottoneDomanda.setText("Nuova domanda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pannello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneDomanda))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pannello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneDomanda)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getCampoRegione() {
        return this.campoRegione.getText();
    }

    public boolean isRadioDataCrescente() {
        return this.radioDataCrescente.isSelected();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaConcorsi.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneDomanda;
    private javax.swing.JTextField campoRegione;
    private javax.swing.JRadioButton radioDataCrescente;
    private javax.swing.JTable tabellaConcorsi;
    // End of variables declaration//GEN-END:variables
}
