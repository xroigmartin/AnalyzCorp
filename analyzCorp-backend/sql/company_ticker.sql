CREATE TABLE public.company_ticker (
     ticker varchar NULL,
     cik numeric NULL,
     title varchar NOT NULL,
     CONSTRAINT company_ticker_pk PRIMARY KEY (ticker)
);
