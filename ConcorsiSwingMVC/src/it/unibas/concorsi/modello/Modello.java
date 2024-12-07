package it.unibas.concorsi.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private final Map<String, Object> beans = new HashMap<>();

    public Object getBeans(String chiave) {
        return this.beans.get(chiave);
    }

    public void putBean(String chiave, Object valore) {
        this.beans.put(chiave, valore);
    }
}
