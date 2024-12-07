package it.unibas.film;

import javax.swing.SwingUtilities;
import lombok.Getter;

@Getter
public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    public static Applicazione getIstance() {
        return singleton;
    }

    private void inizializza() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
