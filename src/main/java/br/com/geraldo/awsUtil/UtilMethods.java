package br.com.geraldo.awsUtil;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;

public class UtilMethods {
    public static List<Message> receberMensagens(SqsClient sqsClient, String queueUrl) {
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .waitTimeSeconds(20)
                .build();
        return sqsClient.receiveMessage(receiveMessageRequest).messages();
    }

    public static void deletarMensagens(SqsClient sqsClient, String queueUrl, List<Message> messages) {
        for (Message message : messages) {
            DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .receiptHandle(message.receiptHandle())
                    .build();
            sqsClient.deleteMessage(deleteMessageRequest);
        }
    }

    public static GetQueueUrlResponse getQueueUrlResponse(String queueName, String queueOwnerAWSAccountId, SqsClient sqsClient) {
        GetQueueUrlRequest request = GetQueueUrlRequest.builder()
                .queueName(queueName)
                .queueOwnerAWSAccountId(queueOwnerAWSAccountId).build();

        return sqsClient.getQueueUrl(request);
    }

    public static final AwsCredentialsProvider credentialsProvider = new AwsCredentialsProvider() {
        @Override
        public AwsCredentials resolveCredentials() {
            return new AwsCredentials() {
                @Override
                public String accessKeyId() {
                    return System.getenv("AWS_ACCESS_KEY");
                }

                @Override
                public String secretAccessKey() {
                    return System.getenv("AWS_SECRET_KEY");
                }
            };
        }
    };

}
