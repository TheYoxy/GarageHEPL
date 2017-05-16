package Beans;

import java.util.EventObject;

public class SearchFoundEvent extends EventObject
{
    private String libelle;

    public SearchFoundEvent(Object source, String libelle)
    {
        super(source);
    }

    public String getLibelle()
    {
        return libelle;
    }
}
