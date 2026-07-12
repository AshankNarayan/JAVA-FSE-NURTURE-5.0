# Hibernate HQL, JPQL, Native & Criteria Query Analysis

## 1. HQL vs. JPQL Comparison

| Feature | HQL (Hibernate Query Language) | JPQL (Java Persistence Query Language) |
| :--- | :--- | :--- |
| **Origin** | Specific to the Hibernate ORM framework. | Part of the JPA (Java Persistence API) specification standard. |
| **Object-Oriented** | Operates on persistent classes and their attributes. | Operates on JPA Entities and their mapped attributes. |
| **INSERT Support** | Supports `INSERT INTO ... SELECT ...` statements. | Does not support `INSERT` statements (only `SELECT`, `UPDATE`, `DELETE`). |
| **Database Portability** | Relies on Hibernate dialects for translations. | Higher portability as it complies strictly with JPA specifications. |
| **Relationship** | JPQL is a standard subset of HQL. All JPQL queries are valid HQL queries. | Standardized subset. Some Hibernate-specific HQL functions aren't valid JPQL. |

---

## 2. HQL Fetch Keyword
The `FETCH` keyword in HQL/JPQL join queries is used to fetch associated collections or entities in a **single database query** instead of lazy-loading them on access.

### Why use `JOIN FETCH`?
- **Prevents N+1 Select Problem:** In a typical lazy relationship (e.g., `Employee -> SkillList`), accessing the skills of $N$ loaded employees generates $N$ additional SQL select queries. Using `LEFT JOIN FETCH e.skillList` tells Hibernate to construct a single SQL `LEFT OUTER JOIN` and populate the collection immediately.
- **Join vs. Join Fetch:**
  - `join` only links the tables to apply filters or checks in the `WHERE` clause but **does not** populate the associated Java collections or beans.
  - `join fetch` links the tables **and** instructs Hibernate to initialize the mapped Java beans/collections with the query result.

---

## 3. Native Queries vs. HQL
A **Native Query** is a raw SQL query that is passed directly to the database engine without translation by the ORM provider.

- **`nativeQuery = true`**: An attribute of the `@Query` annotation. When set to `true`, the query string is treated as standard SQL native to the underlying database engine rather than HQL.
- **Portability Risk:** Native queries are generally discouraged because they contain database-specific syntax (e.g. Oracle-specific syntax or MySQL-specific string formatting). This breaks database portability. Native queries should only be used when using complex database-specific functions or performance optimizations that cannot be expressed in HQL.

---

## 4. Criteria Query: Need and Benefits

### The Problem with HQL/JPQL
If an application requires dynamic filters (like an e-commerce search page with filters for price range, brand, color, reviews, etc.), building raw HQL query strings dynamically using string concatenation is error-prone, hard to maintain, and vulnerable to SQL/HQL injection attacks.

### The Solution: Criteria API
The Criteria API provides a type-safe, programmatic way to construct queries. 

### Key Components:
1. **`CriteriaBuilder`**: Used to construct criteria queries, compound selections, expressions, and predicates.
2. **`CriteriaQuery`**: Represents the query structure itself (select clauses, order, grouping, where clauses).
3. **`Root`**: Defines the query's starting point (the entity range/from clause).
4. **`TypedQuery`**: Binds the completed Criteria query into a compiled, type-safe execution query.

### Benefits:
- **Programmatic & Dynamic:** Easy to append/omit filters (`Predicates`) conditionally.
- **Type-Safe:** Avoids compile-time syntax errors in query strings by using Java fields/metamodels.
- **Injection Resistant:** Uses parameterized prepared statement variables internally.
