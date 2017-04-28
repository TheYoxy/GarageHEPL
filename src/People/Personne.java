package People;

public class Personne {
    protected String _nom;
    protected String _prenom;
    protected String _adresse;
    protected String _numeroTelephone;

    public Personne() {
    }

    public Personne(String nom, String prenom, String adresse, String numeroTelephone) {
        _nom = nom;
        _prenom = prenom;
        _adresse = adresse;
        _numeroTelephone = numeroTelephone;
    }

    @Override
    public String toString() {
        return _nom + " " + _prenom;
    }

    public String get_numeroTelephone() {
        return _numeroTelephone;
    }

    public void set_numeroTelephone(String _numeroTelephone) {
        this._numeroTelephone = _numeroTelephone;
    }

    public String get_prenom() {
        return _prenom;
    }

    public void set_prenom(String _prenom) {
        this._prenom = _prenom;
    }

    public String get_adresse() {
        return _adresse;
    }

    public void set_adresse(String _adresse) {
        this._adresse = _adresse;
    }

    public String get_nom() {
        return _nom;
    }

    public void set_nom(String _nom) {
        this._nom = _nom;
    }
}
