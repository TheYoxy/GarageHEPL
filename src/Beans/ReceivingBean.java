package Beans;

import network.NetworkBasicServer;

import java.util.Vector;

public class ReceivingBean implements InStockListener {

    private String _commande;
    private Vector<ReceiveMessageListener> _receivingMessageListeners;
    private NetworkBasicServer _ser;

    public ReceivingBean()
    {
        setCommande("");
        _receivingMessageListeners = new Vector<ReceiveMessageListener>();
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
       if(!_receivingMessageListeners.contains(rml))
       {
           _receivingMessageListeners.addElement(rml);
       }
    }
    public void removeReceiveMessageListener(ReceiveMessageListener rml)
    {
        if(_receivingMessageListeners.contains(rml))
        {
            _receivingMessageListeners.removeElement(rml);
        }
    }

    protected void notifyReceiveMesageDetected()
    {
        ReceiveMessageEvent e = new ReceiveMessageEvent(this, _commande);
        int n = _receivingMessageListeners.size();
        //On active la méthode MessageDetected pour chaque listener
        for(int i = 0; i<n; i++)
        {
            ReceiveMessageListener obj = _receivingMessageListeners.elementAt(i);
            obj.MessageDetected(e);
        }
    }

}
