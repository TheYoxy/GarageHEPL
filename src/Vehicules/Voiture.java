package Vehicules;

import People.Client;

public class Voiture extends Vehicule {
    /**
     *
     */
    private TypeVoiture Type;
    /**
     *
     */
    private Client Owner;
    /**
     *
     */
    private String Plaque;

    /**
     * @param nbRoues
     * @param nbPlaces
     * @param plaque
     * @param type
     * @param owner
     */
    private Voiture(int nbRoues, int nbPlaces, String plaque, TypeVoiture type, Client owner) {
        super(nbRoues, nbPlaces);
        Type = type;
        Owner = owner;
        Plaque = plaque;
    }

    /**
     * @param plaque
     * @param type
     * @param owner
     */
    public Voiture(String plaque, TypeVoiture type, Client owner) {
        this(4, 5, plaque, type, owner);
    }

    /**
     * @param plaque
     * @param nombrePortes
     * @param type
     * @param marque
     * @param owner
     * @throws MissingTradeMarkException
     */
    public Voiture(String plaque, int nombrePortes, int type, String marque, Client owner) throws MissingTradeMarkException {
        this(plaque, new TypeVoiture(nombrePortes, type, marque), owner);
    }

    /**
     * @param plaque
     * @param type
     * @param nom
     * @param prenom
     * @param adresse
     * @param numeroTelephone
     * @param id
     */
    public Voiture(String plaque, TypeVoiture type, String nom, String prenom, String adresse, String numeroTelephone, String id) {
        this(plaque, type, new Client(nom, prenom, adresse, numeroTelephone, id));
    }

    /**
     * @param plaque
     * @param nombrePortes
     * @param type
     * @param marque
     * @param nom
     * @param prenom
     * @param adresse
     * @param numeroTelephone
     * @param id
     * @throws MissingTradeMarkException
     */
    public Voiture(String plaque, int nombrePortes, int type, String marque, String nom, String prenom, String adresse, String numeroTelephone, String id) throws MissingTradeMarkException {
        this(plaque, new TypeVoiture(nombrePortes, type, marque), new Client(nom, prenom, adresse, numeroTelephone, id));
    }

    /**
     * @return
     */
    public TypeVoiture getType() {
        return Type;
    }

    /**
     * @return
     */
    public Client getOwner() {
        return Owner;
    }

    /**
     * @return
     */
    public String getPlaque() {
        return Plaque;
    }

    /**
     * @return
     */
    @Override
    public String getId() {
        return Plaque;
    }

    /**
     * @param id
     */
    @Override
    public void setId(String id) {
        Plaque = id;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return Type.getMarque() + " " + Plaque;
    }

    /**
     * @return
     */
    @Override
    public String generateId() {
        return Plaque;
    }
}
