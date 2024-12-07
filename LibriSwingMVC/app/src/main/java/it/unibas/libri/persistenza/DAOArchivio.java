package it.unibas.libri.persistenza;

import it.unibas.libri.modello.Archivio;
import it.unibas.libri.modello.Prestito;
import it.unibas.libri.modello.Utente;
import java.time.LocalDate;
import java.time.Month;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();

        Utente harryPotter = new Utente("hpotter", "Harry", "Potter");
        Utente hermioneGranger = new Utente("hgranger", "Hermione", "Granger");

        Prestito prestito1 = new Prestito("Il Signore degli Anelli", "J.R.R. Tolkien", LocalDate.of(2023, 5, 1), LocalDate.of(2023, 8, 14));
        Prestito prestito2 = new Prestito("Norwegian Woods", "Murakami", LocalDate.of(2023, 10, 1), null); // Non restituito
        Prestito prestito3 = new Prestito("Orgoglio e Pregiudizio", "Jane Austen", LocalDate.of(2023, 9, 10), LocalDate.of(2024, 2, 10));
        Prestito prestito4 = new Prestito("1984", "George Orwell", LocalDate.of(2023, 9, 15), null); // Non restituito
        Prestito prestito5 = new Prestito("Harry Potter e la Pietra Filosofale", "J.K. Rowling", LocalDate.of(2023, 8, 1), null);  // Non restituito
        Prestito prestito6 = new Prestito("Invincible", "Abretta", LocalDate.of(2023, 6, 5), LocalDate.of(2023, 7, 21));

        harryPotter.addPrestito(prestito1);
        harryPotter.addPrestito(prestito2);
        harryPotter.addPrestito(prestito3);
        hermioneGranger.addPrestito(prestito4);
        hermioneGranger.addPrestito(prestito5);
        hermioneGranger.addPrestito(prestito6);

        archivio.addUtente(harryPotter);
        archivio.addUtente(hermioneGranger);

        return archivio;
    }
}
