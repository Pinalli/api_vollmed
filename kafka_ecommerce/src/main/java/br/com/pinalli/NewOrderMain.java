package br.com.pinalli;


import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;


public class NewOrderMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        try (var orderDispatcher = new KafkaDispatcher<Order>()) {
            try (var emailDispatcher = new KafkaDispatcher<String>()) {

                for (var i = 0; i < 10; i++) {

                    var userID = UUID.randomUUID().toString();
                    var orderID = UUID.randomUUID().toString();
                    var amount = new BigDecimal(Math.random() * 5000 + 1); // pelo meno 1 real

                    var order = new Order(userID, orderID, amount);
                    orderDispatcher.send("ECOMMERCE_NEW_ORDER", userID, order);

                    var email = "Thank you for your order! We are processing your order!";
                    emailDispatcher.send("ECOMMERCE_SEND_EMAIL", userID, email); // enviar o registro do email e esperar a confirmação
                }
            }

        }

    }
}