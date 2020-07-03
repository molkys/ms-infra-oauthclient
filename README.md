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