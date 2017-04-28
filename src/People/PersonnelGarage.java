package People;

import Authenticate.AValider;
import Authenticate.Identifiable;

public abstract class PersonnelGarage extends Personne implements AValider, Identifiable {

    protected String Id; //Numero de matricule ou membre du personnel

    public PersonnelGarage(String nom, String prenom, String adresse, String numeroTelephone, String id) {
        super(nom, prenom, adresse, numeroTelephone);
        Id = id;
    }

    @Override
    public abstract boolean isValid();

    @Override
    public abstract boolean validate();

    @Override
    public String getId() {
        return Id;
    }

    @Override
    public void setId(String id) {
        Id = id;
    }
}
