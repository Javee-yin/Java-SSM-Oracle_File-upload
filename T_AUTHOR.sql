---------------------------------------------
-- Export file for user JAVEE              --
-- Created by Javee on 2020/5/25, 14:34:02 --
---------------------------------------------
create table T_AUTHOR
(
  author_id NUMBER not null,
  name      VARCHAR2(20 CHAR),
  password  VARCHAR2(20 CHAR),
  valid     CHAR(1) default 1
)
