# 📚 Projet 1 : Gestion d’une Bibliothèque en Kotlin

## 🧾 Description
Ce projet simule la **gestion d’une bibliothèque** à l’aide de la **programmation orientée objet (POO)** en **Kotlin**.  
Il permet d’ajouter des **livres**, de gérer des **utilisateurs**, et de suivre leurs **emprunts et retours de livres**.

## 🏗️ Structure du projet

### Classes principales :
- **`Personne`** : classe de base représentant une personne avec un nom, un prénom et un email.  
- **`Utilisateur`** *(hérite de Personne)* : représente un utilisateur de la bibliothèque capable d’emprunter des livres.  
- **`Livre`** : contient les informations d’un livre (titre, auteur, ISBN, nombre d’exemplaires).  
- **`Emprunt`** : relie un utilisateur et un livre, en stockant les dates d’emprunt et de retour.  
- **`GestionBibliotheque`** *(classe abstraite)* : définit la structure de gestion d’une bibliothèque.  
- **`Bibliotheque`** : implémente les méthodes pour ajouter et afficher les utilisateurs et les livres.

## ⚙️ Fonctionnalités principales
- Ajouter et afficher les livres.  
- Ajouter et afficher les utilisateurs.  
- Effectuer un emprunt de livre (en mettant à jour le stock).  
- Enregistrer le retour d’un livre.  
- Afficher les détails d’un emprunt ou d’un livre.  

## 🧠 Exemple d’exécution
```kotlin
*************** Utilisateurs  *****************
votre nom complet est : naima Ziane 
votre email: zianenaima@gmail.com

************* Emprunts via fonction emprunterLivre() *************
utilisateur : naima
livre: titre1
date emprunt : 4/10/25
date retour : null
```

## ✅ Objectifs pédagogiques
- Appliquer l’héritage et l’encapsulation en Kotlin.  
- Utiliser des listes mutables pour stocker des objets.  
- Comprendre les interactions entre classes.  
- Manipuler des objets à travers des fonctions personnalisées.  

---

# 🚗 Projet 2 : Gestion d’un Parc Automobile en Kotlin

## 🧾 Description
Ce projet met en œuvre un **système de gestion de parc automobile**, permettant de gérer les **véhicules, conducteurs et réservations**.  
Il intègre également une **gestion des exceptions personnalisées**.

## 🏗️ Structure du projet

### Classes principales :
- **`Vehicule`** *(abstraite)* : classe de base contenant les informations communes (immatriculation, marque, modèle, kilométrage, disponibilité).  
- **`Voiture`** *(hérite de Vehicule)* : ajoute des propriétés spécifiques comme le nombre de portes et le type de carburant.  
- **`Moto`** *(hérite de Vehicule)* : ajoute la cylindrée.  
- **`Conducteur`** : représente un conducteur avec un numéro de permis.  
- **`Reservation`** : relie un véhicule et un conducteur, avec les dates et les kilomètres de début et de fin.  
- **`ParcAutomobile`** : gère la liste des véhicules et des réservations.  

### Exceptions personnalisées :
- **`VehiculeIndisponibleException`** : levée quand un véhicule est déjà réservé.  
- **`VehiculeNonTrouveException`** : levée quand le véhicule recherché n’existe pas.  

## ⚙️ Fonctionnalités principales
- Ajouter et supprimer des véhicules du parc.  
- Réserver un véhicule pour un conducteur.  
- Clôturer une réservation et mettre à jour le kilométrage.  
- Afficher les véhicules disponibles et les réservations en cours.  
- Gérer les erreurs (véhicule non trouvé ou indisponible).  

## 🧠 Exemple d’exécution
```kotlin
✅ Véhicules ajoutés au parc automobile.

Immatriculation : A-2334
Marque : BMW, Modele : 2020
Kilometrage : 500, Disponible? : true

Erreur réservation: Le véhicule n'est pas disponible !
Gestion d'erreur: Véhicule non trouvé dans le parc.
```

## ✅ Objectifs pédagogiques
- Mettre en œuvre l’héritage et le polymorphisme.  
- Manipuler les exceptions personnalisées.  
- Utiliser des listes mutables pour gérer un ensemble d’objets.  
- Simuler des opérations de gestion de flotte automobile.

---

## 🛠️ Technologies utilisées
- **Langage :** Kotlin  
- **Paradigme :** Programmation orientée objet (POO)  
- **Environnement :** IntelliJ IDEA / Kotlin Playground  

---

## 🚀 Exécution
1. Ouvrir le projet dans **IntelliJ IDEA**.  
2. Coller le code dans le fichier `Main.kt`.  
3. Cliquer sur **Run ▶️** pour exécuter le programme.  

---

## 📄 Auteur
Projet développé par **Amin Anfamm** — dans le cadre des exercices de **programmation orientée objet en Kotlin**.
