--���ڿ� ���� ������ �Լ�
SELECT CONCAT('Oracle', 'Java Developer')
FROM dual; --������ ���̺�

desc dual;

SELECT INITCAP('kim ki jung')
FROM dual;

SELECT first_name, last_name
FROM employees
--WHERE first_name = 'james';
WHERE LOWER(first_name) = 'james';

SELECT UPPER('bangry')
FROM dual;

SELECT LPAD('DataBase', 10, '*')
FROM dual;

SELECT RPAD('DataBase',10,'*')
FROM dual;

SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;

SELECT SUBSTR('����ð��굿', 4)
FROM dual;

SELECT first_name, LENGTH(first_name)
FROM employees;

SELECT REPLACE('�����ٺ�', '�ٺ�', '�ְ�')
FROM dual;

SELECT REPLACE('���� ��', ' ', '')
FROM dual;

SELECT INSTR('DataBase', 'B')
--SELECT INSTR('DataBase', 'a', 1, 2)
FROM dual;

--SELECT LTRIM('    JavaDeveloper')
--SELECT LTRIM('    JavaDeveloper', ' ')
SELECT LTRIM('JavaDeveloper', 'Java')
FROM dual;

--SELECT RTRIM('JavaDeveloper      ')
--SELECT RTRIM('JavaDeveloper      ', ' ')
SELECT RTRIM('JavaDeveloper', 'Developer')
FROM dual;

SELECT TRIM('      Java  Developer      ')
FROM dual;

-- ���� ���� ������ �Լ�
SELECT  ROUND(45.923), ROUND(45.923, 0), ROUND(45.923, 2), ROUND(45.923, -1)
FROM dual;

SELECT  TRUNC(45.923), TRUNC(45.923, 0), TRUNC(45.923, 2), TRUNC(45.923, -1) 
FROM dual;

SELECT  MOD(123456, 2)
FROM dual;

SELECT  CEIL(123.123)
FROM dual;

SELECT  FLOOR(123.123)
FROM dual;

SELECT  ABS(-500)
FROM dual;

SELECT  LN(10)
FROM dual;

SELECT  POWER(5, 2), SQRT(5), SIN(30), COS(30), TAN(30)
FROM dual;

-- ���������� �ּҰ� ��ȯ
SELECT  LEAST(10, 20, 30, 40)
FROM dual;

-- ���������� �ִ밪 ��ȯ
SELECT  GREATEST(10, 20, 30, 40)
FROM dual;

--��¥ó�� �Լ�
SELECT SYSDATE
FROM dual;

-- DATE Ÿ�Կ� ���� ����
SELECT SYSDATE - 1 "����" , SYSDATE "����", SYSDATE + 1 "����"
FROM dual;

-- ����� �ٹ� �ϼ� �˻�
SELECT first_name,  hire_date, SYSDATE, CEIL(SYSDATE - hire_date) "�ٹ��ϼ�"
FROM employees;

-- ����� �ٹ� ������ �˻�
SELECT first_name, TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date))  "�ٹ�������"
FROM employees;

-- Ư���������� ���� ��¥ ��ȯ
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 2) "���ú��� 2���� ��"
FROM dual;

-- �̹��� ����� ��¥
SELECT SYSDATE "����", NEXT_DAY(SYSDATE, '�����') "�̹��� �����"
FROM dual;

-- �̹��� ������ ��¥
SELECT SYSDATE, LAST_DAY(SYSDATE) "�̹��� ��������"
FROM dual;

--����ȯ �Լ�
SELECT TO_DATE('2011/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('2003-06-17', 'YYYY-MM-DD');

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE(20030617, 'YYYY-MM-DD');

SELECT TO_NUMBER('12345') + 1
FROM dual;

SELECT TO_NUMBER('12,345', '00,000') + 1
FROM dual;

SELECT TO_NUMBER('1000') + TO_NUMBER('2,000', '0,000') + 1
FROM dual;

-- �ʱ� �Ķ����(ȯ�漳��) ��� �˻�
SELECT * FROM  NLS_SESSION_PARAMETERS;


`;

SELECT first_name, hire_date, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI')
FROM employees;

-- �Ի�⵵�� 2002�⵵�� �����
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') = '2002';

SELECT 10 * NULL, 10 * NVL(NULL, 1)
FROM dual;

SELECT first_name, 
          salary, 
          commission_pct, 
          ( salary + ( salary * commission_pct ) ) * 12 "����"
FROM   employees;

SELECT first_name, 
          salary, 
          commission_pct, 
          ( salary + ( salary * NVL(commission_pct, 0) ) ) * 12 "����" 
FROM   employees;

SELECT first_name, 
          job_id, 
          salary, 
          DECODE(job_id, 'IT_PROG', salary * 1.5, 
                              'AC_MRG', salary * 1.3, 
                              'AC_ASST', salary * 1.1, 
                              salary) "�λ�ȱ޿�" 
FROM   employees;

-- Ŀ�̼��� �޴� ����� ��(�̶� NULL�� ������ �������� ����)
SELECT COUNT(commission_pct)
FROM employees;

-- NULL���� ������ ����
SELECT COUNT(*) "��ü�����", COUNT(commission_pct) "Ŀ�̼ǻ����"
FROM employees;

-- �޿� �Ѿ�(NULL�� ����)
SELECT SUM(salary), SUM(commission_pct)
FROM employees;

-- �޿� ���(NULL�� ����)
SELECT AVG(salary)
FROM employees;

SELECT AVG(commission_pct), AVG(NVL(commission_pct, 0))
FROM employees;

