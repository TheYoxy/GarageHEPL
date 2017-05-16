package Beans;

import java.util.Vector;

public class SearchBean implements ReceiveMessageListener {


    private Vector SearchFoundListeners;

    public SearchBean() {

    }

    public void MessageDetected(ReceiveMessageEvent e) {
        String message;
        /*On affiche le message*/
        message = e.getCommande();
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

    protected void notifySearchFoundDetected(String libelle, String etatCommande)
    {
        SearchFoundEvent e = new SearchFoundEvent(this, libelle, etatCommande);
        int n = SearchFoundListeners.size();
        //On active la méthode SearchDetected pour chaque listener
        for(int i = 0; i<n; i++)
        {
            SearchFoundListener obj = (SearchFoundListener)SearchFoundListeners.elementAt(i);
            obj.SearchDetected(e);
        }
    }
}
