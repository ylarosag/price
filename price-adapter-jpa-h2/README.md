# price-adapter-jpa-h2

## Getting started

## STEPS:

# Data Source Properties
```
spring:
  datasource:
# h2     
# file
#   url: jdbc:h2:file:/data/demo
# memory
    url: jdbc:h2:mem:price_readonly;DB_CLOSE_ON_EXIT=FALSE
    username: sa
    password: password
    driverClassName: org.h2.Driver
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect    
    defer-datasource-initialization: true
    hibernate:
# validate | update | create | create-drop
      ddl-auto: create
  h2:
    console.enabled: true
    console:
      path: /h2-console
      settings.trace: false
      settings.web-allow-others: false
```

# POM
```
	<dependencies>
		<dependency>
			<groupId>com.capitole</groupId>
			<artifactId>price-adapter-jpa-h2</artifactId>
		</dependency>
	</dependencies>
```

# URL H2
<http://localhost:8080/price-adapter-rest/h2-console>

```
    url: jdbc:h2:mem:mydb
    username: sa
    password: password
```

# MIGRATION
```
mvn clean flyway:migrate -Dflyway.configFiles=flyway.conf
```

# DATA TYPES
<https://www.h2database.com/html/datatypes.html>

## Authors and acknowledgment
Yudiel La Rosa

## License
GPL v3

## Project status
TEST