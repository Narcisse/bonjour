package vue;

import controleur.All;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Christopher Desrosiers Mondor
 * Ce panneau prendra une liste de labels modifies (BoutonMenu) qui seront
 * affiches dans un gridBagLayout et pour chaque cellule il y aura un
 * separateur (ligne horizontale) entre chaque label. Il n'y a pas de listeners
 * sur le panneau parce que ce panneau ne contient que les menus qui integrent
 * deja leur propre listeners.
 */
public class PanDesMenus extends JPanel{
    // *************************************************************************
    // Donnees membre
    private ArrayList<BoutonMenu> lesMenus;
    
    
    // *************************************************************************
    // Constructeur
    public PanDesMenus(ArrayList<BoutonMenu> listeDeMenu){
        super();
        initComponents(listeDeMenu);
    }
    
    
    // *************************************************************************
    // Methodes specifiques
    private void initComponents(ArrayList<BoutonMenu> uneListe){
        lesMenus = uneListe;
        
        // Creation du GridLayout
        setLayout(new GridLayout(0, 1));
        for (BoutonMenu bouton:uneListe){
            add(bouton);
        }
        // Pour la presentation comme il ny a que deux menus, jajoute des lbl vides
        for (int i=0; i<9; i++){
            add(new JLabel());
        }
        setPreferredSize(new Dimension(All.pourcentage(0.25, All.largeurEcran), All.hauteurUtile-All.pourcentage(0.1, All.hauteurUtile)));
        
        setBackground(All.couleurDeFond);
    }
    
    // *************************************************************************
    // Main
    public static void main(String[] args){        
        PanDesMenus panneau = new PanDesMenus(All.getBoutonsMenu(null));
        JFrame frame = new JFrame(PanDesMenus.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panneau);
        frame.pack();
        frame.setVisible(true);
    }
}
