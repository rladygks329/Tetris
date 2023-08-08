/*
    오라클에서 여러 줄의 주석을 처리할 때
*/
-- 오라클에서 한줄 주석을 처리할 때
CREATE TABLE ex1(
    col1 NUMBER,
    col2 VARCHAR2(100),
    col3 DATE
);

-- 오라클 명령여 (create, INSERT) 등은
-- 대 / 소문자를 구분하지 않음
-- 오라클에서는 테이블 이름과 컬럼 이름을
-- 영문 대문자로 변환함

INSERT INTO EX1 VALUES(
    100, 
    'Hello',  
    sysdate
);
-- sysdate : 명령어 수행 시점의 시간을 저장

INSERT INTO EX1 VALUES(
    100,
    200,
    sysdate
);
-- 첫 번째 컬럼의 데이터 타입 (NUMBER)와
-- 추가하려는 데이터 타입이 다르기 때문에 에러 발생

-- VARCHAR2 데이터 타입
-- 가변길이 문자열: 문자열의 길이에 따라 저장 공간이 동적으로 변경

CREATE TABLE EX2(
    COL1 VARCHAR2(3), -- 문자열 3바이트까지
    COL2 VARCHAR2(3 BYTE), -- 문자열 3바이트 까지
    COL3 VARCHAR2(3 CHAR) -- 문자열 3글자 까지
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
-- ERROR : 저장 크기 초과

INSERT INTO EX2 VALUES(
    '한글날',
    '한',
    '글'
);
-- 에러 : 한글 1글자는 3바이트므로 저장 크기 초과

INSERT INTO EX2 VALUES(
    '한',
    '글',
    '한글날'
);

-- EX2 테이블에 COL1 - 'ABC', COL2 - 'DEF' 데이터를 삽입
INSERT INTO EX2 (COL1, COL2)
VALUES('ABC', 'DEF');

/*
    제약 조건
    - NOT NULL : 데이터를 반드시 입력
    - UNIQUE : 중복되지 않는 데이터만 입력 가능
    
    - PRIMARY KEY(고유키)
    테이블에서 유일한 데이터를 찾을 수 있는 컬럼
    데이터가 반드시 존재해야하고, 중복되지 않아야 함
    
    - FOREIGN KEY:
    테이블 간의 참조 데이터 무결성을 위한 제약 조건
    반드시 참조하는 테이블이 먼저 생성되어야 하며,
    참조키가 참조 테이블의 기본키로 설정되어야 한다.  
*/

CREATE TABLE EX3(
    COL1 VARCHAR2(10) NOT NULL,
    COL2 VARCHAR2(10) UNIQUE
);

INSERT INTO EX3
VALUES('AA', 'BB');

INSERT INTO EX3
VALUES('aa', 'BB');
-- COL2는 UNIQUE 해야 한다는 제약 조건에 위배

INSERT INTO EX3 (COL2) VALUES('CC');
-- COL1는 NOT NULL 해야 한다는 제약 조건에 위배 

CREATE TABLE EX4(
    COL1 VARCHAR2 (10) PRIMARY KEY,
    COL2 VARCHAR2 (10)
);

INSERT INTO EX4 VALUES('AB', 'CD');

-- COL1이 PK이기 때문에 중복된 데이터는 삽입 불가
INSERT INTO EX4 VALUES('AB', 'DC');

-- COL1이 PK이기 때문에 NULL값을 넣을 수 없음
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
    CHECK(GENDER IN ('남', '여'))
);

-- CHECK : 조건에 부합하는 데이터만 입력이 가능하도록 설정하는 제약 조건

INSERT INTO EX7 VALUES(12, '남자'); -- GENDER 제약조건 위반

-- ALTER TABLE: 테이블 정보를 변경할 때 사용

-- 제약 조건 추가
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

-- 테이블 컬럼 이름 변경
ALTER TABLE EX9 RENAME COLUMN COL1 TO AGE;
DESC EX9;
-- DESC : DESCRIBE(테이블 요약)

-- 테이블 컬럼 데이터 타입 변경
ALTER TABLE EX9 MODIFY COL2 VARCHAR2(10);
DESC EX9;

-- 테이블 컬럼 추가
ALTER TABLE EX9 ADD COL3 DATE;
DESC EX9;

-- 테이블 컬럼 삭제
ALTER TABLE EX9 DROP COLUMN COL3;
DESC EX9;

-- DB에 변경 내용 저장
COMMIT;
