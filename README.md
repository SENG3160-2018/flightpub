# Flight Pub - Prototype

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

Compile project and deploy package to Tomcat.

* Note: this is an intelliJ project, opening in intelliJ will allow near automatic dependency and deployment management.

* Note: this project is integrated with Hibernate ORM for DB management.  Although in its current state no DB queries are used, the DB config can be adjusted by editing `src/main/resources/hibernate.cfg.xml`

### Usage

Once deploy, open [http://localhost:8080](http://localhost:8080) in a browser - this is will show the homepage.

The site is navigable, however in its current state their is no active DB or persistance integration.


### Author

Ben Sutter
c3063467