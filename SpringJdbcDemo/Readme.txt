Spring user library setup
=========================
Download spring framework distribution & create "Spring" user library using spring jars available in lib directory
-> C:\Software Downloads\SpringFramework\Spring Framework 4_3_6\spring-framework-4.3.6.RELEASE-dist\spring-framework-4.3.6.RELEASE\libs


Apache Commons logging
======================
Download commons logging jar from Apache website 
-> C:\Software Downloads\Apache CommonsLogging\commons-logging-1.2-bin\commons-logging-1.2


Derby DB setup
==============
Download Derby from Apache website
Add Derby & Derby client jars to the library (Add external jars)


DBCP & Pooling for Derby DB
===========================
Download commons dbcp and commons pool jars from Apache website
Add both the jars to the library (Add external jars)


Goto Apache Derby bin directory and start the network server
============================================================
C:\Software Downloads\ApacheDerby\Derby 10.13.1.1\db-derby-10.13.1.1-bin\bin>startNetworkServer.bat


Goto Apache Derby bin directory and start the prompt to access DB and run queries
=================================================================================
C:\Software Downloads\ApacheDerby\Derby 10.13.1.1\db-derby-10.13.1.1-bin\bin>ij
ij> create table circle(id integer, name char(50));
ij> select * from circle;
ij> insert into circle values(1, 'First Circle');
ij> select * from circle;
ij> exit;


To use Hibernate, download and add jars from "lib" directory on to user library
===============================================================================
C:\Software Downloads\Hibernate\hibernate-release-5.2.8.Final\lib\required
