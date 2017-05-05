package Main;

import ApplicationGestion.Login;
import Authenticate.Identifiable;
import Tools.FilesOperations;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //TODO Changer le login pour qu'il soit en awt
        LinkedList<Identifiable> tableid = new LinkedList<>();
        /*tableid.add(new Client("Simar", "Floryan", null, null, "flo"));
        tableid.add(new Client("AAA", "AAA", null, null, "flo1"));
        tableid.add(new Client("BBB", "BBB", null, null, "flo2"));
        tableid.add(new Client("CCC", "CCC", null, null, "flo3"));
        tableid.add(new Client("DDD", "DDD", null, null, "flo4"));
        tableid.add(new Client("EEE", "EEE", null, null, "flo5"));
        tableid.add(new Client("FFF", "FFF", null, null, "flo6"));
        tableid.add(new Client("GGG", "GGG", null, null, "flo7"));
        tableid.add(new TechnicienExterieur("Simar", "Floryan", null, null, "tflo", "123"));
        tableid.add(new Employe("Simar", "Floryan", null, null, "eflo", "123"));
        tableid.add(new Mecanicien("Simar", "Floryan", null, null, "mflo", "Moteur", "123"));
        */
        final Hashtable<String, String> table = new Hashtable<>();
        for (Iterator<Identifiable> it = tableid.iterator(); it.hasNext(); ) {
            Identifiable temp = it.next();
            table.put(temp.getId(), "123");
        }
        //Client cli1 = new Client("Bonemme", "Nicolas", null, null, "nico");
        FilesOperations xmlfile = new FilesOperations();
        try {
            tableid = xmlfile.loadUsers();

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

        Login log = new Login(tableid, table);
        log.setVisible(true);

    }
}
