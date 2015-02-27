##############################################################
# Nom          : TP1 chasse aux trésors version 1
# Descritpion  : jeu de chasse au trésor sur plan cartésien
# Par          : Étienne Demers
##############################################################
#============= Importations =====================
from tp1_classes import Personnage , Pointage
import random
from datetime import date
#import os #pour ajouter des "clear screen" en console noire
#======= Déclarations de variables ===============
choix_menu = None #int
perso = None #obj
tresor = None #obj
nom = "" #str
score = 0 #int
tab_score = [] #liste d'obj
compte_score = 0 #int
maintenant = date.today() #objet
X = 0 #int
Y = 0 #int
#================= Code =========================
#menu
while True:
    print("\n\n***MENU***\n1.Nouvelle partie\n2.Règlements\n3.Tableau des scores\n4.Quitter")
    choix_menu = int(input("Entrez votre choix: "))
    if choix_menu == 1: #(Nouvelle Partie)
#initialisation de la partie
        print("***NOUVELLE PARTIE***")
        nom = input("Entrez le nom du joueur: ")
        perso = Personnage(nom,0,0)
        tresor = Personnage("trésor",random.randint(-8,8),random.randint(-8,8))
        compte_points = 0
        X = 0
        Y = 0 
#boucle de jeu    
        while perso != tresor:
            print("\n\n",perso)
            print(nom," est à une distance de ",perso.calculer_dist(tresor)," du trésor.")
            X = int(input("Déplacement sur l'axe des X: "))
            Y = int(input("Déplacement sur l'axe des Y: "))
            perso.deplacer(X,Y)
            compte_points += 1
#ajout du score
        score = Pointage(nom,compte_points,maintenant)
        print("\n***Bravo!!!***\nVous avez terminé la partie en ",compte_points," tours!")
        tab_score.append(score)
        tab_score.sort()
        
    elif choix_menu == 2: #(Règlements)
        print("\n\n\n***RÈGLEMENTS***\n\nJeu de chasse au trésor en console.")
        print("La partie se déroule dans un plan cartésien allant de 8 à -8 sur les deux axes.")
        print("Un trésor est caché à une position aléatoire.")
        print("votre personnage commence la partie au centre du plan cartésien.")
        print("À chaque tour, le programme affiche votre position et à quelle distance vous êtes du trésor.")
        print("vous devez vous déplacer sur l'axe des X et des Y jusqu'à ce que vous soyez sur le même point que le trésor.")
        print("Votre score est égal au nombre de tours avant la fin de la partie. Plus il est bas, meileur il est.")
        input("\n\nAppuyez sur entrée pour retourner au menu...")
    elif choix_menu == 3: #(Tableau des scores)
        print("\n\n\n***Tableau des scores***\nVoici le top 5 des meilleurs scores!\n")
        if len(tab_score)>= 5:
            for i in range(0,5,1):
                print(tab_score[i])
        else:
            for i in range(0,len(tab_score),1):
                print(tab_score[i])
    elif choix_menu == 4: #(quitter)
        quit()
    else:
        print("\nErreur: choix non valide.")
        input("Appuyez sur entrée pour retourner au menu.")
         
