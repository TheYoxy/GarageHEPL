package Beans;

import java.util.EventObject;

public class InStockEvent extends EventObject
{
    private String Libelle;
    private boolean EtatCommande;
    private int DateMois;

    public InStockEvent(Object source, String lib, boolean etat, int mois)
    {
        super(source);
        EtatCommande = etat;
        Libelle = lib;
        DateMois = mois;
    }

    public String getLibelle()
    {
        return Libelle;
    }
    public boolean getEtatCommande()
    {
        return EtatCommande;
    }
    public int getDateMois(){return DateMois;}
}
