package Beans;

import network.NetworkBasicServer;

import java.util.Vector;

public class ReceivingBean implements InStockListener {

    private String _commande;
    private Vector ReceivingMessageListeners;
    private NetworkBasicServer _ser;

    public ReceivingBean()
    {
        setCommande("");
        ReceivingMessageListeners = new Vector();
    }

    @Override
    public void InStockDetected(InStockEvent e) {
        //Envoie de la réponse au cllient :
        _ser.sendMessage(e.getEtatCommande() + ";" + e.getLibelle() + ";" + e.get_dateMois());
    }

    public String getCommande() { return _commande; }
    public void setCommande(String c){ _commande = c; }

    public void run(NetworkBasicServer serveur)
    {
        _ser = serveur;

        String message;

        while(true)
        {
            if((message = serveur.getMessage()).compareTo("RIEN") != 0)
            {
                setCommande(message);
                notifyReceiveMesageDetected();
            }
        }
    }

    public void addReceiveMessageListener(ReceiveMessageListener rml)/*Ici ce sera que le search bean normalement*/
    {
       if(!ReceivingMessageListeners.contains(rml))
       {
           ReceivingMessageListeners.addElement(rml);
       }
    }
    public void removeReceiveMessageListener(ReceiveMessageListener rml)
    {
        if(ReceivingMessageListeners.contains(rml))
        {
            ReceivingMessageListeners.removeElement(rml);
        }
    }

    protected void notifyReceiveMesageDetected()
    {
        ReceiveMessageEvent e = new ReceiveMessageEvent(this, _commande);
        int n = ReceivingMessageListeners.size();
        //On active la méthode MessageDetected pour chaque listener
        for(int i = 0; i<n; i++)
        {
            ReceiveMessageListener obj = (ReceiveMessageListener)ReceivingMessageListeners.elementAt(i);
            obj.MessageDetected(e);
        }
    }

}
