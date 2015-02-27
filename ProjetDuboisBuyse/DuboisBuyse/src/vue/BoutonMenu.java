package vue;

import controleur.All;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.RIGHT;

/**
 *
 * @author Christopher Desrosiers Mondor
 * Des labels qui agieront comme des boutons donc qui devront implementer
 * des fonctions pour changer d'apparence quand la souris est sur le composant
 * sort du composant, clic sur le composant, etc.
 */
public class BoutonMenu extends JLabel{
    // *************************************************************************
    // Donnees membres
    
    
    // *************************************************************************
    // Constructeur
    public BoutonMenu(){
        super();
        initComponents();
    }
    public BoutonMenu(String texte){
        super(texte);
        initComponents();
    }
    
    // *************************************************************************
    // Methodes specifiques
    public void initComponents(){
        setHorizontalAlignment(RIGHT);
        setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        setFont(All.policeProjet);
        setBackground(All.couleurDeFond);
    }
    
    
    // *************************************************************************
    // Main
    public static void main(String[] args){
        System.out.println("Hello world!");
    }
}
