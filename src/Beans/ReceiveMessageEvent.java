package Beans;

import java.util.EventObject;

public class ReceiveMessageEvent extends EventObject
{
    private String commande;

    public ReceiveMessageEvent(Object source, String commande)
    {
        super(source);
    }

    public String getCommande()
    {
        return commande;
    }
}
