package it.unibas.ricettario.vista;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.inizializzaComponenti();
        this.inizializzaAzioni();
        this.tabellaPietanze.setModel(new ModelloTabellaPietanze());
    }

    private void inizializzaComponenti() {
        this.comboCategoria.removeAllItems();
        this.comboCategoria.addItem("");
        this.comboCategoria.addItem(Costanti.ANTIPASTO);
        this.comboCategoria.addItem(Costanti.PRIMO);
        this.comboCategoria.addItem(Costanti.SECONDO);
        this.comboCategoria.addItem(Costanti.DESSERT);
    }
    
    private void inizializzaAzioni() {
        this.bottoneCercaPerCategoria.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneCercaPietanzaKcalSimile.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCercaPietanzaCaloricamenteSimile());
    }
    
    public void aggiornaTabella() {
        List<Pietanza> listaPietanze = (List<Pietanza>) Applicazione.getIstance().getModello().getBean(Costanti.PIETANZE);
        ModelloTabellaPietanze modelloTabella = (ModelloTabellaPietanze) this.tabellaPietanze.getModel();
        modelloTabella.setPietanze(listaPietanze);
        modelloTabella.aggiornaTabella(); // Aggiorna il contenuto della tabella
    }

    public String getCategoria() {
        return (String) this.comboCategoria.getSelectedItem();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaPietanze.getSelectedRow();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        comboCategoria = new javax.swing.JComboBox<>();
        bottoneCercaPerCategoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPietanze = new javax.swing.JTable();
        bottoneCercaPietanzaKcalSimile = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca per categoria"));

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCercaPerCategoria.setText("Cerca");
        bottoneCercaPerCategoria.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneCercaPerCategoria)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCercaPerCategoria))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaPietanze.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaPietanze);

        bottoneCercaPietanzaKcalSimile.setText("Cerca pietanza");
        bottoneCercaPietanzaKcalSimile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottoneCercaPietanzaKcalSimileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneCercaPietanzaKcalSimile)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneCercaPietanzaKcalSimile)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bottoneCercaPietanzaKcalSimileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottoneCercaPietanzaKcalSimileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bottoneCercaPietanzaKcalSimileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCercaPerCategoria;
    private javax.swing.JButton bottoneCercaPietanzaKcalSimile;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaPietanze;
    // End of variables declaration//GEN-END:variables
}
