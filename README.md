# AWS-SQS
#### Aplicação em JAVA com um consumer e um producer para fila na AWS SQS

### Criação do projeto:

```
mvn -B archetype:generate -DgroupId=br.com.geraldo -DartifactId=aws-sqs-consumer -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4

```

### Documentação AWS:

[1 - Documentação na AWS](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html)
[2 - GitHub com exemplos](https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/javav2)

### Como executar o projeto:

* exportar variáveis de ambiente no: 1-shellscript 2-.bash_profile 3.bashrc

```
export AWS_ACCESS_KEY="SUA_ACCES_KEY"
export AWS_SECRET_KEY="SUA_SECRET_KEY"
export QUEUE_NAME="NOME_DA_FILA"
export AWS_ACCOUNT_ID="ID_DA_CONTA"
```

* Executar o Consumer

```
./execConsumer.sh
```

* Executar o Producer

```
./execProducer.sh
```
