create database ooad_projectt

use ooad_projectt

-------------------------------------------------------------------------------------------------------

CREATE TABLE usertype (
  id INT NOT NULL,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id),
);



INSERT INTO usertype VALUES  (1,'Admin')
INSERT INTO usertype VALUES  (2,'Organizer')
INSERT INTO usertype VALUES  (3,'Captain') 

Create Table Tournament (
 id INT NOT NULL,
 name varchar(50) NOT NULL,
 format_ varchar(50),
 primary key (id) 
);

INSERT INTO Tournament VALUES (1,'Cricket','T-10')
INSERT INTO Tournament VALUES (2,'Football','5 a Side')
INSERT INTO Tournament VALUES (3,'Volleyball','6 a Side')

create table users (

id INT NOT NULL,
name varchar(50),
username varchar(50) unique,
password_ varchar(50),
email varchar(50) unique,
phoneno varchar(50),
primary key (id),

u_type int,
FOREIGN KEY (u_type) REFERENCES usertype (id) on delete cascade

)

insert into users values(16,'mohsin raza','mohsinr123','1234567','mohsin121@gmail.com','0323-1234557',2) 
insert into users values(17,'adnan akmal','adnana123','1234567','adnanq212@gmail.com','0323-1239967',2) 
insert into users values(18,'faizan maqsood','faizanm123','1234567','faizanw3@gmail.com','0323-1238867',2) 
insert into users values(19,'hammad maqsood','hammadm123','1234567','hammadui7@gmail.com','0323-1004567',2) 
insert into users values(20,'ahmad shahid','ahmads123','1234567','ahmadf512@gmail.com','0323-1223567',2)
insert into users values(21,'farwa batool','farwa123','1234567','farwa512@gmail.com','0323-1266587',2) 
insert into users values(22,'zara naveed','zara123','1234567','zaran2@gmail.com','0323-1223567',2)  

    
insert into users values(26,'Admin','admin123','1234567','admin12@gmail.com','0323-1234567',1) 

create TABLE Teams (

  id INT NOT NULL,
  name varchar(50) NOT NULL,
  CaptainID INT Foreign Key references users (id),
  SportType INT Foreign Key references Tournament (id),
  played INT,
  Won INT,
  Lost INT,
  Tied INT,
  Points INT,
  payment INT,
  PRIMARY KEY (id)

);

create table Players (
id int primary key,
name varchar(30),
email varchar(30),
phoneNo varchar(30),
designation varchar(50),
teamId INT foreign key references teams (id) 
);
ALTER TABLE Players ADD FOREIGN KEY (teamid) REFERENCES teams(id) on delete cascade

create table CricketPlayer (
 id int,
 totalruns int,
 totalwickets int,
 matchesplayed int,
 average float,
 primary key (id),
 foreign key (id) references Players(id) 
);
ALTER TABLE CricketPlayer ADD FOREIGN KEY (id) REFERENCES players(id) on delete cascade;

create table FootballPlayer (
id int,
totalgoals int,
totalassists int,
primary key (id),
foreign key (id) references Players(id)
);
ALTER TABLE FootballPlayer ADD FOREIGN KEY (id) REFERENCES players(id) on delete cascade

create table BasketballPlayer (
id int,
totalpoints int,
totalsteals int,
primary key (id),
foreign key (id) references Players(id)
);
ALTER TABLE BasketballPlayer ADD FOREIGN KEY (id) REFERENCES players(id) on delete cascade

create table PaymentType (
id int primary key,
type_ varchar(20) 
);

insert into PaymentType Values (1,'Jazz Cash')
insert into PaymentType Values (2,'Easy Paisa')
insert into PaymentType Values (3,'Via Cash')

create table Payment (
id int primary key,
paymentType int foreign key references PaymentType (id),
paymentInfo varchar (30),
foreign key (id) references Teams (id) 
)

