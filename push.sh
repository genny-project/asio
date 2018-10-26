#!/bin/bash

if [ -z "${1}" ]; then
   version="latest"
else
   version="${1}"
fi


docker push gennyproject/asio:"${version}"
docker tag  gennyproject/asio:"${version}"  gennyproject/asio:latest
docker push gennyproject/asio:latest

