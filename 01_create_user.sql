use prac;

create table user_info (
	user_id		BIGINT auto_increment ,
	username	varchar(255) not null,
	password	varchar(255) not null,
	mail_address	varchar(255) not null,
	enabled		boolean not null default 0,
	unique index (user_id)
);

create table user_role(
	user_id     bigint not null,
	role        varchar(128) not null 
);
