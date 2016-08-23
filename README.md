# mapinteraction
Question 3:
Create a simple application , integrate google maps, fetch latitude/longitude of places in Pune of your
choice from the database(Create one!) and use markers to display those places in the map.

For solving this question here export two project file
1 MapIntegration which for android project.
2 MapDatabase which for database project.

for andoid project using android studio you easily download project and run that on android studio.
requirement for setup:
compileSdkVersion 23
buildToolsVersion "23.0.3"
minSdkVersion 15
targetSdkVersion 23
play-services:9.0.1


for database project using eclipse and database mysql workbench.
add class-build libarary
1 json-simple-1.1.1.jar
2 mysql-connector-java-5.1.39-bin.jar

jdbc:mysql://localhost:3306/testdb", "root", "root"

for database creation:
create table map(latitude Text, longtitude Text, place Text);
insert into map(latitude, longtitude, place) values("18.519553","73.855381,"Biniwale Wada");
insert into map(latitude, longtitude, place) values("18.520430","73.856744","Sardar Mujumdar Marg");
insert into map(latitude, longtitude, place) values("18.522581","73.862722","Somwar Peth");

On this project .sql file is not add because i am not able find out .sql file on ubuntu manchine.

Application is properly working which is retrive value from database and show on the map.


