# pwi
Product&amp;Warehouse&amp;Inventory

Instructions to deploy and execute project:

1) Build this application using following maven command,
mvn clean install -DskipTests

2) Copy pwi.war from pwi/target folder to your web container. In my case i used Tomcat server at following location,
 [Tomcat_Home]\webapps\pwi.war
 
3) Create new MySQL schema and execute schema.sql file on your MySQL database.

4) Update datasourece in servlet-context.xml file,

<beans:bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
		destroy-method="close">
	<beans:property name="driverClassName" value="com.mysql.jdbc.Driver" />
	<beans:property name="url"
		value="jdbc:mysql://localhost:3306/TestDB" />
	<beans:property name="username" value="root" />
	<beans:property name="password" value="str0ng" />
</beans:bean>
  
In my case db name is 'TestDB', username is 'root' and password is 'str0ng'

5) Hit folowing URLs for managing Items and Warehouses,

http://localhost:8080/pwi/item/items

http://localhost:8080/pwi/warehouse/warehouses

6) See screenshots folder for project working snapshots

Note : This project is not yet completed. Development is in progress.






