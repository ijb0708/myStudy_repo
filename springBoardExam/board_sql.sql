create sequence board_seq
increment by 1
start with 1
minvalue 1
maxvalue 1000
nocycle;

create table members (
  userid varchar(10) PRIMARY KEY,
  userpw varchar(10),
  info varchar(10)
  );
  
create table board (
  idx number PRIMARY KEY,
  title varchar(20),
  cont varchar(50),
  userid varchar(10),
  constraint userid foreign key(userid) REFERENCES members(userid)
  );
  
insert into members values ('홍길동', '1234', 'man');
insert into members values ('성춘향', '1234', 'nor');  
  
select * from members;

select userid, userpw, info from members where USERID = '홍길동';

commit;
  