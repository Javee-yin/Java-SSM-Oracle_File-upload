---------------------------------------------
-- Export file for user JAVEE              --
-- Created by Javee on 2020/5/25, 14:33:22 --
---------------------------------------------

create table T_IMG
(
  img_id    NUMBER not null,
  img_path  VARCHAR2(100),
  author_id NUMBER,
  valid     CHAR(1) default 1
)