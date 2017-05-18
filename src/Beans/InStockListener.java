package Beans;

import java.util.EventListener;

public interface InStockListener extends EventListener
{
    /**
     * @param e
     */
    void InStockDetected(InStockEvent e);
}
