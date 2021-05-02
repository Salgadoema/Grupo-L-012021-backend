
INSERT INTO reviewable (id, title_type, primary_title, original_title, start_year) VALUES
    ('m1','Movie', 'Duro de matar', 'Die hard', 1988),
    ('m2','Movie', 'Duro de matar 2', 'Die hard 2', 1990),
    ('m3','Movie', 'Duro de matar 3', 'Die hard 3', 1992);

INSERT INTO review (id, review_type, preview, full_review, rating, date_of_publish, platform_origin, username_on_platform,
                    language, contains_spoiler, likes, dislikes, reviewable_id) VALUES
    (1, 'Premium', 'this is a premium preview', 'this is a full review', 4.5, '2020-5-28', 'netfli', 'juanito22',
     'castellano', 0, 0, 0, 'm1'),
    (2, 'Public', 'this is a public preview', 'this is a public review', 5, '2020-6-15', 'amazo', 'juanito22',
     'castellano', 0, 0, 0, 'm1');

INSERT INTO actor (id, name) VALUES
    (1, 'El pelado de duro de matar');

INSERT INTO genre (id, genre) VALUES
    (1, 'Accion'), (2, 'Navidenia');

INSERT INTO report (id, reporter, type, review_id) VALUES
    (1, 'jorge', 'tipo', 2);

/* Relacionales */

INSERT INTO reviewable_actors (reviewable_id, actors_id) VALUES
    ('m1', 1), ('m2', 1), ('m3', 1);

INSERT INTO reviewable_genres (reviewable_id, genres_id) VALUES
    ('m1',1), ('m1',2), ('m2',1), ('m3',1);

