package Beans;

import java.util.Vector;

public class PrepareOrderBean implements SearchFoundListener{

    private Vector InStockListeners;

    /**
     *
     */
    public PrepareOrderBean()
    {
        InStockListeners = new Vector();
    }

    /**
     * @param e
     */
    @Override
    public void SearchDetected(SearchFoundEvent e)
    {
        String message = e.getLibelle();
        boolean etat = e.getEtatCommande();
        //Calcul de la date d'expédition
        int date = 0;//Reste à 0 si la commande n'est plus disponible
        if(etat)
        {
            date = (int)(Math.random() * (12-1)) + 1; //Calcul du mois
        }

        notifyInStockDetected(message, etat, date);
    }

    /**
     * @param sfl
     */
    public void addInStockListener(InStockListener sfl)/*Ici ce sera que le prepareOrder bean normalement*/ {
        if (!InStockListeners.contains(sfl)) {
            InStockListeners.addElement(sfl);
        }
    }

    /**
     * @param sfl
     */
    public void removeInStockListener(InStockListener sfl) {
        if (InStockListeners.contains(sfl)) {
            InStockListeners.removeElement(sfl);
        }
    }

    /**
     * @param libelle
     * @param etatCommande
     * @param date
     */
    void notifyInStockDetected(String libelle, boolean etatCommande, int date)
    {
        InStockEvent e = new InStockEvent(this, libelle, etatCommande, date);
        int n = InStockListeners.size();
        //On active la méthode SearchDetected pour chaque listener
        for(int i = 0; i<n; i++)
        {
           InStockListener obj = (InStockListener)InStockListeners.elementAt(i);
            obj.InStockDetected(e);
        }
    }
}
