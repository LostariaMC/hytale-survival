# HytaleSurvival
Experimental Hytale plugin intended as a foundation for developing mods on Hytale. It is currently used on our Survival server.

## Requirements
This project requires the following to get started:
- Java version `25` or higher
- Maven version `3.9.12` or higher
- HytaleServer dependency

### Install HytaleServer locally

Since Hypixel has not yet published the Hytale server JAR to Maven Central, it must be installed manually in the local Maven repository.

Due to the server JAR embedding internal Maven metadata (parent POM and unresolved properties), an additional manual step is required to make the dependency usable in external projects.

#### Step 1: Install the server JAR into the local Maven repository

```bash
# Windows
mvn install:install-file \
 -Dfile="%APPDATA%\Hytale\install\release\package\game\latest\Server\HytaleServer.jar" \
 -DgroupId=com.hypixel.hytale \
 -DartifactId=Server \
 -Dversion=0.0.0-local \
 -Dpackaging=jar
```

#### Step 2: Replace the generated POM with a minimal one
Edit the following file:
```
%USERPROFILE%\.m2\repository\com\hypixel\hytale\Server\0.0.0-local\Server-0.0.0-local.pom
```

Replace its content with:
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.hypixel.hytale</groupId>
  <artifactId>Server</artifactId>
  <version>0.0.0-local</version>
  <packaging>jar</packaging>

  <name>Hytale Server (local)</name>
</project>
```

This minimal POM prevents Maven from attempting to resolve internal server modules that are not available outside Hypixel’s build environment.

## Getting Started

### Clone the repository
```bash
git clone git@github.com:LostariaMC/hytale-survival.git
cd hytale-survival/
```

### Compilation
```bash
mvn clean package
```
