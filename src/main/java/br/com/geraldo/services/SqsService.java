package br.com.geraldo.services;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.List;

import static br.com.geraldo.awsUtil.UtilMethods.*;

public class SqsService {



    public static void lerMensagens() {
        String fila = System.getenv("QUEUE_NAME");
        String awsAccountId = System.getenv("AWS_ACCOUNT_ID");


        SqsClient sqsClient = SqsClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(credentialsProvider)
                .build();


        GetQueueUrlResponse result = getQueueUrlResponse(fila, awsAccountId, sqsClient);

        List<Message> mensagens = receberMensagens(sqsClient, result.queueUrl());

        for(Message msg : mensagens) {
            System.out.println("Mensagem: " + msg.body());
        }

        deletarMensagens(sqsClient, result.queueUrl(), mensagens);
        sqsClient.close();
    }

    public static void enviarMensagem(String msg) {
        String fila = System.getenv("QUEUE_NAME");
        String awsAccountId = System.getenv("AWS_ACCOUNT_ID");


        SqsClient sqsClient = SqsClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(credentialsProvider)
                .build();


        GetQueueUrlResponse result = getQueueUrlResponse(fila, awsAccountId, sqsClient);

        sendMessage(sqsClient, result.queueUrl(), msg);
    }


}
