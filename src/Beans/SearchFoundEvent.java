package Beans;

import java.util.EventObject;

public class SearchFoundEvent extends EventObject
{
    private String Libelle;
    private boolean EtatCommande;

    /**
     * @param source
     * @param lib
     * @param etat
     */
    public SearchFoundEvent(Object source, String lib, boolean etat)
    {
        super(source);
        EtatCommande = etat;
        Libelle = lib;
    }

    /**
     * @return
     */
    public String getLibelle()
    {
        return Libelle;
    }

    /**
     * @return
     */
    public boolean getEtatCommande()
    {
        return EtatCommande;
    }
}
