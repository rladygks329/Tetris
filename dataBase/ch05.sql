-- select �÷��� ����
-- AS�� ������ ������
SELECT EMPLOYEE_ID AS ���, LAST_NAME �̸� FROM EMPLOYEES;

CREATE TABLE EMP1(
    EMP_ID NUMBER,
    FIRST_NAME VARCHAR2(100),
    LAST_NAME VARCHAR2(100),
    SALARY NUMBER
);

-- INSERT-SELECT ����
INSERT INTO EMP1
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > 10000;

SELECT * 
FROM EMP1;

-- �Լ�
-- COUNT() : ���� ���� ���
SELECT COUNT(*) CNT FROM EMPLOYEES;
SELECT COUNT (EMPLOYEE_ID) FROM EMPLOYEES; -- �����Ͱ� �� ���� ȿ������
SELECT COUNT(MANAGER_ID) FROM EMPLOYEES; -- NULL�� ���� ����

-- lower() : �Էµ� ���ڸ� �ҹ��ڷ� ��ȯ
select first_name, last_name from employees
where lower(first_name) like 'a%';

-- upper() : �Էµ� ���ڸ� �빮�ڷ� ��ȯ
select last_name from employees
where upper(last_name) like 'A%';

-- nvl(�÷�, ġȯ��) : �÷��� null ���� ġȯ������ ��ȯ
select first_name, last_name, commission_pct from employees
where nvl(commission_pct, 0) < 0.2;

select first_name, last_name, commission_pct from employees
where commission_pct < 0.2 
    or commission_pct is null;

