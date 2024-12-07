package it.unibas.sito.persistenza;

import it.unibas.sito.modello.Archivio;
import it.unibas.sito.modello.Pagina;
import it.unibas.sito.modello.SitoWeb;
import java.time.LocalDate;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        SitoWeb sito1 = new SitoWeb("Corso di laurea di Informatica", "https://informatica.unibas.it");
        sito1.addPagina(new Pagina("/home", "Pagina Principale", LocalDate.of(2024, 4, 22)));
        sito1.addPagina(new Pagina("/corsi", "Elenco dei Corsi", LocalDate.of(2024, 4, 20)));
        sito1.addPagina(new Pagina("/docenti", "Elenco dei Docenti", LocalDate.of(2024, 3, 15)));
        sito1.addPagina(new Pagina("/contatti", "Contatti e Informazioni", LocalDate.of(2023, 12, 5)));

        SitoWeb sito2 = new SitoWeb("Biblioteca Unibas", "https://biblioteca.unibas.it");
        sito2.addPagina(new Pagina("/home", "Home Page", LocalDate.of(2024, 12, 13)));
        sito2.addPagina(new Pagina("/catalogo", "Catalogo dei Libri", LocalDate.of(2024, 12, 15)));
        sito2.addPagina(new Pagina("/orari", "Orari di Apertura", LocalDate.of(2024, 12, 18)));

        SitoWeb sito3 = new SitoWeb("Eventi Basilicata", "https://eventi.basilicata.it");
        sito3.addPagina(new Pagina("/home", "Pagina Principale", LocalDate.of(2024, 3, 20)));
        sito3.addPagina(new Pagina("/eventi", "Calendario Eventi", LocalDate.of(2024, 4, 10)));
        sito3.addPagina(new Pagina("/biglietti", "Biglietteria", LocalDate.of(2024, 4, 5)));
        sito3.addPagina(new Pagina("/notizie", "Notizie e Aggiornamenti", LocalDate.of(2024, 3, 25)));
        
        archivio.addSitoWeb(sito1);
        archivio.addSitoWeb(sito2);
        archivio.addSitoWeb(sito3);
        
        return archivio;
    }    
}
