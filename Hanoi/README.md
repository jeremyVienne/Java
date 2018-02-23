AUTHORS : Vienne Jeremy & Lecornet Didrick

OBJECTIF: TP hanoi  
        > réaliser le principe du jeu d'Hanoi

GENERER et CONSULTER DOC:
        > Placez vous dans le dossier src et executer la commande: "javadoc hanoi hanoi.util -d ../docs", afin de générer la documentation du paquetage hanoi et de tous ses sous-paquetages
        > La documentation sera disponible dans le dossier docs

COMPILER SOURCES PROJET:
        > Placez vous dans le dossier src, et executer la commande "javac hanoi/HanoiMain -d ../classes".

COMPILER,EXCECUTER TESTS:
        >  Afin de compiler les tests: placez vous dans la racine du projet et executer la commande:"javac -classpath test-1.7.jar test/filename.java", en remplaçant filename par le fichier souhaité.          > Afin d'executer les tests, placer vous dans la racine du projet et executer la commande: "java -jar test-1.7.jar filename", en remplaçant filename par le fichier souhaité.

GENERER .jar:
        > Afin de générer le fichier .jar, placez vous dans le dossier classes et executer la commande: "jar cvf ../appli.jar hanoi". Le fichier appli.jar contient tous les fichiers de l’arborescence dont la racine est le dossier hanoi
        > Afin de générer un .jar executable, placez vous dans la racine de votre projet et copier le fichier manifest-ex. Puis placez vous dans le dossier classes et executer les commandes:"java -classpath appli.jar hanoi.ROBOT"et"jar cvfm ../appli.jar ../manifest-ex

EXECUTER LE PROGRAMME:
        > Afin d'exectuer le programme, placez vous dans la racine du projet et executer la commande: "java -jar appli.jar". Le manifeste de l'archive est automatiquement utilisé pour déterminer le main a executer.

TESTER LE PROGRAMME:
	Utiliser 'g' 'c' 'd' : pour d�placer un disque les cases gauche, centrale, droite.
		ex: 
			> gd
			Tower 0 -> Tower 2
     |          |          |     


   --|--        |          |     


  ---|---       |         -|-    
			