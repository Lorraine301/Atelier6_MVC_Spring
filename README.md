#  Application Web Spring Boot – Gestion des Absences de l'école maternelle : Les Petits Génies

Cette application web permet de gérer les **étudiants** et leurs **absences** dans une école maternelle, en utilisant **Spring Boot**, **Spring MVC**, **Spring Data JPA**, **Thymeleaf** et **MySQL**.

---

##  Fonctionnalités clés

###  Étudiants
- Ajouter un étudiant  
- Modifier un étudiant  
- Supprimer un étudiant  
- Afficher la liste des étudiants  

###  Absences
- Enregistrer une absence  
- Modifier/Supprimer une absence  
- Lister toutes les absences  
- Filtrer les absences par date  

### Tableau de bord
- Nombre total d’étudiants  
- Nombre total d’absences  
- Étudiants les plus absents  
- Graphiques (barres, lignes, camembert)

---

##  Technologies utilisées

- **Java 17**  
- **Spring Boot** (Web, MVC, JPA)  
- **MySQL**  
- **Hibernate**  
- **Thymeleaf**  
- **Maven**  
- **Lombok**

---

##  Installation

### 1️- Cloner le projet
```bash
git clone https://github.com/Lorraine301/Atelier6_MVC_Spring.git
```

### 2️- Créer la base de données MySQL
CREATE DATABASE absence_db;

### 3- Configurer application.properties
```bash
spring.application.name=absenceapp

#Configuration de la base de donnees MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/absence_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

#Configuration Hibernate / JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true

#Configuration du serveur
server.port=8080

#Configuration Thymeleaf
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.cache=false

#Debogage Spring MVC et erreur
logging.level.org.hibernate.SQL=debug
logging.level.org.hibernate.type.descriptor.sql=trace

```
### 4️- Lancer l’application (via Tomcat)

Accéder à l’application :
 http://localhost:8080

## Architecture simplifiée du projet
controller/

entity/

repository/

service/

templates/

## Auteur

RAHELIARISOA Andriamasy Lorraine Agnès

Cycle Ingénieur – LSI

Année universitaire 2025–2026
