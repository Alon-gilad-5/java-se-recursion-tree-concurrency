# Java Software Engineering Homework 4: Trees, Recursion, and Concurrency

## 🎯 Project Overview
This assignment, developed for the Technion's Software Engineering course, focuses on implementing advanced algorithms under specific constraints and building a fundamental synchronization primitive from scratch.

### Part A: Recursion and Binary Trees 
Implements complex algorithms on binary trees:
* **Path Existence (`PathFromRoot`):** A strictly **recursive** function designed to check if a given string exists as a path starting from the root node. The implementation adheres to constraints forbidding loops, helper methods, and additional static variables.
* **Level Analysis (`LevelMostOccurrences`):** A function that uses a **Level-Order Traversal** (Breadth-First Search) to find the tree level that contains the highest number of occurrences of a specific integer.

### Part B: Concurrency and Custom Locks
Implementation of a custom, fully functional thread synchronization mechanism:
* **Reentrant Lock (`MyReentrantLock`):** Implements the `Lock` and `AutoCloseable` interfaces to create a **reentrant**, thread-safe lock.
* **Constraint-Driven Implementation:** The lock is implemented **without using the `synchronized` keyword** (and thus no `wait`/`notify`), relying instead on low-level primitives like `AtomicBoolean` and careful use of the `Thread` class to minimize **Busy Waiting**.

## 🛠 Technology & Design
* **Language:** Java
* **Core Concepts:** Recursion, Binary Tree Traversal, Concurrency, **Reentrancy**, Atomic Operations, and Custom Exceptions (`IllegalReleaseAttempt` inherits from `IllegalMonitorStateException`).

## 📂 Project Structure
The code is structured using the default Java package, with all source files located directly under the `src` directory, and the documentation folder included as required by the assignment:


---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 9.0.4 or higher.

### Running the Tests
The `Main.java` class contains comprehensive test methods for both Part A (Tree operations) and Part B (Concurrency/Lock behavior).

1.  **Compile the files** from the project root directory:
    ```bash
    javac src/*.java
    ```
2.  **Run the Main class** from the project root directory:
    ```bash
    java Main
    ```
    *(The concurrency test section is configured to timeout after 5 seconds to prevent hung threads.)*
