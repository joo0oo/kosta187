select employee_id, last_name, salary, hire_date
from employees
where hire_date LIKE '02%';

--order by 정렬
select employee_id, last_name, salary, hire_date
from employees
--order by employee_id desc;
order by last_name asc, salary desc;

--group by 절
select department_id, count(department_id)
from employees
group by DEPARTMENT_ID
having department_id is not null
order by department_id asc;


-- 서브쿼리(내부쿼리)를 이용한 테이블 복사
create table emp as
  select *
  from employees; 
  
SELECT first_name
FROM   employees
UNION
SELECT first_name
FROM   emp;

select*
from employees
union all
select *
from emp;

SELECT *
FROM   employees
intersect
SELECT *
FROM   emp;

SELECT *
FROM   employees
minus
SELECT *
FROM   emp;
