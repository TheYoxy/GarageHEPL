package Vehicules;

import java.io.Serializable;

public class TypeVoiture implements Serializable{
    private int NombrePortes;
    private int Type;
    private String Marque;

    /**
     * @param nombrePortes
     * @param type
     * @param marque
     * @throws MissingTradeMarkException
     */
    public TypeVoiture(int nombrePortes, int type, String marque) throws MissingTradeMarkException {
        NombrePortes = nombrePortes;
        Type = type;
        if (marque == null)
            throw new MissingTradeMarkException();
        Marque = marque;
    }

    /**
     * @return
     */
    public int getNombrePortes() {
        return NombrePortes;
    }

    /**
     * @param nombrePortes
     */
    public void setNombrePortes(int nombrePortes) {
        NombrePortes = nombrePortes;
    }

    /**
     * @return
     */
    public int getType() {
        return Type;
    }

    /**
     * @param type
     */
    public void setType(int type) {
        Type = type;
    }

    /**
     * @return
     */
    public String getMarque() {
        return Marque;
    }

    /**
     * @param marque
     */
    public void setMarque(String marque) {
        Marque = marque;
    }
}