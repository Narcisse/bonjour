package controleur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import vue.FenetrePrincipale;
import vue.PanDesEchelons;
import vue.PanDesMenus;
import vue.TuileEchelon;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Lanceur {
    // *************************************************************************
    // Main
    public static void main(String[] args){
        JPanel pan1 = new JPanel(new GridLayout(2, 1, 3, 3));
        pan1.setBackground(Color.BLUE);
        pan1.setPreferredSize(new Dimension(All.largeurEcran, All.pourcentage(0.1, All.hauteurEcran)));
        
        PanDesMenus panneau = new PanDesMenus(All.getBoutonsMenu());
        
        ArrayList<TuileEchelon> tuiles = new ArrayList<>();
        for (int i=0; i<37; i++){
            TuileEchelon tuile = new TuileEchelon();
            tuile.setBackground(Color.red);
            tuiles.add(tuile);
        }
        
        JPanel pan3 = new PanDesEchelons(tuiles);
        pan3.setBackground(All.couleurDeFond);
        new FenetrePrincipale(pan1, panneau, pan3);
    }
}
