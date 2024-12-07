package it.unibas.agenzia.persistenza;

/**
 *
 * @author David
 */
public class DAOException extends Exception {

    /**
     *
     */
    public DAOException (){}

    /**
     *
     * @param msg
     */
    public DAOException (String msg){super(msg);}

    /**
     *
     * @param ex
     */
    public DAOException (Exception ex){super(ex);}
}
