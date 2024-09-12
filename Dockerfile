# Sử dụng image Maven để build project
FROM maven:3.8.6-openjdk-17 AS build

# Đặt thư mục làm việc trong container
WORKDIR /app

# Copy toàn bộ project vào container
COPY . .

# Build ứng dụng
RUN mvn clean package

# Sử dụng image OpenJDK để chạy ứng dụng
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc
WORKDIR /app

# Copy file .war hoặc .jar từ giai đoạn build
COPY --from=build /app/target/your-app.war /app/your-app.war

# Thiết lập biến môi trường PORT
ENV PORT=8080

# Lệnh chạy ứng dụng, đảm bảo sử dụng cổng từ biến PORT
CMD ["java", "-jar", "/app/your-app.war"]
