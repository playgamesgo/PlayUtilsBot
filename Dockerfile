FROM eclipse-temurin:25.0.2_10-jdk-noble

WORKDIR /app

RUN apt update && apt install -y tesseract-ocr