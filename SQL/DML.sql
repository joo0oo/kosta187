-- ����� NULL �Է� 
INSERT INTO departments 
                  (department_id, 
                   department_name, 
                   manager_id, 
                   location_id) 
VALUES        (900, 
                   'KOSTA', 
                   NULL, 
                   NULL); 

select *
from departments;

--������ ��ųʸ� ��ȸ
select *
from user_constraints;


-- �������� �̿��� �μ���ȣ �Է� 
INSERT INTO departments (department_id,  department_name, manager_id, location_id) 
VALUES       (departments_seq.NEXTVAL, 'KOSTA', NULL, NULL); 

SELECT * 
FROM   user_sequences; 

-- ������ NULL �Է� 
INSERT INTO departments (department_id, department_name) 
VALUES     (510,  'KOSTA1'); 


--���̺� ����
create table dept
as select *
   from departments
where 1=0;

insert into dept 
select *
from departments;

select * from dept;

--update
update employees
set salary= salary*1.1
where department_id = 30;

UPDATE EMP SET SAL = SAL * 1.1 WHERE DEPTNO = 20 ;
UPDATE EMP SET HIREDATE = SYSDATE;

DELETE FROM EMP ;
DELETE FROM EMP WHERE EMPNO = 7902 ;
DELETE FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP) ;     

select* from employees;
select* from jobs;

select*
from user_constraints
where table_name='EMPLOYEES';

select employee_id,job_id, manager_id, department_id
from employees
where job_id='IT_PROG';

INSERT INTO employees(employee_id,first_name, last_name, 
                      email, phone_number, 
                      hire_date, job_id, 
                      salary, commission_pct, 
                      manager_id, department_id)
VALUES (employees_seq.NEXTVAL, 'Song', 'JuHyeon', 
        'zuzbxx', '010.111.2222',
        SYSDATE, 'IT_PROG', 
        10000, 0.1, 
        102, 60);
        
commit;