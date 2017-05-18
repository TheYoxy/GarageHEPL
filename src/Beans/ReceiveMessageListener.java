package Beans;

import java.util.EventListener;

public interface ReceiveMessageListener extends EventListener
{
    /**
     * @param e
     */
    void MessageDetected (ReceiveMessageEvent e);
}
