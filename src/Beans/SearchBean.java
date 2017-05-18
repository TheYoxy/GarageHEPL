package Beans;

import java.util.Random;
import java.util.Vector;

public class SearchBean implements ReceiveMessageListener {
    private Vector<SearchFoundListener> SearchFoundListeners;
    private boolean EtatCommande;

    public SearchBean()
    {
        SearchFoundListeners = new Vector<>();
        EtatCommande = false;
    }

    public void MessageDetected(ReceiveMessageEvent e) {
        String message;

        /*On recupere la commande*/
        message = e.getCommande();
        /*Serialiser container*/
        EtatCommande = checkDisponibility();
        notifySearchFoundDetected(message, EtatCommande);

    }

    public void addSearchFoundListener(SearchFoundListener sfl)/*Ici ce sera que le prepareOrder bean normalement*/ {
        if (!SearchFoundListeners.contains(sfl)) {
            SearchFoundListeners.addElement(sfl);
        }
    }

    public void removeSearchFoundListener(SearchFoundListener sfl) {
        if (SearchFoundListeners.contains(sfl)) {
            SearchFoundListeners.removeElement(sfl);
        }
    }

    private void notifySearchFoundDetected(String libelle, boolean etatCommande)
    {
        SearchFoundEvent e = new SearchFoundEvent(this, libelle, etatCommande);
        int n = SearchFoundListeners.size();
        //On active la méthode SearchDetected pour chaque listener
        for(int i = 0; i<n; i++)
        {
            SearchFoundListener obj = SearchFoundListeners.elementAt(i);
            obj.SearchDetected(e);
        }
    }

    private boolean checkDisponibility()
    {
        //noinspection PointlessArithmeticExpression
        return new Random().nextBoolean();
    }
}
