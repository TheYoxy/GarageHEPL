package Activités;

import People.Mecanicien;
import Vehicules.Voiture;

public class Entretien extends Travail {
    /**
     * @param car         Voiture sur laquelle on va effectuer un entretien
     * @param travailleur Le mécanicien qui va s'occuper du travail
     * @param libelle     Info sur le travail à effectuer
     * @param remarque    Eventuelles Remarques
     */
    public Entretien(Voiture car, Mecanicien travailleur, String libelle, String remarque) {
        super(car, travailleur, libelle, remarque);
    }

    /**
     * @param id nouvel Id de l'entretien
     */
    @Override
    public void setId(String id) {
        Id = id;
    }
}