create table Schedule
(

id int primary key,
team1 int,
team2 int,
date_ varchar(30),
time_ varchar(20),
venue varchar(30),
SportType INT Foreign Key references Tournament (id),
status_ int, 

foreign key (team1) references Teams (id), 
foreign key (team2) references Teams (id) 
)
ALTER TABLE Schedule add matchoffcialid int foreign key references users(id)

create table CricketSummary
(
matchid int primary key,
team1score int,
team2score int,
team1wickets int,
team2wickets int,
team1overs float,
team2overs float,

foreign key (matchid) references Schedule (id) 

)
ALTER TABLE CricketSummary add ManOfTheMatch int foreign key references CricketPlayer(id)


Create table CricketPlayerMatchStats
(
summaryid int,
playerid int,
score int,
ballstaken int,
overs int,
runsconceeded int,
wickets int,

foreign key (playerid) references CricketPlayer(id) ,
foreign key (summaryid) references CricketSummary(matchid),

primary key (summaryid,playerid)

)

create table FootballSummary
(
matchid int primary key,
team1goals int,
team2goals int,

foreign key (matchid) references Schedule (id) 

)

ALTER TABLE FootballSummary add ManOfTheMatch int foreign key references FootballPlayer(id)

Create table FootballPlayerMatchStats
(
summaryid int,
playerid int,
goals int,
assists int,

foreign key (playerid) references FootballPlayer(id) ,
foreign key (summaryid) references FootballSummary(matchid),

primary key (summaryid,playerid)

)

create table BasketBallSummary
(
matchid int primary key,
team1points int,
team2points int,

foreign key (matchid) references Schedule (id) 

)

ALTER TABLE BasketBallSummary  add ManOfTheMatch int foreign key references BasketballPlayer(id)

Create table BasketBallPlayerMatchStats
(
summaryid int,
playerid int,
points int,
steals int,

foreign key (playerid) references BasketBallPlayer(id) ,
foreign key (summaryid) references basketBallSummary(matchid),

primary key (summaryid,playerid)

)

create table Notifications(
NotificationId int primary key,
subject_ varchar(50),
Content_ varchar(200), 
MessageType int
)

create table NotifiedUsers(
Userid int foreign key references Users(id),
notifId int foreign key references Notifications(NotificationId)
)



select * from usertype
select * from PaymentType
select * from Tournament

select * from users
select * from Teams
select * from Players
select * from CricketPlayer
select * from FootballPlayer
select * from BasketBallPlayer

select * from Schedule

select * from CricketSummary
select * from FootballSummary
select * from BasketBallSummary  
select * from CricketPlayerMatchStats
select * from FootballPlayerMatchStats
select * from BasketBallPlayerMatchStats

select * from Payment

select * from Notifications
select * from NotifiedUsers

-------------------------------------------------------------------------------------------------------

-------------------------------------------DELETE AND DROP STATEMENTS----------------------------------------------------------

/*
delete from CricketPlayerMatchStats 
delete from FootballPlayerMatchStats 
delete from BasketBallPlayerMatchStats 

delete from CricketSummary
delete from FootballSummary
delete from BasketBallSummary

delete from Payment 
delete from Schedule 

delete from FootballPlayer
delete from CricketPlayer
delete from BasketBallPlayer 

delete from players 
delete from teams  
delete from users 


drop table CricketPlayerMatchStats 
drop table FootballPlayerMatchStats 
drop table BasketBallPlayerMatchStats 

drop table CricketSummary
drop table FootballSummary
drop table BasketBallSummary

drop table Payment 
drop table Schedule 

drop table FootballPlayer
drop table CricketPlayer
drop table BasketBallPlayer 

drop table players 
drop table teams  
drop table users*/ 




-----------------------------------------------------------------DB INSERTIONS---------------------------------------------------------------------



------------------------------------------Football Sample------------------------------------------------------

insert into users values(1,'Hamza Khalid','hamza123','1234567','hamza12@gmail.com','0323-1487503',2) 

insert into teams values(1,'Pakistan',1,2,0,0,0,0,0,1)

