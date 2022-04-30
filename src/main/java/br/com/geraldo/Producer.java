package br.com.geraldo;

import br.com.geraldo.services.SqsService;

import java.time.LocalDate;
import java.util.Scanner;

public class Producer {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        while (true) {
            SqsService.enviarMensagem(teclado.nextLine() + " - " + LocalDate.now());
        }
    }
}
