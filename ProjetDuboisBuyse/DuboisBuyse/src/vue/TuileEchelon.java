package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modele.Echelon;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class TuileEchelon extends JPanel implements Serializable{
    // *************************************************************************
    // Donnees utiles
    private JLabel imageDeLechelon;
    private JLabel nomDeLechelon;
    
    private Echelon unEchelon;
    private int noEchelon;
    // *************************************************************************
    // Constructeur
    public TuileEchelon(Echelon unEchelon, int noEchelon){
        super();
        init(unEchelon, noEchelon);
        listen();
    }
    
    // *************************************************************************
    // Initialisation
    public void init(Echelon unEchelon, int noEchelon){
        this.unEchelon = unEchelon;
        this.noEchelon = noEchelon;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 100));
        
        JLabel plume = new JLabel(new ImageIcon("data\\Images\\plume.jpg"));
        JLabel echelon = new JLabel("Echelon : " + noEchelon);
        
        this.add(plume, BorderLayout.CENTER);
        this.add(echelon, BorderLayout.SOUTH);
    }
    public void listen(){
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, unEchelon.getListeAffichable(true));
            }
            
        });
    }
    public Echelon getEchelon(){
        return this.unEchelon;
    }
    // *************************************************************************
    // Main
    public static void main(String[] args){
        System.out.println("Hello world!");
    }
}
