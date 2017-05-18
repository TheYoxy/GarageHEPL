package Beans;

import java.util.EventListener;

public interface InStockListener extends EventListener
{
    void InStockDetected(InStockEvent e);
}
