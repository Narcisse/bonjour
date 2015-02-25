##############################################################
# Classes      : Personnage, Pointage
# Descritpion  : voir dans la classe
# Par          : Pierre Coutu 
##############################################################
#============= Importations =====================
from datetime import date
import math

#============= Classe ===========================
class Personnage :
    """
    Description :
    ===========
    Personnage de jeu avec nom et une position x et y, représentée
    par des entiers.
    Les déplacements se font avec des valeurs entières.
    L'affichage inclus le nom, et les coordonnées.
    Les comparateur == et != permettent de comparer les coordonnées de
    2 Personnages.
    
    Données membres privées :
    ======================
    __nom= ""     # str (nom du Personnage)
    __x = 0       # int (position sur l'axe des x)
    __y = 0       # int (position sur l'axe des y)

    Méthodes publiques :
    ==================
    Personnage(p_nom:str,p_x:int=0,p_y:int=0)   # constructeur qui
                                 # initialise les attributs, par défaut
                                 # x et y valent 0
    deplacer(p_dx:int,p_dy:int)  # déplace le personnage dans l'axe des x et y
                                 # par p_dx et p_dy unités respectivement
    calculer_dist(autre:objet)-> float  # retourne la distance entre l'objet
                                        # courant et celui passé en param. 
    ==                           # vrai si les x et y sont égaux
    !=                           # vrai si les x ou y sont différents
    """
    
    #----------- Déclaration des données membres -----------
    __x = 0       # int (position sur l’axe des x)
    __y = 0       # int (position sur l’axe des y)
    __nom= ""     # str

    #-----------  Constructeur -----------------------------
    def __init__(self,p_nom:str,p_x:int=0,p_y:int=0) :
        """
        Constructeur qui initialise les données membres.
           p_nom : est le nom du personnage
           p_x : la position initiale en x 
           p_y : la position initiale en y 
        """
        self.__nom = p_nom
        if (isinstance(p_x,int) and isinstance(p_y,int)) :
            self.__x=p_x
            self.__y=p_y
        else :
            raise TypeError("Les coordonnées doivent être des entiers")
    #----------- Accesseurs/Mutateurs ----------------------
    def get_nom(self)->str :
        return self.__nom
    def get_x(self)->int :
        return self.__x
    def get_y(self)->int :
        return self.__y

    #----------- Opérations --------------------------------
    def deplacer(self,p_dx:int,p_dy:int):
        """
        Permet de se déplacer en x et y de p_dx et p_dy unités
        respectivement
        """
        if (isinstance(p_dx,int) and isinstance(p_dy,int)) :
            self.__x+=p_dx
            self.__y+=p_dy
        else :
            raise TypeError("Les déplacements doivent être des entiers")

    def calculer_dist(self,autre:object) -> float :
        """
        Calcul la distance en valeur absolue entre l'objet courant
        et l'objet autre. 
        """
        disantce=0.0 # float (variable locale)
        distance=math.sqrt((self.__x-autre.__x)**2+(self.__y-autre.__y)**2)
        return round(distance,2)
    
    #-----------  Affichage  -------------------------------
    def __str__(self):
        """
        Formate l'affichage selon le format:
           La position de _____ est [x :__ et y :___]
        """
        s="La position de "+self.__nom+" est " 
        s+="{x:"+str(self.__x)+" et y:"+str(self.__y)+"}" 
        return s

    #-----------  Comparateurs  -------------------------------
    def __eq__(self,autre) -> bool:
        """
        Défini le comparateur ==    Vrai si les x et y sont égaux. 
        """
        test=False   # bool
        if (isinstance(autre,Personnage)):
            if (self.__x==autre.__x and self.__y==autre.__y):
                test=True
        return test
                
    def __ne__(self,autre) -> bool :
        """
        Défini le comparateur !=   Vrai si les x ou y sont différents. 
        """
        return not(self.__eq__(autre))


class Pointage :
    """
    Description :
    ===========
    Pointage d'une partie avec nom, nombre d'essai, et la date.
    Les objets de type Pointage sont « triables » par :
        points, nom et date (... dans cet ordre) 
    
    Données membres privées :
    ======================
    __nom= ""     # str  (nom du joueur)
    __points = 0  # int  (nombre d'essais pour trouver)
    __date = None # date (date où la partie s'est jouée)

    Méthodes publiques :
    ==================
    Pointage(p_nom:str,p_points:int,p_date:date)  # constructeur qui
                                                  # initialise les attributs
    <                           # comparateur défini pour le triage
    """
    
    #----------- Déclaration des données membres -----------
    __nom= ""     # str  (nom du joueur)
    __points = 0  # int  (nombre d’essais)
    __date = 0    # date (date de la partie)

    #-----------  Constructeur -----------------------------
    def __init__(self,p_nom:str,p_points:int,p_date:object) :
        """
        Constructeur qui initialise les données membres.
           p_nom    : est le nom du personnage
           p_points : nombre d'essais pour trouver
           p_date   : date de la partie
        """
        self.__nom     = p_nom
        self.__points  = p_points
        self.__date    = p_date

     #-----------  Affichage  -------------------------------
    def __str__(self):
        """
        Formate l'affichage selon le format:
           Nom, points, date
        """
        s=""    #str
        # ajuste le nom pour qu'il prenne 11 caractères
        if len(self.__nom) >= 10 :
            s=self.__nom[0:10]
        else :
            s=self.__nom.rjust(10)
        s=s+"     "
        # ajuste les points pour qu'il prenne 4 caractères
        s=s+str(self.__points).rjust(4)
        # ajoute la date form jj/mm/aaaa
        s=s+"     "+self.__date.strftime("%d/%m/%Y")
        return s
    
    def __repr__(self):
        """
        Formate l'affichage lorsqu'utilisée dans une liste
        """
        return self.__str__()
    #-----------  Comparateurs  -------------------------------
    def __cmp__(self,autre) -> int:
        '''
	Retourne -1 si self < autre, 0 si self == autre, 1 si self > autre.
        Les points sont d’abord comparés. En cas d’égalité, on va ensuite au 
        nom, et finalement à la date. 
        '''
        test=0  # int (valeur à retourner)
        if   (self.__points < autre.__points) :
            test= -1
        elif (self.__points > autre.__points) :
            test=  1
        else :
            if   (self.__nom < autre.__nom) :
                test= -1
            elif (self.__nom > autre.__nom) :
                test=  1
            else : 
                if   (self.__date < autre.__date) :
                    test= -1
                elif (self.__date > autre.__date) :
                    test=  1
        return test       

    def __lt__(self,autre) :
        ''' Défini l’opérateur < '''
        return self.__cmp__(autre)<0
