FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/voxxed-2017-clojure.jar /voxxed-2017-clojure/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/voxxed-2017-clojure/app.jar"]
