# Engineering-Back-end-Internship-Assessment

application.properties:

server.port = 8085


security.oauth2.client.clientID = 758522523635-461rkudhrvpv7ja4incpod8iojetr0mu.apps.googleusercontent.comm
security.oauth2.client.clientSecret =  lBniwwcVpZ8JgV1mBhSJS9sh
security.oauth2.client.accessTokenUri = http://www.googleapis.com/oauth2/v3/token
security.oauth2.client.userAuthprizationUri =  http://acounts.google.com/o/oauth2/auth
security.oauth2.client.tokenName =oauth_token
security.oauth2.client.authenticationScheme = query
security.oauth2.client.clientAuthenticationScheme = form
security.oauth2.client.scope = profile email

security.oauth2.resource.userInfoUri = http://www.googleapis.com/userinfo/v2/me
security.oauth2.resource.preferTokenInfo =  false








login.jsp:

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>

	<h1>Login</h1>
	${SPRING_SECURITY_LAST_EXCEPTION.message}
	<form action="Login" method='POST'>
	
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit"  value="submit" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>







pom.xml

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>io.application</groupId>
  <artifactId>appSpring</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>myApp</name>
  
   <parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>1.4.2.RELEASE</version>
  </parent>
  
  <properties>
		<java.version>1.8</java.version>
	</properties>
  
   <dependencies>
  	<!-- This is a web application -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
		<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-security</artifactId>
	</dependency>

		<!-- Tomcat embedded container-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>

		<!-- JSTL for JSP -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>

		<!-- Need this to compile JSP -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>

		<!-- Need this to compile JSP,
			tomcat-embed-jasper version is not working, no idea why -->
		<dependency>
			<groupId>org.eclipse.jdt.core.compiler</groupId>
			<artifactId>ecj</artifactId>
			<version>4.6.1</version>
			<scope>provided</scope>
		</dependency>

		<!-- Optional, test for static content, bootstrap CSS-->
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>3.3.7</version>
		</dependency>
		
		<dependency>
   		 <groupId>org.springframework.security.oauth</groupId>
    		<artifactId>spring-security-oauth2</artifactId>
		</dependency>
	</dependencies>
	
	<build>
		<plugins>
			<!-- Package as an executable jar/war -->
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
  
</project>