insert into players values(1,'Shahid Afridi','shahid@gmail.com','0323-1234567','attacker',1) 
insert into players values(2,'Sarfaraz Ahmed','sarfaraz@gmail.com','0324-1234567','defender',1)
insert into players values(3,'Shoaib Akhtar','shoaib@gmail.com','0323-1234567','attacker',1)
insert into players values(4,'Fakhar Zaman','fakhar@gmail.com','0321-1234567','attacker',1)
insert into players values(5,'Misbah-ul-Haq','misbah@gmail.com','0320-1234567','defender',1)



insert into FootballPlayer values(1,0,0) 
insert into FootballPlayer values(2,0,0) 
insert into FootballPlayer values(3,0,0) 
insert into FootballPlayer values(4,0,0) 
insert into FootballPlayer values(5,0,0)




insert into users values(2,'Muaviya Ijaz','muaviya123','1234567','muaviya12@gmail.com','0323-1487503',3) 

insert into teams values(2,'India',2,2,0,0,0,0,0,1)

insert into players values(6,'Rohit Sharma','rohit@gmail.com','0323-1234567','attacker',2) 
insert into players values(7,'Shikhar Dhawan','dhawan@gmail.com','0324-1234567','attacker',2)
insert into players values(8,'Virat Kohli','kohli@gmail.com','0322-1234567','attacker',2)
insert into players values(9,'MS Dhoni','dhoni@gmail.com','0321-1234567','defender',2)
insert into players values(10,'Hardik Pandya','pandya@gmail.com','0320-1234567','attacker',2)



insert into FootballPlayer values(6,0,0)
insert into FootballPlayer values(7,0,0) 
insert into FootballPlayer values(8,0,0) 
insert into FootballPlayer values(9,0,0) 
insert into FootballPlayer values(10,0,0)



insert into users values(3,'Danish Irfan','danish123','1234567','danish12@gmail.com','0323-1487503',2) 

insert into teams values(3,'Australia',3,2,0,0,0,0,0,1)

insert into players values(11,'David Warner','warner@gmail.com','0323-1234567','attacker',3)
insert into players values(12,'Aaron Finch','finch@gmail.com','0324-1234567','attacker',3)
insert into players values(13,'Steven Smith','smith@gmail.com','0322-1234567','attacker',3)
insert into players values(14,'Mitchell Starc','starc@gmail.com','0321-1234567','defender',3)
insert into players values(15,'Pat Cummins','cummins@gmail.com','0320-1234567','attacker',3)



insert into FootballPlayer values(11,0,0) 
insert into FootballPlayer values(12,0,0) 
insert into FootballPlayer values(13,0,0) 
insert into FootballPlayer values(14,0,0) 
insert into FootballPlayer values(15,0,0)



insert into users values(4,'Usama Riaz','usama123','1234567','usama@gmail.com','0323-1487503',2) --password needs to be of length 7

insert into teams values(4,'England',4,2,0,0,0,0,0,1) 

insert into players values(16,'Jason Roy','jason@gmail.com','0323-1234567','attacker',4) 
insert into players values(17,'Johnny Bairstow','bairstow@gmail.com','0324-1234567','attacker',4)
insert into players values(18,'Joe Root','root@gmail.com','0322-1234567','attacker',4)
insert into players values(19,'Ben Stokes','stokes@gmail.com','0321-1234567','defender',4)
insert into players values(20,'Eoin Morgan','morgan@gmail.com','0320-1234567','attacker',4)



insert into FootballPlayer values(16,0,0) 
insert into FootballPlayer values(17,0,0) 
insert into FootballPlayer values(18,0,0) 
insert into FootballPlayer values(19,0,0) 
insert into FootballPlayer values(20,0,0)



insert into users values(5,'Fahad Arshad','fahad123','1234567','fahad@gmail.com','0323-1487503',2) 

