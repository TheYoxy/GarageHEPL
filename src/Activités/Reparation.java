package Activités;

import People.Mecanicien;
import Vehicules.Voiture;

public class Reparation extends Travail {

    public Reparation(Voiture car, Mecanicien travailleur, String libelle, String remarque) {
        super(car, travailleur, libelle, remarque);
    }

    @Override
    public void setId(String id) {
        Id = id;
    }
}
