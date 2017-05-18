package People;

import Authenticate.AValider;
import Authenticate.Identifiable;

import java.util.Map;

public abstract class APersonne extends Personne implements AValider, Identifiable {
    /**
     *
     */
    private String Id; //Numero de matricule ou membre du personnel
//    private String _pass;

    /**
     *
     */
    protected APersonne(){}

    /**
     * @param nom
     * @param prenom
     * @param adresse
     * @param numeroTelephone
     * @param id
     */
    protected APersonne (String nom, String prenom, String adresse, String numeroTelephone, String id) {
        super(nom, prenom, adresse, numeroTelephone);
        Id = id;
//        _pass = pass;
    }

    /**
     * @return
     */
    @Override
    public boolean isValid()
    {
        return false;
    }

    /**
     * @param entry
     * @return
     */
    @Override
    public boolean validate(Map.Entry<String,String> entry)
    {
//        return entry.getKey().equals(Id) && entry.getValue().equals(_pass);
        return false;
    }

    /**
     * @return
     */
    @Override
    public String getId() {
        return Id;
    }

    /**
     * @param id
     */
    @Override
    public void setId(String id) {
        Id = id;
    }
}
