package Tools;
import Activités.Entretien;
import Activités.Travail;
import Authenticate.Identifiable;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.LinkedList;

public class FilesOperations {


    //Save XML file, LinkedList<Identifiable>
    public void saveUsers(LinkedList<Identifiable> person) throws FileNotFoundException {
        XMLEncoder encoder;
        encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("personne.xml")));
        encoder.writeObject(person);
        encoder.flush();
        //encoder.close();
    }

    //Load XML file
    public LinkedList<Identifiable> loadUsers() throws FileNotFoundException {
        XMLDecoder decoder;
        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("personne.xml")));
        LinkedList<Identifiable> list = (LinkedList<Identifiable>) decoder.readObject();
        decoder.close();

        return list;
    }

    //Save to binary file
    public void saveToBinaryFile(LinkedList<Travail> object, String filename) throws IOException {
        ObjectOutputStream objstream = new ObjectOutputStream( new FileOutputStream(filename));
        objstream.writeObject(object);
        objstream.close();
    }

    //Load from binary file
   public LinkedList<Travail> loadFromBinaryFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(filename));
        LinkedList<Travail> object = (LinkedList<Travail>) objstream.readObject();
        objstream.close();

        return object;
    }

}
