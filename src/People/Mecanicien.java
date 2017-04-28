package People;

public class Mecanicien extends PersonnelGarage {
    private String _specialisation;

    public Mecanicien(String nom, String prenom, String adresse, String numeroTelephone, String id, String specialisation) {
        super(nom, prenom, adresse, numeroTelephone, id);
        _specialisation = specialisation;
    }

    public String getSpecialisation() {
        return _specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this._specialisation = specialisation;
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
