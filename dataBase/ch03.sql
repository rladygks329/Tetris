-- SELECT, INSERT, UPDATE, DELETE

CREATE TABLE EX_MEMBER(
    ID VARCHAR2(20) PRIMARY KEY,
    PW VARCHAR2(20),
    EMAIL VARCHAR2(100)
);

-- EX_MEMBER 테이블에 데이터 3개 추가
INSERT INTO EX_MEMBER
VALUES('admin', 'admin1234', 'admin@test.com');

INSERT INTO EX_MEMBER
VALUES('guest', 'guest1234', 'guest@test.com');

INSERT INTO EX_MEMBER
VALUES('member', 'member1234', 'member@test.com');

INSERT INTO EX_MEMBER(ID, PW)
VALUES('alpha', 'alpha1234');