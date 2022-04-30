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

## AWS — Diferença entre SQS e SNS

#### SNS (Simple Notification Service)

SNS é um serviço baseado eum publish-subscribe, basicamente funciona com envios rápidos de notificações individuais ou em massa para um grande número de destinatários. Por ser extremamento flexível, torna muito fácil e econômico o envio de notificações para diversos dispositivos de diferentes plataformas, suportando e-mail, sms, http, SQS, entre outros.


#### SQS (Simple Queue Services)

SQS é um serviço baseado no enfileiramento de mensagens, totalmente gerenciável, que permite o desacoplamento de microsserviços, aplicações e sistemas distribuídos. No SQS os receptores das mensagens precisam buscá-las nas filas para que possam ler as mesmas, mensagens estas que podes ser armazenadas por um curto período de tempo (ajustável).

Além disso, a mensagem não pode ser recebida por vários receptores ao mesmo tempo, pois uma vez que um receptor recebe uma determinada mensagem, ela passa para outro estado e fica indisponível para leitura de outros receptores. Desse modo, ao receber uma mensagem, o receptor pode processar e excluir ou permitir que a mensagem volte para a fila após um tempo definido pela política da fila.

#### SNS x SQS



| SNS | SQS |
| -------- | -------- |
| Assinatura de tópico (Pub/Sub)     | Fila     |
| Envia mensagens para os consumidores     | Os consumidores pesquisam as mensagens na fila     |
| Sem persistência. O consumidor que estiver disponível no momento da chegada da mensagem a recebe e a mensagem é excluída. Se nenhum consumidor estiver disponível, a mensagem será perdida.     | As mensagens são persistidas por algum tempo se nenhum consumidor estiver disponível.     |
| Não garante a entrega     | Garante a entrega     |


