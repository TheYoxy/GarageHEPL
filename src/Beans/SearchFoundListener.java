package Beans;

import java.util.EventListener;

public interface SearchFoundListener extends EventListener
{
    /**
     * @param e
     */
    void SearchDetected(SearchFoundEvent e);
}
