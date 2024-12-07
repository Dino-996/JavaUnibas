package it.unibas.fitness.vista;

import it.unibas.fitness.Applicazione;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Frame extends javax.swing.JFrame {
    
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            log.debug("Errore durante il caricamento del Look&Feel: " + ex.getMessage());
        }
    }
    
    public void inizializza() {
        this.initComponents();
        VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
        this.setContentPane(new JScrollPane(vistaPrincipale));
        this.setTitle("Automobili");
        this.setMinimumSize(new Dimension(700, 500));
        this.inizializzaAzioni();
        this.setLocationRelativeTo(this);
        this.setVisible(true);
    }
    
    public void getMessage(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, "Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void getErrore(String errore) {
        JOptionPane.showMessageDialog(this, errore, "Errore", JOptionPane.ERROR_MESSAGE);
    }
    
    private void inizializzaAzioni() {
        this.azioneCarica.setAction(Applicazione.getIstance().getControlloMenu().getAzioneCarica());
        this.azioneCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.azioneEsci.setAction(Applicazione.getIstance().getControlloMenu().getAzioneEsci());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        azioneCarica = new javax.swing.JMenuItem();
        azioneCerca = new javax.swing.JMenuItem();
        azioneEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        azioneCarica.setText("jMenuItem1");
        jMenu1.add(azioneCarica);

        azioneCerca.setText("jMenuItem2");
        jMenu1.add(azioneCerca);

        azioneEsci.setText("jMenuItem3");
        jMenu1.add(azioneEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem azioneCarica;
    private javax.swing.JMenuItem azioneCerca;
    private javax.swing.JMenuItem azioneEsci;
    // End of variables declaration//GEN-END:variables
}
