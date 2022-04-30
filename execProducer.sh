#!/bin/bash
export AWS_ACCESS_KEY=""
export AWS_SECRET_KEY=""
export QUEUE_NAME=""
export AWS_ACCOUNT_ID=""

mvn exec:java -Dexec.mainClass="br.com.geraldo.Producer" -X
