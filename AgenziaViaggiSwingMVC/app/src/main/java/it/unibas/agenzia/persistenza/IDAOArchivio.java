package it.unibas.agenzia.persistenza;

import it.unibas.agenzia.modello.Archivio;

/**
 *
 * @author David
 */
public interface IDAOArchivio {

    /**
     *
     * @param file
     * @return
     * @throws DAOException
     */
    Archivio carica(String file) throws DAOException;
}
