create table USR_INFO (
                          id bigint not null auto_increment primary key,
                          usr_key varchar(32) not null unique,
                          usr_reg_num varchar(50) not null,
                          usr_nm varchar(20) not null,
                          usr_icm_amt bigint default 0 not null
);

create table LOAN_REVIEW(
                            id bigint not null auto_increment primary key,
                            usr_key varchar(32) not null unique,
                            loan_lmt_amt bigint default 0 not null,
                            loan_intrt double default 0.0 not null
);