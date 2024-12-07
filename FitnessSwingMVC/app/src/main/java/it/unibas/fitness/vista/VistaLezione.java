package it.unibas.fitness.vista;

import it.unibas.fitness.Applicazione;
import it.unibas.fitness.modello.Corso;
import it.unibas.fitness.modello.Costanti;
import it.unibas.fitness.modello.ECostanti;
import java.util.Date;

public class VistaLezione extends javax.swing.JDialog {

    public VistaLezione(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    public void inizializza() {
        this.initComponents();
        this.aggiornaComponenti();
        this.inizializzaAzioni();
        this.tabellaDettagliLezione.setModel(new ModelloTabellaDettagliCorso());
    }

    public void visualizza() {
        this.aggiornaTabella();
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }

    private void inizializzaAzioni() {
        this.bottoneAggiungi.setAction(Applicazione.getIstance().getControlloLezione().getAzioneAggiungi());
    }

    public void aggiornaTabella() {
        Corso corso = (Corso) Applicazione.getIstance().getModello().getBean(ECostanti.CORSO_SELEZIONATO);
        this.labelCorso.setText(corso.getNomeCorso());
        this.labelIstruttore.setText(corso.getNomeIstruttore());
        this.labelCostoMensile.setText(corso.getCostoMensile() + "");
        ModelloTabellaDettagliCorso modelloTabella = (ModelloTabellaDettagliCorso) this.tabellaDettagliLezione.getModel();
        modelloTabella.setListaDettagliCorso(corso.getListaDettagliCorso());
        modelloTabella.fireTableDataChanged();
    }

    private void aggiornaComponenti() {
        this.comboDifficolta.removeAllItems();
        this.comboDifficolta.addItem("");
        for (int i = Costanti.DIFF_MIN; i <= Costanti.DIFF_MAX; i++) {
            this.comboDifficolta.addItem(i + "");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        labelCorso = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelIstruttore = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        labelCostoMensile = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaDettagliLezione = new javax.swing.JTable();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        spinnerDataOra = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        comboDifficolta = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        campoDurata = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        radioChiuso = new javax.swing.JRadioButton();
        radioAperto = new javax.swing.JRadioButton();
        bottoneAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dettagli corso"));

        jLabel1.setText("Nome corso: ");

        labelCorso.setText("jLabel2");

        jLabel3.setText("Nome istruttore:");

        labelIstruttore.setText("jLabel4");

        jLabel5.setText("Costo mensile:");

        labelCostoMensile.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCorso)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIstruttore)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCostoMensile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelCorso)
                    .addComponent(jLabel3)
                    .addComponent(labelIstruttore)
                    .addComponent(jLabel5)
                    .addComponent(labelCostoMensile))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaDettagliLezione.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaDettagliLezione);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuova lezione"));

        spinnerDataOra.setModel(new javax.swing.SpinnerDateModel());

        jLabel2.setText("Data:");

        jLabel4.setText("Difficolta:");

        comboDifficolta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Durata:");

        jLabel7.setText("La lezione si svolge:");

        buttonGroup1.add(radioChiuso);
        radioChiuso.setSelected(true);
        radioChiuso.setText("Al chiuso");
        radioChiuso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioChiusoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioAperto);
        radioAperto.setText("All'aperto");

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioChiuso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioAperto)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDifficolta, 0, 91, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDurata, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerDataOra)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneAggiungi)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboDifficolta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(campoDurata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(radioChiuso)
                    .addComponent(radioAperto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerDataOra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(bottoneAggiungi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioChiusoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioChiusoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioChiusoActionPerformed

    public boolean isChiuso() {
        return this.radioChiuso.isSelected();
    }

    public String getDurata() {
        return this.campoDurata.getText();
    }

    public String getDifficolta() {
        return (String) this.comboDifficolta.getSelectedItem();
    }

    public Date getDataOra() {
        return (Date) this.spinnerDataOra.getValue();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JTextField campoDurata;
    private javax.swing.JComboBox<String> comboDifficolta;
    private javax.swing.JLabel labelCorso;
    private javax.swing.JLabel labelCostoMensile;
    private javax.swing.JLabel labelIstruttore;
    private javax.swing.JRadioButton radioAperto;
    private javax.swing.JRadioButton radioChiuso;
    private javax.swing.JSpinner spinnerDataOra;
    private javax.swing.JTable tabellaDettagliLezione;
    // End of variables declaration//GEN-END:variables
}
