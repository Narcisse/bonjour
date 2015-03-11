package controleur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import vue.FenetrePrincipale;
import vue.PanDesMenus;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Lanceur {
    // *************************************************************************
    // Main
    public static void main(String[] args){
        JPanel pan1 = new JPanel(new GridLayout(2, 1, 3, 3));
        pan1.setBackground(Color.red);
        pan1.setPreferredSize(new Dimension(All.largeurEcran, All.pourcentage(0.1, All.hauteurEcran)));
        
        PanDesMenus panneau = new PanDesMenus(All.getBoutonsMenu());
        
        JPanel pan3 = new JPanel(new GridLayout(1, 1, 3, 3));
        pan3.setBackground(Color.yellow);
        new FenetrePrincipale(pan1, panneau, pan3);
    }
}
