package vue;

import controleur.All;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import static javax.swing.SwingConstants.RIGHT;

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
    private ArrayList<JLabel> lesMenus;
    
    
    // *************************************************************************
    // Constructeur
    public PanDesMenus(ArrayList<JLabel> listeDeMenu){
        super();
        initComponents(listeDeMenu);
    }
    
    
    // *************************************************************************
    // Methodes specifiques
    private void initComponents(ArrayList<JLabel> uneListe){
        lesMenus = uneListe;
        
        // Creation du GridBagLayout et positionnement des elements
        setLayout(new GridBagLayout());
        GridBagConstraints lastConstraints = new GridBagConstraints();
        GridBagConstraints labelConstraints = new GridBagConstraints();
        GridBagConstraints separatorConstraint = new GridBagConstraints();
        
        lastConstraints.fill = GridBagConstraints.NONE;
        lastConstraints.anchor = GridBagConstraints.EAST;
        lastConstraints.weightx = 0.0;
        lastConstraints.gridwidth = GridBagConstraints.REMAINDER;
        lastConstraints.insets = new Insets(8, 8, 8, 8);

        labelConstraints = (GridBagConstraints) lastConstraints.clone();
        labelConstraints.weightx = 0.0;
        labelConstraints.fill = GridBagConstraints.NONE;
        labelConstraints.anchor = GridBagConstraints.EAST;
        labelConstraints.gridwidth = 1;

        separatorConstraint.weightx = 1.0;
        separatorConstraint.fill = GridBagConstraints.HORIZONTAL;
        separatorConstraint.gridwidth = GridBagConstraints.REMAINDER;
        
        for (int i=0; i<lesMenus.size(); i++){
            add(lesMenus.get(i), labelConstraints);
            add(new JLabel(), lastConstraints);
            add(new JSeparator(JSeparator.HORIZONTAL), separatorConstraint);
        }
        
        setPreferredSize(new Dimension(All.pourcentage(0.25, All.largeurEcran), All.hauteurUtile-All.pourcentage(0.1, All.hauteurUtile)));
        
        setBackground(All.couleurDeFond);
    }
    
    // *************************************************************************
    // Main
    public static void main(String[] args){
        JLabel test = new JLabel("Les echelons      ");
        test.setHorizontalAlignment(RIGHT);
        test.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        test.setFont(new Font("Arial", Font.BOLD, 24));
        
        JLabel test2 = new JLabel("Les echelons      ");
        test2.setHorizontalAlignment(RIGHT);
        test2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        test2.setFont(new Font("Arial", Font.BOLD, 24));
        
        ArrayList<JLabel> uneListe = new ArrayList<>();
        uneListe.add(test);
        uneListe.add(test2);
        
        PanDesMenus panneau = new PanDesMenus(uneListe);
        
        JFrame frame = new JFrame(PanDesMenus.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panneau);
        frame.pack();
        frame.setVisible(true);
    }
}
