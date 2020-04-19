# HealthCare_PAF

      ===================HEALTH CARE====================


=====TOOS USED TO THE PROJECT ======

USED SERVER: apache tomcat 8.5

DATA BASE TOOL: mqsql workbecnh tool

DATABASE SEVER: mysql

TESTING: POSTMAN

INTIGRATION & TESTING: Git hub

(git used => console(git bash) and tool)

IDE: eclipse 2020-03

JDK & JRE VERSION: jdk 1.8 and jre 1.8

JERSEY VERSION: 2.30.1

PROJECT TYPE: maven project


===Branches====


master == Completed error free full project. 


developmain==  In order to make the whole project Error free and follow best Practies use this branch and contain (Gateway, CRUDmain) 


CRUDmain==  in order to merge each member CRUD oparations useed this branch bellow mension the 6 member branches.


IT18119572_User_Chathuranga 	   == Chathuranga W.W.P.K

IT18119718_Doctor_Liyanage  	   == Liyanage D.R.Y

IT18120226_Laboratory_Oshadi 	   == Oshadi Yashodhika G.B.

IT18113914_Hospital_Rashmika       == De Silva L.S.R

IT18114386_Payments_Athalage       == Athalage C.D

IT18115826__Appointment__Ranaweera == Ranaweera W.G.D.U


=====Chathuranga W.W.P.K IT18119572=====

create database userdb;

use userdb;

create table usertable(

fname varchar(20),
Lname varchar(20),
nic varchar(15) primary key not null,
email varchar(50) not null,
username varchar(20) not null,
gender varchar(20),
address varchar(100),
contact varchar(20),
password varchar(20) not null

);


========Liyanage D.R.Y IT18119718========


create database helthcare;

use helthcare;


create table doctortable(

nic varchar(15) primary key not null,
medicalid varchar(15) not null,
fname varchar(20),
Lname varchar(20),
gender varchar(20),
address varchar(100),
contact varchar(20),
email varchar(50) not null,
specialization varchar(100) not null,
Hospital varchar(100),
stimechecking varchar(30) not null,
etimechecking varchar(30) not null,
noofdailyappointment int not null,
username varchar(20) not null,
password varchar(20) not null

);


create table doctor_days(
nic varchar(15) ,
dayofviste varchar(20),
constraint pk1 primary key(nic,dayofviste),
constraint fk1 foreign key(nic) references doctortable(nic)
);


create table doctor_fee(
feeid varchar(10)not null,
nic varchar(15),
fee varchar,
constraint pk1 primary key(nic,feeid),
constraint fk2 foreign key(nic) references doctortable(nic)


);


==== De Silva L.S.R IT18113914======


create database test;

use test;


CREATE TABLE hospital

(
HRegID varchar(11) PRIMARY KEY,
HName varchar(50),
HAddress varchar(70),
HCity varchar(40),
HDestrict varchar(30),
HProvince varchar(40),
HEmail varchar(70),
HContactNum varchar(15),
HUsername varchar(20),
HPassword varchar(20)
);

CREATE TABLE hospitalFee
(
HFeeID varchar(11),
HRegID varchar(11),
Fee varchar(11),

CONSTRAINT Hospital_pk   PRIMARY KEY(HFeeID, HRegID),
CONSTRAINT HospitalFee_fk FOREIGN KEY(HRegID) REFERENCES hospital(HRegID)

)

=====Oshadi Yashodhika G.B. IT18120226====


create database test;

use test;


CREATE TABLE lab

(

labRegID varchar(11) PRIMARY KEY,
labName varchar(50),
labAddress varchar(70),
labCity varchar(40),
labDestrict varchar(30),
labProvince varchar(40),
labEmail varchar(70),
labContactNum varchar(15),
labUsername varchar(15),
labPassword varchar(15),
OpenTime varchar(10),
CloseTime varchar(10)

);

CREATE TABLE testType

(

labRegID varchar(11),
TestName varchar(30),
TestFee varchar(10),


CONSTRAINT TestFee_pk PRIMARY KEY (labRegID,TestName),
CONSTRAINT TestFee_fk FOREIGN KEY(labRegID) REFERENCES lab(labRegID)

);


======Athalage C.D=====

create database paymentdb


create table paymentdetails(

PaymentID int,
Name varchar(50),
CardNo varchar(50),
Cvc int,Exp varchar(10),
AppointmentID int,
Amount float,
PayDate varchar(10),
Email varchar(50)

);


=====Ranaweera W.G.D.U=====


CREATE DATABASE appointmentdb;


CREATE TABLE appointmentdoc(

appDocId int,
specialization varchar(50),
docName varchar(50),
hospital varchar(50),
date varchar(20),
patientNIC varchar(20),
patientName varchar(50),
patientAge int,
patientEmail varchar(50),
patientContact int

);

CREATE TABLE appointmentlab(

appLabId int,
labName varchar(50),
testType varchar(50),
date varchar(30),
patientNIC varchar(20),
patientName varchar(50),
patientAge int,
patientEmail varchar(50),
patientContact int

);


===Dependency====


dependency used in pom xml for jdbc connecter

	     <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.38</version>
		</dependency> 

		<!-- <dependency> <groupId>mysql</groupId> <artifactId>mysql-connector-java</artifactId> 
			<version>5.1.38</version> </dependency> -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.19</version>
		</dependency>

===Dependency=====

 okhttp  and auth in gate way dependency 

		<dependency>
			<groupId>com.squareup.okhttp3</groupId>
			<artifactId>okhttp</artifactId>
			<version>4.2.2</version>
		</dependency>
		<dependency>
			<groupId>com.auth0</groupId>
			<artifactId>java-jwt</artifactId>
			<version>3.10.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.0</version>
		</dependency>

