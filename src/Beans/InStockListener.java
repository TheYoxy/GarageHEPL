package Beans;

import java.util.EventListener;

public interface InStockListener extends EventListener
{
    public void InStockDetected (InStockEvent e);
}
