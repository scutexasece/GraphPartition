#!/bin/bash

for i in `ps -ef|grep JavaServer | cut -d' ' -f4`; do
    kill -9 "$i"
done
