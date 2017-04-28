package test;

import People.Client;
import Vehicules.MissingTradeMarkException;
import Vehicules.TypeVoiture;
import Vehicules.Voiture;

import java.util.Arrays;
import java.util.Vector;

import static java.lang.System.exit;

public class TestVehicules {
    public static void main(String[] args) throws MissingTradeMarkException {
        if (args.length < 2) exit(0);
        Voiture[] voiture = new Voiture[]
                {new Voiture("1-111-111", new TypeVoiture(4, 0, "Audi-TT"), new Client("AAA", "BBB", "CCC", "DDD", "EEE")),
                        new Voiture("1-111-111", new TypeVoiture(4, 0, "Audi-TT"), new Client("AAA", "BBB", "CCC", "DDD", "EEE")),
                        new Voiture("1-111-111", new TypeVoiture(4, 0, "Audi-TT"), new Client("AAA", "BBB", "CCC", "DDD", "EEE")),
                        new Voiture("1-111-111", new TypeVoiture(4, 0, "Audi-TT"), new Client("AAA", "BBB", "CCC", "DDD", "EEE")),
                        new Voiture("1-111-111", new TypeVoiture(4, 0, "Audi-TT"), new Client("AAA", "BBB", "CCC", "DDD", "EEE"))};
        Vector<Voiture> vector = new Vector<>();
        vector.addAll(Arrays.asList(voiture).subList(0, Integer.valueOf(args[1])));
        for (Voiture temp : vector) {
            System.out.println(temp);
        }
    }
}
