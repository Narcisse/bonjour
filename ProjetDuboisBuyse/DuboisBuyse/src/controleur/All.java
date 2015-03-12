package controleur;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import modele.EchelleDuboisBuyseFr;
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
    public static int getRandom(int de0aCeNombreExclusif){
        Random generator = new Random();
        int nbRetour = generator.nextInt(de0aCeNombreExclusif);
        return nbRetour;
    }
    public static boolean estDejaLa(ArrayList<String> uneListe, String mot){
        boolean estPresent = false;
        for(int i=0; i<uneListe.size(); i++){
            if (uneListe.get(i).equals(mot)){
                estPresent = true;
                break;
            }
        }
        return estPresent;
    }
    public EchelleDuboisBuyseFr genererEchelle(){
        File echelle = new File("data\\Echelle\\echelle_francaise.txt");
        EchelleDuboisBuyseFr echelleFrancaise = new EchelleDuboisBuyseFr();
        
        return echelleFrancaise;
    }
    public void enregistrerLechelle(EchelleDuboisBuyseFr uneEchelle){
        
    }
    // Fonction qui renvoi un pourcentage en entier d'une valeur
    // Ex: passer 0.1 et la hauteur de lecran renvoi une valeur en int pouvant
    // etre utiliser pour occuper 10% de la hauteur de l'ecran
    public static int pourcentage(double pourcentage, int valeur){
        return (int)(valeur*pourcentage);
    }
}
