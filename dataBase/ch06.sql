-- JOIN:
-- �� �� �̻��� ���̺��� �����͵��� �����ؼ� �˻��ϴ� ���
-- Self - Join:
-- �ϳ��� ���̺��� ������ ���� �����ؼ� �˻��ϴ� ���

-- ���� ���̺��� ���, �̸�, �μ���ȣ�� �˻�
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPARTMENT_ID
FROM EMPLOYEES;

-- �μ� ���̺��� �μ���ȣ, �μ��̸��� �˻�
SELECT DEPARTMENT_ID, DEPARTMENT_NAME
FROM DEPARTMENTS;

-- ������ �μ� ���̺��� ���, �̸�, �μ���ȣ, �μ��̸��� �˻� (ORACLE JOIN)
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID; 

-- ANSI JOIN(ǥ�� ���� ����)
select e.employee_id, e.last_name,
    e.department_id, d.department_name
from employees e JOIN departments d
ON e.department_id = d.department_id;

-- �μ���ȣ�� null�� ������ �����ؼ� �˻�
select e.employee_id, e.last_name,
    e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);

-- ���, ��å ���̺��� ���, �̸�, ��å ���̵�, ��å �̸��� �˻�
select e.employee_id, e.last_name,
    e.job_id, j.job_title
from employees e, jobs j
where e.job_id = j.job_id;

select e.employee_id, e.last_name,
    e.job_id, j.job_title
from employees e join jobs j
on e.job_id = j.job_id;

-- ���� �÷� : ROWNUM
SELECT ROWNUM R, EMPLOYEE_ID, LAST_NAME FROM EMPLOYEES;

SELECT A.R, A.EMPLOYEE_ID, A.LAST_NAME
FROM(
    SELECT ROWNUM R, EMPLOYEE_ID, LAST_NAME FROM EMPLOYEES
) A
WHERE A.R >= 7 AND A.R <= 9;