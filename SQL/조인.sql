--크로스 조인
SELECT e.first_name, d.department_name
FROM employees  e, departments d;

--ANSI 조인
SELECT e.first_name, d.department_name
FROM employees e
  CROSS JOIN departments d;
  
SELECT TO_CHAR('A') "start alphabet", count(e.last_name) "cnt"
FROM dual
  CROSS JOIN employees e
  WHERE e.last_name like 'A%';
  
--inner join (oracle)
SELECT e.employee_id, 
          e.last_name, 
          d.department_name 
FROM employees e, departments d
WHERE e.department_id= d.department_id
AND e.salary>= 3000;

--inner join (ASNI)
SELECT e.employee_id, 
          e.last_name, 
          d.department_name 
FROM employees e
JOIN departments d
--on e.department_id= d.department_id
using(department_id)
WHERE e.salary>=3000;

--3개이상 테이블 JOIN
SELECT e.employee_id, 
          e.last_name, 
          d.department_name, 
          l.city, 
          l.state_province, 
          c.country_name 
FROM employees e
  JOIN departments d
    ON e.department_id = d.department_id
  JOIN locations l
    ON d.location_id= l.location_id
  JOIN countries c
    ON l.country_id = c.country_id;

SELECT e.employee_id, e.last_name, e.salary, j.job_title
FROM employees e, JOBS j
WHERE e.salary BETWEEN j.min_salary AND j.max_salary
ORDER BY e.employee_id;

SELECT e.employee_id, 
          e.first_name, 
          e.last_name, 
          d.department_name 
FROM employees e, departments d
WHERE e.department_id= d.department_id(+);

SELECT e.first_name, d.department_name
FROM employees e
  LEFT OUTER JOIN departments d
    ON e.department_id= d.department_id;
    
SELECT e.first_name, d.department_name
FROM employees e
  RIGHT OUTER JOIN departments d
    ON e.department_id= d.department_id;
    
SELECT e.first_name, d.department_name
FROM employees e
  FULL OUTER JOIN departments d
    ON e.department_id= d.department_id;
    
SELECT employee.first_name, manager.first_name
FROM employees employee, employees manager
WHERE employee.manager_id = manager.employee_id;

SELECT employee.first_name, manager.first_name
FROM employees employee
LEFT OUTER JOIN employees manager
  ON employee.manager_id= manager.employee_id;