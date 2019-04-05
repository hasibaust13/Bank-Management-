
---------PROCEDURE--------

---1-----
CREATE or replace PROCEDURE insert_into_transaction(a_id in NUMBER,b_id in number,
													date_of_tran in varchar2,p_amount in FLOAT,p_action in varchar2) AS

BEGIN

insert into TRANSACTION (transaction_id,account_id,branch_id,date_of_transaction,amount,action) 
   values(t_id_sequence.NEXTVAL,a_id,b_id,
	to_date(date_of_tran,'dd-MM-yyyy hh24:mi:ss'),p_amount,p_action);

END;


----2-------
create or replace PROCEDURE get_name_and_current_amount(p_a_id in NUMBER,v_name out VARCHAR2,c_balance out NUMBER) AS
BEGIN
	
	select name into v_name from ACCOUNTS ac join customer  c 
  on (ac.customer_id=c.customer_id) where ACCOUNT_ID=p_a_id;	

  select CURRENT_BALANCE into c_balance  from ACCOUNTS where ACCOUNT_ID=p_a_id;
END;


----3------

create or replace PROCEDURE view_full_profile
   (p_a_id in NUMBER,p_name out VARCHAR2,p_phone out VARCHAR2,p_email out VARCHAR2,
   p_houseno out VARCHAR2,p_zip out VARCHAR2,p_city out VARCHAR2,p_c_balance out NUMBER) AS
BEGIN
	select name into p_name from ACCOUNTS ac
  join CUSTOMER c on (ac.customer_id=c.customer_id) where account_id=p_a_id;

	select phone into p_phone from ACCOUNTS ac
  join CUSTOMER c on (ac.customer_id=c.customer_id) where account_id=p_a_id;

	select email into p_email from ACCOUNTS ac
  join CUSTOMER c on (ac.customer_id=c.customer_id) where account_id=p_a_id;

  select house_no into p_houseno from ACCOUNTS ac
  join CUSTOMER c on (ac.customer_id=c.customer_id) where account_id=p_a_id;

	select zipcode into p_zip from ACCOUNTS ac
  join CUSTOMER c on (ac.customer_id=c.customer_id) where account_id=p_a_id;

	select city into p_city from ACCOUNTS ac
  join CUSTOMER c on (ac.customer_id=c.customer_id) where account_id=p_a_id;

	select current_balance into p_c_balance from ACCOUNTS where account_id=p_a_id;

END;







------function------

----1-----

create or replace function get_current_amount(a_id number) return number AS

current_amount NUMBER;
BEGIN
	
	select current_balance into current_amount  from accounts where account_id=a_id;
	
	return current_amount;
END;



----2------

create or replace function get_transaction(a_id number) return SYS_REFCURSOR AS

my_cursor SYS_REFCURSOR;
BEGIN
	
	open my_cursor for  select TRANSACTION_ID,BRANCH_ID,DATE_OF_TRANSACTION,AMOUNT,ACTION from TRANSACTION 
  where ACCOUNT_ID= a_id order by date_of_transaction desc;
	return my_cursor;

END;

----3----

create or replace function e_login(f_name VARCHAR2, f_password VARCHAR2) return SYS_REFCURSOR AS

my_cursor SYS_REFCURSOR;
BEGIN
	
	open my_cursor for  select USERNAME,U_PASSWORD from EMP_LOGIN 
  where USERNAME=f_name and U_PASSWORD=f_password ;

	return my_cursor;

END;


-----4-----

create or replace function customer_info(a_id NUMBER) return SYS_REFCURSOR AS

my_cursor SYS_REFCURSOR;
BEGIN
	
	open my_cursor for  select name,PHONE from ACCOUNTS ac
                      join CUSTOMER c on (ac.customer_id=c.customer_id) where account_id=a_id;

	return my_cursor;

END;










-----TRIGGER-----

---1----

CREATE OR REPLACE TRIGGER deposit_balance
AFTER INSERT ON TRANSACTION 
FOR EACH ROW 
WHEN (new.ACTION = 'Deposite')

DECLARE 
		a_id NUMBER;
		balance FLOAT;
		t_type VARCHAR2(20);

BEGIN 
			a_id := :NEW.ACCOUNT_ID;
			balance := :NEW.AMOUNT;
			t_type := :NEW.ACTION;
			DBMS_OUTPUT.PUT_LINE(a_id);
			DBMS_OUTPUT.PUT_LINE(balance);
			DBMS_OUTPUT.PUT_LINE(t_type);

			UPDATE ACCOUNTS
			SET CURRENT_BALANCE=CURRENT_BALANCE+balance
			WHERE ACCOUNT_ID= a_id;
END;



----2------



CREATE OR REPLACE TRIGGER withdraw_balance
AFTER INSERT ON TRANSACTION 
FOR EACH ROW 
WHEN (new.ACTION = 'Withdraw')

DECLARE 
		a_id NUMBER;
		balance FLOAT;
		t_type VARCHAR2(20);

BEGIN 
			a_id := :NEW.ACCOUNT_ID;
			balance := :NEW.AMOUNT;
			t_type := :NEW.ACTION;
			DBMS_OUTPUT.PUT_LINE(a_id);
			DBMS_OUTPUT.PUT_LINE(balance);
			DBMS_OUTPUT.PUT_LINE(t_type);

			UPDATE ACCOUNTS
			SET CURRENT_BALANCE=CURRENT_BALANCE-balance
			WHERE ACCOUNT_ID= a_id;
END;


























