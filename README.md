# Trabalho Prog Avançada

# NASA Near Earth Object Tracker

[![NASA Logo](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/NASA_logo.svg/220px-NASA_logo.svg.png)](https://www.nasa.gov/)


Este projeto Java fornece uma ferramenta para rastrear e analisar objetos próximos à Terra (NEOs) com base em dados da API da NASA. Ele permite que os usuários:

* Recupere informações sobre Objetos próximos a terra, incluindo nomes, tamanhos, datas de abordagem e perigos potenciais.
* Filtra e classifique por vários critérios.
* Armazene dados NEO em um banco de dados local para acesso offline.
* Exiba informações do NEO em uma interface amigável.

![Tela Principal](/tela_inicial.png)

## Características

* **Busca de dados:** Busca dados NEO da API da NASA usando os endpoints fornecidos.
* **Armazenamento de dados:** Armazena dados NEO e dados de abordagem associados em um banco de dados local (usando MySQL).
* **Filtragem e classificação:** Fornece opções para filtrar e classificar dados NEO por data, distância e outros atributos.
* **Interface do usuário:** Apresenta dados NEO em uma interface gráfica usando componentes Java Swing (tabelas, botões, etc.).
* **Tratamento de erros:** inclui mecanismos de tratamento de erros para gerenciar problemas como problemas de conectividade de rede ou dados inválidos.

## Estutura de pastas
![Tela Principal](/estrutura_pastas.png)

## Uso

1. **Inicie o aplicativo:** Execute o código Java compilado.
2. **Buscar dados:** Clique no botão "Atualizar dados" para buscar os dados NEO mais recentes da NASA (Caso já possua informações no banco de dados elas serão carregadas na tabela).
A API da NASA possuí uma limitação de período de 7 dias.
3. **Explorar dados:** Use a interface para filtrar, classificar e visualizar detalhes do NEO.
