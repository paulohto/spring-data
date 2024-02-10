# Estudo: Spring Cloud V1

Esse é um material de exemplo da usabilidade e praticidade do SpringCloud e alguns de seus módulos na implementação de microserviços.

* Spring Cloud Function
* Spring Cloud OpenFeign
* Spring Cloud Gateway

Aqui foi aplicado no exemplo de uma loja com 2 microserviços: Estoque e Pedidos.
Sendo os pedidos consumindo itens que estão no microserviço estoque.
<p>
Sendo essa conversa realizada através do <b>OpenFeign</b>.
O consumo automático do estoque foi facilitado através do <b>Spring Cloud Function</b>. Sendo fundamental para redução do código.
<p>
E ao final foi utilizado o recurso do <b>Spring Cloud Gateway</b> para a proteção das portas dos serviços. 
Centralizando a visualização em uma porta única e protegendo da porta api. Impedindo a entrada através de porta pública.

### application.properties de cada microserviço
````
# estoque
server.port=8081
spring.cloud.function.web.path=/api

# pedidos
server.port=8082

# gateway
server.port=8080
````
## dependências no pom.xml
### Spring Cloud Function
````aidl
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-function-web</artifactId>
	<version>4.1.0</version>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
````
### Spring Cloud OpenFeign
````aidl
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-openfeign</artifactId>
	<version>4.1.0</version>
</dependency>
````
### Spring Cloud Gateway
````aidl
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
````

## MS: Estoque
``GET: http://localhost:8081/get-all``
<p> retorno esperado

````aidl
[
    {
        "id": 1,
        "nome": "Tomates",
        "quantidade": 10000
    },
    {
        "id": 2,
        "nome": "Abacaxi",
        "quantidade": 10
    }
]
````

### api Consumer
``POST: http://localhost:8081/api/consumer-remova-estoque``
<P> retorno esperado
````aidl
{
    "idProduto": 1,
    "quantidade": 10
}
````

## MS: Pedidos
``GET: http://localhost:8082/get-all``
<p> retorno esperado

````aidl
[
    {
        "id": "655667af-3075-4adb-882e-d4d8c5fa65c6",
        "idCliente": "8191e5d9-cdfb-4381-a71d-200241d2d3d3",
        "itens": [
            {
                "id": 1,
                "idProduct": 1,
                "quantidade": 10
            }
        ]
    },
    {
        "id": "ea1226a1-ec78-4625-95de-62b1adef7709",
        "idCliente": "f5cb551a-7ee4-4d87-ab8d-c3204557975b",
        "itens": [
            {
                "id": 1,
                "idProduct": 1,
                "quantidade": 10
            }
        ]
    }, ...
````

## Gateway
``GET: http://localhost:8080/pedidos/get-all``
<br/>
``GET: http://localhost:8080/estoque/get-all``
<p> retorno esperado: Como anteriores mas na porta pública.

#### Tentando acessar a api de forma pública.
``GET: http://localhost:8080/estoque/api/consumer-remova-estoque``

````aidl
{
    "timestamp": "2024-02-10T22:11:46.979+00:00",
    "path": "/estoque/api/consumer-remova-estoque",
    "status": 404,
    "error": "Not Found",
    "requestId": "ae27fb33-3"
}
````
