CREATE TABLE IF NOT EXISTS public.music_band_test
(
    mb_id uuid NOT NULL DEFAULT gen_random_uuid(),
    mb_name character varying COLLATE pg_catalog."default" NOT NULL,
    mb_genre character varying COLLATE pg_catalog."default" NOT NULL,
    mb_creationdate date NOT NULL,
    mb_phonenumber character varying COLLATE pg_catalog."default" NOT NULL,
    mb_email character varying COLLATE pg_catalog."default" NOT NULL,
    mb_isdeleted boolean NOT NULL DEFAULT false,
    CONSTRAINT music_band_pkey PRIMARY KEY (mb_id),
    CONSTRAINT unique_data UNIQUE (mb_id, mb_phonenumber, mb_email)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.music_band_test
    OWNER to postgres;
	
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Linkin Park, ROCK, 1999-12-31, +4455865156, linkinpark@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Evanescence, ROCK, 2001-05-01, +556621865156, evanescence@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Foo Fighters, ROCK, 1977-05-06, +476621865156, foo@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Metallica, ROCK, 1979-08-07, +00147865156, metallica@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Korn, ROCK, 1999-03-04, +9995664124, korn@email.com);

INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Duke Ellington His Orchestra, JAZZ, 1967-09-10, +2295664124, duke@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Louis Armstrong His Hot Five, JAZZ, 1949-04-08, +77695664124, arm@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Benny Goodman His Orchestra, JAZZ, 1955-11-03, +00995664124, benny@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Miles Davis Quintet, JAZZ, 1941-06-22, +36715564124, miles@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (John Coltrane Quartet, JAZZ, 1997-08-19, +6633111478, john@email.com);

INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (ABBA, POP, 1974-02-16, +95689126124, abba@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Destiny Child, POP, 1993-05-13, +19849651155, destiny@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (Madonna, POP, 1967-02-01, +2295664124, madonna@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (The Beach Boys, POP, 192-06-29, +00447774124, beach@email.com);
INSERT INTO public.music_band_test(mb_name, mb_genre, mb_creationdate, mb_phonenumber, mb_email) 
VALUES (The Beatles, POP, 1934-01-01, +66745251456, the@email.com);