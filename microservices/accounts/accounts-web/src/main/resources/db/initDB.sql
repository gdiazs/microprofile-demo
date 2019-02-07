-- Drop table

-- DROP TABLE public.accounts

CREATE TABLE public.accounts (
	account_number varchar(100) NOT NULL,
	account_alias varchar(200) NOT NULL,
	account_balance numeric(12,5) NOT NULL DEFAULT 0,
	account_currency varchar(3) NOT NULL,
	account_enabled int4 NOT NULL DEFAULT 1,
	user_id varchar(100) NOT NULL,
	account_version int4 NOT NULL DEFAULT 1,
	CONSTRAINT accounts_pkey PRIMARY KEY (account_number, user_id)
);

INSERT INTO public.accounts
(account_number, account_alias, account_balance, account_currency, account_enabled, user_id, account_version)
VALUES('CR05015202001026284066', 'Cuenta Corriente', 10000.00000, 'CRC', 1, 'gdiazs', 1);
INSERT INTO public.accounts
(account_number, account_alias, account_balance, account_currency, account_enabled, user_id, account_version)
VALUES('CR05015202001026284067', 'Cuenta Planilla', 10000.00000, 'CRC', 1, 'gdiazs', 1);
INSERT INTO public.accounts
(account_number, account_alias, account_balance, account_currency, account_enabled, user_id, account_version)
VALUES('CR05015202001056284067', 'Cuenta Ahorros', 5000.00000, 'USD', 1, 'gdiazs', 1);
INSERT INTO public.accounts
(account_number, account_alias, account_balance, account_currency, account_enabled, user_id, account_version)
VALUES('CR05015302001056284067', 'Saving account', 1200.00000, 'USD', 1, 'macme', 1);
