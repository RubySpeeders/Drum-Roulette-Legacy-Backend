# Band-Assignment-App-Back-End


## About

This repo contains a RESTful resource server that serves resources back to authenticated users. 

This server is configured to accept requests with JWT tokens and validate JWT tokens provided by a Keycloak authentication server. 

Keycloak is a provider of authentication services. We are using Keycloak to register users, store user data, and login users. When the user logs in to Keycloak, Keyloak returns a JWT token to the user. The user can then add the JWT token to the Headers of any HTTP request sent to the resource server. The server, when configured correctly, will provide access to protected endpoints only to users with a valid JWT token. 

## Setting up Keycloak

At the present, you must run keycloak locally. In production mode, a keycloak server will need to be running in the cloud to allow external users to register and log in. Instructions for establishing and configuring a keycloak server are forthcoming. 

<!-- TODO: Add instructions for establishing and configuring a locally-running Keycloak server" --> 

## Running the server

1. Replace the ${realmName} with the name of your keycloak realm, or include the name of the realm as an environment variable in your runtime configuration
2. Run the application
3. Test the /user endpoint in your terminal: 
  - Log in to Keycloak in your terminal. Replace ${variables} with values 
  ``` curl --request POST 'http://localhost:8080/realms/${realmName}/protocol/openid-connect/token' --header 'Content-Type: application/x-www-form-urlencoded' --data-urlencode 'client_id='${clientId}' --data-urlencode 'username=${userName}' --data-urlencode 'password=${password}' --data-urlencode 'grant_type=password'```
  You should receive back a valid JWT token from the server
  - Make a GET request, replacing ${token} with the access_token you received above:
  ``` curl 'http://localhost:8081/user' --header 'Authorization: Bearer ${token}'```
