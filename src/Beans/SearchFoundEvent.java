package Beans;

import java.util.EventObject;

public class SearchFoundEvent extends EventObject
{
    private String _libelle;
    private boolean _etatCommande;

    public SearchFoundEvent(Object source, String lib, boolean etat)
    {
        super(source);
        _etatCommande = etat;
        _libelle = lib;
    }

    public String get_libelle()
    {
        return _libelle;
    }
    public boolean get_etatCommande()
    {
        return _etatCommande;
    }
}
