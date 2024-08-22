## Propósito do trabalho

Para facilitar a gestão diária dos proprietários de kitnets, desenvolvemos uma aplicação que simplifica a administração desses empreendimentos. O sistema oferece um módulo de gerenciamento de cadastros, permitindo o cadastro, edição e remoção de contratos, além de um módulo específico para a gestão de kitnets, com funcionalidades para cadastrar, editar e remover imóveis. Além disso, o sistema inclui um módulo de autenticação de usuários, possibilitando o cadastro e login de maneira segura.

## Participantes

Nathalia Azevedo de Melo

Luiz Gustavo da Silva

Erick Marques Oliveira Azevedo

## Organização do projeto com o respectivo diagrama de classes

Para este projeto, adotamos a arquitetura MVC, dividindo o trabalho em três módulos principais: Módulo de Autenticação, Módulo de Kitnets e Módulo de Contratos. Cada módulo possui um controller dedicado, responsável por intermediar a comunicação entre as interfaces de usuário e a lógica de negócios.

O Módulo de Kitnets é composto por três telas:

- Tela de Listagem
- Tela de Edição
- Tela de Cadastro

O Módulo de Contratos também possui três telas:

- Tela de Listagem
- Tela de Edição
- Tela de Cadastro

Já o Módulo de Autenticação conta com duas telas:

- Tela de Login
- Tela de Cadastro

## Tecnologias utilizadas

- Java
- Swing
- UUID
- Gradle

## Regras de negócio

Um contrato pode ter uma kitnet associada;


## Instruções de como realizar o build

### No Linux:

Requisitos: Tenha o Gradle e o Java instalados no sistema

- Abra um terminal na pasta raiz do projeto e digite: ./gradlew build

### No Windows: 

Requisitos: Tenha o Gradle e o Java instalados no sistema

- Abra o Powershell na pasta raiz do projeto e digite: gradle build

## Instruções de como executar

### No Linux
- Execute o .jar gerado na pasta /build/libs usando o comando: java -jar SIGILP2-1.0-SNAPSHOT.jar

### No Windows

- Execute o .jar gerado na pasta /build/libs

## Diagrama UML

---
title: Views Package
---
classDiagram
direction BT
class ContractEditPage {
  + setTextFields() void
  - addUIComponents() void
  + editContract() void
}
class ContractRegistrationPage {
  - addUIcomponents() void
  + saveContract() void
  + actionPerformed(ActionEvent) void
}
class ContractsPage {
  - addUIComponents() void
}
class KitnetEditPage {
  + updateKitnet() void
  + searchKitnet() void
  - addUIComponents() void
  + actionPerformed(ActionEvent) void
}
class KitnetRegistrationPage {
  - addUIComponents() void
  + saveKitnet() void
  + actionPerformed(ActionEvent) void
}
class KitnetsPage {
  - addUIComponents() void
  + recoverKitchenettes() List~Kitnet~
  + actionPerformed(ActionEvent) void
  + removeKitnet(UUID) boolean
}
class LoginForm {
  + actionPerformed(ActionEvent) void
  - addUIComponents() void
}
class MyFrame
class RegisterForm {
  + actionPerformed(ActionEvent) void
  - addUIcomponents() void
  - registerNewUser() void
}

ContractEditPage  -->  MyFrame 
ContractRegistrationPage  -->  MyFrame 
ContractsPage  -->  MyFrame 
KitnetEditPage  -->  MyFrame 
KitnetRegistrationPage  -->  MyFrame 
KitnetsPage  -->  MyFrame 
LoginForm  -->  MyFrame 
RegisterForm  -->  MyFrame 
