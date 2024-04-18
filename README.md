# APIs-Android-Studio

Projeto realizado para a disciplina de `Programação para Dispositivos Moveis`. Como requerimento do nosso orientador, `Paulo Rogerio da Silva`, este projeto deve utilizar uma API RESTful para o Android Studio.



# API OpenWeatherMap

Este projeto utiliza a API [OpenWeatherMap](https://openweathermap.org/) para obter dados meteorológicos em tempo real. Certifique-se de criar uma conta e ter uma chave de API válida para acessar os recursos. Existe outras funções, mas devo mensionar que, outras funcionalidades, é necessário fazer um pagamento prévio para ter o acesso aos serviços e para receber o Token.   


# Funcionalidades Pagas


1. Previsão do tempo atual e futuro para várias localidades.

2. Dados históricos do tempo.

3. Dados sobre poluição do ar.

4. Índices de qualidade do ar.

5. Dados sobre a qualidade da água.

6. Dados sobre o tempo para satélites e estações meteorológicas.


# Volley

Volley é uma biblioteca de rede rápida e eficiente para Android. Ela facilita a execução de solicitações de rede de forma assíncrona, enquanto gerencia automaticamente a fila de solicitações e o cache de resposta.

## Recursos

- Execução de solicitações de rede de forma assíncrona.
- Gerenciamento automático da fila de solicitações de rede.
- Cache de resposta integrado, com suporte para caching de disco e de memória.
- Suporte para solicitações HTTP GET, POST, PUT, DELETE e HEAD.
- Suporte para solicitações JSON, imagens, strings e arquivos binários.
- Extensível e fácil de personalizar.

## Como usar

### Adicionando Volley ao seu projeto

Para usar Volley em seu projeto Android, adicione a seguinte dependência ao seu arquivo `build.gradle`:

```groovy
dependencies {
    implementation 'com.android.volley:volley:1.2.0'
}

```

# Objetivo

Esse projeto tem o objetivo de o usuário digitar o estado onde deseja verificar a situação da meteorologia, e receber os dados de maneira descritiva. 

Exemplo: Temperatura , Umidade , Velocidade do Vento , Pressão , Sensação , Nebulosidade , Descrição e Clima Atual.

 # Tecnologias Utilizadas

- Java
- Android Studio
- API OpenWeatherMap

# Telas
<img src="https://github.com/DaveBrito/APIs-Android-Studio/raw/main/telainicial.png" width="50%" height="50%">
<img src="https://github.com/DaveBrito/APIs-Android-Studio/raw/main/newyork.png" width="50%" height="50%">
<img src="https://github.com/DaveBrito/APIs-Android-Studio/raw/main/saopaulo.png" width="50%" height="50%">
<img src="https://github.com/DaveBrito/APIs-Android-Studio/raw/main/riogrande.png" width="50%" height="50%">







