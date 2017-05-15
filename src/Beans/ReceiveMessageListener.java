package Beans;

import java.util.EventListener;

public interface ReceiveMessageListener extends EventListener
{
    public void MessageDetected (ReceiveMessageEvent e);
}
