# CS 61B - Data Structures

[CS 61B - Spring 2021](https://sp21.datastructur.es) from UC Berkeley.

## Table of Contents

- Lectures
- Labs
- Assignments
  - Homework
  - Project
- Resources

## Lectures

Appended with progress ->

- [x] 1. Intro, Hello World Java
- [x] 2. Defining and Using Classes
- [x] 3. Testing (May 17) 
- [x] 4. References, Recursion, and Lists
- [x] 5. SLLists, Nested Classes, Sentinel Nodes (May 19)
- [x] 6. DLLists, Arrays
- [x] 7. ALists, Resizing, vs. SLists (May 20)
- [x] 8. Inheritance, Implements (May 22)
- [x] 9. Extends, Casting, Higher Order Functions
- [x] 10. Subtype Polymorphism vs. HoFs
- [x] 11. Exceptions, Iterators, Object Methods (May 25)
- [x] 12. Command Line Programming, Git, Project 2 Preview
- [x] 13. Asymptotics I (May 31)
- [x] 14. Disjoint Sets
- [x] 15. Asymptotics II
- [x] 16. ADTs, Sets, Maps, BSTs (Jun 11)

## Labs

Appended with progress ->

- [x] Lab 1. Setting Up Your Computer & IntelliJ Setup
- [x] Lab 2. JUnit Tests and Debugging (May 19)
- [x] Lab 3. Timing Tests and Randomized Comparison Tests (May 20)
- [ ] Lab 4&5. Peer Code Review and Git (Ignored)
- [x] Lab 6. Getting Started on Project 2 (Jun 11)

## Homeworks

Appended with progress ->

- [x] HW0: Basic Java Programs

## Projects

Appended with progress ->

- [x] Project 0: [2048 Clone](./skeleton-sp21/proj0)

   ![2048 Clone Demo](https://media.giphy.com/media/QmqjrNWBvFXiWwvkBv/giphy.gif)

- [x] Project 1: Data Structures (May 25)
  - Implementation of `Deque` Interface using 1. Linked List, `LinkedListDeque`, and using 2. Array, `ArrayDeque`.
    - The core of `LinkedListDeque` is by using a doubly-linked list with a circular sentinel topology
    - The core of `ArrayDeque` is by using ["Circular ArrayDeque"](https://docs.google.com/presentation/d/1XBJOht0xWz1tEvLuvOL4lOIaY0NSfArXAvqgkrx0zpc/edit#slide=id.g1094ff4355_0_101)
    - Both extend `Iterable<T>` so that they are iterable
    - Comprehensive autograder tests using Junit
  - Implement the [Karplus-Strong algorithm](https://en.wikipedia.org/wiki/Karplus–Strong_string_synthesis) to synthesize a guitar string sound using the `Deque` interface we previously built

## Resources

- [Course Homepage]()(https://sp21.datastructur.es)
- [Skeleton code for homework and projects](https://github.com/Berkeley-CS61B/skeleton-sp21.git)
