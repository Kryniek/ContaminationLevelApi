# ContaminationLevelApi
This API provides possibility to examine contamination level in Poland near Wejherowo city.

# Build

Maven package builder: "mvn package"

# Run

Run jar: "java -jar ContaminationLevelApi.jar"

# Configuration

Configuration can be modyfied in "src/main/resources/application.properties".

 - Default port is "6969" stored in property: "server.port"
 - Default data source url is "jdbc:mysql://localhost:3306/contaminationlevel?useSSL=false" stored in property: "spring.datasource.url"
 - Default db username is "root" stored in property: "spring.datasource.username"
 - Default db password is "root" stored in property: "spring.datasource.password"
