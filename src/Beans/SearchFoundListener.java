package Beans;

import java.util.EventListener;

public interface SearchFoundListener extends EventListener
{
    void SearchDetected(SearchFoundEvent e);
}
