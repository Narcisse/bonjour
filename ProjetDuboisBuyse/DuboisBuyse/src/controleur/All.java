package controleur;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;
import vue.BoutonMenu;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class All {
    // *************************************************************************
    // Donnees graphiques
    public static final int largeurEcran = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int hauteurEcran = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static final int hauteurUtile = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
    public static final Font policeProjet = new Font("Arial", Font.BOLD, 24);
    public static final Color couleurDeFond = Color.WHITE;
    // Boutons du menu
    // Generer une liste de boutons
    public static ArrayList<BoutonMenu> getBoutonsMenu(){
        ArrayList<BoutonMenu> boutons = new ArrayList<>();
        // Menus
        BoutonMenu echelons = new BoutonMenu("Les echelons");
        BoutonMenu progression = new BoutonMenu("Progression");
        // Ecouteurs
        echelons.addMouseListener(new ControlleurMenuEchelons(echelons));
        progression.addMouseListener(new ControlleurMenuProgression(progression));
        // Remplissage de la liste
        boutons.add(echelons);
        boutons.add(progression);
        // Renvoi de la liste avec les boutons de menu et leurs ecouteurs
        return boutons;
    }    
    
    // *************************************************************************
    // Methodes specifiques
    
    // Fonction qui renvoi un pourcentage en entier d'une valeur
    // Ex: passer 0.1 et la hauteur de lecran renvoi une valeur en int pouvant
    // etre utiliser pour occuper 10% de la hauteur de l'ecran
    public static int pourcentage(double pourcentage, int valeur){
        return (int)(valeur*pourcentage);
    }
}
