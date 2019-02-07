-- Drop table

-- DROP TABLE public.authorities

CREATE TABLE public.authorities (
	id_authoritie int4 NOT NULL,
	authority_description varchar(100) NOT NULL,
	authority_enabled int4 NOT NULL,
	authority_name varchar(40) NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT authorities_pkey PRIMARY KEY (id_authoritie)
);

-- Drop table

-- DROP TABLE public.users

CREATE TABLE public.users (
	id_user int4 NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	user_account_non_expired int4 NOT NULL,
	user_account_non_locked int4 NOT NULL,
	user_credentials_non_expired int4 NOT NULL,
	user_email varchar(50) NOT NULL,
	user_enabled int4 NOT NULL,
	user_last_password_reset_date timestamp NOT NULL,
	user_name varchar(20) NOT NULL,
	user_password varchar(100) NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id_user)
);

-- Drop table

-- DROP TABLE public.users_authorities

CREATE TABLE public.users_authorities (
	authoritie_id int4 NOT NULL,
	user_id int4 NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT uk_6uk70o9gngtb60n4qb5sr0xsg UNIQUE (user_id),
	CONSTRAINT uk_p6riuboavq2dk38kq8at4w9te UNIQUE (authoritie_id),
	CONSTRAINT users_authorities_pkey PRIMARY KEY (authoritie_id, user_id),
	CONSTRAINT fkhpafpofndaokj07nj9lsd29sm FOREIGN KEY (authoritie_id) REFERENCES authorities(id_authoritie),
	CONSTRAINT fkq3lq694rr66e6kpo2h84ad92q FOREIGN KEY (user_id) REFERENCES users(id_user)
);


INSERT INTO public.users
(id_user, created_at, updated_at, user_account_non_expired, user_account_non_locked, user_credentials_non_expired, user_email, user_enabled, user_last_password_reset_date, user_name, user_password)
VALUES(1, '2016-06-01 00:00:00.000', '2016-06-01 00:00:00.000', 1, 1, 1, 'admin@email.com', 1, '2015-07-07 00:00:00.000', 'admin', '$2a$10$foOg.PH1tvrO2iI9SZzOdejIrLzUOvhnWiMqoPwRAgVc5eNV8iVQG');
INSERT INTO public.users
(id_user, created_at, updated_at, user_account_non_expired, user_account_non_locked, user_credentials_non_expired, user_email, user_enabled, user_last_password_reset_date, user_name, user_password)
VALUES(2, '2019-02-06 15:19:32.880', '2019-02-06 15:19:34.488', 1, 1, 1, 'owner@email.com', 1, '2019-02-06 15:19:58.687', 'gdiazs', '$2a$10$foOg.PH1tvrO2iI9SZzOdejIrLzUOvhnWiMqoPwRAgVc5eNV8iVQG');



INSERT INTO public.authorities
(id_authoritie, authority_description, authority_enabled, authority_name, created_at, updated_at)
VALUES(1, 'ADMIN', 1, 'ROLE_ADMIN', '2016-06-01 00:00:00.000', '2016-06-01 00:00:00.000');
INSERT INTO public.authorities
(id_authoritie, authority_description, authority_enabled, authority_name, created_at, updated_at)
VALUES(2, 'OWNER', 1, 'ROLE_OWNER', '2019-02-06 15:19:21.649', '2019-02-06 15:19:23.377');


INSERT INTO public.users_authorities
(authoritie_id, user_id, created_at, updated_at)
VALUES(1, 1, '2016-06-01 00:00:00.000', '2016-06-01 00:00:00.000');
INSERT INTO public.users_authorities
(authoritie_id, user_id, created_at, updated_at)
VALUES(2, 2, '2019-02-06 15:21:30.025', '2019-02-06 15:21:31.945');




