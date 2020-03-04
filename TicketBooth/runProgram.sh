#!/bin/bash
CLASSPATH=bin

if [ $# -eq 2 ]; then
	java -classpath "$CLASSPATH" frontend.Main "$1" "$2"
else
	java -classpath "$CLASSPATH" frontend.Main
fi
