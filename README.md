# OAuth2 Client (ms-infra-oauthclient)

# Overview
 OAuth2 Client, Spring Boot based application, which intends to act as a web client in a secure environment protected through OAuth2 protocol. 

The workflow in which this application will be involved is deceived below:

 * a. Perform connectivity with the OAuth Server,
 * b. Identify itself to the OAuth Server and obtain its credentials translated as OAuth2 security token,
 * c. Using the token obtained from (b), invoke a resource that is allowed to invoke from Resources service,
 * d. Display into the screen the response retrieved by the Resource service.

# Flowchart
<img src="/docs/images/OAuth2_Example.jpg" alt="Flowchart" width="750"/>

# Technical spec
* Java 8
* Spring Boot 2.1.5.RELEASE
* Cloud version: Greenwich.SR1

`Note`: see pom.xml files for additional libraries required when running under Java 11

# Pre-Requisites
Make sure you already have running the following applications in your local environment:

* [Resources service](https://github.com/molkys/ms-infra-oauthresources)
* [OAuth2 Server](https://github.com/molkys/ms-infra-oauthserver)

# Starting up application
#### 1. Import the Java code into your IDE (this tutorial uses STS as IDE)
#### 2. Create a ```run configuration``` and run the application using ```localhost```as  profile.

<img src="/docs/images/startup_01.png" alt="Flowchart" width="450"/>

<img src="/docs/images/startup_02.png" alt="Flowchart" width="450"/>

#### 3. Once the application is up and running, open a Web browser window and type ```http://localhost:8888/greeting```

<img src="/docs/images/startup_03.png" alt="Flowchart" width="500"/>

#### 4. Click ```Get Greeting``` button. If everything is set up correctly you should be able to successfully have been obtained a secure token from the server, consume a resource from Resources service application and see into the page the returned message from the consumed resource:

<img src="/docs/images/startup_04.png" alt="Flowchart" width="500"/>



