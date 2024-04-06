create database employee_db;
use employee_db;
create table employee_details(
employeename varchar(50),
employeeid int,
doj date,
technology varchar(20),
experience int,
constraint pk_ei primary key(employeeid)
);

insert into employee_details values ("Ravi uppu",123456,"2023-04-12","Java",2);
insert into employee_details values ("vinod",3456352,"2023-02-11","SAP",3);
insert into employee_details values ("Amit Patel", 789123, "2024-01-15", "Python", 4);
insert into employee_details values ("Sara Johnson", 456789, "2023-12-10", "Data Science", 5);
insert into employee_details values ("John Doe", 321654, "2024-02-20", "Web Development", 3);
insert into employee_details values ("Jane Smith", 987321, "2023-11-30", "Machine Learning", 6);


insert into employee_details values ("John Smith", 7890123, "2023-05-25", "Python", 4);
insert into employee_details values ("Alice Johnson", 4567489, "2023-07-17", "JavaScript", 2);
insert into employee_details values ("Michael Brown", 9387654, "2023-09-03", "C++", 5);
insert into employee_details values ("Emily Davis", 6254321, "2023-11-12", "Ruby", 3);
insert into employee_details values ("Daniel Lee", 3241098, "2023-08-28", "React", 2);
insert into employee_details values ("Sophia Martinez", 2456801, "2023-10-05", "Angular", 4);
insert into employee_details values ("Matthew Taylor", 1335790, "2023-12-20", "SQL", 3);
insert into employee_details values ("Olivia Wilson", 8032467, "2023-06-14", "Java", 4);
insert into employee_details values ("William Anderson", 5793512, "2023-04-30", "PHP", 2);
insert into employee_details values ("Emma Thomas", 9753618, "2023-03-08", "Swift", 5);

 insert into employee_details values ("Rajesh Kumar", 1234564, "2024-03-15", "Data Analysis", 3);
insert into employee_details values ("Priya Singh", 6543421, "2023-10-20", "Web Design", 2);
insert into employee_details values ("Mohammed Ali", 7893012, "2024-02-28", "Software Testing", 4);
insert into employee_details values ("Linda Johnson", 2104987, "2023-12-01", "Network Security", 5);
select * from employee_details ;

select * from employee_details where employeeid= 123456;