package People;

import Authenticate.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Client extends Personne implements Identifiable {

    /**
     *
     */
    private String Numero; //Numéro de client

    /**
     *
     */
    public Client() {
    }

    /**
     * @param nom
     * @param prenom
     * @param adresse
     * @param numeroTelephone
     * @param id
     */
    public Client(String nom,String prenom,String adresse,String numeroTelephone,String id) {
        super(prenom == null ? "Mr" : nom, prenom == null ? nom : prenom, adresse, numeroTelephone);
            Numero = id == null ? generateId() : id;

    }

    /**
     * @return
     */
    @Override
    public String getId() {
        return Numero;
    }

    /**
     * @param id
     */
    @Override
    public void setId(String id) {
        Numero = id;
    }

    /**
     * @return
     */
    @NotNull
    private String generateId()
    {
        char[] temp = new char[5];
        Random ale = new Random();
        for (int n = 0; n < 5; n++)
            temp[n] = (char) (ale.nextInt()%(122 - 97) + 97);
        return new String(temp);
    }
}
