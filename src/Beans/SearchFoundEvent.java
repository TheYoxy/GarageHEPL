package Beans;

import java.util.EventObject;

public class SearchFoundEvent extends EventObject
{
    private String libelle;
    private String etatCommande;

    public SearchFoundEvent(Object source, String libelle, String etatCommande)
    {
        super(source);
    }

    public String getLibelle()
    {
        return libelle;
    }
}
