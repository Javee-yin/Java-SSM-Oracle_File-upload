---------------------------------------------
-- Export file for user JAVEE              --
-- Created by Javee on 2020/5/21, 16:22:23 --
---------------------------------------------

create table T_IMG
(
  img_id   NUMBER not null,
  img_path VARCHAR2(100),
  author   VARCHAR2(10 CHAR),
  valid    CHAR(1) default 1
)
