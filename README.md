# gestiondecursos

This project has been upgraded to use Java 21 (LTS).

## Local setup

1. Install Java 21 JDK on your system (e.g., Adoptium, Microsoft Temurin, or Azul Zulu).
   - Ensure `JAVA_HOME` is set to your JDK 21 installation directory.
   - Add `%JAVA_HOME%\bin` to your `PATH`.

2. Check Java and Maven versions:

```powershell
java -version
mvn -v
```

Expected output: Java 21 and compatible Maven.

## Build and test

To build the project and run tests locally:

```powershell
mvn -T 1C clean verify
```

If you want to skip tests:

```powershell
mvn -T 1C clean package -DskipTests
```

## What changed
- Project Java version updated to 21 in `pom.xml` (properties and `maven-compiler-plugin`).
- `maven-enforcer-plugin` added to require Java 21 or later.
- Updated plugin versions (`maven-compiler-plugin` to 3.11.0 and `maven-surefire-plugin` to 3.1.2).
- Updated JUnit to 4.13.2.
- Fixed package declarations in test files to `com.gestiondecursos`.

## Notes
- The automatic "generate_upgrade_plan" tool is not available in this environment (requires Copilot Pro/Enterprise). The upgrade was performed manually by updating the project configuration.
- After making sure Java 21 is installed, run a full build and tests; review any warnings or errors and adjust dependencies or code as needed for Java 21.
