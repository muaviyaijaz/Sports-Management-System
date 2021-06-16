# Sports-Management-System
Java based desktop application using Java Swing library to manage different sports details 
 
Section 1:

PRE_REQUIREMENT: you should have sql server managment studio in server authentication mode and need to create the given schema.

Open the given SQL file using SQL Server Management Studio. (We have used the login user with username='admin123' and password='1234567')
Open the project folder in NetBeans.
Establish connection with SQL by adding two jar files by going into project properties: sqljdbc42.jar and mysql-connector.jar
Run project. The main page opens up. 
Select either one of the login options or the admin signup option,otherwise view the basic functionalities as a spectator.

Fill the required fields accordingly.

    1.If you've logged in as a user, you can view points table,fixtures,teams,top scorers,certificate,match summary and can do payment(in pay later option case)      

    2.If you've logged in as an organizer, you can do all of user things above except view certificate and can add,update match,create summary.

    3.If you've logged in as an admin, you can do all of above things + see personal info of teams and organizers,update points table.

                a)Create summary.
                      Enter details of match and then save button.

                b)View fixtures.
                      Fixtures will be generated.

                c)Update PointsTable
                        points table will be updated acc to summary.

	              d)view player certificate
                         certificate generated
                
	            	e)user profile
                        user can see his personal info
                
                f)add match
                        can add fixtures by writing date and selecting venue,time.

                g)view teams data
                        can see teams info and their players stats.

                h)send notification
                        admin can send notification via email/sms to users(organizers or users), receive func not proposed
                            but data getting stored in db of the notifications admin has sent.
		
	            	i)allocating official
                         we could allocate official in add match dialog
                 
Once you've done all of the things, you can LOGOUT too .

Section 2:

We have made use of Singleton Pattern in our Project which returns the single instance of dbconnection as we need
its single instance for whole project. 
Db connectivity makes use of may resources so it is better to get a single instance of it. 

Singleton class:

-dbConnectivity class

REFERENCES:

Used in following classes:

-JFrame class
-Tournament class
-Team class
-Schedule class
-Sports Management Class


