--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS demo2;
--
-- Name: demo2; Type: DATABASE; Schema: -; Owner: demo2
--

CREATE DATABASE demo2 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';


ALTER DATABASE demo2 OWNER TO demo2;

\connect demo2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: schema1; Type: SCHEMA; Schema: -; Owner: demo2
--

CREATE SCHEMA schema1;


ALTER SCHEMA schema1 OWNER TO demo2;

--
-- Name: get_person_count(); Type: PROCEDURE; Schema: public; Owner: demo2
--

CREATE PROCEDURE public.get_person_count(OUT result integer)
    LANGUAGE plpgsql
    AS $$
BEGIN
    SELECT COUNT(*) INTO result FROM person;
END;
$$;


ALTER PROCEDURE public.get_person_count(OUT result integer) OWNER TO demo2;

--
-- Name: get_person_count(); Type: PROCEDURE; Schema: schema1; Owner: demo2
--

CREATE PROCEDURE schema1.get_person_count(OUT result integer)
    LANGUAGE plpgsql
    AS $$
BEGIN
    SELECT COUNT(*)*2 INTO result FROM public.person;
END;
$$;


ALTER PROCEDURE schema1.get_person_count(OUT result integer) OWNER TO demo2;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: person; Type: TABLE; Schema: public; Owner: demo2
--

CREATE TABLE public.person (
    id character varying(255) NOT NULL,
    name character varying(255)
);


ALTER TABLE public.person OWNER TO demo2;

--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: demo2
--

INSERT INTO public.person VALUES ('bsn123', 'Bartje');


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: demo2
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

