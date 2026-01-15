# HytaleSurvival
Experimental Hytale plugin intended as a foundation for developing mods on Hytale. It is currently used on our Survival server.

## Requirements
This project requires the following to get started:
- Java version `25` or higher
- Maven version `3.9.12` or higher
- HytaleServer dependency

### Install HytaleServer locally
Since Hypixel has not yet published the Hytale server JAR to Maven Central, it must be installed manually in the local Maven repository.
```bash
# Windows
mvn install:install-file \
  -Dfile="%APPDATA%\Hytale\install\release\package\game\latest\Server\HytaleServer.jar" \
  -DgroupId=com.hypixel.hytale \
  -DartifactId=HytaleServer-parent \
  -Dversion=1.0-SNAPSHOT \
  -Dpackaging=jar
```

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