insert into teams values(5,'New Zealand',5,2,0,0,0,0,0,1) 
insert into players values(21,'Martin Guptill','guptill@gmail.com','0323-1234567','attacker',5) 
insert into players values(22,'Kane Williamson','kane@gmail.com','0324-1234567','attacker',5)
insert into players values(23,'Mitchell Santner','santner@gmail.com','0322-1234567','defender',5)
insert into players values(24,'Trent Boult','boult@gmail.com','0321-1234567','attacker',5)
insert into players values(25,'Lockie Ferguson','ferguson@gmail.com','0320-1234567','attacker',5)



insert into FootballPlayer values(21,0,0)
insert into FootballPlayer values(22,0,0) 
insert into FootballPlayer values(23,0,0) 
insert into FootballPlayer values(24,0,0) 
insert into FootballPlayer values(25,0,0) 

---------------------------------------------------------------------------------------------------------------------------------------------------


------------------------------------------Cricekt Sample------------------------------------------------------

insert into users values(6,'Micky Arthur','micky12','1234567','micky@gmail.com','0323-1487503',3) 

insert into teams values(6,'Karachi Kings',6,1,0,0,0,0,0,1)

insert into players values(26,'Babar Azam','babar@gmail.com','0320-1234567','batsman',6) 
insert into players values(27,'Amir','amir@gmail.com','0321-1234567','fast bowler',6)
insert into players values(28,'Rizwan','rizwan@gmail.com','0322-1234567','wicket-keeper batsman',6)
insert into players values(29,'Imad Wasim','imad@gmail.com','0323-1234567','bowling all-rounder',6)
insert into players values(30,'Mir Hamza','hamza@gmail.com','0324-1234567','batting all-rounder',6)



insert into CricketPlayer values(26,0,0,0,0) 
insert into CricketPlayer values(27,0,0,0,0) 
insert into CricketPlayer values(28,0,0,0,0) 
insert into CricketPlayer values(29,0,0,0,0) 
insert into CricketPlayer values(30,0,0,0,0)

---------team 2
insert into users values(7,'Dean Jones','jones12','1234567','jones@gmail.com','0300-1487503',3) 

insert into teams values(7,'Islamabad United',7,1,0,0,0,0,0,1) 

insert into players values(31,'Shadab Khan','shadab@gmail.com','0301-1234567','bowling all-rounder',7)
insert into players values(32,'Asif','asif@gmail.com','0302-1234567','batsman',7)
insert into players values(33,'Luke Ronchi','ronchi@gmail.com','0303-1234567','wicket-keeper batsman',7)
insert into players values(34,'Samit Patel','patel@gmail.com','0304-1234567','bowling all-rounder',7)
insert into players values(35,'Musa Khan','musa@gmail.com','0305-1234567','fast bowler',7)

--inserting 5 players stats into football player table

insert into CricketPlayer values(31,0,0,0,0) 
insert into CricketPlayer values(32,0,0,0,0) 
insert into CricketPlayer values(33,0,0,0,0) 
insert into CricketPlayer values(34,0,0,0,0) 
insert into CricketPlayer values(35,0,0,0,0)


---------team3
insert into users values(8,'Vivian Richards','vivian12','1234567','vivian@gmail.com','0313-1487503',3)

insert into teams values(8,'Queta Gladiators',8,1,0,0,0,0,0,1)

insert into players values(36,'Ahmad Shehzad','ahmad@gmail.com','0310-1234567','batsman',8) 
insert into players values(37,'Husnain','husnain@gmail.com','0312-1234567','fast-bowler',8)
insert into players values(38,'Sarfraz','sarfraz@gmail.com','0314-1234567','wicket-keeper batsman',8)
insert into players values(39,'Nawaz','nawaz@gmail.com','0315-1234567','bowling all-rounder',8)
insert into players values(40,'Shane Watson','watson@gmail.com','0311-1234567','batting all-rounder',8)



insert into CricketPlayer values(36,0,0,0,0) 
insert into CricketPlayer values(37,0,0,0,0) 
insert into CricketPlayer values(38,0,0,0,0) 
insert into CricketPlayer values(39,0,0,0,0) 
insert into CricketPlayer values(40,0,0,0,0)


