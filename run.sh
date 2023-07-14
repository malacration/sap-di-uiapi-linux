#!/bin/bash
export DOCKER_IMG="wine-jdk8-32:2018-11-11"
export JAVA_EXE='c:\Program Files\Java\jdk1.8.0_191\bin\java.exe'
export JAR='legacy-app.jar'
export JNA='lib/win32'
export MAIN_CLASS='br.Main'

docker run --rm -v "$PWD:/build" -w /build -it "$DOCKER_IMG" wine "$JAVA_EXE" -cp "$JAR" -Djna.library.path="$JNA" "$MAIN_CLASS"
