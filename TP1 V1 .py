##############################################################
# Nom          : TP1 chasse aux trésors version 1
# Descritpion  : jeu de chasse au trésor sur plan cartésien
# Par          : Étienne Demers
##############################################################
#============= Importations =====================
from tp1_classes import Personnage , Pointage
import random
from datetime import date
#import os ####################################################ICI
#======= Déclarations de variables ===============
choix_menu = None #int
perso = None #obj
tresor = None #obj
nom = "" #str
tab_score = [] #liste d'obj
compte_score = 0 #int
maintenant = date.today() #objet
#================= Code =========================
#menu
while True:
    print("***MENU***\n1.Nouvelle pertie\n2.Règlements\n3.Tableau des scores\n4.Quitter")
    choix_menu = int(input("Entrez votre choix: "))
    if choix_menu == 1:
#initialisation de la partie
        print("***NOUVELLE PARTIE***")
        nom = input("Entrez le nom du personnage: ")
        perso = Personnage(nom,0,0)
        tresor = Personnage("trésor",random.randint(-8,8),random.randint(-8,8))
        compte_points = 0
        X = 0 #int
        Y = 0 #int
#boucle de jeu    
        while perso == tresor: #######remodifier op
            print("\n\n",perso)
            print(nom," est à une distance de ",perso.calculer_dist(tresor)," du trésor.")
            X = int(input("Déplacement sur l'axe des X: "))
            Y = int(input("Déplacement sur l'axe des Y: "))
            perso.deplacer(X,Y)
            compte_points += 1
#ajout du score
        tab_score.append(Pointage(nom,compte_points,maintenant))
    elif choix_menu == 2:
        print()
    elif choix_menu == 3:
        print()
    elif choix_menu == 4:
        quit()
    else:
        print("Erreur: choix non valide.")
        input("Appuyez sur entrée pour continuer.")
         

