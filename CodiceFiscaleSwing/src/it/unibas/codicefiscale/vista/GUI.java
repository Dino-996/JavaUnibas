package it.unibas.codicefiscale.vista;

import it.unibas.codicefiscale.modello.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GUI extends javax.swing.JFrame {
    
    public static final Logger logger = LoggerFactory.getLogger(Persona.class);
    
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            logger.warn(GUI.class.getName());
        }
    }
    
    private void inizializza() {
        this.initComponents();
        this.inizializzaComponenti();
        this.inizializzaAzioni();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void inizializzaComponenti() {
        try {
            this.setIconImage(new ImageIcon(ClassLoader.getSystemResource("risorse/test.png")).getImage());
        } catch (NullPointerException e) {
            logger.debug("La risorsa non è stata trovata");
        }
        this.comboSesso.removeAllItems();
        this.comboSesso.addItem("");
        this.comboSesso.addItem("Maschio");
        this.comboSesso.addItem("Femmina");
    }
    
    private void inizializzaAzioni() {
        this.menuEsci.setAction(this.azioneEsci);
        this.menuCalcola.setAction(this.azioneCalcola);
        this.bottoneInvia.setAction(this.azioneCalcola);
        this.campoNome.setAction(this.azioneCalcola);
        this.campoCognome.setAction(this.azioneCalcola);
        this.campoLuogo.setAction(this.azioneCalcola);
        this.campoAnno.setAction(this.azioneCalcola);
    }
    
    public void errore(String errore) {
        JOptionPane.showMessageDialog(this, errore, "Errore", JOptionPane.ERROR_MESSAGE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pannello = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoCognome = new javax.swing.JTextField();
        campoAnno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        campoLuogo = new javax.swing.JTextField();
        comboSesso = new javax.swing.JComboBox<>();
        labelRisultato = new javax.swing.JLabel();
        bottoneInvia = new javax.swing.JButton();
        javax.swing.JMenuBar menu = new javax.swing.JMenuBar();
        javax.swing.JMenu File = new javax.swing.JMenu();
        menuCalcola = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Codice Fiscale");

        pannello.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserisci i dati della persona"));
        pannello.setToolTipText("");
        pannello.setName(""); // NOI18N

        jLabel1.setText("Nome:");

        jLabel2.setText("Cognome:");

        jLabel3.setText("Sesso:");

        jLabel4.setText("Anno:");

        jLabel5.setText("Luogo:");

        comboSesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelRisultato.setBackground(new java.awt.Color(51, 153, 0));
        labelRisultato.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelRisultato.setForeground(new java.awt.Color(255, 255, 255));
        labelRisultato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRisultato.setText("RISULTATO");
        labelRisultato.setOpaque(true);

        bottoneInvia.setText("Invio");

        javax.swing.GroupLayout pannelloLayout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(pannelloLayout);
        pannelloLayout.setHorizontalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(campoCognome))
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pannelloLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoNome))
                            .addGroup(pannelloLayout.createSequentialGroup()
                                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(10, 10, 10)
                                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoAnno)
                                    .addComponent(campoLuogo)
                                    .addComponent(comboSesso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelRisultato, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneInvia)))
                .addContainerGap())
        );
        pannelloLayout.setVerticalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboSesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoLuogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneInvia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRisultato, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        File.setText("File");

        menuCalcola.setText("Calcola");
        File.add(menuCalcola);

        menuEsci.setText("Esci");
        File.add(menuEsci);

        menu.add(File);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pannello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pannello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI();
            gui.inizializza();
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneInvia;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoCognome;
    private javax.swing.JTextField campoLuogo;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> comboSesso;
    private javax.swing.JLabel labelRisultato;
    private javax.swing.JMenuItem menuCalcola;
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JPanel pannello;
    // End of variables declaration//GEN-END:variables

// Controllo
    private final AzioneEsci azioneEsci = new AzioneEsci();
    private final AzioneCalcola azioneCalcola = new AzioneCalcola();
    
    private class AzioneEsci extends AbstractAction {
        
        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    private class AzioneCalcola extends AbstractAction {
        
        public AzioneCalcola() {
            this.putValue(NAME, "Calcola");
            this.putValue(SHORT_DESCRIPTION, "Calcola codice fiscale");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = campoNome.getText();
            String cognome = campoCognome.getText();
            String anno = campoAnno.getText();
            String luogo = campoLuogo.getText();
            String sesso = (String) comboSesso.getSelectedItem();
            String errori = convalidaDati(nome, cognome, luogo, sesso, anno);
            if (!errori.isEmpty()) {
                logger.error("Errori nella convalida {}", errori);
                errore(errori);
                return;
            }
            int interoAnno = Integer.parseInt(anno);
            Persona persona = new Persona();
            persona.setNome(nome);
            persona.setCognome(cognome);
            persona.setAnno(interoAnno);
            persona.setLuogo(luogo);
            persona.setSesso(sesso);
            String codiceFiscale = persona.getCodiceFiscale();
            logger.debug("Codice fiscale: {}", codiceFiscale);
            labelRisultato.setText(codiceFiscale);
        }
        
        private String convalidaDati(String nome, String cognome, String luogo, String sesso, String anno) {
            StringBuilder sb = new StringBuilder();
            if (nome.trim().isEmpty()) {
                sb.append("Il campo nome non puo essere vuoto\n");
            } else if (nome.length() < 3) {
                sb.append("Il campo nome deve essere almeno di 3 caratteri\n");
            }
            if (cognome.trim().isEmpty()) {
                sb.append("Il campo cognome non puo essere vuoto\n");
            } else if (cognome.length() < 3) {
                sb.append("Il campo cognome deve essere almeno di 3 caratteri\n");
            }
            if (luogo.isEmpty()) {
                sb.append("Il campo luogo non puo essere vuoto\n");
            }
            if (sesso.isEmpty()) {
                sb.append("Il campo sesso non può essere vuoto\n");
            }
            if (anno.isEmpty()) {
                sb.append("Il campo anno non può essere vuoto\n");
            } else {
                try {
                    Integer.valueOf(anno);
                } catch (NumberFormatException e) {
                    sb.append("Il campo anno deve essere un'intero\n");
                }
            }
            return sb.toString().trim();
        }
    }
}
