package vue;

import controleur.All;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
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
        setLayout(new GridLayout(0, 5, 10, 10));
        for (TuileEchelon tuile : uneListe){
            add(tuile);
        }
        
        setBackground(All.couleurDeFond);
    }
    // *************************************************************************
    // Main
    public static void main(String[] args){
        ArrayList<TuileEchelon> tuiles = new ArrayList<>();
        for (int i=0; i<37; i++){
            TuileEchelon tuile = new TuileEchelon();
            tuile.setBackground(Color.red);
            tuiles.add(tuile);
        }
        JFrame frame = new JFrame("Test");
        frame.setLayout(new GridLayout(1, 1, 10, 10));
        frame.add(new PanDesEchelons(tuiles));
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
