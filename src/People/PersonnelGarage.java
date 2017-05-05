package People;

public abstract class PersonnelGarage extends APersonne {

    protected PersonnelGarage(){}
    protected PersonnelGarage (String nom, String prenom, String adresse, String numeroTelephone, String id,String pass) {
        super(nom, prenom, adresse, numeroTelephone,id,pass);
    }
}
