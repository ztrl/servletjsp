create table boards2 (
    bno number PRIMARY KEY,
    btitle VARCHAR2(200) NOT NULL,
    bcontent clob not null,
    bwriter VARCHAR2(20) not null,
    bdate date not null,
    bhitcount number not null,
    bfilename varchar2(100) null,
    bsavedname varchar2(100) null,
    bfiletype varchar2(100) null
);

create sequence seq_boards2_bno;