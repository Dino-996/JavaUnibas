package it.unibas.agenzia.modello;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David
 */
public class Modello {

    private final Map<String, Object> bean = new HashMap<>();

    /**
     *
     * @param chiave
     * @param valore
     */
    public void putBean(String chiave, Object valore) {
        this.bean.put(chiave, valore);
    }

    /**
     *
     * @param chiave
     * @return
     */
    public Object getBean(String chiave) {
        return this.bean.get(chiave);
    }
}
