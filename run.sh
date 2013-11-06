#!/bin/bash

OPTS="-Dlogback.configurationFile=./src/main/resources/logback-silent.xml"

java $OPTS -cp './target/classes:./target/dependency/*' com.eggs.domain.AnnotatedApp