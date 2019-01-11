# Project Title

This is Zipcode optimization project will be part of Shipping business logic 

## Getting Started

This is Springboot framework based project need following prerequisites 

### Prerequisites

What things you need to install the software and how to install them

```
JAVA 8 
Maven 2
```

### Installing

Here is how to install java 8

```
https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
```

Here is how to install maven 2

```
https://maven.apache.org/install.html
```
## Build and Run

```
mvn spring-boot:run
```

## REST API for Optimize Restricted zipcode 

URL
```
http://localhost:8080/wsgc/shipping/restricted/zipcodes

```

Method 
```
POST

```

Payload
```
{
  "shipping": {
    "restricted_zipcodes": [
      {
        "from": "94133",
        "to": "94133"
      },
      {
        "from": "94200",
        "to": "94299"
      },
      {
        "from": "94226",
        "to": "94399"
      },
      {
        "from": "09424",
        "to": "09427"
      },
      {
        "from": "09423",
        "to": "09427"
      },
      {
        "from": "09412",
        "to": "09427"
      }
    ]
  }
}

```

![alt tag](https://raw.githubusercontent.com/saravananalagarsamy/zipcode/master/HowToRun.jpg "How to run in postman")

## API Doc 

Access swagger here 

```
http://localhost:8080/swagger-ui.html#/shipping-zipcodes

```

## Authors

* **Saravanan Alagarsamy** - *Initial work* - [SaravananAlagarsamy](https://github.com/saravananalagarsamy)
