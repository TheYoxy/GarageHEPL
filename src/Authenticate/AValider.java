package Authenticate;

import java.util.Map;

public interface AValider {
    boolean isValid();

    boolean validate(Map.Entry<String,String> entry);
}
