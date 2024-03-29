# ProjetS2.01

Projet sismique

Objectif

L’objectif est de réaliser une application permettant d’aﬃcher et de traiter des données sismiques de France métropolitaine.

Les données sont issues du site SisFrance (https://www.sisfrance.net/). Cette base de données est maintenue par le BRGM (Bureau de Recherches Géologiques et Minières), en collaboration avec EDF et l’IRSN (Institut de Radioprotection et de Sûreté Nucléaire). Elle vise à rendre accessible au grand public les données sismiques enregistrées depuis plus de 40 ans. Elle contient aussi les évènements décrits dans les archives et datant de plus de 1000 ans. Ces données sont accessibles sur le site Web et exportable en fichier au format CSV.

Votre application devra permettre d’importer, de visualiser et d’analyser les données extraites de ces fichiers CSV. Elle permettre de les ﬁltrer selon les différents attributs stockés (c.f. glossaire du site SisFrance). Elle devra par exemple permettre de lister tous les évènements ayant lieu dans un certain rayon d’un point (latitude et longitude données), ou dans une région. Elle devra aussi permettre de trier les informations des séismes en fonction des différents attributs renseignés. Ces données brutes seront affichées sous la forme d’un tableau, appuyé par un affichage cartographique de la localisation des séismes sélectionnés.

En plus de la visualisation des données, votre application devra permettre de générer des informations statistiques sur les séismes (des tableaux de bord ou « dashboards »). Par exemple, elle devra afficher sous la forme d’un graphique l’évolution du nombre de séismes sur une zone, une période et une échelle de temps données. Elle pourra aussi afficher pour la zone ciblée la force moyenne, maximale et minimale des séismes enregistrés. Elle pourra par ailleurs utiliser différents types de graphiques pour mettre en avant différents aspects des données.

Au delà des aspects purement fonctionnels, votre application devra être développée en JavaFX et mettre en pratique toutes les techniques permettant de garantir la qualité du code. Ainsi, le code devra être commenté, versionné et documenté. Pour cela, vous utiliserez Javadoc et Git. L’architecture du code devra aussi mettre en avant la séparation entre l’interface graphique et le noyau de l’application. Pour cela, vous vous documenterez sur l’architecture MVVM et essaierez de la mettre en place. Vous ferez de même pour les bonnes pratiques en matière d’ergonomie des interfaces graphiques. Pour ces deux derniers points, vous devrez donc faire un peu de recherche bibliographique. Dans votre rapport, vous veillerez donc à bien citer vos sources pour appuyer votre argumentaire.
