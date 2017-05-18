package People;

public class Mecanicien extends PersonnelGarage {
    /**
     *
     */
    private String Specialisation;

    /**
     *
     */
    public Mecanicien()
    {}

    /**
     * @param nom
     * @param prenom
     * @param adresse
     * @param numeroTelephone
     * @param id
     * @param specialisation
     */
    public Mecanicien(String nom, String prenom, String adresse, String numeroTelephone, String id,String specialisation) {
        super(nom, prenom, adresse, numeroTelephone, id);
        Specialisation = specialisation;
    }

    /**
     * @return
     */
    public String getSpecialisation() {
        return Specialisation;
    }

    /**
     * @param specialisation
     */
    public void setSpecialisation(String specialisation) {
        this.Specialisation = specialisation;
    }

}
