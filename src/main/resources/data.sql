insert into location
(location_id, location_name, parent_id)
values (1, 'India', null);
insert into location
(location_id, location_name, parent_id)
values (2, 'Maharashtra', 1);
insert into location
(location_id, location_name, parent_id)
values (3, 'Mumbai', 2);
insert into location
(location_id, location_name, parent_id)
values (4, 'Pune', 2);
insert into location
(location_id, location_name, parent_id)
values (5, 'Navi Mumbai', 3);
insert into location
(location_id, location_name, parent_id)
values (6, 'Central Mumbai', 3);
insert into location
(location_id, location_name, parent_id)
values (7, 'Ghansoli', 5);
insert into location
(location_id, location_name, parent_id)
values (8, 'Reliance Corporate Park', 7);

insert into employee
(sl_no, emp_id, first_name, last_name, email, status, location_id)
values (1, 'P410001', 'James', 'Bond', 'james.bond@abc.com', 1, 7);
insert into employee
(sl_no, emp_id, first_name, last_name, email, status, location_id)
values (2, 'P410002', 'Tom', 'Cruise', 'tom.cruise@abc.com', 1, 5);
insert into employee
(sl_no, emp_id, first_name, last_name, email, status, location_id)
values (3, 'C410001', 'Brad', 'Pitt', 'brad.pitt@abc.com', 1, 3);
insert into employee
(sl_no, emp_id, first_name, last_name, email, status, location_id)
values (4, 'C410002', 'Jenifer', 'Lopez', 'jenifer.lopez@abc.com', 1, 3);
insert into employee
(sl_no, emp_id, first_name, last_name, email, status, location_id)
values (5, 'C410003', 'Uma', 'Thurman', 'uma.thurman@abc.com', 1, 7);
insert into employee
(sl_no, emp_id, first_name, last_name, email, status, location_id)
values (6, 'E410001', 'Will', 'Smith', 'will.smith@abc.com', 1, 7);

insert into card_master
(sl_no, card_id, status, encoding)
values(1, 50001, 1, 123456789);
insert into card_master
(sl_no, card_id, status, encoding)
values(2, 50002, 1, 123456789);
insert into card_master
(sl_no, card_id, status, encoding)
values(3, 50003, 1, 123456789);
insert into card_master
(sl_no, card_id, status, encoding)
values(4, 50004, 1, 123456789);
insert into card_master
(sl_no, card_id, status, encoding)
values(5, 50005, 1, 123456789);
insert into card_master
(sl_no, card_id, status, encoding)
values(6, 50006, 1, 123456789);
insert into card_master
(sl_no, card_id, status, encoding)
values(7, 50007, 1, 987654321);
insert into card_master
(sl_no, card_id, status, encoding)
values(8, 50008, 1, 987654321);
insert into card_master
(sl_no, card_id, status, encoding)
values(9, 50009, 1, 987654321);
insert into card_master
(sl_no, card_id, status, encoding)
values(10, 50010, 1, 987654321);
insert into card_master
(sl_no, card_id, status, encoding)
values(11, 50011, 1, 987654321);

insert into mapping_employee_card
(sl_no, emp_sl_no, card_sl_no, access_attributes)
values(1, 1, 1, 1);
insert into mapping_employee_card
(sl_no, emp_sl_no, card_sl_no, access_attributes)
values(2, 1, 2, 1);
insert into mapping_employee_card
(sl_no, emp_sl_no, card_sl_no, access_attributes)
values(3, 1, 3, 0);
insert into mapping_employee_card
(sl_no, emp_sl_no, card_sl_no, access_attributes)
values(4, 2, 4, 1);
insert into mapping_employee_card
(sl_no, emp_sl_no, card_sl_no, access_attributes)
values(5, 3, 5, 1);
insert into mapping_employee_card
(sl_no, emp_sl_no, card_sl_no, access_attributes)
values(6, 4, 6, 1);
insert into mapping_employee_card
(sl_no, emp_sl_no, card_sl_no, access_attributes)
values(7, 5, 7, 1);
insert into mapping_employee_card
(sl_no, emp_sl_no, card_sl_no, access_attributes)
values(8, 6, 8, 1);
--insert into mapping_employee_card
--(sl_no, emp_sl_no, card_sl_no, access_attributes)
--values(9, 7, 9, 0);
--insert into mapping_employee_card
--(sl_no, emp_sl_no, card_sl_no, access_attributes)
--values(10, 8, 10, 0);
--insert into mapping_employee_card
--(sl_no, emp_sl_no, card_sl_no, access_attributes)
--values(11, 9, 11, 0);


















