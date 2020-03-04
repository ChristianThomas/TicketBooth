#!/bin/bash
CLASSPATH=bin

java -classpath "$CLASSPATH" frontend.Main
echo "Program exited with code: $?"
