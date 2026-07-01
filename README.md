# 🦖 Jurassic Survival

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Terminal](https://img.shields.io/badge/Terminal-4D4D4D?style=for-the-badge&logo=windows-terminal&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

A terminal-based, turn-based survival and exploration game developed in Java. The player is dropped into a procedurally generated $20\times20$ matrix facility overrun by prehistoric predators and must rely on strategy, resource management, and combat mechanics to survive.

---

## 📋 Table of Contents
- [About the Project](#-about-the-project)
- [Key Features](#-key-features)
- [OOP Architecture](#-oop-architecture)
- [How to Play](#-how-to-play)
- [Installation & Execution](#-installation--execution)
- [Author](#-author)

---

## 📖 About the Project

This project was developed to solidify core concepts of **Object-Oriented Programming (OOP)**. It translates complex systems like grid-based movement, artificial intelligence, and field-of-vision mathematics into a playable Command Line Interface (CLI) experience without relying on external game engines.

---

## 🚀 Key Features

* **Procedural Map Generation:** Walls, items (crates/weapons), and dinosaurs are randomly populated across the grid on every new game.
* **Dynamic Fog of War:** A custom raycasting algorithm that calculates Line of Sight (LoS). Entities hidden behind walls or outside the player's direct horizontal/vertical vision remain obscured.
* **Enemy Artificial Intelligence:** Predators act autonomously during their turn. 
  * *Velociraptors* move twice as fast as the player.
  * The *T-Rex* spawns in the opposite quadrant and requires specific equipment to be defeated.
* **Turn-Based Combat System:** Mathematical encounter resolution involving dice-roll mechanics, critical hits, dodge rates, and weapon damage modifiers.
* **Developer Debug Mode:** A built-in command to instantly reveal the entire matrix for testing purposes.

---

## 🧠 OOP Architecture

This project strictly adheres to Java OOP principles:

| Concept | Application in Project |
| :--- | :--- |
| **Encapsulation** | All entity stats (health, coordinates, inventory) are strictly protected and modified only via controlled getters/setters. |
| **Inheritance** | A robust class hierarchy where specific creatures (e.g., `Velociraptor`, `TiranossauroRex`) extend the abstract superclass `Dinossauro`. |
| **Polymorphism** | The game loop handles movement and combat generically, but specific behavior and damage calculations are resolved at runtime using the `instanceof` operator. |
| **Composition** | The `Mapa` is built upon a 2D array of `Celula` objects, which in turn aggregate items, characters, and environmental states. |

---

## 🎮 How to Play

### Controls
* `W` - Move Up
* `S` - Move Down
* `A` - Move Left
* `D` - Move Right
* `X` - Toggle Debug Mode (Reveal Map)

### Mechanics
1. **Explore:** Move through the map to uncover the Fog of War.
2. **Scavenge:** Find supply crates to equip weapons (such as the stun baton, the Medkit, and the tranquilizer dart weapons) and restore health.
3. **Survive:** Avoid or fight dinosaurs. Engaging a dinosaur triggers a dice-roll combat phase where your equipped items matter.

---

## ⚙️ Installation & Execution

### Prerequisites
* **Java Development Kit (JDK):** Version 8 or higher.

### Step-by-Step
1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/PatrickAssarian/TRABALHO.git
1. Navigate to the project folder:
   ```bash
   cd [INSERT-FOLDER-NAME-HERE]
2. Compile the Java files:
   ```bash
   javac Main.java
3. Run the main class to start the game:
   ```bash
   java Main.java
## 👨‍💻 Author
* Patrick Assarian da Luz
* Undergraduate Student in Computer Engineering (5th Semester)
* Federal University of Pelotas (UFPel)
