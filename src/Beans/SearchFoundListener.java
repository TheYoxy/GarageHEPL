package Beans;

import java.util.EventListener;

public interface SearchFoundListener extends EventListener
{
    public void MessageDetected (ReceiveMessageEvent e);
}
