package controleur;

import java.io.IOException;
import modele.EchelleDuboisBuyseFr;
import modele.Echelon;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Lanceur {
    // *************************************************************************
    // Main
    public static void main(String[] args) throws IOException{
        All.genererEchelle();
        /*
        EchelleDuboisBuyseFr echelleFr = All.getEchelleDB();
        int echelonActuel = 24;
        Echelon echelon4 = echelleFr.getEchelons().get(echelonActuel-1);
        System.out.println("Mots de l'echelon " + echelonActuel + " :");
        for(int i=0; i < echelon4.getMotsEchelon().size(); i++){
            System.out.println(echelon4.getMotsEchelon().get(i));
        }
        System.out.println("***********************************************");
        System.out.println(echelon4.getListeAffichable(true));
                */
    }
}
