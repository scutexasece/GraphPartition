#!/bin/bash

SRC_DIR=~/IdeaProjects/thrift/src/main/java/

rm -rf gen-java
thrift --gen java shared.thrift
thrift --gen java search.thrift

rm -rf $SRC_DIR/search
rm -rf $SRC_DIR/shared
cp -r gen-java/search $SRC_DIR
cp -r gen-java/shared $SRC_DIR

