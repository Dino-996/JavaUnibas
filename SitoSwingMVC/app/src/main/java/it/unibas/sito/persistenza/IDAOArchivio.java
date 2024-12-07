package it.unibas.sito.persistenza;

import it.unibas.sito.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String file) throws DAOException;
}
