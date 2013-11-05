#!/bin/bash

MENU_LANG=en
OPTS=""
OPTS="$OPTS -Dlogback.configurationFile=/tmp/eggs/logback.xml"
#OPTS="$OPTS -Dmenu.lang=hu"
OPTS="$OPTS -cp "'target/classes:target/dependency/*'

java $OPTS com.eggs.App