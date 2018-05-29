# ContaminationLevelApi
This API provides possibility to examine contamination level in Poland in selected cities.

# Build

Maven package builder: `mvn package`

# Run

Run jar: `java -jar ContaminationLevelApi.jar`

# Configuration

Configuration can be modyfied in `src/main/resources/application.properties`.

 - Default port is `6969` stored in property: `server.port`
 - Default data source url is `jdbc:mysql://localhost:3306/contaminationlevel?useSSL=false` stored in property: `spring.datasource.url`
 - Default db username is `root` stored in property: `spring.datasource.username`
 - Default db password is `root` stored in property: `spring.datasource.password`
 - Cron task that is resposible for inserting measurements from last 24 hours is configured to work three times a day at 6:00, 14:00 and 22:00 o'clock. Default configuration is stored in property: `cron.scheduler.Measurement.insertForSensorIds`.

# Api

 * `GET:api/measurements` - get all measurements
