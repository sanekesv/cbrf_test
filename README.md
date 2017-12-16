# cbrf_test

тестовое задание для центрального банка</br>
выполнил Ермолаев Александр</br>
</br>
## Перед запуском:</br>
<li>создайте базу данных в Postgres</li>
<li>замените url для подключения к базе в pom.xml</li>

````
<database.url>jdbc:postgresql://localhost:5432/bnk</database.url>
<database.username>postgres</database.username></br>
<database.password>postgres</database.password></br>
````

<li>замените путь до проекта в pom.xml</li>

````
<dbf.full.path>/Users/sanekesv/IdeaProjects/</dbf.full.path>
````

## Сборка и установка
<li>в папке проекта выполните</li>

````
mvn clean package install
````

#### для запуска через mvn
<li>перейдите в папку application и выполните команду </li>

````
mvn spring-boot:run
````

#### для запуска через tomcat 
<li>скопируйте application/target/ROOT.war в tomcat/webapps</li>
<li>запустите томкат (tomcat/bin/startup.sh)</li>
