package Main;

import People.*;
import Tools.FilesOperations;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Personne> tableid = new LinkedList<>();
        tableid.add(new Client("Simar", "Floryan", null, null, "flo"));
        tableid.add(new Client("AAA", "AAA", null, null, "flo1"));
        tableid.add(new Client("BBB", "BBB", null, null, "flo2"));
        tableid.add(new Client("CCC", "CCC", null, null, "flo3"));
        tableid.add(new Client("DDD", "DDD", null, null, "flo4"));
        tableid.add(new Client("EEE", "EEE", null, null, "flo5"));
        tableid.add(new Client("FFF", "FFF", null, null, "flo6"));
        tableid.add(new Client("GGG", "GGG", null, null, "flo7"));
        tableid.add(new TechnicienExterieur("Simar", "Floryan", null, null, "tflo"));
        tableid.add(new Employe("Simar", "Floryan", null, null, "eflo"));
        tableid.add(new Mecanicien("Simar", "Floryan", null, null, "mflo", "Moteur"));

        /*final Hashtable<String, String> table = new Hashtable<>();
        for (Iterator<Personne> it = tableid.iterator(); it.hasNext(); ) {
            Personne temp = it.next();
            table.put(temp.getId(), "123");
        }*/
        //Client cli1 = new Client("Bonemme", "Nicolas", null, null, "nico");
        FilesOperations xmlfile = new FilesOperations();
       try {
            FilesOperations.saveUsers(tableid);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

        //Login log = new Login(tableid, table);
        //log.setVisible(true);

    }
}
