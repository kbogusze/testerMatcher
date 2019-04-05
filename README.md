# Tester Matcher
Purpose of this application is to find best mobile tester that fit searching criteria from CSV Database. 
Algorithm take two matching Criteria (Country and Device) and presents a sorted list of results. Application was wroten using JavaFX libraries.

# Use Case 

We would like to find all tester from United State and Japan that have experience with testing on iPhone 4 and 4S.

Country | Device
------------ | -------------
US| iPhone 4
JP | iPhone 4S

Result of search are shown in Table:

![Przechwytywanie](https://user-images.githubusercontent.com/21298169/55623068-33fc4500-57a2-11e9-9778-a502a6abf618.JPG)

# To run application:

1. Clone repository from GIT or download zip with source code
2. Go inside project folder with command line tool or git bash
3. Build application with maven command

```
mvn clean install 
```

4. Move to target folder
```
cd target
```

5. Run application jar with java
```
java -jar testerMatcher-1.0-SNAPSHOT
```


Requirements:

* JRE version 1.8.60+
* Apache Maven version 3.3+

