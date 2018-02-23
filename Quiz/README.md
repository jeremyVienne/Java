auteurs:
  VIENNE Jérémy
  IRAKOZE Franco Davy

Description: 
  Ce projet consiste à la réalisation d'un questionnaire, graphique et mode texte. Le questionnaire doit être crée a partir d'un fichier écrit avec une syntaxe précise (question, reponse, points).
  
how to:

  Récupération du dépôt:
    git clone git@gitlab-etu.fil.univ-lille1.fr:irakoze/TP-Quiz.git
    pour mettre à jour le dossier:
    git pull git@gitlab-etu.fil.univ-lille1.fr:irakoze/TP-Quiz.git

  Génération de l'exécutable:
    mvn package (depuis la racine du projet)

  Exécution du projet: (depuis le dossier target), avant l'exécution de celui-ci, veillez à mettre le fichier quiz.txt dans le dossier où se trouve l'exécutable.
    java -jar file.jar

    
