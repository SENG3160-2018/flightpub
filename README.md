# Flight Pub

## Important

This project is too large to submit via Turnitin, so to review and download repository please visit [https://github.com/SENG3160-2018/flightpub](https://github.com/SENG3160-2018/flightpub)

This package is running Struts2 based on Java.

Hibernate ORM is used.

A simple web service is required for deployment so Tomcat has been chosen, however the app can be deployed to any Java based web container.

Webpack and Node.js resources are used for frontend tools.

### Install

Unpackage all files to a folder.

Install all dependancies via Maven.

Install all npm modules and compile
`npm install`
`npm run production`

Update database configuration details (MySQL user and password) in `src/main/resources/META-INF/persistence.xml`

Compile project and deploy package to Tomcat.

* Note: this is an intelliJ project, opening in intelliJ will allow near automatic dependency and deployment management.

### Usage

Once deployed, open [http://localhost:8080](http://localhost:8080) in a browser - this is will show the homepage.


### Authors

Ben Sutter

Nathan Ebba

Joel Paxton
