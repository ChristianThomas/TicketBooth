#!/bin/bash
CLASSPATH=bin
# SCRIPTPATH is the absolute filepath of the directory containing this script
SCRIPT=$(readlink -f $0)
SCRIPTPATH=`dirname $SCRIPT`

(
	cd $SCRIPTPATH
	if [ $# -eq 2 ]; then
		java -classpath "$SCRIPTPATH/$CLASSPATH" frontend.Main "$1" "$2"
	else
		java -classpath "$SCRIPTPATH/$CLASSPATH" frontend.Main
	fi
)
