package Beans;

import java.util.EventObject;

public class ReceiveMessageEvent extends EventObject
{
    /**
     *
     */
    private String Commande;

    /**
     * @param source
     * @param com
     */
    public ReceiveMessageEvent(Object source, String com)
    {
        super(source);
        Commande = com;
    }

    /**
     * @return
     */
    public String getCommande()
    {
        return Commande;
    }
}
