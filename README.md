# Problème du Fumeur de Cigarettes — Synchronisation par Sémaphores

## Description

Ce projet est une implémentation en Java du **Problème du Fumeur de Cigarettes** (*Cigarette Smokers Problem*), un problème classique de synchronisation de processus concurrents proposé par Suhas Patil en 1971.

Le problème illustre l'utilisation des **sémaphores** pour coordonner l'accès à des ressources partagées entre plusieurs threads.

---

## Le Problème

Il y a **un agent** et **trois fumeurs**. Chaque fumeur possède en quantité illimitée **un seul ingrédient** parmi les trois nécessaires pour rouler une cigarette :

| Fumeur   | Ingrédient possédé |
|----------|--------------------|
| FumeurA  | Allumettes (A)     |
| FumeurP  | Papier (P)         |
| FumeurT  | Tabac (T)          |

L'agent place aléatoirement **deux des trois ingrédients** sur la table. Le fumeur qui possède le troisième ingrédient prend les deux ingrédients sur la table, roule une cigarette et fume. Une fois terminé, il signale à l'agent de recommencer.

---

## Structure du Projet

```
src/
├── Agent.java      # Thread de l'agent : choisit et dépose 2 ingrédients aléatoirement
├── FumeurA.java    # Fumeur possédant les allumettes — attend Tabac + Papier
├── FumeurP.java    # Fumeur possédant le papier    — attend Tabac + Allumettes
├── FumeurT.java    # Fumeur possédant le tabac     — attend Papier + Allumettes
└── Test.java       # Classe principale : déclare les sémaphores et démarre les threads
```

---

## Sémaphores utilisés

| Sémaphore | Rôle                                                          |
|-----------|---------------------------------------------------------------|
| `S`       | Contrôle l'accès de l'agent à la table (initialisé à 1)      |
| `TP`      | Signale le fumeur A (Tabac + Papier disponibles)              |
| `TA`      | Signale le fumeur P (Tabac + Allumettes disponibles)          |
| `PA`      | Signale le fumeur T (Papier + Allumettes disponibles)         |

---

## Prérequis

- **Java JDK 8** ou supérieur

---

## Compilation et Exécution

```bash
# Compiler tous les fichiers sources
javac src/*.java -d out/

# Exécuter le programme
java -cp out/ Test
```

### Exemple de sortie

```
L'agent a mis T et P
Le fumeur avec les allumettes peut fumer
Le fumeur A fume
```

---

## Concepts Clés

- **Thread** : Chaque acteur (agent et fumeurs) s'exécute dans son propre thread Java (`Thread`).
- **Semaphore** : Utilisé depuis `java.util.concurrent.Semaphore` pour bloquer et débloquer les threads de manière synchronisée.
- **Exclusion mutuelle** : Le sémaphore `S` garantit qu'un seul thread accède à la table à la fois.

---

## Auteur

**Abdallah Sallem**
