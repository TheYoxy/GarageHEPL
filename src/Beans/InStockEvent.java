package Beans;

import java.util.EventObject;

public class InStockEvent extends EventObject
{
    private String _libelle;
    private boolean _etatCommande;
    private int _dateMois;

    public InStockEvent(Object source, String lib, boolean etat, int mois)
    {
        super(source);
        _etatCommande = etat;
        _libelle = lib;
        _dateMois = mois;
    }

    public String getLibelle()
    {
        return _libelle;
    }
    public boolean getEtatCommande()
    {
        return _etatCommande;
    }
    public int get_dateMois(){return _dateMois;}
}
