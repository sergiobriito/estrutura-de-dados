# Controle de Contatos

GRUPO 1

* Fabrício Martins
* Gustavo Fonseca de Oliveira
* Gustavo Junio
* Henrique Willer
* Sérgio Brito

## Descrição

Este projeto consiste em um sistema de **gerenciamento de contatos** desenvolvido em Java, com uma interface gráfica simples utilizando **Swing**. Ele permite ao usuário adicionar, remover, buscar, e listar contatos por nome ou telefone. O projeto utiliza estruturas de dados eficientes e persistência de informações em um arquivo txt.

A aplicação é composta por duas partes principais:
- **ControleContatos**: Lida com a lógica de manipulação de contatos e sua persistência em arquivo.
- **ControleContatosGUI**: Interface gráfica com o usuário (GUI) para facilitar a interação.

## Motivação das Escolhas

### 1. **TreeMap**
- O uso da classe `TreeMap` garante que os contatos sejam **armazenados em ordem**, tanto por nome quanto por telefone, facilitando a busca e ordenação. Além disso, `TreeMap` oferece as operações de busca eficientes, mesmo com grandes quantidades de dados.
- **Dois `TreeMap`** são mantidos: um para a relação **nome → telefone** e outro para **telefone → nome**, permitindo buscas rápidas em ambas as direções.

### 2. **HashSet**
Dois HashSet são utilizados para garantir a exclusividade dos nomes e telefones. O uso do HashSet para nomes e telefones permite verificar rapidamente se um nome ou telefone já existe na lista de contatos, evitando duplicidade e aumentando a eficiência nas operações de adição e remoção.

### 3. **Persistência em Arquivo**
- Os contatos são **armazenados em um arquivo de texto** (`contatos.txt`) para garantir que os dados persistam entre execuções da aplicação. 
- As funções de **ler** e **salvar** são implementadas utilizando `BufferedReader` e `BufferedWriter`, garantindo uma operação eficiente com arquivos.

### 4. **Interface Gráfica**
- A interface gráfica foi desenvolvida utilizando **Java Swing**, que fornece componentes de UI nativos e é amplamente utilizado para aplicações desktop Java.
 toque moderno à interface, tornando-a mais atraente e intuitiva.
  
## Funcionalidades

1. **Adicionar Contato**:
   - Insere um novo contato com nome, telefone e e-mail. Se o telefone já estiver cadastrado, o sistema avisa o usuário.
   - Caso o nome já exista, o sistema faz incrementos no nome (`nome_1`, `nome_2`, etc.) para evitar duplicatas.

2. **Remover Contato**:
   - Remove um contato existente da lista através do número de telefone.

3. **Buscar Contato**:
   - Permite buscar por nome ou telefone, retornando o respectivo telefone ou nome associado.

4. **Listar Contatos**:
   - Exibe todos os contatos cadastrados, ordenados lexicograficamente por nome.

## Estrutura do Projeto

- **`ControleContatos.java`**: Lógica de controle dos contatos (manipulação, persistência, e buscas).
- **`ControleContatosGUI.java`**: Interface gráfica da aplicação.
- **`Contato.java`**: Classe modelo que representa um contato com nome, telefone e e-mail.
