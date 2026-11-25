# Spring MVC Practice Test

A hands-on practice exam for an Enterprise Java Spring MVC assessment. Build the missing parts of an equipment inventory app, then check your work against a working answer key.

## Start here

- [Open the practice exam](practice-exam.html) for setup, five coding tasks, a marking guide, and browser checks.
- [Read the study notes](lessons/0001-spring-mvc-edit-workflow.html) for worked examples of GET and POST handlers, validation, Thymeleaf tables and forms, and JPA updates.
- [Review the quick reference](reference/spring-mvc-edit.html) for common syntax and debugging steps.
- [Open the project overview](index.html) for the full set of materials.

## Run the starter

Open the `starter` folder as a Maven project, or run this from that folder:

```powershell
.\mvnw.cmd spring-boot:run
```

Then open http://localhost:8085/equipment. The project uses an embedded H2 database with three sample records. It runs locally and requires no database setup.

Complete the TODOs in `starter/src/main`. Compare your solution with the code in `answer-key` after trying the practice exam.

## Topics

1. Spring MVC GET and POST handlers with `Model`
2. Jakarta validation and `BindingResult`
3. Thymeleaf collection tables
4. Bound edit forms and field errors
5. Database reads and updates with Spring Data JPA

This is a practice resource based on the course announcement. The scenario, timing, and marks are suggested for practice.
