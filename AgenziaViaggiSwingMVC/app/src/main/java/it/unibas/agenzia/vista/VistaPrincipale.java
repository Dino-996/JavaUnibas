package it.unibas.agenzia.vista;

import it.unibas.agenzia.Applicazione;
import it.unibas.agenzia.modello.Agenzia;
import it.unibas.agenzia.modello.Costanti;
import java.util.List;

/**
 *
 * @author David
 */
public class VistaPrincipale extends javax.swing.JPanel {

    /**
     *
     */
    public void inizializza() {
        this.initComponents();
        this.aggiornaComponenti();
        this.inizializzaAzioni();
        this.tabellaAgenzie.setModel(new ModelloTabellaAgenzie());
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneVisualizzaPacchetto.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza());
        this.bottoneVerificaArchivio.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneVerifica());
    }
    
    private void aggiornaComponenti() {
        this.radioNomeCrescente.setText(Costanti.NOME_CRESCENTE);
        this.radioNomeDecrescente.setText(Costanti.NOME_DECRESCENTE);
    }

    /**
     *
     */
    public void aggiornaTabella() {
        List<Agenzia> listaFiltrata = (List<Agenzia>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaAgenzie modelloTabellaAgenzie = (ModelloTabellaAgenzie) this.tabellaAgenzie.getModel();
        modelloTabellaAgenzie.setListaAgenzie(listaFiltrata);
        modelloTabellaAgenzie.aggiornaTabella();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        radioNomeCrescente = new javax.swing.JRadioButton();
        radioNomeDecrescente = new javax.swing.JRadioButton();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAgenzie = new javax.swing.JTable();
        bottoneVisualizzaPacchetto = new javax.swing.JButton();
        bottoneVerificaArchivio = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca agenzie"));

        jLabel1.setText("Ordinamento:");

        buttonGroup1.add(radioNomeCrescente);
        radioNomeCrescente.setSelected(true);
        radioNomeCrescente.setText("jRadioButton1");

        buttonGroup1.add(radioNomeDecrescente);
        radioNomeDecrescente.setText("jRadioButton2");

        bottoneCerca.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(radioNomeCrescente)
                .addGap(18, 18, 18)
                .addComponent(radioNomeDecrescente)
                .addGap(18, 18, 18)
                .addComponent(bottoneCerca)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radioNomeCrescente)
                    .addComponent(radioNomeDecrescente)
                    .addComponent(bottoneCerca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaAgenzie.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAgenzie);

        bottoneVisualizzaPacchetto.setText("jButton1");

        bottoneVerificaArchivio.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bottoneVerificaArchivio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottoneVisualizzaPacchetto)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bottoneVisualizzaPacchetto)
                    .addComponent(bottoneVerificaArchivio))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @return
     */
    public boolean isNomeCrescente() {
        return this.radioNomeCrescente.isSelected();
    }

    /**
     *
     * @return
     */
    public boolean isNomeDecrescente() {
        return this.radioNomeDecrescente.isSelected();
    }

    /**
     *
     * @return
     */
    public int getRigaSelezionata() {
        return this.tabellaAgenzie.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneVerificaArchivio;
    private javax.swing.JButton bottoneVisualizzaPacchetto;
    private javax.swing.JRadioButton radioNomeCrescente;
    private javax.swing.JRadioButton radioNomeDecrescente;
    private javax.swing.JTable tabellaAgenzie;
    // End of variables declaration//GEN-END:variables
}
