package vue;

import controleur.All;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Christopher Desrosiers Mondor
 * Cette fenetre prend 4 panneaux en parametre pour remplir un borderLayout de
 * facon automatique.
 * 
 * De plus, le panneau de gauche doit prendre en tout temps 20% de la largeur de
 * l'ecran, celui de droite prendre l'espace restant a droite et celui du haut
 * ne prendre que 5 a 10% de la frame
 */
public class FenetrePrincipale extends JFrame{
    // *************************************************************************
    // Donnees graphiques
    private JPanel controleFrame; // panneau qui remplacera les controles de la
                                  // barre par defaut ( minimise, agrandit et X)
    
    private JPanel lesMenus;      // Panneau qui fera office de panneau a onglet
                                  // mais d'un style que j'aurai moi meme defini
    
    private JPanel librairie;     // Panneau qui affichera selon le meme modele
                                  // que les albums sur itunes les differents
                                  // echelons de l'echelle dubois-buyse
    
    
    // *************************************************************************
    // Constructeur
    public FenetrePrincipale(JPanel ControleFrame, JPanel lesMenus, JPanel librairie){
        super();
        initComponents(ControleFrame, lesMenus, librairie);
        initListeners();
    }
    
    
    // *************************************************************************
    // Methodes specifiques
    private void initComponents(JPanel ControleFrame, JPanel lesMenus, JPanel librairie){
        // On initialise les parametres requis de la fenetre
        this.setUndecorated(true);
        this.setSize(All.largeurEcran, All.hauteurUtile);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        // this.setFont(null); // Ici initialiser la police qui servira dans
                               // tout le programe
        
        /* initialisation des panneaux avec les JPanel passes en parametre du
           constrcuteur. Ils seront place dans un BorderLayout.*/
        this.controleFrame = ControleFrame;
        this.lesMenus = lesMenus;
        this.librairie = librairie;
        
        // On applique un borderLayout a la fenetre principale
        this.setLayout(new BorderLayout());
        
        // On positionne les panneaux
        this.add(this.controleFrame, BorderLayout.NORTH);
        this.add(this.lesMenus, BorderLayout.WEST);
        this.add(this.librairie, BorderLayout.CENTER);
        
        
        this.setVisible(true);
    }
    private void initListeners(){
        
    }
    
    
    // *************************************************************************
    // Main
    public static void main(String[] args){
        JPanel pan1 = new JPanel(new GridLayout(2, 1, 3, 3));
        pan1.setBackground(Color.red);
        pan1.setPreferredSize(new Dimension(All.largeurEcran, All.pourcentage(0.1, All.hauteurEcran)));
        
        PanDesMenus panneau = new PanDesMenus(All.getBoutonsMenu());
        
        JPanel pan3 = new JPanel(new GridLayout(1, 1, 3, 3));
        pan3.setBackground(Color.yellow);
        FenetrePrincipale uneFrame = new FenetrePrincipale(pan1, panneau, pan3);
    }
}
