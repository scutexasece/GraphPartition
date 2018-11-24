#!/bin/bash

for i in `ps -ef|grep JavaServer | awk '{print $2}'`; do
    kill -9 "$i"
done
