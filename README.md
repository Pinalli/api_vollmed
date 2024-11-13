# RESTful API


<p align ="center">
  <h2>Fluxo de uma Requisição de uma API REST com Filter e Controller</h2>
</p>

<p align="center">
  <img src="https://github.com/Pinalli/med.voll.api/assets/18580532/97c13fe3-2276-4fd6-8c5d-f17fb4792dfb" alt="fluxo rest" />
</p>

1. **Cliente (Browser ou Aplicação)**:
    - O cliente (usuário ou aplicação) inicia a requisição enviando uma solicitação HTTP para a API REST. Isso pode ser feito por meio de um navegador, aplicativo móvel ou qualquer outra ferramenta que faça chamadas HTTP.
  
2. **Filter (Filtro)**:
    - O **Filter** é um componente intermediário que pode ser configurado para executar antes ou depois do Controller.
    - Ele pode ser usado para realizar tarefas como autenticação, autorização, logging, manipulação de cabeçalhos, entre outros.
    - No fluxo de requisição, o Filter pode ser aplicado antes de chegar ao Controller.
    - Filter é um dos recursos que fazem parte da especificação de Servlets, a qual padroniza o tratamento de requisições e respostas em aplicações Web no Java. Ou seja, tal recurso não é específico do Spring, podendo assim ser utilizado em qualquer aplicação Java.

   - É um recurso muito útil para isolar códigos de infraestrutura da aplicação, como, por exemplo, segurança, logs e auditoria, para que tais códigos não sejam duplicados e misturados aos códigos relacionados às regras de negócio da aplicação.

   - Para criar um Filter, basta criar uma classe e implementar nela a interface Filter (pacote jakarta.servlet)

3. **DispatcherServlet**
    - Centralização do Processamento:
        O DispatcherServlet segue o padrão de projeto front controller.
        Ele atua como um ponto central de entrada para todas as requisições direcionadas à aplicação.
    - Processamento de Requisições:
        Quando uma requisição HTTP chega, o DispatcherServlet a recebe.
        Ele delega o processamento da requisição aos componentes configurados, como controllers, handlers e views.
2.1. HandlerAdapter e Controllers:
    - O DispatcherServlet utiliza HandlerAdapters para encontrar o manipulador (geralmente métodos em classes controladoras) adequado para a URI da requisição.
    - Os controllers contêm a lógica de negócio específica para a operação solicitada (por exemplo, criar, ler, atualizar ou excluir dados).
2.2. Views e Respostas:
    - O DispatcherServlet combina os resultados do manipulador com as views (geralmente JSPs) para gerar um documento HTML.
    - A resposta final é enviada ao cliente (navegador ou aplicativo) como uma resposta HTTP.
Em resumo, o DispatcherServlet é responsável por rotear as requisições, encontrar os manipuladores adequados e gerar as respostas apropriadas. Ele é fundamental para o funcionamento do Spring MVC! 🚀

4. **Handler Interceptors**
    - Os Handler Interceptors são usados para executar ações de pré-processamento e pós-processamento antes e depois da execução dos métodos dos Controllers.
    - Eles permitem adicionar lógica comum a várias requisições, evitando a repetição de código nos Controllers.
5. **Controller**:
    - O **Controller** é responsável por receber a requisição do cliente.
    - Ele mapeia a URL da requisição para um método específico dentro do Controller.

6. **Controller Method (Método do Controller)**:
    - O método do Controller é invocado para processar a requisição.
    - Ele contém a lógica de negócio específica para a operação solicitada (por exemplo, criar, ler, atualizar ou excluir dados).

7. **Serviço (Service)**:
    - O Controller pode delegar parte da lógica de negócio para um **Serviço**.
    - O Serviço é responsável por executar operações mais complexas, como interagir com o banco de dados ou outras APIs.

8. **Repository (Repositório)**:
    - O **Repository** é responsável por acessar o banco de dados ou outra fonte de dados.
    - Ele realiza operações de leitura e gravação nos dados.

9. **Resposta HTTP**:
    - Após processar a requisição, o Controller retorna uma resposta HTTP.
    - A resposta pode incluir um código de status (por exemplo, 200 OK), cabeçalhos (como Content-Type) e um corpo (geralmente em formato JSON).

10. **Cliente Recebe a Resposta**:
    - O cliente (navegador, aplicativo) recebe a resposta HTTP e pode processá-la conforme necessário.

Esse fluxo ilustra como uma requisição é tratada desde o cliente até a resposta final da API REST, passando pelo Controller e possivelmente pelo Filter. 🚀

