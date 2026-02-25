show user;
-- USER이(가) "SYS"입니다.

alter session set "_ORACLE_SCRIPT"=true;
-- Session이(가) 변경되었습니다.

--  sistuser 이라는 오라클 일반사용자 계정을 생성합니다. 암호는 sistsix 라고 하겠습니다.
create user sistuser identified by sistsix default tablespace users;
-- User SISTUSER이(가) 생성되었습니다.


-- 생성되어진 오라클 일반사용자 계정인 sistuser 에게 오라클서버에 접속이 되어지고, 
-- 접속이 되어진 후 테이블 등을 생성할 수 있도록 권한을 부여해주겠다.
grant connect, resource, unlimited tablespace to sistuser;
-- Grant을(를) 성공했습니다.


show user;
-- USER이(가) "SISTUSER"입니다.
        
create table genie_music
(NO        NUMBER  NOT NULL      
,CNO       NUMBER        
,RANK      NUMBER  NOT NULL      
,TITLE     VARCHAR2(200) NOT NULL 
,SINGER    VARCHAR2(100) NOT NULL 
,ALBUM     VARCHAR2(200) NOT NULL 
,POSTER    VARCHAR2(260) NOT NULL 
,STATE     CHAR(6)       
,IDCREMENT NUMBER        
,KEY       VARCHAR2(100) 
,HIT       NUMBER        
,LIKECOUNT NUMBER
);


select * 
from genie_music
order by rank asc;

