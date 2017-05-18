package People;

public class Employe
        extends PersonnelGarage {

    /**
     *
     */
    public Employe() {
    }

    /**
     * @param nom
     * @param prenom
     * @param adresse
     * @param numeroTelephone
     * @param id
     */
    public Employe(String nom, String prenom, String adresse, String numeroTelephone, String id) {
        super(nom, prenom, adresse, numeroTelephone, id);
    }
}
