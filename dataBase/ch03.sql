-- SELECT, INSERT, UPDATE, DELETE

CREATE TABLE EX_MEMBER(
    ID VARCHAR2(20) PRIMARY KEY,
    PW VARCHAR2(20),
    EMAIL VARCHAR2(100)
);

-- EX_MEMBER ���̺� ������ 3�� �߰�
INSERT INTO EX_MEMBER
VALUES('admin', 'admin1234', 'admin@test.com');

INSERT INTO EX_MEMBER
VALUES('guest', 'guest1234', 'guest@test.com');

INSERT INTO EX_MEMBER
VALUES('member', 'member1234', 'member@test.com');

INSERT INTO EX_MEMBER(ID, PW)
VALUES('test', 'test1234');

-- ��ü EX_MEMBER ������ �˻�
SELECT ID, PW, EMAIL FROM EX_MEMBER;

--- ȸ�� ���̺��� ID, PW �÷� �����͸� �˻�
SELECT ID, PW FROM EX_MEMBER;

-- ȸ�� ���̺��� ID�� 'test'�� ��� ������ �˻�
SELECT ID, PW, EMAIL 
FROM EX_MEMBER
WHERE ID = 'test';

-- ID�� guest�� ������ ���� �������� email ����
UPDATE EX_MEMBER
SET EMAIL = 'UPDATE@TEST.COM'
WHERE ID ='guest';

-- ID�� guest�� ������ ���� ������ ����
DELETE EX_MEMBER
WHERE ID = 'guest';

CREATE TABLE EX_STUDENT(
    ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    BIRTHDAY TIMESTAMP DEFAULT SYSDATE,
    EMAIL VARCHAR2(100)
);

DESC EX_STUDENT;
-- TIMESTAMP : �ð� ǥ�� ������ ��¥ Ÿ��

INSERT INTO EX_STUDENT 
VALUES(1, 'Aaa', '1970-01-01', 'aaa@test.com');

INSERT INTO EX_STUDENT(ID, NAME)
VALUES(2, 'Bbb');

INSERT INTO EX_STUDENT(ID, NAME, EMAIL)
VALUES(3, 'Abc', 'abc@test.com');

INSERT INTO EX_STUDENT(ID, NAME, BIRTHDAY)
VALUES(4, 'aaa', '2000-01-01');

SELECT * FROM EX_STUDENT;

-- EX_STUDENT ���̺��� iD, NAME �����͸� �˻�(ID�� �������� ��������)
SELECT ID, NAME
FROM EX_STUDENT
ORDER BY ID DESC;
-- DESC : ��������

-- EX_STUDENT ���̺��� ��� ������ �˻�(NAME�� �������� ��������)
SELECT * 
FROM EX_STUDENT 
ORDER BY NAME;

SELECT * 
FROM EX_STUDENT 
ORDER BY BIRTHDAY;

-- NAME�� ������ �� A�� �����ϴ� ���ڿ��� ���� ��� ������ �˻�
SELECT *
FROM EX_STUDENT
WHERE NAME LIKE 'A%';

-- NAME�� ������ �� a�� ������ ���ڿ��� ���� ��� ������ �˻�
SELECT *
FROM EX_STUDENT
WHERE NAME LIKE '%a';

-- NAME�� ������ �� b�� �����ϴ� ���ڿ��� ���� ��� ������ �˻�
SELECT *
FROM EX_STUDENT
WHERE NAME LIKE '%b%';

-- 2000�� 1�� 1�� ���Ŀ� ����� �л����� ������ �˻�
SELECT * 
FROM EX_STUDENT
WHERE BIRTHDAY >= '2000-01-01';

-- EMAIL ���� NULL�� �ƴ� ��� ������ �˻�
SELECT *
FROM EX_STUDENT
WHERE EMAIL IS NOT NULL;

-- NAME�� ���� A�� �����ϰ�,
-- EMAIL ���� NULL�� �ƴ� ��� ������ �˻�
SELECT *
FROM EX_STUDENT
WHERE NAME LIKE 'A%' AND EMAIL IS NOT NULL;

-- NAME�� ���� A�� �����ϰų�, B�� �����ϴ�
-- ��� ������ �˻�
SELECT *
FROM EX_STUDENT
WHERE NAME LIKE 'A%' OR NAME LIKE 'B%';

