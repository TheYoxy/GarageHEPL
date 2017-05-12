package Tools;

import Activités.Travail;
import People.Client;
import People.Employe;
import People.Mecanicien;
import People.Personne;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Vector;

public class FilesOperations {

    private final static String USER_FILENAME = "personne.xml";
    private final static String PROPERTIES = "filename.properties";
    public final static String ATTENTE_FILENAME;
    public final static String OCCUPE_FILENAME;
    public final static String FINI_FILENAME;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ATTENTE_FILENAME = properties.getProperty("ATTENTE_FILENAME");
        OCCUPE_FILENAME = properties.getProperty("OCCUPE_FILENAME");
        FINI_FILENAME = properties.getProperty("FINI_FILENAME");
    }

    //Save XML file, LinkedList<Identifiable>
    public static void saveUsers(LinkedList<Personne> person) throws FileNotFoundException {
        XMLEncoder encoder;
        encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(USER_FILENAME)));
        encoder.writeObject(person);
        encoder.flush();
        //encoder.close();
    }

    //Load XML file
    public static LinkedList<Personne> loadUsers() throws FileNotFoundException {
        XMLDecoder decoder;
        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(USER_FILENAME)));
        LinkedList<Personne> list = (LinkedList<Personne>) decoder.readObject();
        decoder.close();
        return list;
    }

    //Save to binary file
    public static void saveFini(LinkedList<Travail> object) throws IOException {
        ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream(FINI_FILENAME));
        objstream.writeObject(object);
        objstream.close();
    }

    //Load from binary file
    public static LinkedList<Travail> loadFini() throws IOException, ClassNotFoundException {
        ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(FINI_FILENAME));
        LinkedList<Travail> object = (LinkedList<Travail>) objstream.readObject();
        objstream.close();
        return object;
    }

    public static void saveAttente(Hashtable<Vector<Object>, Boolean> hashtable) throws IOException {
        ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream(ATTENTE_FILENAME));
        objstream.writeObject(hashtable);
        objstream.close();
    }

    public static Hashtable<Vector<Object>, Boolean> loadAttente() throws IOException, ClassNotFoundException {
        ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(ATTENTE_FILENAME));
        Hashtable<Vector<Object>, Boolean> object = (Hashtable<Vector<Object>, Boolean>) objstream.readObject();
        objstream.close();
        return object;
    }

    public static void saveOccupe(Hashtable<Travail, Integer> hashtable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(OCCUPE_FILENAME));
        objectOutputStream.writeObject(hashtable);
        objectOutputStream.close();
    }

    public static Hashtable<Travail, Integer> loadOccupe() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(OCCUPE_FILENAME));
        Hashtable<Travail, Integer> hashtable = (Hashtable<Travail, Integer>) objectInputStream.readObject();
        objectInputStream.close();
        return hashtable;
    }

    public static void main(String[] args) {
        LinkedList<Personne> temp = new LinkedList<>();
        temp.add(new Mecanicien("Simar", "Floryan", "", "", "aa", "Pneus"));
        temp.add(new Employe("Simar", "Floryan", "", "", "bb"));
        temp.add(new Client("Simar", "Floryan", "", "", "cc"));
        try {
            FilesOperations.saveUsers(temp);
            System.out.println("Ajout réussi");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
