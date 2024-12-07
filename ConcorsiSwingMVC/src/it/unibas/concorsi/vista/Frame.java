package it.unibas.concorsi.vista;

import it.unibas.concorsi.Applicazione;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame extends javax.swing.JFrame {
    
    private final static Logger console = LoggerFactory.getLogger(Frame.class);

    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            console.debug("Impossibile caricare il look&feel: " + ex.getMessage());
        }
    }

    public void inizializza() {
        this.initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Concorsi pubblici");
        this.inizializzaAzioni();
        this.pack();
        VistaPrincipale vista = Applicazione.getInstance().getVistaPrincipale();
        this.setContentPane(new JScrollPane(vista));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void inizializzaAzioni() {
        this.menuCarica.setAction(Applicazione.getInstance().getControlloMenu().getAzioneCarica());
        this.menuCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.menuEsci.setAction(Applicazione.getInstance().getControlloMenu().getAzioneEsci());
    }

    public void getMessaggio(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, "Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }

    public void getErrore(String errore) {
        JOptionPane.showMessageDialog(this, errore, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuCarica = new javax.swing.JMenuItem();
        menuCerca = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        menuCarica.setText("jMenuItem1");
        jMenu1.add(menuCarica);

        menuCerca.setText("jMenuItem2");
        jMenu1.add(menuCerca);

        menuEsci.setText("jMenuItem3");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCarica;
    private javax.swing.JMenuItem menuCerca;
    private javax.swing.JMenuItem menuEsci;
    // End of variables declaration//GEN-END:variables
}
