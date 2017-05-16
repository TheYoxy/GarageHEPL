package Beans;

import java.util.EventListener;

public interface SearchFoundListener extends EventListener
{
    public void SearchDetected (SearchFoundEvent e);
}
