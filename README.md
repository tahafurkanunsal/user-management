# Minimal User Management Application 
A basic `User Management` sample application. 

## How to Run
There are two ways of running this application;
1. With [Maven](https://maven.apache.org/index.html).
2. With [Docker](https://www.docker.com/).

### 1.Maven
You can run the application with Maven. Maven bundled in via Maven Wrapper. If you want to run the application 
with Maven then you also need to install MySQL database separately.

##### 1.1 Dependencies
  - JDK 17
  - MySQL Database

##### 1.2 Run the Application
 - Clone the repository
 - Make sure you have JDK-17.
 - Install MySQL Database
 - Go into the project directory and run `./mvnw springboot:run`.

### 2. Docker
There are Dockerfile and Docker Compose files.

##### 2.1 Dependencies
 - [Docker](https://www.docker.com/products/docker-desktop/)

##### 2.2 Run the Application
- Go into project directory and run `docker-compose up`

You need to see logs like below:
```
[+] Running 2/0
 ⠿ Container springboot-mysql-project-2-mysqldb-1  Created                                                                                                                                                                                                0.0s
 ⠿ Container springboot-mysql-project-2-web_app-1  Created                                                                                                                                                                                                0.0s
Attaching to springboot-mysql-project-2-mysqldb-1, springboot-mysql-project-2-web_app-1
springboot-mysql-project-2-mysqldb-1  | 2022-10-15 06:46:09+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.0.31-1.el8 started.
springboot-mysql-project-2-mysqldb-1  | 2022-10-15 06:46:09+00:00 [Note] [Entrypoint]: Switching to dedicated user 'mysql'
springboot-mysql-project-2-mysqldb-1  | 2022-10-15 06:46:09+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.0.31-1.el8 started.
springboot-mysql-project-2-mysqldb-1  | '/var/lib/mysql/mysql.sock' -> '/var/run/mysqld/mysqld.sock'
springboot-mysql-project-2-mysqldb-1  | 2022-10-15T06:46:09.699010Z 0 [Warning] [MY-011068] [Server] The syntax '--skip-host-cache' is deprecated and will be removed in a future release. Please use SET GLOBAL host_cache_size=0 instead.
springboot-mysql-project-2-mysqldb-1  | 2022-10-15T06:46:09.699906Z 0 [System] [MY-010116] [Server] /usr/sbin/mysqld (mysqld 8.0.31) starting as process 1
springboot-mysql-project-2-mysqldb-1  | 2022-10-15T06:46:09.705793Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
springboot-mysql-project-2-mysqldb-1  | 2022-10-15T06:46:09.810421Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
springboot-mysql-project-2-mysqldb-1  | 2022-10-15T06:46:09.962038Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
springboot-mysql-project-2-mysqldb-1  | 2022-10-15T06:46:09.962231Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
springboot-mysql-project-2-mysqldb-1  | 2022-10-15T06:46:09.965389Z 0 [Warning] [MY-011810] [Server] Insecure configuration for --pid-file: Location '/var/run/mysqld' in the path is accessible to all OS users. Consider choosing a different directory.
springboot-mysql-project-2-mysqldb-1  | 2022-10-15T06:46:09.978573Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.31'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.
springboot-mysql-project-2-mysqldb-1  | 2022-10-15T06:46:09.978571Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
springboot-mysql-project-2-web_app-1  |
springboot-mysql-project-2-web_app-1  |   .   ____          _            __ _ _
springboot-mysql-project-2-web_app-1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
springboot-mysql-project-2-web_app-1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
springboot-mysql-project-2-web_app-1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
springboot-mysql-project-2-web_app-1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
springboot-mysql-project-2-web_app-1  |  =========|_|==============|___/=/_/_/_/
springboot-mysql-project-2-web_app-1  |  :: Spring Boot ::                (v2.7.4)
springboot-mysql-project-2-web_app-1  |
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:10.208  INFO 1 --- [           main] t.sandbox.usermanagement.Application     : Starting Application v0.0.1-SNAPSHOT using Java 17.0.4.1 on aa9e3f37905f with PID 1 (/opt/app/usermanagement-0.0.1-SNAPSHOT.jar started by root in /)
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:10.210  INFO 1 --- [           main] t.sandbox.usermanagement.Application     : No active profile set, falling back to 1 default profile: "default"
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:10.678  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:10.712  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 27 ms. Found 1 JPA repository interfaces.
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.137  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.148  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.149  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.65]
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.195  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.195  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 950 ms
springboot-mysql-project-2-web_app-1  | Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.324  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.354  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.6.11.Final
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.447  INFO 1 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.509  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.512  WARN 1 --- [           main] com.zaxxer.hikari.util.DriverDataSource  : Registered driver with driverClassName=com.mysql.jdbc.Driver was not found, trying direct instantiation.
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.652  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:11.662  INFO 1 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL5InnoDBDialect
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:12.002  INFO 1 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:12.006  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:12.191  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:12.422  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
springboot-mysql-project-2-web_app-1  | 2022-10-15 06:46:12.429  INFO 1 --- [           main] t.sandbox.usermanagement.Application     : Started Application in 2.688 seconds (JVM running for 2.985)
```

## About the API
This is a simple User Management REST API. It stores data in a relational database, MySQL.

### Create a Users
```
POST /api/users HTTP/1.1
Host: localhost:6868
Content-Type: application/json
Content-Length: 66

{
"name": "Ahmet",
"lastName":"Cevizyiyengillerden",
"email":"ahmetcevizyiyen@gmail.com"
}
```

### Get a User
```
GET /api/users/4 HTTP/1.1
Host: localhost:6868
```

And the response will be like this
```
{
    "id": 4,
    "name": "Ahmet",
    "lastName": "Cevizyiyengillerden",
    "email": "ahmetcevizyiyen@gmail.com"
}
```

### Delete a User

```
DELETE /api/users/1 HTTP/1.1
Host: localhost:6868
```