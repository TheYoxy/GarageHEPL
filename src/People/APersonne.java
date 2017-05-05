package People;

import Authenticate.AValider;
import Authenticate.Identifiable;

import java.util.Map;

public abstract class APersonne extends Personne implements AValider, Identifiable {
    private String _id; //Numero de matricule ou membre du personnel
    private String _pass;
    protected APersonne (String nom, String prenom, String adresse, String numeroTelephone, String id,String pass) {
        super(nom, prenom, adresse, numeroTelephone);
        _id = id;
        _pass = pass;
    }

    @Override
    public boolean isValid()
    {
        return false;
    }

    @Override
    public boolean validate(Map.Entry<String,String> entry)
    {
        return entry.getKey().equals(_id) && entry.getValue().equals(_pass);
    }

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public void setId(String id) {
        _id = id;
    }
}
