package People;

public class Employé extends PersonnelGarage {

    public Employé(String nom, String prenom, String adresse, String numeroTelephone, String id) {
        super(nom, prenom, adresse, numeroTelephone, id);
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean validate() {
        return false;
    }

}
