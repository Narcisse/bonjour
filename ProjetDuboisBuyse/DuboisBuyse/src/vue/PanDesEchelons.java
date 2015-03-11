package vue;

import controleur.All;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class PanDesEchelons extends JPanel{
    // *************************************************************************
    // Donnees membre
    private ArrayList<TuileEchelon> lesTuilesEchelons;
    
    
    // *************************************************************************
    // Constructeur
    public PanDesEchelons(ArrayList<TuileEchelon> listeDeTuile){
        super();
        initComponents(listeDeTuile);
    }
    
    
    // *************************************************************************
    // Methodes specifiques
    private void initComponents(ArrayList<TuileEchelon> uneListe){
        lesTuilesEchelons = uneListe;
        
        // Creation du GridLayout , 5 colonnes, nombre indetermine de rangees
        setLayout(new GridLayout(0, 5));
        for (TuileEchelon tuile:uneListe){
            add(tuile);
        }
        
        setBackground(All.couleurDeFond);
    }
    // *************************************************************************
    // Main
    public static void main(String[] args){
        System.out.println("Hello world!");
    }
}