---------team4
insert into users values(9,'Darren Sammy','sammy12','1234567','sammy@gmail.com','0330-1487503',3) 

insert into teams values(9,'Peshawar',9,1,0,0,0,0,0,1) 
insert into players values(41,'Wahab Riaz','wahab@gmail.com','0331-1234567','bowling all-rounder',9) 
insert into players values(42,'Haider Ali','haider@gmail.com','0332-1234567','batsman',9)
insert into players values(43,'Kamran Akmal','kamran@gmail.com','0333-1234567','wicket-keeper batsman',9)
insert into players values(44,'Umaid Asif','umaid@gmail.com','0334-1234567','bowling all-rounder',9)
insert into players values(45,'Junaid Khan','junaid@gmail.com','0335-1234567','fast bowler',9)



insert into CricketPlayer values(41,0,0,0,0) 
insert into CricketPlayer values(42,0,0,0,0) 
insert into CricketPlayer values(43,0,0,0,0) 
insert into CricketPlayer values(44,0,0,0,0) 
insert into CricketPlayer values(45,0,0,0,0)


------team5
insert into users values(10,'Rana Fawad','rana12','1234567','rana@gmail.com','0340-1487503',3) 

insert into teams values(10,'Lahore Qalandars',10,1,0,0,0,0,0,1) 


insert into players values(46,'Cris Lynn','lynn@gmail.com','0341-1234567','batsman',10) 
insert into players values(47,'Haris Rauf','haris@gmail.com','0342-1234567','fast-bowler',10)
insert into players values(48,'Ben Dunks','ben@gmail.com','0343-1234567','wicket-keeper batsman',10)
insert into players values(49,'Hafeez','hafeez@gmail.com','0344-1234567','bowling all-rounder',10)
insert into players values(50,'David Wiesey','david@gmail.com','0345-1234567','batting all-rounder',10)



insert into CricketPlayer values(46,0,0,0,0) 
insert into CricketPlayer values(47,0,0,0,0) 
insert into CricketPlayer values(48,0,0,0,0) 
insert into CricketPlayer values(49,0,0,0,0) 
insert into CricketPlayer values(50,0,0,0,0)


 -------------- basket ball insertions ----------------------------------------------------------------
 
insert into users values(11,'Ali','ali123','1234567','ali@gmail.com','0323-1487503',3) --password needs to be of length 7

insert into teams values(11,'Shooting Stars',11,3,0,0,0,0,0,1)

insert into players values(51,'Hafiz','hafiz@gmail.com','0323-1111111','attacker',11) --teamId team kei table ki primary key hai jo kei
insert into players values(52,'Haseeb','haseeb@gmail.com','0323-2222222','defender',11)
insert into players values(53,'Hunain','hunain@gmail.com','0323-3333111','attacker',11)
insert into players values(54,'Arslan','arslan@gmail.com','0323-9999000','attacker',11)
insert into players values(55,'Abu Bakar','abubakar@gmail.com','0323-1234567','defender',11) 

insert into BasketBallPlayer values(51,0,0)
insert into BasketBallPlayer values(52,0,0) 
insert into BasketBallPlayer values(53,0,0) 
insert into BasketBallPlayer values(54,0,0) 
insert into BasketBallPlayer values(55,0,0)


insert into users values(12,'Ahmad','ahmad123','1234567','ahmad@gmail.com','0323-1114444',3) --password needs to be of length 7

insert into teams values(12,'Jayhawks',12,3,0,0,0,0,0,1) 

insert into players values(56,'Hammad','hammad@gmail.com','0323-1558831','attacker',12) --teamId team kei table ki primary key hai jo kei
insert into players values(57,'Ahad','ahad@gmail.com','0323-0478195','defender',12)
insert into players values(58,'Ahmad','ahmad@gmail.com','0323-0000111','attacker',12)
insert into players values(59,'Ammar','ammar@gmail.com','0323-7631058','attacker',12)
insert into players values(60,'Akhir','akhir@gmail.com','0323-120746','defender',12)

