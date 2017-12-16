# cbrf_test

тестовое задание для центрального банка</br>
выполнил Ермолаев Александр</br>
</br>
## Перед запуском:</br>
<li>создайте базу данных в Postgres</li>
<li>замените url для подключения к базе в pom.xml</li>

````
&lt;database.url>jdbc:postgresql://localhost:5432/bnk&lt;/database.url>
&lt;database.username>postgres&lt;/database.username></br>
&lt;database.password>postgres&lt;/database.password></br>
````

<li>замените путь до проекта в pom.xml</li>
&lt;dbf.full.path>/Users/sanekesv/IdeaProjects/&lt;/dbf.full.path>

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
