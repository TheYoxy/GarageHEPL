package Beans;

public class SearchBean implements ReceiveMessageListener
{
    public SearchBean()
    {
        ReceivingBean rb = new ReceivingBean();
        rb.addReceiveMessageListener(this);
        //rb.run();
    }

    public void MessageDetected(ReceiveMessageEvent e)
    {
        /*On affiche le message*/
        //e.getCommande();
    }
}