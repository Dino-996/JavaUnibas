package it.unibas.docenti.persistenza;

import it.unibas.docenti.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String file) throws DAOException;
}
