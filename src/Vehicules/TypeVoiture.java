package Vehicules;

import java.io.Serializable;

public class TypeVoiture implements Serializable{
    private int NombrePortes;
    private int Type;
    private String Marque;

    public TypeVoiture(int nombrePortes, int type, String marque) throws MissingTradeMarkException {
        NombrePortes = nombrePortes;
        Type = type;
        if (marque == null)
            throw new MissingTradeMarkException();
        Marque = marque;
    }

    public int getNombrePortes() {
        return NombrePortes;
    }

    public void setNombrePortes(int nombrePortes) {
        NombrePortes = nombrePortes;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }
}