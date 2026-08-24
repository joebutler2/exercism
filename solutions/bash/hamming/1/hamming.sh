#!/usr/bin/env bash

main () {
    if [[ ${#@} -lt 2 ]]; then
        echo "Usage: hamming.sh <string1> <string2>"
        exit 1
    fi
    local strandA="$1"
    local strandB="$2"
    local length=${#strandA}
    local lengthB=${#strandB}
    if [[ length -ne lengthB ]]; then
        echo "strands must be of equal length"
        exit 1
    fi
    
    local delta=0
    for ((i = 0 ; i < $length ; i++)); do
        if [[ ${strandB:$i:1} != ${strandA:$i:1} ]]; then
            ((delta++))
        fi
    done
    echo "$delta"
}

main "$@"
