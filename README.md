# Utilisation des scripts:
Les 3 scripts sont:
* compile.sh : Permet de lancer la compilation de tout les fichers java pour les projets banking, logger et testframework.
* launch_banking.sh : Permet de lancer l'application banking, ce script ne prend aucun paramètres. 
* test.sh : Permet de lancer les tests du projet banking. Ce script prend en paramètre le nom de la methode à tester.
	les paramètres  sont:
	* Deposit	teste la méthode permettant de faire un dépot 
	* Withdraw	teste la méthode permettant de faire un retrait 
	* Credit	teste la méthode permettant de faire un crédit 
	* Transfert	teste la méthode permettant de faire un transfert

Exemple: ./test.sh Deposit Withdraw Transfert Credit lancera tous les tests.


# Points d'entrée du code:
les points d'entrée sont:
* Bank.java	Pour l'application banking
* RunTest.java	Pour les tests


# Utilisation de l'application banking:
L'application ne contient aucun utilisateurs au lancement, il faut commencer par en ajouter au moins un avec la commande a.
Pour faire une action sur l'utilisateur (transfert, dépot, retrait, crédit) il faut d'abord sélectionner l'utilisateur (avec la commande s) puis faire l'action voulue(transfert=t, dépot=d, retrait=r, crédit=c). L'action sera faite pour l'utilisateur séléctionné.
L'action transfert ne peut être faite que si au moins deux utilisateurs ont été ajouté.


# Problèmes rencontrées:
L'un des problèmes que nous avons rencontré est la création de méthodes testables. Les premières methodes de dépot, retrait, crédit et transfert demandaient une entrée clavier à l'utilisateur et renvoyaient un message de confirmation. Cela empêchait les méthodes d'être testées via du code et polluait les données en sortie. Nous avons résolu ces problèmes en séparant les méthodes en deux: l'une demandant les entrée utilisateurs et renvoyant les messages d'erreur/confirmation et l'autre executant les operations. le code executant les opérations renvoie des exceptions en cas de problème et la méthode faisant le lien avec l'utilisateur renvoie les messages obtenus via les exceptions.

# Participants
* RAGUIDEAU Akiya
* CAYOL Joe-Yann
* DESRIVIERE Arnaud
