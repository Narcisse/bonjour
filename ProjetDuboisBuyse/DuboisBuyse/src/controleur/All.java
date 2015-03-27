package controleur;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import modele.EchelleDuboisBuyseFr;
import modele.Echelon;
import vue.BoutonMenu;
import vue.TuileEchelon;

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
    public static Color invisibilityCloak = new Color(0, 0, 0, 0);
    // *************************************************************************
    // Donnees utiles
    private LocalTime leTemps;
    private LocalDate laDate;

    // Boutons du menu
    // Generer une liste de boutons

    public static ArrayList<BoutonMenu> getBoutonsMenu(JPanel unPanRoot) {
        ArrayList<BoutonMenu> boutons = new ArrayList<>();
        // Menus
        BoutonMenu echelons = new BoutonMenu("Les echelons");
        BoutonMenu progression = new BoutonMenu("Progression");
        // Ecouteurs
        echelons.addMouseListener(new ControlleurMenuEchelons(unPanRoot));
        progression.addMouseListener(new ControlleurMenuProgression(unPanRoot));
        // Remplissage de la liste
        boutons.add(echelons);
        boutons.add(progression);
        // Renvoi de la liste avec les boutons de menu et leurs ecouteurs
        return boutons;
    }

    // *************************************************************************
    // Methodes specifiques
    public static int getRandom(int de0aCeNombreExclusif) {
        Random generator = new Random();
        int nbRetour = generator.nextInt(de0aCeNombreExclusif);
        return nbRetour;
    }

    public static boolean estDejaLa(ArrayList<String> uneListe, String mot) {
        boolean estPresent = false;
        for (int i = 0; i < uneListe.size(); i++) {
            if (uneListe.get(i).equals(mot)) {
                estPresent = true;
                break;
            }
        }
        return estPresent;
    }

    public static void genererEchelle() {
        BufferedReader reader = null;
        EchelleDuboisBuyseFr echelle = new EchelleDuboisBuyseFr();
        Echelon unEchelon = new Echelon();
        try {
            reader = new BufferedReader(new FileReader(new File("data\\Echelle\\echelle_francaise.txt")));
            String line = "";
            int echelonActuel = 1;
            while ((line = reader.readLine()) != null) {
                String unMot = line;
                int echelon = Integer.valueOf(reader.readLine());
                if (echelon == echelonActuel) {
                    if (echelon != 43) {
                        unEchelon.addMot(line);
                    } else {
                        unEchelon.addMot(line);
                        echelle.addEchelon(unEchelon);
                    }
                } else {
                    echelle.addEchelon(unEchelon);
                    unEchelon = new Echelon();
                    unEchelon.addMot(unMot);
                    if (echelon == 41 && echelonActuel == 39) {
                        echelonActuel += 2;
                    } else {
                        echelonActuel += 1;
                    }
                }
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }

        ObjectOutputStream writer = null;
        try {
            writer = new ObjectOutputStream(new FileOutputStream(new File("data\\Echelle\\echelleFR.db")));
            writer.writeObject((EchelleDuboisBuyseFr) echelle);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }
    }

    public static EchelleDuboisBuyseFr getEchelleDB() {
        ObjectInputStream reader = null;
        EchelleDuboisBuyseFr uneEchelle = null;
        try {
            reader = new ObjectInputStream(new FileInputStream(new File("data\\Echelle\\echelleFR.db")));
            uneEchelle = (EchelleDuboisBuyseFr) reader.readObject();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } catch (ClassNotFoundException cnfEx) {
            cnfEx.printStackTrace();
        }
        return uneEchelle;
    }

    public void enregistrerLechelle(EchelleDuboisBuyseFr uneEchelle) {

    }
    
    public static ArrayList<TuileEchelon> getListeTuiles(){
        EchelleDuboisBuyseFr echelle = All.getEchelleDB();
        ArrayList<TuileEchelon> tuiles = new ArrayList<>();
        for (int i=0; i<echelle.getEchelons().size(); i++){
            TuileEchelon tuile = new TuileEchelon(echelle.getEchelons().get(i), i+1);
            tuiles.add(tuile);
        }
        return tuiles;
    }

    // Fonction qui renvoi un pourcentage en entier d'une valeur
    // Ex: passer 0.1 et la hauteur de lecran renvoi une valeur en int pouvant
    // etre utiliser pour occuper 10% de la hauteur de l'ecran

    public static int pourcentage(double pourcentage, int valeur) {
        return (int) (valeur * pourcentage);
    }

    public String donneHeure() {
        leTemps = LocalTime.now();
        String heure = leTemps.getHour() + ":" + leTemps.getMinute();
        return heure;
    }

    public String donneDate() {
        laDate = LocalDate.now();
        String date = laDate.format(DateTimeFormatter.ofPattern("d MMM uuuu"));
        return date;
    }
}
