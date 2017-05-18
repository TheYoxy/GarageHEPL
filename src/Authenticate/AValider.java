package Authenticate;

import java.util.Map;

public interface AValider {
    /**
     * @return
     */
    boolean isValid();

    /**
     * @param entry
     * @return
     */
    boolean validate(Map.Entry<String,String> entry);
}
