package Beans;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Bean qui ecrit et lit simplement dans un fichier (ne génere pas d'évenements)
 */
public class FichierLogBean implements ReceiveMessageListener,SearchFoundListener,InStockListener
{
    private String _filename;
    private FileOutputStream _file;
    public FichierLogBean(String filename) {
        _filename = filename;
        try {
            _file = new FileOutputStream(_filename);
        } catch (FileNotFoundException e) {
            System.err.println("Impossible d'ouvrir le fichier " + _filename);
            System.exit(-1);
        }
    }
    public void finalize()
    {
        try {
            _file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void MessageDetected(ReceiveMessageEvent e) {
        try {
            _file.write(e.getCommande().getBytes());
            _file.write(new byte[] {Byte.parseByte("\n")});
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void SearchDetected(SearchFoundEvent e) {
        try {
            _file.write(e.get_libelle().getBytes());
            _file.write(new byte[] {Byte.parseByte("\n")});
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void InStockDetected(InStockEvent e) {
        try {
            _file.write(e.get_dateMois());
            _file.write(new byte[] {Byte.parseByte("\n"),Byte.parseByte("\n")});
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public String get_filename() {
        return _filename;
    }
}
