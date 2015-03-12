package modele;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class EchelleDuboisBuyseFr implements Serializable{
    // *************************************************************************
    // Donnee membre
    private ArrayList<Echelon> echelons = new ArrayList<>();
    
    // *************************************************************************
    // Constructeur
    public EchelleDuboisBuyseFr(){
        this.echelons = new ArrayList<>();
    }
    
    // *************************************************************************
    // Methodes specifiques
    public void addEchelon(Echelon unEchelon){
        this.echelons.add(unEchelon);
    }
}