insert into BasketBallPlayer values(56,0,0)
insert into BasketBallPlayer values(57,0,0) 
insert into BasketBallPlayer values(58,0,0) 
insert into BasketBallPlayer values(59,0,0) 
insert into BasketBallPlayer values(60,0,0)

insert into users values(13,'Aijaz','aijaz12','1234567','aijaz@gmail.com','0323-3333333',3) --password needs to be of length 7

insert into teams values(13,'Basket Hounds',13,3,0,0,0,0,0,1) 

insert into players values(61,'Badar','badar@gmail.com','0323-1186311','attacker',13) --teamId team kei table ki primary key hai jo kei
insert into players values(62,'Umer','umer@gmail.com','0323-2220813','defender',13)
insert into players values(63,'Danish','danish@gmail.com','0300-3333111','attacker',13)
insert into players values(64,'Abdullah','abdullah@gmail.com','0333-9999000','attacker',13)
insert into players values(65,'Hamza','hamza@gmail.com','0300-1234567','defender',13)


insert into BasketBallPlayer values(61,0,0) 
insert into BasketBallPlayer values(62,0,0) 
insert into BasketBallPlayer values(63,0,0) 
insert into BasketBallPlayer values(64,0,0) 
insert into BasketBallPlayer values(65,0,0)


insert into users values(14,'Arsil','arsil101','1234567','arsil@gmail.com','0323-4882434',3) --password needs to be of length 7

insert into teams values(14,'Team11',14,3,0,0,0,0,0,1)


insert into players values(66,'Areeb','areeb@gmail.com','0323-193843','attacker',14) --teamId team kei table ki primary key hai jo kei
insert into players values(67,'Haseeb','haseeb11@gmail.com','0300-2222222','defender',14)
insert into players values(68,'Shahab','shahab@gmail.com','0333-3309111','attacker',14)
insert into players values(69,'Shoaib','shoib@gmail.com','0300-9991000','attacker',14)
insert into players values(70,'Afzal','afzal@gmail.com','0323-1230167','defender',14)

insert into BasketBallPlayer values(66,0,0)
insert into BasketBallPlayer values(67,0,0) 
insert into BasketBallPlayer values(68,0,0) 
insert into BasketBallPlayer values(69,0,0) 
insert into BasketBallPlayer values(70,0,0)


insert into users values(15,'Hassan','hassan123','1234567','hassan@gmail.com','0300-1456910',3) --password needs to be of length 7

insert into teams values(15,'Ball Busters',15,3,0,0,0,0,0,1) 

insert into players values(71,'Huzefa','huzefa@gmail.com','0323-10156511','attacker',15) --teamId team kei table ki primary key hai jo kei
insert into players values(72,'Meesam','meesam@gmail.com','0323-2202357','defender',15)
insert into players values(73,'Nooh','nooh@gmail.com','0323-123564','attacker',15)
insert into players values(74,'Zubair','zubair@gmail.com','0323-9222000','attacker',15)
insert into players values(75,'Saleh','saleh@gmail.com','0322-1234567','defender',15)
--inserting 5 players stats into football player table

insert into BasketBallPlayer values(71,0,0) 
insert into BasketBallPlayer values(72,0,0) 
insert into BasketBallPlayer values(73,0,0) 
insert into BasketBallPlayer values(74,0,0) 
insert into BasketBallPlayer values(75,0,0)


-------------------------------------------------------------PAYMENT VALUES------------------------------------------------------------------

---------------------------------------------------FOOTBALL TEAMS PAYMENT-------------------------------------------------------------------
insert into payment values(1,1,0323-1230978)
insert into payment values(2,2,0324-6523771)
insert into payment values(3,2,0323-1209876)
insert into payment values(4,2,0323-9824125)
insert into payment values(5,2,0333-8876231)

-----------------------------------------------------CRICKET TEAMS PAYMENT-------------------------------------------------------------------

insert into payment values(6,1,0333-2211876)
insert into payment values(7,2,0323-5517812)
insert into payment values(8,1,0333-1199876)
insert into payment values(9,1,0333-1233367)
insert into payment values(10,1,0300-9911232)

