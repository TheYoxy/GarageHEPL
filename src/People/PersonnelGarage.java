package People;

public abstract class PersonnelGarage extends APersonne {

    /**
     *
     */
    protected PersonnelGarage(){}

    /**
     * @param nom
     * @param prenom
     * @param adresse
     * @param numeroTelephone
     * @param id
     */
    protected PersonnelGarage (String nom, String prenom, String adresse, String numeroTelephone, String id) {
        super(nom, prenom, adresse, numeroTelephone,id);
    }
}
