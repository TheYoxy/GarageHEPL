package People;

import java.io.Serializable;

public class Personne implements Serializable{
    private String _nom;
    private String _prenom;
    private String _adresse;
    private String _numeroTelephone;

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

    public void set_numeroTelephone(String numeroTelephone) {
        this._numeroTelephone = numeroTelephone;
    }

    public String get_prenom() {
        return _prenom;
    }

    public void set_prenom(String prenom) {
        this._prenom = prenom;
    }

    public String get_adresse() {
        return _adresse;
    }

    public void set_adresse(String adresse) {
        this._adresse = adresse;
    }

    public String get_nom() {
        return _nom;
    }

    public void set_nom(String nom) {
        this._nom = nom;
    }
}