---------------------------------------------------BASKETBALL TEAMS PAYMENT-------------------------------------------------------------------

insert into payment values(11,2,0300-5551122)
insert into payment values(12,2,0323-1265231)
insert into payment values(13,1,0323-8732127)
insert into payment values(14,1,0300-1117721)
insert into payment values(15,1,0300-5552123)



-------------------------------------------------------------SCHEDULE VALUES------------------------------------------------------------------

---------------------------------------------------FOOTBALL TEAMS SCHEDULE-------------------------------------------------------------------
insert into Schedule values(1,1,2,'15/02/2020','1-2 pm','Football Ground',2,1,16) --created
--insert into Schedule values(2,1,3,'15/03/2020','2-3 pm','Football Ground',2,1,17)
--insert into Schedule values()
--insert into Schedule values()
--insert into Schedule values()

-----------------------------------------------------CRICKET TEAMS SCHEDULE-------------------------------------------------------------------

--insert into Schedule values(3,6,7,'25/04/2020','3-4 pm','Cricket Ground',1,0,18)
--insert into Schedule values(4,6,8,'27/05/2020','2-3 pm','Cricket Ground',1,0,19)
--insert into Schedule values()
--insert into Schedule values()
--insert into Schedule values()

---------------------------------------------------BASKETBALL TEAMS SCEDULE-------------------------------------------------------------------


insert into Schedule values(5,11,12,'29/06/2020','1-2 pm','BasketBall Ground',3,1,17) --created

--insert into Schedule values(6,11,15,'30/07/2020','2-3 pm','BasketBall Ground',3,0,15)
--insert into Schedule values()
--insert into Schedule values()
--insert into Schedule values()


---------------------------------------------------------MATCH SUMMARIES-----------------------------------------------------------------------------

---------------------------------------------------------FOOTBALL MATCHES----------------------------------------------------------------------------

-------------------------------------------------------------Match1--------------------------------------------------------------------------------


insert into FootballSummary values(1,5,4,2)

--team1
insert into FootballPlayerMatchStats values(1,1,1,0)
insert into FootballPlayerMatchStats values(1,2,3,0)
insert into FootballPlayerMatchStats values(1,3,1,1)
insert into FootballPlayerMatchStats values(1,4,0,1)
insert into FootballPlayerMatchStats values(1,5,0,1)

--team2
insert into FootballPlayerMatchStats values(1,6,1,0)
insert into FootballPlayerMatchStats values(1,7,1,0)
insert into FootballPlayerMatchStats values(1,8,1,1)
insert into FootballPlayerMatchStats values(1,9,1,0)
insert into FootballPlayerMatchStats values(1,10,0,1)

update FootballPlayer set totalgoals=1  where id=1
update FootballPlayer set totalgoals=3 where id=2
update FootballPlayer set totalgoals=1  where id=3
update FootballPlayer set totalgoals=0 where id=4
update FootballPlayer set totalgoals=0  where id=5
update FootballPlayer set totalgoals=1 where id=6
update FootballPlayer set totalgoals=1  where id=7
update FootballPlayer set totalgoals=1 where id=8
update FootballPlayer set totalgoals=1  where id=9
update FootballPlayer set totalgoals=0  where id=10

update FootballPlayer set totalassists=0  where id=1
update FootballPlayer set totalassists=0 where id=2
update FootballPlayer set totalassists=1  where id=3
update FootballPlayer set totalassists=1 where id=4
update FootballPlayer set totalassists=1  where id=5
update FootballPlayer set totalassists=0 where id=6
update FootballPlayer set totalassists=0  where id=7
update FootballPlayer set totalassists=1 where id=8
update FootballPlayer set totalassists=0  where id=9
update FootballPlayer set totalassists=1  where id=10



