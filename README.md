# Bookstore App

## Sobre o Projeto

O **Bookstore App** é uma aplicação simples de cadastro e gerenciamento de livros desenvolvida com **Spring Boot** no back-end e **React + Vite** no front-end.

O projeto foi desenvolvido como parte dos estudos do curso **Spring Data JPA | Curso 2024**, ministrado por Michelli Brito, com o objetivo de praticar conceitos fundamentais de persistência de dados utilizando **Spring Data JPA** e **JPA/Hibernate**, além da construção de uma interface web moderna.

A aplicação permite realizar operações de **CRUD (Create, Read, Update, Delete)** de livros através de uma API REST integrada a uma interface desenvolvida em React.

---

## Tecnologias Utilizadas

### Back-end
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- MySQL / PostgreSQL

### Front-end
- React
- Vite
- JavaScript
- CSS

---

## Conceitos Aplicados

Durante o desenvolvimento do projeto foram aplicados diversos conceitos importantes, como:

- Mapeamento objeto-relacional (ORM) com JPA
- Criação de entidades utilizando anotações:
  - `@Entity`
  - `@Table`
  - `@Id`
  - `@GeneratedValue`
  - `@Column`
- Relacionamentos entre entidades:
  - `@OneToOne`
  - `@OneToMany`
  - `@ManyToOne`
  - `@ManyToMany`
- Operações em cascata com `CascadeType`
- Criação de repositórios utilizando `JpaRepository`
- Métodos de acesso a dados:
  - `save()`
  - `findAll()`
  - `findById()`
  - `deleteById()`
- Gerenciamento de transações com `@Transactional`
- Configuração de **DataSource** no `application.properties`
- Integração com banco de dados **MySQL** ou **PostgreSQL**
- Construção de uma API REST para comunicação com o front-end

---

## Funcionalidades

A aplicação permite:

- Cadastrar livros
- Listar livros cadastrados
- Atualizar informações de livros
- Remover livros do sistema
- Visualizar catálogo de livros no front-end

---

## Interface da Aplicação

### Home

![Home](https://github.com/user-attachments/assets/9d1dbb10-bb42-4d8c-af97-1dd13930a60d)

### Registro de Livros

![Registro](https://github.com/user-attachments/assets/630db6f9-47a7-4b42-85c3-8930f481c8e4)

### Catálogo

![Catalogo](https://github.com/user-attachments/assets/d8c50354-2642-4bb7-b18f-98408bc0713b)

---

## Como Executar o Projeto

### Back-end (Spring Boot)

1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Configure o banco de dados no arquivo:

```
src/main/resources/application.properties
```

3. Execute a aplicação:

```bash
mvn spring-boot:run
```

A API estará disponível em:

```
http://localhost:8080
```

---

### Front-end (React + Vite)

1. Acesse a pasta do front-end

```bash
cd frontend
```

2. Instale as dependências

```bash
npm install
```

3. Inicie o projeto

```bash
npm run dev
```

O front-end estará disponível em:

```
http://localhost:5173
```

---

## Objetivo do Projeto

Este projeto foi desenvolvido com foco em **aprendizado e prática de desenvolvimento full stack**, integrando **Spring Boot** no back-end com **React** no front-end, aplicando boas práticas de arquitetura, persistência de dados e consumo de APIs REST.

---

## Autor

Desenvolvido por **Otavio Caetano**
