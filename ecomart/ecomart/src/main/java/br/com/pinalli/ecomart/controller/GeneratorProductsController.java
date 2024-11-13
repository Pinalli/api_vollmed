package br.com.pinalli.ecomart.controller;


import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;



@RestController
@RequestMapping("gerador")
public class GeneratorProductsController {

    private final ChatClient chatClient;
    private static final Logger logger = LoggerFactory.getLogger(GeneratorProductsController.class);


    public GeneratorProductsController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String generateProducts() {
        try {
            var ask = "Gere 5 produtos ecológicos";
            logger.info("Iniciando geração de produtos com prompt: {}", ask);

            String response = this.chatClient.prompt()
                    .user(ask)
                    .call()
                    .content();

            logger.info("Resposta gerada com sucesso");
            return response;
        } catch (Exception e) {
            logger.error("Erro ao gerar produtos: ", e);
            throw e;
        }
    }
}

