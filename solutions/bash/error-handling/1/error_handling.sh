#!/usr/bin/env bash

main () {
    if [[ $# -gt 1 || $# == 0 ]]; then
        echo "Usage: error_handling.sh <person>"
        exit 1
    else
        echo "Hello, $1"
    fi
}

main "$@"
