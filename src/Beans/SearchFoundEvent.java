package Beans;

import java.util.EventObject;

public class SearchFoundEvent extends EventObject
{
    private String libelle;
    private boolean etatCommande;

    public SearchFoundEvent(Object source, String lib, boolean etat)
    {
        super(source);
        etatCommande = etat;
        libelle = lib;
    }

    public String getLibelle()
    {
        return libelle;
    }
    public boolean getEtatCommande()
    {
        return etatCommande;
    }
}
