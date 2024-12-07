package it.unibas.agenzia.vista;

import it.unibas.agenzia.Applicazione;
import it.unibas.agenzia.modello.Agenzia;
import it.unibas.agenzia.modello.Costanti;
import java.util.Date;

/**
 *
 * @author David
 */
public class VistaPacchetto extends javax.swing.JDialog {

    /**
     *
     * @param parent
     * @param modal
     */
    public VistaPacchetto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    /**
     *
     */
    public void inizializza() {
        this.initComponents();
        this.setTitle("Pacchetto vacanza");
        this.inizializzaAzioni();
        this.tabellaPacchetto.setModel(new ModelloTabellaDettagliPacchetto());
    }

    /**
     *
     */
    public void visualizza() {
        this.aggiornaComponenti();
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }

    /**
     *
     */
    public void aggiornaComponenti() {
        Agenzia agenzia = (Agenzia) Applicazione.getIstance().getModello().getBean(Costanti.AGENZIA_SELEZIONATA);
        this.labelAgenzia.setText(agenzia.getNome());
        this.labelCitta.setText(agenzia.getCitta());
        this.labelCodiceUnivoco.setText(agenzia.getCodiceUnivoco() + "");
        this.comboTipologia.removeAllItems();
        this.comboTipologia.addItem("");
        this.comboTipologia.addItem(Costanti.CITTA);
        this.comboTipologia.addItem(Costanti.CROCIERA);
        this.comboTipologia.addItem(Costanti.VILLAGGIO);
        ModelloTabellaDettagliPacchetto modelloTabella = (ModelloTabellaDettagliPacchetto) this.tabellaPacchetto.getModel();
        modelloTabella.setListaDettagliPacchettoVacanza(agenzia.listaDettagliPacchettoVacanza());
        modelloTabella.aggiornaTabella();
    }

    private void inizializzaAzioni() {
        this.bottoneAggiungi.setAction(Applicazione.getIstance().getControlloPacchetto().getAzioneAggiungi());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        labelCodiceUnivoco = new javax.swing.JLabel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        labelAgenzia = new javax.swing.JLabel();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        labelCitta = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPacchetto = new javax.swing.JTable();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoDestinazione = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        spinnerImporto = new javax.swing.JSpinner();
        spinnerDataOra = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        spinnerDurata = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        comboTipologia = new javax.swing.JComboBox<>();
        bottoneAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agenzia selezionata"));

        jLabel6.setText("Codice univoco:");

        labelCodiceUnivoco.setText("jLabel7");

        jLabel8.setText("Nome agenzia:");

        labelAgenzia.setText("jLabel9");

        jLabel10.setText("Citta:");

        labelCitta.setText("jLabel11");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCodiceUnivoco)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAgenzia)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCitta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelCodiceUnivoco)
                    .addComponent(jLabel8)
                    .addComponent(labelAgenzia)
                    .addComponent(jLabel10)
                    .addComponent(labelCitta))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tabellaPacchetto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaPacchetto);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aggiungi pacchetto"));

        jLabel1.setText("Destinazione:");

        jLabel2.setText("Importo:");

        spinnerImporto.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        spinnerDataOra.setModel(new javax.swing.SpinnerDateModel());

        jLabel3.setText("Data:");

        jLabel4.setText("Durata:");

        spinnerDurata.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel5.setText("Tipologia:");

        comboTipologia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDestinazione))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerDataOra)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerImporto)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerDurata))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipologia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneAggiungi)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoDestinazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(spinnerImporto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spinnerDurata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerDataOra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(comboTipologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @return
     */
    public int getDurata() {
        return (Integer) this.spinnerDurata.getValue();
    }

    /**
     *
     * @return
     */
    public double getImporto() {
        return (Double) this.spinnerImporto.getValue();
    }

    /**
     *
     * @return
     */
    public Date getDataOra() {
        return (Date) this.spinnerDataOra.getValue();
    }

    /**
     *
     * @return
     */
    public String getCampoDestinazione() {
        return this.campoDestinazione.getText();
    }

    /**
     *
     * @return
     */
    public String getComboTipologia() {
        return (String) this.comboTipologia.getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JTextField campoDestinazione;
    private javax.swing.JComboBox<String> comboTipologia;
    private javax.swing.JLabel labelAgenzia;
    private javax.swing.JLabel labelCitta;
    private javax.swing.JLabel labelCodiceUnivoco;
    private javax.swing.JSpinner spinnerDataOra;
    private javax.swing.JSpinner spinnerDurata;
    private javax.swing.JSpinner spinnerImporto;
    private javax.swing.JTable tabellaPacchetto;
    // End of variables declaration//GEN-END:variables
}
