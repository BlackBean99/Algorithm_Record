# GEMINI Code Companion: Algorithm Problem Solving Repository

This document provides an overview of the Algorithm_Record project, its structure, and how to effectively use this repository.

## Project Overview

This repository is a personal collection of solutions to algorithm and data structure problems from various online judges and programming books. The primary purpose of this repository is to serve as a reference and a log of solved problems.

The solutions are implemented in several programming languages:

*   **C++:** Used for solving problems on platforms like Baekjoon Online Judge (BOJ).
*   **Java:** Used for solving problems on platforms like BOJ and Programmers.
*   **Kotlin:** Used for solving problems on Programmers and other platforms.
*   **Python:** Used for solving problems from various sources, including the book "This is Coding Test."

The problems are sourced from:

*   Baekjoon Online Judge (BOJ)
*   Programmers
*   "Cracking the Coding Interview" book
*   "This is Coding Test" book
*   Various corporate coding tests

## Directory Structure

The repository is organized by programming language and platform:

*   `BOJ_cpp/`: C++ solutions for Baekjoon Online Judge problems.
*   `BOJ_java/`: Java solutions for Baekjoon Online Judge problems.
*   `BOJ_kotlin/`: Kotlin solutions for Baekjoon Online Judge problems.
*   `programmers_cpp/`: C++ solutions for Programmers problems.
*   `programmers_java/`: Java solutions for Programmers problems.
*   `programmers_kotlin/`: Kotlin solutions for Programmers problems.
*   `python_solve/`: Python solutions, categorized by algorithm type.

Within each language-specific directory, solutions are often further categorized by algorithm type (e.g., `bfs`, `dfs`, `dp`) or by problem number.

## Development Conventions

*   **Java Naming Convention:** Java files for BOJ problems follow the convention `Main_<problem_number>.java`. For other problems, the class name is typically `Main`.
*   **File-per-Problem:** Each file in this repository represents a solution to a single problem.

## Building and Running

Since this is a collection of individual files, there is no central build system. You can compile and run each solution independently.

### C++

To compile and run a C++ file (e.g., `12865.cpp`):

```bash
g++ 12865.cpp -o 12865
./12865
```

### Java

To compile and run a Java file (e.g., `Main.java`):

```bash
javac Main.java
java Main
```

*Note: For Java files in packages, you need to compile and run them from the correct directory. For example, for a file in the package `org.algorithm.BFS`, you should be in the `java` directory and use the full class name:*

```bash
javac org/algorithm/BFS/Main.java
java org.algorithm.BFS.Main
```

### Python

To run a Python file (e.g., `미로탈출.py`):

```bash
python 미로탈출.py
```
