# POBLESEC TESTING APP

This app is designed & developed by: Joan Francesc Pedro Garcia

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

## Other things

cd C:\Users\jfped\Documents\GitHub\PobleSec-Test-App\bin

compile -> javac --module-path ../lib --add-modules javafx.controls -d . ../src/*.java

execute -> java --enable-preview --module-path ../lib --add-modules javafx.controls View

Error -> https://linuxtut.com/if-you-get-a-quantum-renderer-no-suitable-pipeline-found-error-when-running-the-jar-file-b0514/