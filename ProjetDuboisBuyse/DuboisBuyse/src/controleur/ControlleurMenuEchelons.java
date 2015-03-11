package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import vue.BoutonMenu;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class ControlleurMenuEchelons implements MouseListener{
    // *************************************************************************
    // Donnee membre
    private BoutonMenu leBouton;
    
    // *************************************************************************
    // Constructeur
    public ControlleurMenuEchelons(BoutonMenu unBouton){
        this.leBouton = unBouton;
    }
    // *************************************************************************
    // Ecouteurs
    @Override
    public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null, leBouton.getText());
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
