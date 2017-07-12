# E-Commerce 
E-Commerce rest-api made with Spring Boot

Divided in two parts, Core and REST.

Core part is made of entities, exceptions, repositories(for comunnicating with database) and services(provide communication between controllers and repositories).

REST part is an entry point for clients. It is made of controllers, exceptions and resources. Resources are external represantation of entities and provide methods for Entity-Resource conversion.

## Documentation

For the sake of saving space, I will show only 4 URIs with GET,POST,PUT,DELETE Methods.

### Show client
* <b>URL</b> 
  /api/client/{id}
* <b>Method</b> 
  GET
* <b>Url Params</b>
```
id = [integer]
```
* <b>Success response:</b> 
  - Code: 200 OK
  - Content
  ```
  {
    "username": "gentaliti",
    "name": "gent",
    "lastName": "aliti",
    "country": "kosove",
    "city": "prishtine",
    "address": "--",
    "email": "gent@gent.com",
    "role": "ROLE_ADMIN",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/client/1"
            }
        }
    }
  ```
* <b>Error response:</b> 
- Code: 401 Unauthorized
- Content
    ```
    {
        "timestamp": 1499856909468,
        "status": 401,
        "error": "Unauthorized",
        "message": "Client not found",
        "path": "/api/client/1"
    }
    ```
        
- Code: 403 Forbidden
- Content
    ```
    {
        "timestamp": 1499857022629,
        "status": 403,
        "error": "Forbidden",
        "exception": "org.springframework.security.access.AccessDeniedException",
        "message": "Access Denied",
        "path": "/api/client/22"
    }
    ```
    
    
    
    
    
    
### Add product
* <b>URL</b> 
  /api/product
* <b>Method</b> 
  POST
* <b>Url Params</b>
```
producer = [String]
category = [String]
```
* <b>Data Params</b>
```
sentProduct = [ProductResource]
```
* <b>Success response:</b> 
  - Code: 201 CREATED
  - Content
  ```
  {
    "name": "Syza",
    "price": 120,
    "description": "Syza",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/product/7"
        },
        "category": {
            "href": "http://localhost:8080/api/category/kategori2"
        },
        "producer": {
            "href": "http://localhost:8080/api/producer/Nike"
        }
    }
  }
 ``` ``` ``` 
 
 
* <b>Error response:</b> 
- Code: 500 Internal Server Error
- Content
    ```
    {
        "timestamp": 1499857880178,
        "status": 500,
        "error": "Internal Server Error",
        "exception": "com.ecommerce.core.exceptions.CategoryNotFoundException",
        "message": "Category not found",
        "path": "/api/product"
    }
    ```
  
    
    
### Update Category
* <b>URL</b> 
  /api/category/{categoryName}
* <b>Method</b> 
  PUT
* <b>Url Params</b>
```
categoryName = [String]
```

* <b>Data Params</b>
```
sentCategory = [CategoryResource]
```

* <b>Success response:</b> 
  - Code: 200 OK
  - Content
  ```
  {
    "name": "kategori2Updated",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/category/kategori2Updated"
        }
    }
}
  ```
* <b>Error response:</b> 
- Code: 401 Unauthorized
- Content
    ```
    {
        "timestamp": 1499858451800,
        "status": 401,
        "error": "Unauthorized",
        "message": "Bad credentials",
        "path": "/api/category/kategori2333"
    }
    ```
        
- Code: 403 Forbidden
- Content
    ```
    {
        "timestamp": 1499858513440,
        "status": 403,
        "error": "Forbidden",
        "exception": "org.springframework.security.access.AccessDeniedException",
        "message": "Access is denied",
        "path": "/api/category/kategori2"
    }
    ```
    
    
    
