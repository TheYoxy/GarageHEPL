package Tools;

import Activites.Travail;
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

    /**
     *
     */
    public final static String PROPERTIES = "config.properties";
    /**
     *
     */
    private final static String USER_FILENAME = "personne.xml";
    /**
     *
     */
    private final static String ATTENTE_FILENAME;
    /**
     *
     */
    private final static String OCCUPE_FILENAME;
    /**
     *
     */
    private final static String FINI_FILENAME;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        final File dossier = new File(properties.getProperty("FOLDER"));
        final String folder = dossier.getName() + System.getProperty("file.separator");
        if (!dossier.exists())
            dossier.mkdir();
        ATTENTE_FILENAME = folder + properties.getProperty("ATTENTE_FILENAME");
        OCCUPE_FILENAME = folder + properties.getProperty("OCCUPE_FILENAME");
        FINI_FILENAME = folder + properties.getProperty("FINI_FILENAME");
    }

    /**
     * @param person
     * @throws FileNotFoundException
     */
    //Save XML file, LinkedList<Identifiable>
    public static void saveUsers(LinkedList<Personne> person) throws FileNotFoundException {
        XMLEncoder encoder;
        encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(USER_FILENAME)));
        encoder.writeObject(person);
        encoder.flush();
        //encoder.close();
    }

    /**
     * @return
     * @throws FileNotFoundException
     */
    //Load XML file
    public static LinkedList<Personne> loadUsers() throws FileNotFoundException {
        XMLDecoder decoder;
        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(USER_FILENAME)));
        LinkedList<Personne> list = (LinkedList<Personne>) decoder.readObject();
        decoder.close();
        return list;
    }

    /**
     * @param object
     * @throws IOException
     */
    //Save to binary file
    public static void saveFini(LinkedList<Travail> object) throws IOException {
        ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream(FINI_FILENAME));
        objstream.writeObject(object);
        objstream.close();
    }

    /**
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    //Load from binary file
    public static LinkedList<Travail> loadFini() throws IOException, ClassNotFoundException {
        ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(FINI_FILENAME));
        LinkedList<Travail> object = (LinkedList<Travail>) objstream.readObject();
        objstream.close();
        return object;
    }

    /**
     * @param hashtable
     * @throws IOException
     */
    public static void saveAttente(Hashtable<Vector<Object>, Boolean> hashtable) throws IOException {
        ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream(ATTENTE_FILENAME));
        objstream.writeObject(hashtable);
        objstream.close();
    }

    /**
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Hashtable<Vector<Object>, Boolean> loadAttente() throws IOException, ClassNotFoundException {
        ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(ATTENTE_FILENAME));
        Hashtable<Vector<Object>, Boolean> object = (Hashtable<Vector<Object>, Boolean>) objstream.readObject();
        objstream.close();
        return object;
    }

    /**
     * @param hashtable
     * @throws IOException
     */
    public static void saveOccupe(Hashtable<Travail, Integer> hashtable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(OCCUPE_FILENAME));
        objectOutputStream.writeObject(hashtable);
        objectOutputStream.close();
    }

    /**
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Hashtable<Travail, Integer> loadOccupe() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(OCCUPE_FILENAME));
        Hashtable<Travail, Integer> hashtable = (Hashtable<Travail, Integer>) objectInputStream.readObject();
        objectInputStream.close();
        return hashtable;
    }

    /**
     * @param args
     */
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
