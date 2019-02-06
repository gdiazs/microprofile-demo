CREATE TABLE ACCOUNTS (
	ACCOUNT_NUMBER VARCHAR(100),
	ACCOUNT_ALIAS VARCHAR(200) NOT NULL,
	ACCOUNT_BALANCE DECIMAL(12, 5) NOT NULL default 0,
	ACCOUNT_CURRENCY VARCHAR(3) NOT NULL,
	ACCOUNT_ENABLED INTEGER NOT NULL default 1,
	USER_ID	VARCHAR(100) NOT NULL,
	ACCOUNT_VERSION INTEGER NOT NULL default 1,
	PRIMARY KEY(ACCOUNT_NUMBER, USER_ID)
);

INSERT INTO public.accounts
(account_number, account_alias, account_balance, account_currency, account_enabled, user_id, account_version)
VALUES('CR05015202001026284066', 'Cuenta Corriente', 10000.00, 'CRC', 1, 'gdiazs', 1);

INSERT INTO public.accounts
(account_number, account_alias, account_balance, account_currency, account_enabled, user_id, account_version)
VALUES('CR05015202001026284067', 'Cuenta Planilla', 10000.00, 'CRC', 1, 'gdiazs', 1);

INSERT INTO public.accounts
(account_number, account_alias, account_balance, account_currency, account_enabled, user_id, account_version)
VALUES('CR05015202001056284067', 'Cuenta Ahorros', 5000.00, 'USD', 1, 'gdiazs', 1);

INSERT INTO public.accounts
(account_number, account_alias, account_balance, account_currency, account_enabled, user_id, account_version)
VALUES('CR05015302001056284067', 'Saving account', 1200.00, 'USD', 1, 'macme', 1);

