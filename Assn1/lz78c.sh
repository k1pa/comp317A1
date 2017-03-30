#!/bin/bash
# My first script

cat $1  | java encoder $2 | java decoder > $1.lz78