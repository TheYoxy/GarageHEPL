package People;

import Authenticate.AValider;
import Authenticate.Identifiable;

import java.util.Map;

public class TechnicienExterieur
        extends Personne implements Identifiable, AValider {
    private String _id;
    private String _pass;
    public TechnicienExterieur (String nom, String prenom, String adresse, String numeroTelephone, String id, String pass) {
        super(nom, prenom, adresse, numeroTelephone);
        _id = id;
        _pass = pass;
    }

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public void setId(String id) {
        _id = id;
    }

    @Override
    public boolean isValid () {
        return false;
    }

    @Override
    public boolean validate (final Map.Entry<String, String> entry) {
        return entry.getKey().equals(_id) && entry.getValue().equals(_pass);
    }
}
