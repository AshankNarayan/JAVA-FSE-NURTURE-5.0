# SME Walkthrough: Spring Web Project & XML Configuration

This document answers the core concepts and project structure walkthrough points as part of the hands-on.

---

## Part 1: Project Structure Walkthrough

### 1. Folders
- **`src/main/java`**: The root folder for your Java source files. All packages, service classes, controllers, models, and repositories reside here.
- **`src/main/resources`**: Used to hold non-Java resource files. Typical files include XML configurations (e.g. `country.xml`), application properties (`application.properties` or `application.yml`), and static assets.
- **`src/test/java`**: Contains all unit and integration test source files (e.g. JUnit and Mockito test classes).

### 2. SpringLearnApplication.java
- **`main()` method**: The entry point of a Java application. In a Spring Boot application, it invokes `SpringApplication.run(SpringLearnApplication.class, args)`. This static call bootstraps the application, starts the embedded Tomcat server, initializes the Spring IoC container, and triggers component scanning.

### 3. @SpringBootApplication Annotation
This is a convenience annotation that combines three key annotations:
1. **`@SpringBootConfiguration`**: Specifies that the class is a source of bean definitions.
2. **`@EnableAutoConfiguration`**: Instructs Spring Boot to automatically configure beans based on dependencies present on the classpath (e.g., configuring a data source if an H2 dependency is found).
3. **`@ComponentScan`**: Enables scanning for Spring stereotype annotations (`@Component`, `@Service`, `@Repository`, `@RestController`) starting from the package containing this class.

### 4. pom.xml Configurations
- **`<parent>`**: Declares the Spring Boot Starter Parent, which defines default versions for common dependencies, compiler configurations, and resources plugins.
- **`<dependencies>`**: Includes:
  - `spring-boot-starter-web` for RESTful APIs and servlet configurations.
  - `spring-boot-devtools` for hot reloading.
  - `spring-boot-starter-test` for testing frameworks (JUnit 5, Mockito, AssertJ).
- **`<plugins>`**: Includes `spring-boot-maven-plugin` to package the application as an executable jar/war file.

---

## Part 2: Spring XML Bean Configuration

### 1. XML Tags and Attributes
- **`<bean>`**: Defines a single object definition managed by the Spring IoC container.
  - **`id`**: Unique identifier for the bean instance inside the container context.
  - **`class`**: Fully qualified name of the Java class of the bean.
- **`<property>`**: Injects values into bean properties via setter injection.
  - **`name`**: The name of the property/field (maps to `setCode()` and `setName()` methods in Java).
  - **`value`**: The literal string value injected into the property.

### 2. Context Implementations
- **`ApplicationContext`**: The core interface representing the Spring IoC container. It is responsible for instantiating, configuring, and assembling beans.
- **`ClassPathXmlApplicationContext`**: A concrete implementation of `ApplicationContext` that loads configuration definitions from an XML file located on the classpath (e.g. `src/main/resources`).

### 3. What happens when `context.getBean()` is invoked?
1. The container queries its internal registry of bean definitions for the requested bean id (`country`).
2. If the bean scope is `singleton` (default) and has already been instantiated, Spring returns the cached instance.
3. If the bean is not yet instantiated, the container instantiates the class using reflection, performs dependency injection (sets the properties using setter/constructor injection), registers it in the singleton cache, and returns it.
4. If the type parameter is supplied (e.g. `Country.class`), Spring casts the returned bean instance automatically to avoid manual casting.
