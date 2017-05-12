package Activités;

import People.Mecanicien;
import Vehicules.Voiture;

public class Entretien extends Travail {
    public Entretien(Voiture car, Mecanicien travailleur, String libelle, String remarque) {
        super(car, travailleur, libelle, remarque);
    }

    @Override
    public void setId(String id) {
        _id = id;
    }
}
