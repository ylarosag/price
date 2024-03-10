FROM amazoncorretto:17-al2023-jdk
RUN mkdir -p  /opt/price-adapter-rest
RUN mkdir -p  /opt/price-adapter-rest/config
COPY config/ /opt/price-adapter-rest/config
COPY target/*.jar /opt/price-adapter-rest/
RUN ls -all /opt/price-adapter-rest
WORKDIR /opt/price-adapter-rest