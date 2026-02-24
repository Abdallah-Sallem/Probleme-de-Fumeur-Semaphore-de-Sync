# Problème des Fumeurs — Synchronisation par Sémaphores

## Description

Ce projet est une implémentation en Java du **Problème des Fumeurs** (*Cigarette Smokers Problem*), un problème classique de synchronisation de processus en programmation concurrente.

### Le problème

Il y a trois ingrédients nécessaires pour fabriquer une cigarette :
- **A** — Allumettes (*Matches*)
- **P** — Papier (*Paper*)
- **T** — Tabac (*Tobacco*)

Il y a trois fumeurs et un agent :

- Chaque **fumeur** possède en quantité infinie **un seul** ingrédient.
- L'**agent** place aléatoirement **deux ingrédients différents** sur la table.
- Le fumeur qui possède le troisième ingrédient ramasse les deux ingrédients posés, roule une cigarette et fume.
- Une fois terminé, il signale à l'agent de recommencer.

| Fumeur | Ingrédient possédé | Attend que l'agent pose |
|--------|-------------------|-------------------------|
| `FumeurA` | Allumettes | Tabac + Papier (sémaphore `TP`) |
| `FumeurP` | Papier | Tabac + Allumettes (sémaphore `TA`) |
| `FumeurT` | Tabac | Papier + Allumettes (sémaphore `PA`) |

---

## Architecture

```
src/
├── Agent.java      # Thread agent : place deux ingrédients aléatoires sur la table
├── FumeurA.java    # Thread fumeur possédant les allumettes
├── FumeurP.java    # Thread fumeur possédant le papier
├── FumeurT.java    # Thread fumeur possédant le tabac
└── Test.java       # Classe principale : initialise les sémaphores et démarre les threads
```

### Sémaphores utilisés

| Sémaphore | Valeur initiale | Rôle |
|-----------|----------------|------|
| `S`  | 1 | Contrôle l'accès de l'agent à la table (mutex) |
| `TP` | 0 | Signale que Tabac + Papier sont disponibles → réveille `FumeurA` |
| `TA` | 0 | Signale que Tabac + Allumettes sont disponibles → réveille `FumeurP` |
| `PA` | 0 | Signale que Papier + Allumettes sont disponibles → réveille `FumeurT` |

---

## Prérequis

- **Java JDK 8** ou supérieur

## Compilation et exécution

```bash
# Compiler tous les fichiers source
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

## Concepts illustrés

- **Threads Java** (`Thread`)
- **Sémaphores Java** (`java.util.concurrent.Semaphore`)
- **Exclusion mutuelle** et **synchronisation** entre threads
- **Problème classique de synchronisation** (Dijkstra, 1965)
