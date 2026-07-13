# SME Walkthrough: REST Services and JSON Serialization

This document addresses the key concepts and walkthrough points for `spring-rest-handson2`.

---

## 1. What happens in the Controller method?
When a request is sent to an endpoint like `/country` or `/countries/in`:
1. The DispatcherServlet receives the incoming HTTP request.
2. It queries HandlerMapping to locate the controller class and method annotated with the matching path mapping (e.g. `@GetMapping("/countries/{code}")`).
3. If parameters like `@PathVariable` are declared, Spring parses the request path variable from the URL and binds it to the method arguments.
4. The controller method executes the business logic (such as loading the bean or invoking the service layer method) and returns a Java object (e.g., `Country`).

---

## 2. How is a Java Bean converted into a JSON response?
Spring Boot Web relies on the **Jackson JSON library** (specifically `MappingJackson2HttpMessageConverter`) registered automatically on the classpath:
1. Because the controller is annotated with `@RestController` (which implicitly applies `@ResponseBody` to all methods), the return value of the method is written directly to the HTTP response body.
2. Spring processes the return type of the controller method. It looks up registered `HttpMessageConverter` instances to find one that can handle the target media type (`application/json`).
3. Jackson processes the returned `Country` Java bean, calls its getter methods (like `getCode()` and `getName()`) via reflection, serializes the property key-value pairs into a JSON string format, and writes it to the output stream.

---

## 3. HTTP Header Analysis in Browser Network Tab & Postman
When calling `http://localhost:8083/countries/in`, the server returns key HTTP headers:

### Typical Response Headers:
- **`Content-Type: application/json`**: Crucial header instructing the browser/client that the payload body represents JSON data.
- **`Transfer-Encoding: chunked`**: Indicates that the response is sent in chunks instead of declaring a fixed `Content-Length`.
- **`Date`**: The timestamp of when the response was processed by the server.
- **`Keep-Alive` / `Connection: keep-alive`**: Reuses the TCP connection for subsequent HTTP requests to optimize speed.
