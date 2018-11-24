#!/bin/bash

MVN_DEPENDENCY=~/IdeaProjects/thrift/target/classes:/Users/sycheng/.m2/repository/org/apache/thrift/libthrift/0.11.0/libthrift-0.11.0.jar:/Users/sycheng/.m2/repository/org/slf4j/slf4j-api/1.7.12/slf4j-api-1.7.12.jar:/Users/sycheng/.m2/repository/org/apache/httpcomponents/httpclient/4.4.1/httpclient-4.4.1.jar:/Users/sycheng/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/Users/sycheng/.m2/repository/commons-codec/commons-codec/1.9/commons-codec-1.9.jar:/Users/sycheng/.m2/repository/org/apache/httpcomponents/httpcore/4.4.1/httpcore-4.4.1.jar

INPUT_PATH=/Users/sycheng/IdeaProjects/thrift/scripts/input/

for i in {1..5}
do
    java -cp $MVN_DEPENDENCY server.JavaServer $i 1000 $INPUT_PATH &
done
