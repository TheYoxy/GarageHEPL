package People;

import java.io.Serializable;

public class Personne implements Serializable{

    private String Nom;
    private String Prenom;
    private String Adresse;
    private String NumeroTelephone;

    /**
     *
     */
    public Personne() {
    }

    /**
     * @param nom
     * @param prenom
     * @param adresse
     * @param numeroTelephone
     */
    public Personne(String nom, String prenom, String adresse, String numeroTelephone) {
        Nom = nom;
        Prenom = prenom;
        Adresse = adresse;
        NumeroTelephone = numeroTelephone;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return Nom + " " + Prenom;
    }

    /**
     * @return
     */
    public String getNumeroTelephone() {
        return NumeroTelephone;
    }

    /**
     * @param numeroTelephone
     */
    public void setNumeroTelephone(String numeroTelephone) {
        this.NumeroTelephone = numeroTelephone;
    }

    /**
     * @return
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.Prenom = prenom;
    }

    /**
     * @return
     */
    public String getAdresse() {
        return Adresse;
    }

    /**
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.Adresse = adresse;
    }

    /**
     * @return
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.Nom = nom;
    }
}