update teams set played=1,won=1,lost=0,tied=0,points=3 where id=1
update teams set played=1,won=0,lost=1,tied=0,points=0 where id=2
-------------------------------------------------------------Match2--------------------------------------------------------------------------------
/*insert into FootballSummary()

insert into FootballPlayerMatchStats()
insert into FootballPlayerMatchStats()
insert into FootballPlayerMatchStats()
insert into FootballPlayerMatchStats()
insert into FootballPlayerMatchStats()

-------------------------------------------------------------Match3--------------------------------------------------------------------------------
insert into FootballSummary()

insert into FootballPlayerMatchStats()
insert into FootballPlayerMatchStats()
insert into FootballPlayerMatchStats()
insert into FootballPlayerMatchStats()
insert into FootballPlayerMatchStats()


---------------------------------------------------------CRICKET MATCHES----------------------------------------------------------------------------

-------------------------------------------------------------Match4--------------------------------------------------------------------------------
insert into CricketSummary()

insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()

-------------------------------------------------------------Match5--------------------------------------------------------------------------------
insert into CricketSummary()

insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()

-------------------------------------------------------------Match6--------------------------------------------------------------------------------
insert into CricketSummary()

insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
insert into CricketPlayerMatchStats()
*/
---------------------------------------------------------BasketBall MATCHES----------------------------------------------------------------------------

-------------------------------------------------------------Match7--------------------------------------------------------------------------------


insert into BasketBallSummary values(5,100,99,52)

--team1
insert into basketballPlayerMatchStats values(5,51,20,5)
insert into basketballPlayerMatchStats values(5,52,31,5)
insert into basketballPlayerMatchStats values(5,53,9,7)
insert into basketballPlayerMatchStats values(5,54,22,2)
insert into basketballPlayerMatchStats values(5,55,18,8)

--team2
insert into basketballPlayerMatchStats values(5,56,20,9)
insert into basketballPlayerMatchStats values(5,57,25,3)
insert into basketballPlayerMatchStats values(5,58,25,2)
insert into basketballPlayerMatchStats values(5,59,15,0)
insert into basketballPlayerMatchStats values(5,60,14,4)

update basketballPlayer set totalpoints=20  where id=51
update basketballPlayer set totalpoints=31 where id=52
update basketballPlayer set totalpoints=9  where id=53
update basketballPlayer set totalpoints=22 where id=54
update basketballPlayer set totalpoints=18  where id=55
update basketballPlayer set totalpoints=20 where id=56
update basketballPlayer set totalpoints=25  where id=57
update basketballPlayer set totalpoints=25 where id=58
update basketballPlayer set totalpoints=15  where id=59
update basketballPlayer set totalpoints=14  where id=60

update basketballPlayer set totalsteals=5  where id=51
update basketballPlayer set totalsteals=5 where id=52
update basketballPlayer set totalsteals=7  where id=53
update basketballPlayer set totalsteals=2 where id=54
update basketballPlayer set totalsteals=8  where id=55
update basketballPlayer set totalsteals=9 where id=56
update basketballPlayer set totalsteals=3  where id=57
update basketballPlayer set totalsteals=2 where id=58
update basketballPlayer set totalsteals=0  where id=59
update basketballPlayer set totalsteals=4  where id=60


update teams set played=1,won=1,lost=0,tied=0,points=3 where id=11
update teams set played=1,won=0,lost=1,tied=0,points=0 where id=12

/*
-------------------------------------------------------------Match8--------------------------------------------------------------------------------
insert into BasketBallSummary()

insert into BaksetBallPlayerMatchStats()
insert into BaksetBallPlayerMatchStats()
insert into BaksetBallPlayerMatchStats()
insert into BaksetBallPlayerMatchStats()
insert into BaksetBallPlayerMatchStats()

-------------------------------------------------------------Match9--------------------------------------------------------------------------------
insert into BasketBallSummary()

insert into BaksetBallPlayerMatchStats()
insert into BaksetBallPlayerMatchStats()
insert into BaksetBallPlayerMatchStats()
insert into BaksetBallPlayerMatchStats()
insert into BaksetBallPlayerMatchStats()
*/










