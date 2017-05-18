package Beans;

import network.NetworkBasicServer;

import java.util.Vector;

public class ReceivingBean implements InStockListener {

    /**
     *
     */
    private String Commande;
    /**
     *
     */
    private Vector<ReceiveMessageListener> ReceivingMessageListeners;
    /**
     *
     */
    private NetworkBasicServer Ser;

    /**
     *
     */
    public ReceivingBean() {
        setCommande("");
        ReceivingMessageListeners = new Vector<>();
    }

    /**
     * @param e
     */
    @Override
    public void InStockDetected(InStockEvent e) {
        //Envoie de la réponse au cllient :
        Ser.sendMessage(e.getEtatCommande() + ";" + e.getLibelle() + ";" + e.getDateMois());
    }

    /**
     * @return
     */
    public String getCommande() {
        return Commande;
    }

    /**
     * @param c
     */
    private void setCommande(String c) {
        Commande = c;
    }

    /**
     * @param serveur
     */
    public void run(NetworkBasicServer serveur) {
        Ser = serveur;

        String message;

        while (true) {
            if ((message = serveur.getMessage()).compareTo("RIEN") != 0) {
                setCommande(message);
                notifyReceiveMesageDetected();
            }
        }
    }

    /**
     * @param rml
     */
    public void addReceiveMessageListener(ReceiveMessageListener rml)/*Ici ce sera que le search bean normalement*/ {
        if (!ReceivingMessageListeners.contains(rml)) {
            ReceivingMessageListeners.addElement(rml);
        }
    }

    /**
     * @param rml
     */
    public void removeReceiveMessageListener(ReceiveMessageListener rml) {
        if (ReceivingMessageListeners.contains(rml)) {
            ReceivingMessageListeners.removeElement(rml);
        }
    }

    /**
     *
     */
    private void notifyReceiveMesageDetected() {
        ReceiveMessageEvent e = new ReceiveMessageEvent(this, Commande);
        int n = ReceivingMessageListeners.size();
        //On active la méthode MessageDetected pour chaque listener
        for (int i = 0; i < n; i++) {
            ReceivingMessageListeners.elementAt(i).MessageDetected(e);
        }
    }
}
