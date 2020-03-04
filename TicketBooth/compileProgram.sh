#!/bin/bash
CLASSPATH=bin

if [ ! -d "$CLASSPATH" ]; then
	echo "$CLASSPATH does not exist! Creating output directory"
	mkdir "$CLASSPATH"
fi

javac -d "$CLASSPATH/" src/frontend/*.java
if [ $? -eq 0 ]; then
	echo "Compile successful."
fi
