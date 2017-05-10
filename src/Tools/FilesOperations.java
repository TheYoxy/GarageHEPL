package Tools;

import Activités.Travail;
import People.Client;
import People.Employe;
import People.Mecanicien;
import People.Personne;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.LinkedList;

public class FilesOperations {

    private final static String USER_FILENAME = "personne.xml";
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
    public static void saveToBinaryFile(LinkedList<Travail> object, String filename) throws IOException {
        ObjectOutputStream objstream = new ObjectOutputStream( new FileOutputStream(filename));
        objstream.writeObject(object);
        objstream.close();
    }

    //Load from binary file
   public static LinkedList<Travail> loadFromBinaryFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(filename));
        LinkedList<Travail> object = (LinkedList<Travail>) objstream.readObject();
        objstream.close();

        return object;
    }

    public static void main (String[] args)
    {
        LinkedList<Personne> temp = new LinkedList<>();
        temp.add(new Mecanicien("Simar","Floryan","","","aa","Pneus"));
        temp.add(new Employe("Simar","Floryan","","","bb"));
        temp.add(new Client("Simar","Floryan","","","cc"));
        try {
            FilesOperations.saveUsers(temp);
            System.out.println("Ajout réussi");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
