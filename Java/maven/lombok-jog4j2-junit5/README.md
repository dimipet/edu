Simple project demonstrating right setup of junit 5, lombok, log4j2 and maven pom.xml.

Add the corresponding `log4j2.xml` file in `/src/main/resources` and `/src/test/resources` .

Levels are `ALL` and `TRACE DEBUG INFO WARN ERROR FATAL` and `OFF.`

Setting `<Root level="ERROR">` means to log `ERROR FATAL`. 

Setting `<Root level="DEBUG">` means to log `DEBUG INFO WARN ERROR FATAL`. 

Setting `<Root level="OFF">` means to log nothing.

Setting `<Root level="ALL">` means to log everything.

Setting `<Root level="OFF">` means to log nothing.

Setting `<Logger name="com.dimipet" level="WARN">` means to log only from `com.dimipet` packages and only `WARN ERROR FATAL`

Take a look at the 2 files, `/src/main/resources` and `/src/test/resources`, for example. 

Use following to see logging from main app and junit 5 tests.

```
mvn clean package
mvn compile exec:java -Dexec.mainClass="com.dimipet.jog4j2junit5.App"
``` 