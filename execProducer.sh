#!/bin/bash
export AWS_ACCESS_KEY="AKIA3AA6LECF75I6ATF6"
export AWS_SECRET_KEY="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"
export QUEUE_NAME="fila-gustavo"
export AWS_ACCOUNT_ID="755977887883"

mvn exec:java -Dexec.mainClass="br.com.geraldo.Producer" -X