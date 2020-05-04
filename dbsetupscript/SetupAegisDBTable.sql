DROP TABLE account;
DROP TABLE activity;
DROP TABLE courses;
CREATE TABLE account (Id int, Password VARCHAR(12), State VARCHAR(10), FName VARCHAR(20), LName VARCHAR(20));
CREATE TABLE activity (ACode varchar(6), AName VARCHAR(6), AHour INT);
CREATE TABLE courses (CCode varchar(6), CName VARCHAR(6), Credit INT, Cost INT);
select * from account ;
select * from activity ;
select * from courses ;
