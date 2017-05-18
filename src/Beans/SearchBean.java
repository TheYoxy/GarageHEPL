package Beans;

import java.util.Vector;

public class SearchBean implements ReceiveMessageListener {
    private Vector<SearchFoundListener> _searchFoundListeners;
    private boolean _etatCommande;

    public SearchBean()
    {
        _searchFoundListeners = new Vector<>();
        _etatCommande = false;
    }

    public void MessageDetected(ReceiveMessageEvent e) {
        String message;

        /*On recupere la commande*/
        message = e.getCommande();
        /*Serialiser container*/
        _etatCommande = checkDisponibility();
        notifySearchFoundDetected(message, _etatCommande);

    }

    public void addSearchFoundListener(SearchFoundListener sfl)/*Ici ce sera que le prepareOrder bean normalement*/ {
        if (!_searchFoundListeners.contains(sfl)) {
            _searchFoundListeners.addElement(sfl);
        }
    }

    public void removeSearchFoundListener(SearchFoundListener sfl) {
        if (_searchFoundListeners.contains(sfl)) {
            _searchFoundListeners.removeElement(sfl);
        }
    }

    protected void notifySearchFoundDetected(String libelle, boolean etatCommande)
    {
        SearchFoundEvent e = new SearchFoundEvent(this, libelle, etatCommande);
        int n = _searchFoundListeners.size();
        //On active la méthode SearchDetected pour chaque listener
        for(int i = 0; i<n; i++)
        {
            SearchFoundListener obj = _searchFoundListeners.elementAt(i);
            obj.SearchDetected(e);
        }
    }

    public boolean checkDisponibility()
    {
        //noinspection PointlessArithmeticExpression
        return (int)(Math.random() * (1 - 0)) + 1 != 0;
    }
}
