package Beans;

import network.NetworkBasicServer;

public class ReceivingBean {

    private String _commande;

    public ReceivingBean()
    {
        setCommande("");
    }

    public String getCommande() { return _commande; }
    public void setCommande(String c){ _commande = c; }

    public void run(NetworkBasicServer serveur)
    {
        String message;

        while(true)
        {
            if((message = serveur.getMessage()).compareTo("RIEN") == 0)
            {
                setCommande(message);
            }
        }
    }

    public void addAlertListener(){/*Ici ce sera que le search bean normalement*/ }
    public void removeAlertListener(){}

}
