package controleur;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vue.BoutonMenu;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class ControlleurMenuProgression implements MouseListener{
    // *************************************************************************
    // Donnee membre
    private BoutonMenu leBouton;
    
    private JPanel unPanneauRoot;
    
    private JFrame uneFrameRoot;
    // *************************************************************************
    // Constructeur
    public ControlleurMenuProgression (BoutonMenu unBouton){
        this.leBouton = unBouton;
    }
    public ControlleurMenuProgression(JPanel unPanneauRoot){
        this.unPanneauRoot = unPanneauRoot;
    }
    // *************************************************************************
    // Ecouteurs
    @Override
    public void mouseClicked(MouseEvent e) {
        unPanneauRoot.removeAll();
        unPanneauRoot.setLayout(new GridLayout(1, 1));
        unPanneauRoot.add(new JPanel());
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
