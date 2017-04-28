package People;

import Authenticate.Identifiable;

public class TechnicienExtérieur extends Personne implements Identifiable {
    private String Id;

    public TechnicienExtérieur(String nom, String prenom, String adresse, String numeroTelephone, String id) {
        super(nom, prenom, adresse, numeroTelephone);
        Id = id;
    }

    @Override
    public String getId() {
        return Id;
    }

    @Override
    public void setId(String id) {
        Id = id;
    }

}
