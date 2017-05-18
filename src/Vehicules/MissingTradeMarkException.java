package Vehicules;

/**
 * Created by floryan on 22/03/17.
 */
public class MissingTradeMarkException extends Throwable {
    /**
     *
     */
    public MissingTradeMarkException() {
        super("Marque inexistante");
    }
}
