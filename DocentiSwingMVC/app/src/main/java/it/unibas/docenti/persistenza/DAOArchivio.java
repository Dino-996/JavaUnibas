package it.unibas.docenti.persistenza;

import it.unibas.docenti.modello.Archivio;
import it.unibas.docenti.modello.Docente;
import it.unibas.docenti.modello.Prenotazione;
import java.time.LocalDateTime;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        // Docente 1
        Docente bianchi = new Docente("Michele", "Bianchi", "Psicologia"); // 3
        bianchi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 1, 16, 30), LocalDateTime.of(2024, 9, 1, 16, 45), "54321"));
        bianchi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 3, 10, 0), LocalDateTime.of(2024, 9, 3, 10, 15), "12345"));
        bianchi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 10, 11, 30), LocalDateTime.of(2024, 9, 10, 11, 50), "98765"));
        bianchi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 5, 12, 0), LocalDateTime.of(2024, 9, 5, 12, 20), "12345"));
        bianchi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 5, 18, 30), LocalDateTime.of(2024, 9, 5, 19, 30), "54321"));

        // Docente 2
        Docente rossi = new Docente("Giovanni", "Rossi", "Matematica"); // 2
        rossi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 2, 9, 0), LocalDateTime.of(2024, 9, 2, 9, 20), "56789"));
        rossi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 4, 15, 0), LocalDateTime.of(2024, 9, 4, 15, 15), "67890"));

        // Docente 3
        Docente verdi = new Docente("Elena", "Verdi", "Psicologia"); // 4
        verdi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 1, 14, 0), LocalDateTime.of(2024, 9, 1, 14, 30), "23456"));
        verdi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 3, 16, 30), LocalDateTime.of(2024, 9, 3, 16, 50), "45678"));
        verdi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 5, 12, 0), LocalDateTime.of(2024, 9, 5, 12, 20), "23456"));
        verdi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 5, 12, 0), LocalDateTime.of(2024, 9, 5, 12, 20), "543298"));
        verdi.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 5, 12, 0), LocalDateTime.of(2024, 9, 5, 12, 20), "762312"));

        // Docente 4
        Docente neri = new Docente("Anna", "Neri", "Letteratura"); // 1
        neri.addPrenotazione(new Prenotazione(LocalDateTime.of(2024, 9, 2, 10, 0), LocalDateTime.of(2024, 9, 2, 10, 15), "11223"));
        
        archivio.addDocente(bianchi);
        archivio.addDocente(rossi);
        archivio.addDocente(verdi);
        archivio.addDocente(neri);
        
        return archivio;
    }

}
