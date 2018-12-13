SELECT *
FROM employees 
WHERE salary = (SELECT salary
                FROM employees
                WHERE lower(last_name)='seo')
                and lower(last_name) != 'seo';
                
SELECT *
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

SELECT * FROM emp 
WHERE salary=ALL(3100);

SELECT ROWID, ROWNUM, employee_id, last_name
FROM employees;

SELECT employee_id, last_name
FROM employees
WHERE ROWNUM >0;

SELECT employee_id, last_name
FROM employees
WHERE ROWNUM >1;

--salary 순으로 상위 5명 출력하기
SELECT ROWNUM employee_id, salary
FROM employees
WHERE ROWNUM <= 5
ORDER BY salary DESC;

--논리적으로 이게맞음 (salary 순으로 상위 5명 출력하기)
SELECT first_name, salary
FROM (SELECT first_name, salary 
      FROM employees 
      ORDER BY salary DESC)
WHERE ROWNUM <=5;

-- 급여순으로 10 ~ 20 사이
SELECT page, 
          employee_id, 
          first_name, 
          salary 
FROM   (SELECT CEIL(ROWNUM/10) page, 
                     employee_id, 
                     first_name, 
                     salary 
           FROM   (SELECT ROWNUM, 
                                employee_id, 
                                first_name, 
                                salary 
                      FROM   employees 
                      ORDER  BY salary DESC)) 
WHERE  page = 2; 

--연습
SELECT first_name||' '||last_name "name", ROUND(MONTHS_BETWEEN(SYSDATE,hire_date)) "근무달수"
FROM employees
ORDER BY "근무달수" ASC;

SELECT first_name||' '||last_name "name", job_id, TRUNC((MONTHS_BETWEEN(SYSDATE, hire_date))/12) "근무연차"
FROM employees;

사원이름, 월금, 월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력하시오.
SELECT first_name||' '||last_name "name", 
       salary, 
       salary+NVL(commission_pct,0) "실급여"
FROM employees;

월급과 커미션을 함친 금액이 2,000이상인 급여를 받는 사원의 이름, 업무, 월급, 커미션, 고용날짜를 출력하시오.
SELECT first_name, job_id, TO_CHAR(hire_date,'YYYY-MM-DD')
FROM employees
WHERE SALARY+NVL(commission_pct,0) >= 2000;

Kochhar의 급여보다 많은 사원의 정보
SELECT employee_id, last_name, job_id, salary 
FROM employees
WHERE salary> (SELECT salary from employees 
              where lower(last_name)='kochhar');
              
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
where salary < (SELECT AVG(salary) FROM employees);

SELECT e.employee_id, e.first_name, e.job_id, e.salary, e.department_id, d.department_name
FROM employees e
  JOIN departments d
    ON e.department_id= d.department_id
where salary < (SELECT AVG(salary) FROM employees);

SELECT min(salary)
from employees
where department_id=100;

select department_id, min(salary)
from employees
group by department_id
  having min(salary)>(SELECT min(salary)
          from employees
          where department_id=100) ;

--에러
select DISTINCT d.department_name, e.department_id, e.min(salary)
from employees e
  JOIN departments d
    on e.department_id = d.department_id
  group by department_id
  having min(salary)>(SELECT min(salary)
          from employees
          where department_id=100) ;