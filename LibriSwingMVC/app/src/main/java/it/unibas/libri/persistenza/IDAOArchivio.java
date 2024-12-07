package it.unibas.libri.persistenza;

import it.unibas.libri.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String file) throws DAOException;
}
