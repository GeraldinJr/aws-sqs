package br.com.geraldo;

import br.com.geraldo.services.SqsService;

/**
 * Hello world!
 *
 */
public class Consumer
{
    public static void main( String[] args )
    {
        while(true) {
            SqsService.lerMensagens();
        }
    }
}
