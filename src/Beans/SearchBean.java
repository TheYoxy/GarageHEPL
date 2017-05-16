package Beans;

public class SearchBean implements ReceiveMessageListener
{
    public SearchBean()
    {

    }

    public void MessageDetected(ReceiveMessageEvent e)
    {
        String message;
        /*On affiche le message*/
        message = e.getCommande();
    }
}
