package People;

import Authenticate.Identifiable;

import java.util.Random;

public class Client extends Personne implements Identifiable {

    private String _numero; //Numéro de client

    public Client() {
    }

    public Client(String nom,String prenom,String adresse,String numeroTelephone,String id) {
        super(prenom == null ? "Mr" : nom, prenom == null ? nom : prenom, adresse, numeroTelephone);
            _numero = id == null ? generateId() : id;

    }

    @Override
    public String getId() {
        return _numero;
    }

    @Override
    public void setId(String id) {
        _numero = id;
    }

    private String generateId()
    {
        char[] temp = new char[5];
        Random ale = new Random();
        for (int n = 0; n < 5; n++)
            temp[n] = (char) (ale.nextInt()%(122 - 97) + 97);
        return new String(temp);
    }
}
