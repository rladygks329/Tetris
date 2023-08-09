-- select 컬럼의 별명
-- AS는 생략이 가능해
SELECT EMPLOYEE_ID AS 사번, LAST_NAME 이름 FROM EMPLOYEES;

CREATE TABLE EMP1(
    EMP_ID NUMBER,
    FIRST_NAME VARCHAR2(100),
    LAST_NAME VARCHAR2(100),
    SALARY NUMBER
);

-- INSERT-SELECT 구문
INSERT INTO EMP1
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > 10000;

SELECT * 
FROM EMP1;

-- 함수
-- COUNT() : 행의 개수 출력
SELECT COUNT(*) CNT FROM EMPLOYEES;
SELECT COUNT (EMPLOYEE_ID) FROM EMPLOYEES; -- 데이터가 더 적어 효율적임
SELECT COUNT(MANAGER_ID) FROM EMPLOYEES; -- NULL은 세지 않음

-- lower() : 입력된 문자를 소문자로 변환
select first_name, last_name from employees
where lower(first_name) like 'a%';

-- upper() : 입력된 문자를 대문자로 변환
select last_name from employees
where upper(last_name) like 'A%';

-- nvl(컬럼, 치환값) : 컬럼의 null 값을 치환값으로 변환
select first_name, last_name, commission_pct from employees
where nvl(commission_pct, 0) < 0.2;

select first_name, last_name, commission_pct from employees
where commission_pct < 0.2 
    or commission_pct is null;

