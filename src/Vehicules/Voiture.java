package Vehicules;

import People.Client;

public class Voiture extends Vehicule {
    private TypeVoiture Type;
    private Client Owner;
    private String Plaque;

    public Voiture(int nbRoues, int nbPlaces, String plaque, TypeVoiture type, Client owner) {
        super(nbRoues, nbPlaces);
        Type = type;
        Owner = owner;
        Plaque = plaque;
    }

    public Voiture(String plaque, TypeVoiture type, Client owner) {
        this(4, 5, plaque, type, owner);
    }

    public Voiture(String plaque, int nombrePortes, int type, String marque, Client owner) throws MissingTradeMarkException {
        this(plaque, new TypeVoiture(nombrePortes, type, marque), owner);
    }

    public Voiture(String plaque, TypeVoiture type,String nom,String prenom, String adresse, String numeroTelephone,String id) {
        this(plaque, type, new Client(nom, prenom, adresse, numeroTelephone, id));
    }

    public Voiture(String plaque, int nombrePortes, int type, String marque,String nom,String prenom, String adresse, String numeroTelephone,String id) throws MissingTradeMarkException {
        this(plaque, new TypeVoiture(nombrePortes, type, marque), new Client(nom, prenom, adresse, numeroTelephone, id));
    }

    public TypeVoiture getType() {
        return Type;
    }

    public Client getOwner() {
        return Owner;
    }

    public String getPlaque() {
        return Plaque;
    }

    @Override
    public String getId() {
        return Plaque;
    }

    @Override
    public void setId(String id) {
        Plaque = id;
    }

    @Override
    public String toString()
    {
        return Type.getMarque() + " " + Plaque;
    }

    @Override
    public String generateId() {
        return Plaque;
    }
}
