package controleur;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vue.BoutonMenu;
import vue.PanDesEchelons;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class ControlleurMenuEchelons implements MouseListener{
    // *************************************************************************
    // Donnee membre
    private BoutonMenu leBouton;
    // Un panneau qui sera appele lors du clic pour se placer dans un autre panneau
    private JPanel unPanneauRemplacement;
    // Le panneau qui contient le panneau qui sera change
    private JPanel unPanneauRoot;
    
    // *************************************************************************
    // Constructeur
    public ControlleurMenuEchelons(BoutonMenu unBouton){
        this.leBouton = unBouton;
    }
    
    public ControlleurMenuEchelons(JPanel unPanneauRoot){
        this.unPanneauRoot = unPanneauRoot;
    }
    // *************************************************************************
    // Ecouteurs
    @Override
    public void mouseClicked(MouseEvent e) {
        unPanneauRoot.removeAll();
        unPanneauRoot.setLayout(new GridLayout(1, 1));
        unPanneauRoot.add(new PanDesEchelons(All.getListeTuiles()));
        unPanneauRoot.getParent().revalidate();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    // *************************************************************************
    // Main
    public static void main(String[] args){
        System.out.println("Hello world!");
    }
}
