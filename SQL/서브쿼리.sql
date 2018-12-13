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

--salary ������ ���� 5�� ����ϱ�
SELECT ROWNUM employee_id, salary
FROM employees
WHERE ROWNUM <= 5
ORDER BY salary DESC;

--�������� �̰Ը��� (salary ������ ���� 5�� ����ϱ�)
SELECT first_name, salary
FROM (SELECT first_name, salary 
      FROM employees 
      ORDER BY salary DESC)
WHERE ROWNUM <=5;

-- �޿������� 10 ~ 20 ����
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

--����
SELECT first_name||' '||last_name "name", ROUND(MONTHS_BETWEEN(SYSDATE,hire_date)) "�ٹ��޼�"
FROM employees
ORDER BY "�ٹ��޼�" ASC;

SELECT first_name||' '||last_name "name", job_id, TRUNC((MONTHS_BETWEEN(SYSDATE, hire_date))/12) "�ٹ�����"
FROM employees;

����̸�, ����, ���ް� Ŀ�̼��� ���� ���� �÷��� �Ǳ޿���� �ؼ� ����Ͻÿ�.
SELECT first_name||' '||last_name "name", 
       salary, 
       salary+NVL(commission_pct,0) "�Ǳ޿�"
FROM employees;

���ް� Ŀ�̼��� ��ģ �ݾ��� 2,000�̻��� �޿��� �޴� ����� �̸�, ����, ����, Ŀ�̼�, ��볯¥�� ����Ͻÿ�.
SELECT first_name, job_id, TO_CHAR(hire_date,'YYYY-MM-DD')
FROM employees
WHERE SALARY+NVL(commission_pct,0) >= 2000;

Kochhar�� �޿����� ���� ����� ����
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

--����
select DISTINCT d.department_name, e.department_id, e.min(salary)
from employees e
  JOIN departments d
    on e.department_id = d.department_id
  group by department_id
  having min(salary)>(SELECT min(salary)
          from employees
          where department_id=100) ;