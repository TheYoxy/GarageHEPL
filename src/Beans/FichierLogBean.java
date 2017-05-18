package Beans;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Bean qui ecrit et lit simplement dans un fichier (ne génere pas d'évenements)
 */
public class FichierLogBean implements ReceiveMessageListener,SearchFoundListener,InStockListener
{
    /**
     *
     */
    private String Filename;
    /**
     *
     */
    private FileOutputStream File;

    /**
     * @param filename
     */
    public FichierLogBean(String filename) {
        Filename = filename;
        try {
            File = new FileOutputStream(Filename);
        } catch (FileNotFoundException e) {
            System.err.println("Impossible d'ouvrir le fichier " + Filename);
            System.exit(-1);
        }
    }

    /**
     *
     */
    public void finalize()
    {
        try {
            File.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param e
     */
    @Override
    public void MessageDetected(ReceiveMessageEvent e) {
        try {
            File.write(e.getCommande().getBytes());
            File.write(new byte[] {Byte.parseByte("\n")});
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * @param e
     */
    @Override
    public void SearchDetected(SearchFoundEvent e) {
        try {
            File.write(e.getLibelle().getBytes());
            File.write(new byte[] {Byte.parseByte("\n")});
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * @param e
     */
    @Override
    public void InStockDetected(InStockEvent e) {
        try {
            File.write(e.getDateMois());
            File.write(new byte[] {Byte.parseByte("\n"),Byte.parseByte("\n")});
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * @return
     */
    public String getFilename() {
        return Filename;
    }
}
