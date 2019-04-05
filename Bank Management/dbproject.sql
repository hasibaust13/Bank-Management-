
---1. show the customer name who has the maximum balance----

select current_blance,customer_name from ACCOUNT as a
join CUSTOMER as c
on (a.customer_id=c.customer_id)
where current_blance=(select max(current_blance) from ACCOUNT)

---2.show branch names which have most transaction amount ---

select branch_name , sum(amount) as maxamount from TRANSACTIONS as t
join BRANCH as b
on(b.branch_id=t.branch_id)
group by branch_name

---3.show customers and amount  who withdrawed  money from branch name dutchbangla  ---

select customer_name,amount from ACCOUNT as a
join CUSTOMER as c
on(c.customer_id=a.customer_id)
join TRANSACTIONS as t
on (a.account_id=t.account_id)
join BRANCH as b
on (b.branch_id=t.branch_id)
where branch_name='dutchbangla'

----4. how many times each customer withdraw money ---
select customer_name,count(amount) as totaltransaction from ACCOUNT as a
join CUSTOMER as c
on(c.customer_id=a.customer_id)
join TRANSACTIONS as t
on (a.account_id=t.account_id)
group by customer_name


-----5.show average withdraw amount from each branch-----

select branch_name , avg(amount) as avgamount from TRANSACTIONS as t
join BRANCH as b
on(b.branch_id=t.branch_id)
group by branch_name


------6.show branches who have average withdraw amount greater than average withdraw amount of the whole bank  ----

select branch_name , avg(amount) as avgamount from TRANSACTIONS as t
join BRANCH as b
on(b.branch_id=t.branch_id)
group by branch_name
having avg(amount) > ( select avg(amount)  from TRANSACTIONS as t
					join BRANCH as b on(b.branch_id=t.branch_id) )

----7. show branch name which has maximum avarage transaction----

select branch_name , avg(amount) as avgamount from TRANSACTIONS as t
join BRANCH as b
on(b.branch_id=t.branch_id)
group by branch_name
having avg(amount) = ( select max(avgamount) from
					(select branch_name , avg(amount) as avgamount from TRANSACTIONS as t
				   join BRANCH as b
				   on(b.branch_id=t.branch_id)
				   group by branch_name) as maxavg  )


---8.which customer made most number of withdraw ----

select customer_name,count(amount) as totaltransaction from ACCOUNT as a
join CUSTOMER as c
on(c.customer_id=a.customer_id)
join TRANSACTIONS as t
on (a.account_id=t.account_id)
group by customer_name

having count(amount) = ( select max(totaltransaction) from
						(select customer_name,count(amount) as totaltransaction from ACCOUNT as a
						join CUSTOMER as c
						on(c.customer_id=a.customer_id)
						join TRANSACTIONS as t
						on (a.account_id=t.account_id)
						group by customer_name) as maxtra  )



----9.show current balance of customers who opend an account after 2015 ------
select current_blance,customer_name, date_opened from ACCOUNT as a
join CUSTOMER as c
on (a.customer_id=c.customer_id)
where year(date_opened)= 2015


----10.show customers who opend account on friday and on march-----

select current_blance,customer_name, date_opened from ACCOUNT as a
join CUSTOMER as c
on (a.customer_id=c.customer_id)
where datename(dw,date_opened)= 'friday' and datename(MONTH,date_opened)= 'march'

