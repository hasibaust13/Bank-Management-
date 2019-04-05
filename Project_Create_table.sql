
CREATE SEQUENCE c_id_sequence
  MINVALUE 10001
  MAXVALUE 999999999999999999999999999
  START WITH 10001
  INCREMENT BY 1
  CACHE 20;

--------////-------

CREATE SEQUENCE a_id_sequence
  MINVALUE 100011
  MAXVALUE 999999999999999999999999999
  START WITH 100011
  INCREMENT BY 1
  CACHE 20;

----///-----

CREATE SEQUENCE b_id_sequence
  MINVALUE 101
  MAXVALUE 999999999999999999999999999
  START WITH 101
  INCREMENT BY 1
  CACHE 20;

--- /// ----

CREATE SEQUENCE t_id_sequence
  MINVALUE 1001
  MAXVALUE 999999999999999999999999999
  START WITH 1001
  INCREMENT BY 1
  CACHE 20;

------Table--------

create table EMP_LOGIN
(
	username varchar2(10),
	u_password varchar2(10)
	
);


create table customer 
(
	customer_id NUMBER(20) NOT NULL,
	name VARCHAR2(15) NOT NULL,
	phone VARCHAR2(11) NOT NULL,
	email VARCHAR2(30) NOT NULL,
	house_no VARCHAR2(10) NOT NULL,
	city VARCHAR2(10) NOT NULL,
	zipcode VARCHAR2(15) NOT NULL,

	primary key ( customer_id)
	
);


INSERT INTO CUSTOMER 
(customer_id,name,phone,email,house_no,city,zipcode)
VALUES
(c_id_sequence.NEXTVAL,'Mahade','01671648062','undefinedmahade@gmail.com','Q5','Dhaka','1207');

INSERT INTO CUSTOMER 
(customer_id,name,phone,email,house_no,city,zipcode)
VALUES
(c_id_sequence.NEXTVAL,'Riad','0173832700','riad566@gmail.com','370/371','Dhaka','1217');




CREATE TABLE ACCOUNTS
(	
	account_id NUMBER(20) NOT NULL,
	customer_id NUMBER(20) NOT NULL,
	date_opened DATE NOT NULL,
	date_closed DATE,
	current_balance FLOAT ,

	PRIMARY KEY (account_id),
	FOREIGN KEY (customer_id) REFERENCES CUSTOMER(customer_id)
	
);

INSERT INTO ACCOUNTS 
(account_id, customer_id, date_opened, date_closed,current_balance)
VALUES
(a_id_sequence.NEXTVAL, 10001,'18-Feb-2016','',50000);


INSERT INTO ACCOUNTS 
(account_id, customer_id, date_opened, date_closed,current_balance)
VALUES
(a_id_sequence.NEXTVAL, 10002,'20-Feb-2016','',95000);




CREATE TABLE BRANCH
( 
	branch_id NUMBER(20) NOT NULL,
	name varchar2(15) NOT NULL,
	house_no VARCHAR2(15) NOT NULL,
	city VARCHAR2(15) NOT NULL,
	zip_code VARCHAR2(15) NOT NULL,

	primary key (branch_id)
);

INSERT INTO BRANCH VALUES (b_id_sequence.NEXTVAL,'Malibagh','M502', 'Dhaka', '1217');
INSERT INTO BRANCH VALUES (b_id_sequence.NEXTVAL,'Mohammadpur','M555', 'Dhaka', '1207');



CREATE TABLE TRANSACTION 
(
	transaction_id NUMBER(20) NOT NULL,
	account_id NUMBER(20) NOT NULL,
	branch_id NUMBER(20) NOT NULL,
	date_of_transaction DATE NOT NULL,
	amount FLOAT(20) NOT NULL,
	action VARCHAR2(20),

	primary key (transaction_id),
	FOREIGN KEY (account_id) REFERENCES ACCOUNTS(account_id),
	FOREIGN KEY (branch_id) REFERENCES BRANCH(branch_id)
);


INSERT INTO TRANSACTION VALUES (t_id_sequence.NEXTVAL,100011,101,'19-Feb-2016',5000.00,'withdraw');







-------------

select name,account_id,phone from ACCOUNTS  a join customer  c on(a.customer_id=c.customer_id) 
where   account_id=100011;

select name,phone from customer order by name desc


insert into TRANSACTION (transaction_id,account_id,branch_id,date_of_transaction,amount,action) 
   values(t_id_sequence.NEXTVAL,100011,101,
	to_date('19-FEB-2016 12:10:12','dd-MM-yyyy hh24:mi:ss'),'5000','withdraw') 





