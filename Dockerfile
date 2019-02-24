FROM openjdk:8-jdk-alpine
VOLUME /home/markus/shared/shared/Sudoku
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-cp","app:app/lib/*","org.deepfrequencies.sudoku.Application"]

#ARG JAR_FILE
COPY /target/sudoku-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]/

#start with sudo docker -p 808:8080 <name of image> &
# from windows host its 10.0.0.5, or check ifconfig