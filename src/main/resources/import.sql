INSERT INTO public.equipes (equipe_pk, nom) VALUES (1, 'equipeA');
INSERT INTO public.equipes (equipe_pk, nom) VALUES (2, 'equipeB');

INSERT INTO public.joueurs (joueur_pk, date_naissance, nom, equipe_fk) VALUES (1, '1992-04-28', 'Jonas Aguenier', 1);
INSERT INTO public.joueurs (joueur_pk, date_naissance, nom, equipe_fk) VALUES (2, '1990-08-13', 'Jenia Grebennikov', 1);
INSERT INTO public.joueurs (joueur_pk, date_naissance, nom, equipe_fk) VALUES (3, '1995-01-29', 'Luka Basic', 1);
INSERT INTO public.joueurs (joueur_pk, date_naissance, nom, equipe_fk) VALUES (4, '1996-12-22', 'Jean Patry', 2);
INSERT INTO public.joueurs (joueur_pk, date_naissance, nom, equipe_fk) VALUES (5, '1989-11-21', 'Raphaël Corre', 2);

INSERT INTO public.tournois (tournoi_pk, nom) VALUES (1, 'coupe de France');

INSERT INTO public.equipes_tournois (equipe_fk, tournoi_fk) VALUES (1, 1);
INSERT INTO public.equipes_tournois (equipe_fk, tournoi_fk) VALUES (2, 1);