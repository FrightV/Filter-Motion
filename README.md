# FilterMotion

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![License](https://img.shields.io/badge/License-MIT-green)

FilterMotion is a **backend API built with Java and Spring Boot** that searches products on Google Shopping and allows filtering results by price.

The goal of this project is to provide a simple tool for **product price monitoring and filtering**, with the possibility of evolving into a full **price alert system** in the future.

---

## 🚀 Features

* Search products by name
* Integration with Google Shopping via SerpAPI
* Filter products by maximum price
* Returns product information such as:

  * Product name
  * Store
  * Price
  * Product URL
  * Image

---

## 🛠 Technologies Used

* Java
* Spring Boot
* Maven
* RestTemplate
* Jackson
* SerpAPI
* Hibernate / JPA

---

## 📦 Running the Project

---

# Requirements

Before running the project, make sure you have installed:

- Java 17+
- Maven
- A SerpAPI account

---

### 1. Clone the repository

```
git clone https://github.com/YOUR-USERNAME/filtermotion.git
```

### 2. Navigate to the project folder

```
cd filtermotion
```

### 3. Configure your SerpAPI key

Add your API key in the code or in the configuration file:

```
private final String API_KEY = "YOUR_API_KEY";
```

### 4. Run the project

```
./mvnw spring-boot:run
```

Or run it directly from your IDE.

---

## 🔎 API Endpoint

### Search products

```
GET /produtos/buscar
```

### Parameters

| Parameter | Type    | Description           |
| --------- | ------- | --------------------- |
| termo     | string  | Product name          |
| precoMax  | decimal | Maximum product price |

### Example request

```
http://localhost:8080/produtos/buscar?termo=your-product-name&precoMax=50
```

---

## 📄 Example Response

```json
[
  {
    "nome": "product name",
    "loja": "store name",
    "preco": price,
    "url": "https://...",
    "imagem": "https://..."
  }
]
```

---

## 🎯 Future Improvements

* Price alert system
* Discord bot notifications
* Result caching
* Product pagination
* Multi-store support

---

## 👨‍💻 Author

Developed by **Victor** as a backend learning project using Spring Boot.
