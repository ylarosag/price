# PRICE

## Notes

>[!NOTE]
> This is an example of hexagonal architecture components with a domain-driven design.
>This is a standard NOTE block.

>[!TIP]
> It is recommended to add Kafka and to add an event-driven architecture.[^1]

>[!IMPORTANT]
> Additional components will be added to strengthen the [microservices architecture](https://microservices.io/patterns/microservices.html)

>[!CAUTION]
> These components use java 17, we recommend the use of [Openjdk Amazon Corretto](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html).

## Documentation
### Diagrams:

![DDD - HEXAGONAL: Drawing](https://github.com/ylarosag/price/blob/main/doc/000_PRICE_DDD_HEX.png)

![DDD - HEXAGONAL: Component Diagram](https://github.com/ylarosag/price/blob/main/doc/001_CD_DDD_HEX.png)

![DDD - HEXAGONAL: Sequence Diagram](https://github.com/ylarosag/price/blob/main/doc/002_SD_PRICE_GET.png)

![DDD - HEXAGONAL: TABLE OF DB](https://github.com/ylarosag/price/blob/main/doc/004_DB_SELECT.png)

### Version 
[Actuator/info](http://localhost:8080/price-adapter-rest/actuator/info)
```json
{
  "build": {
    "artifact": "price-adapter-rest",
    "name": "price-adapter-rest",
    "time": "2024-03-12T22:33:49.040Z",
    "version": "1.0.0-SNAPSHOT",
    "group": "com.capitole"
  }
}
```

### OpenAPI v3
[Swagger UI](http://localhost:8080/price-adapter-rest/swagger-ui.html)

![swagger](https://github.com/ylarosag/price/blob/main/doc/000_swagger.png)

ISOs[^2]

## Adapters
### Adapter H2
See [Readme](https://github.com/ylarosag/price/blob/main/price-adapter-jpa-h2/README.md)

## Tests
### Postman collection
[JSON](https://github.com/ylarosag/price/blob/main/doc/test/001_price-adapter-rest.postman_collection.json)

## Authors and acknowledgment
Yudiel La Rosa

## License
GPL v3

## Project status
TEST

### References
[^1]: [EDA] (https://aws.amazon.com/es/what-is/eda/)
[^2]: [ISO 4217] (https://www.iso.org/iso-4217-currency-codes.html)

