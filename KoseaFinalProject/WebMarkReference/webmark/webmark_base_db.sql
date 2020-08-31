DROP USER webmark CASCADE;

CREATE USER webmark IDENTIFIED BY kosea;

GRANT CONNECT, RESOURCE, DBA TO webmark;

GRANT CREATE SESSION TO webmark;

ALTER USER webmark ACCOUNT UNLOCK;

conn webmark/kosea;

CREATE TABLE accountwm (
	user_id		VARCHAR2(100)	NOT NULL,
	user_pw		VARCHAR2(100)	NOT NULL,
	user_name	VARCHAR2(100)	NOT NULL,
	user_nick		VARCHAR2(100)	NOT NULL,
	e_mail		VARCHAR2(200)	UNIQUE,
	create_date	DATE		DEFAULT SYSDATE,
	CONSTRAINT PK_accountwm		PRIMARY KEY(user_id)
);

CREATE TABLE category (
	cat_num		NUMBER		NOT NULL,
	user_id		VARCHAR2(100)	NOT NULL,
	cat_name		VARCHAR2(100)	NOT NULL, /*디폴트로 할 지 고민*/
	/*depth		NUBMER		DEFAULT 0, */
	/*upper_name	VARCHAR2(100),	*/
	CONSTRAINT PK_category		PRIMARY KEY(cat_num),
	CONSTRAINT FK_category		FOREIGN KEY(user_id)	REFERENCES accountwm
);

CREATE SEQUENCE category_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE urlwm (
	url_num		NUMBER		NOT NULL,
	cat_num		NUMBER		NOT NULL,
	url_address	VARCHAR2(4000)	NOT NULL,
	url_name		VARCHAR2(100)	NOT NULL,  /*디폴트로 할 지 고민*/
	url_access	CHAR(1)		DEFAULT '0'	CHECK(url_access IN ('0', '1')),
	tag		VARCHAR2(100),
	CONSTRAINT PK_urlwm		PRIMARY KEY(url_num),
	CONSTRAINT FK_urlwm		FOREIGN KEY(cat_num)	REFERENCES category
);

CREATE SEQUENCE urlwm_seq START WITH 1 INCREMENT BY 1;

COMMIT;