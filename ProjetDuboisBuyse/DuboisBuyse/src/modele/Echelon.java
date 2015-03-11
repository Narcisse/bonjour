package modele;

import controleur.All;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher Desrosiers Mondor
 * 
 * Un echelon est constitue de plusieurs mots qui devront etre facilement
 * presente par groupe de 30 (il peut y avoir moin de mots dans lechelon donc
 * prevoir cette possibilite) au tuteur qui utilisera le programme.
 * 
 * La classe doit egalement fournir une methode pour obtenir un nombre x de
 * mots.Cette methode doit egalement pouvoir prendre une liste de mots qu'on
 * ne veut pas revoir dans les nouveaux mots presentes.
 * 
 * La liste ainsi fournit pourra etre soit en ordre alphabetique ou dans le desordre.
 * 
 * Cette classe doit pouvoir etre ecrite et lue comme un objet dans un fichier.
 * 
 * Le but de cette condition est de creer un fichier contenant les echelons
 * prefabriques pour accelerer l'execution en ne demandant pas au programme de
 * recreer inutilement les echelons a chaque ouverture du pogramme.
 * 
 */
public class Echelon implements Serializable{
    // *************************************************************************
    // Donnee membre
    private ArrayList<String> motsDeLechelon;
    
    // *************************************************************************
    // Constructeur
    public Echelon(ArrayList<String> uneListeDeMots){
        this.motsDeLechelon = uneListeDeMots;
    }
    
    // *************************************************************************
    // Methodes specifiques
    /*
    Nom: getListeTest
    Argument: ordreAlphabetique
    
    Creer la liste de test pour le tuteur. Si l'echelon contient moins de 30
    mots alors on renvoi simplement la liste de mot.
    
    ordreAlphabetique definit si la liste est en ordre alphabetique ou dans le
    desordre. C'est un booleen.
    
    Si la liste contient plus de 30 mots on effectu un random de 0 a x ou x est
    le nombre delements dans la liste de mots.
    
    S'assurer qu'il n'y a pas de doublon en verifiant que le mot n'est pas deja
    dans la liste avant de le rajouter.
    */
    public ArrayList<String> getListeTest(boolean ordreAlphabetique){
        ArrayList<String> listeRetour;
        int nbMots = motsDeLechelon.size();
        if (nbMots >= 30){
            // On cree la liste vide pour effectuer un choix aleatoire des
            // nouveaux mots a renvoyer (seulement 30/x disponibles)
            listeRetour = new ArrayList<>();
            // On genere la liste de mots
            while (listeRetour.size()<30){
                String nouveauMot = motsDeLechelon.get(All.getRandom(nbMots));
                // On verfie que le mot n'est pas deja dans la liste
                if(!All.estDejaLa(listeRetour, nouveauMot)){
                    listeRetour.add(nouveauMot);
                }
            }
            if (ordreAlphabetique){
                Collections.sort(listeRetour);
                return listeRetour;
            } else {
                return listeRetour;
            }
        } else {
            if (ordreAlphabetique){
                Collections.sort(motsDeLechelon);
                return motsDeLechelon;
            } else {
                return motsDeLechelon;
            }
        }
    }
    
    public String getListeAffichable(boolean ordreAlphabetique){
        String affichage = "";
        ArrayList<String> mots = getListeTest(ordreAlphabetique);
        for (int i=0; i<mots.size(); i++){
            if (i!=(mots.size()-1)){
                affichage += mots.get(i) + "\n";
            } else {
                affichage += mots.get(i);
            }
        }
        return affichage;
    }
    // *************************************************************************
    // Main (zone de test)
    public static void main(String[] args){
        String mot1 = "oiseau";
        String mot2 = "bateau";
        String mot3 = "dahlia";
        String mot4 = "exhaler";
        
        ArrayList<String> motsDeLechelon = new ArrayList<>();
        
        motsDeLechelon.add(mot1);
        motsDeLechelon.add(mot2);
        motsDeLechelon.add(mot3);
        motsDeLechelon.add(mot4);
        
        Echelon echelonZ = new Echelon(motsDeLechelon);
        
        JOptionPane.showMessageDialog(null, echelonZ.getListeAffichable(true));
    }
}
