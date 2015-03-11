package modele;

import java.io.Serializable;
import java.util.ArrayList;

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
 * Cette classe doit pouvoir etre ecrite et lue comme un objet dans un fichier.
 * Le but de cette condition est de creer un fichier contenant les echelons
 * prefabriques pour accelerer l'execution en ne demandant pas au programme de
 * recreer inutilement les echelons a chaque ouverture du pogramme.
 * 
 */
public class Echelon implements Serializable{
    // *************************************************************************
    // Donnee membre
    ArrayList<String> motsDeLechelon;
    
    // *************************************************************************
    // Main (zone de test)
    public static void main(String[] args){
        System.out.println("Hello world!");
    }
}
