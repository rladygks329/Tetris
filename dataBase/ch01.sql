/*
    ����Ŭ���� ���� ���� �ּ��� ó���� ��
*/
-- ����Ŭ���� ���� �ּ��� ó���� ��
CREATE TABLE ex1(
    col1 NUMBER,
    col2 VARCHAR2(100),
    col3 DATE
);

-- ����Ŭ ��ɿ� (create, INSERT) ����
-- �� / �ҹ��ڸ� �������� ����
-- ����Ŭ������ ���̺� �̸��� �÷� �̸���
-- ���� �빮�ڷ� ��ȯ��

INSERT INTO EX1 VALUES(
    100, 
    'Hello',  
    sysdate
);
-- sysdate : ��ɾ� ���� ������ �ð��� ����

INSERT INTO EX1 VALUES(
    100,
    200,
    sysdate
);
-- ù ��° �÷��� ������ Ÿ�� (NUMBER)��
-- �߰��Ϸ��� ������ Ÿ���� �ٸ��� ������ ���� �߻�

-- VARCHAR2 ������ Ÿ��
-- �������� ���ڿ�: ���ڿ��� ���̿� ���� ���� ������ �������� ����

CREATE TABLE EX2(
    COL1 VARCHAR2(3), -- ���ڿ� 3����Ʈ����
    COL2 VARCHAR2(3 BYTE), -- ���ڿ� 3����Ʈ ����
    COL3 VARCHAR2(3 CHAR) -- ���ڿ� 3���� ����
);

INSERT INTO EX2 VALUES(
    'ABC',
    'ABC',
    'ABC'
);

INSERT INTO EX2 VALUES(
    'ABC',
    'ABC',
    'ABCD'
);
-- ERROR : ���� ũ�� �ʰ�

INSERT INTO EX2 VALUES(
    '�ѱ۳�',
    '��',
    '��'
);
-- ���� : �ѱ� 1���ڴ� 3����Ʈ�Ƿ� ���� ũ�� �ʰ�

INSERT INTO EX2 VALUES(
    '��',
    '��',
    '�ѱ۳�'
);

-- EX2 ���̺� COL1 - 'ABC', COL2 - 'DEF' �����͸� ����
INSERT INTO EX2 (COL1, COL2)
VALUES('ABC', 'DEF');

/*
    ���� ����
    - NOT NULL : �����͸� �ݵ�� �Է�
    - UNIQUE : �ߺ����� �ʴ� �����͸� �Է� ����
    
    - PRIMARY KEY(����Ű)
    ���̺��� ������ �����͸� ã�� �� �ִ� �÷�
    �����Ͱ� �ݵ�� �����ؾ��ϰ�, �ߺ����� �ʾƾ� ��
    
    - FOREIGN KEY:
    ���̺� ���� ���� ������ ���Ἲ�� ���� ���� ����
    �ݵ�� �����ϴ� ���̺��� ���� �����Ǿ�� �ϸ�,
    ����Ű�� ���� ���̺��� �⺻Ű�� �����Ǿ�� �Ѵ�.  
*/

CREATE TABLE EX3(
    COL1 VARCHAR2(10) NOT NULL,
    COL2 VARCHAR2(10) UNIQUE
);

INSERT INTO EX3
VALUES('AA', 'BB');

INSERT INTO EX3
VALUES('aa', 'BB');
-- COL2�� UNIQUE �ؾ� �Ѵٴ� ���� ���ǿ� ����

INSERT INTO EX3 (COL2) VALUES('CC');
-- COL1�� NOT NULL �ؾ� �Ѵٴ� ���� ���ǿ� ���� 

CREATE TABLE EX4(
    COL1 VARCHAR2 (10) PRIMARY KEY,
    COL2 VARCHAR2 (10)
);

INSERT INTO EX4 VALUES('AB', 'CD');

-- COL1�� PK�̱� ������ �ߺ��� �����ʹ� ���� �Ұ�
INSERT INTO EX4 VALUES('AB', 'DC');

-- COL1�� PK�̱� ������ NULL���� ���� �� ����
INSERT INTO EX4 (COL2) VALUES('DC');

CREATE TABLE EX5(
    COL1 VARCHAR2(10),
    COL2 VARCHAR2(10),
    CONSTRAINTS PK_EX5 PRIMARY KEY (COL1)
);

CREATE TABLE EX6(
    COL1 VARCHAR2(10),
    CONSTRAINTS UN_EX6 UNIQUE(COL1)
);

CREATE  TABLE EX7(
    AGE NUMBER CHECK(AGE >= 0),
    GENDER VARCHAR(10),
    CONSTRAINTS CHECK_GENDER
    CHECK(GENDER IN ('��', '��'))
);

-- CHECK : ���ǿ� �����ϴ� �����͸� �Է��� �����ϵ��� �����ϴ� ���� ����

INSERT INTO EX7 VALUES(12, '����'); -- GENDER �������� ����

-- ALTER TABLE: ���̺� ������ ������ �� ���

-- ���� ���� �߰�
ALTER TABLE EX7 ADD CONSTRAINTS UN_EX7 UNIQUE(AGE);

CREATE TABLE EX8 (
    COL1 VARCHAR2(10),
    CONSTRAINTS NN_EX8
        CHECK (COL1 IS NOT NULL)
);

CREATE TABLE EX9 (
    COL1 NUMBER, 
    COL2 VARCHAR2(10)
);

-- ���̺� �÷� �̸� ����
ALTER TABLE EX9 RENAME COLUMN COL1 TO AGE;
DESC EX9;
-- DESC : DESCRIBE(���̺� ���)

-- ���̺� �÷� ������ Ÿ�� ����
ALTER TABLE EX9 MODIFY COL2 VARCHAR2(10);
DESC EX9;

-- ���̺� �÷� �߰�
ALTER TABLE EX9 ADD COL3 DATE;
DESC EX9;

-- ���̺� �÷� ����
ALTER TABLE EX9 DROP COLUMN COL3;
DESC EX9;

-- DB�� ���� ���� ����
COMMIT;
