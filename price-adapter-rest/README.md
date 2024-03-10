# source-template

## Getting started
Para cada tabla que se desee observar el valor del puntero procesado se debe adicionar un registro en la tabla OIC.PROCESS_INTEGRATION

Cada dominio debe tener una biblioteca data-{dominio} y una commons-{dominio}

## Pasos:
Description	Resource	Path	Location
1. TODO TCLOUD STEP 1 CONFIG: Declarar nombre de la integración	
SourceTemplateServiceImpl.java	/source-template/src/main/java/uy/com/gdn/source/domain/service	line 63
2. TODO TCLOUD STEP 2 CONFIG: declaras tablas para las que se observan punteros	
SourceTemplateServiceImpl.java	/source-template/src/main/java/uy/com/gdn/source/domain/service	line 69
3. TODO TCLOUD STEP 3 QUERY: Personalizar para obtener la cantidad de elementos a procesar	
SourceTemplateServiceImpl.java	/source-template/src/main/java/uy/com/gdn/source/domain/service	line 75
4. TODO TCLOUD STEP 4 Verificación: personalizar para agregar código defensivo para verificar los punteros	
SourceTemplateServiceImpl.java	/source-template/src/main/java/uy/com/gdn/source/domain/service	line 88
5. TODO TCLOUD STEP 5 Definición: personalizar o reutilizar lógica de trace ID
SourceTemplateServiceImpl.java	/source-template/src/main/java/uy/com/gdn/source/domain/service	line 104
6. TODO TCLOUD STEP 6 Definición: adicionar los servicios de integraciones, recuerden un servicio por integración
ConsumerEvents.java	/source-template/src/main/java/uy/com/gdn/source/domain/events	line 44
7. TODO TCLOUD STEP 7 Lógica de negocio Adicionar lógica para la obtención de datos
SourceTemplateAsynServiceImpl.java	/source-template/src/main/java/uy/com/gdn/source/domain/service	line 61

## Authors and acknowledgment
Yudiel La Rosa

## License
GPL v3

## Project status
