package Beans;

import java.util.EventObject;

public class ReceiveMessageEvent extends EventObject
{
    private String _commande;

    public ReceiveMessageEvent(Object source, String com)
    {
        super(source);
        _commande = com;
    }

    public String getCommande()
    {
        return _commande;
    }
}
