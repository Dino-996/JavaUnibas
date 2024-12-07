package it.unibas.agenzia.vista;

import it.unibas.agenzia.Applicazione;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author David
 */
@Slf4j
public class Frame extends javax.swing.JFrame {

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            log.debug("Non e' stato possibile caricare il lookAndFeel");
        }
    }

    /**
     *
     */
    public void inizializza() {
        this.initComponents();
        VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
        this.setContentPane(new JScrollPane(vistaPrincipale));
        this.inizializzaAzioni();
        this.setTitle("Agenzie");
        this.setSize(new Dimension(700, 700));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void inizializzaAzioni() {
        this.menuCarica.setAction(Applicazione.getIstance().getControlloMenu().getAzioneCarica());
        this.menuCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.menuEsci.setAction(Applicazione.getIstance().getControlloMenu().getAzioneEsci());
    }

    /**
     *
     * @param messaggio
     */
    public void getMessage(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, "Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     *
     * @param errore
     */
    public void getErrore(String errore) {
        JOptionPane.showMessageDialog(this, errore, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu File = new javax.swing.JMenu();
        menuCarica = new javax.swing.JMenuItem();
        menuCerca = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        File.setText("File");

        menuCarica.setText("jMenuItem1");
        menuCarica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCaricaActionPerformed(evt);
            }
        });
        File.add(menuCarica);

        menuCerca.setText("jMenuItem2");
        File.add(menuCerca);

        menuEsci.setText("jMenuItem3");
        File.add(menuEsci);

        jMenuBar1.add(File);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCaricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCaricaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCaricaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuCarica;
    private javax.swing.JMenuItem menuCerca;
    private javax.swing.JMenuItem menuEsci;
    // End of variables declaration//GEN-END:variables
}
