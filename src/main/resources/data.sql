
INSERT INTO reviewable (title_type, primary_title, original_title, start_year) VALUES
    ('Movie', 'Duro de matar', 'Die hard', 1988),
    ('Movie', 'Duro de matar 2', 'Die hard 2', 1990),
    ('Movie', 'Duro de matar 3', 'Die hard 3', 1992),
    ('Series', 'Una serie', 'Una serie original', 1990),
    ('Episode', 'Un episodio', 'Un episodio original', 1990);

INSERT INTO review (review_type, preview, full_review, rating, date_of_publish, platform_origin, username_on_platform,
                    language, contains_spoiler, likes, dislikes, reviewable_id) VALUES
    ('Public', 'this is a premium preview', 'this is a full review', 4.5, '2020-5-28', 'netfli', 'juanito22',
     'castellano', 0, 0, 0, 1),
    ('Public', 'this is a public preview', 'this is a public review', 5, '2020-6-15', 'amazo', 'juanito22',
     'castellano', 0, 0, 0, 1),
('Premium', 'this is a public preview', 'this is a public review', 5, '2020-6-15', 'amazo', 'juanito22',
    'castellano', 0, 0, 0, 2);



INSERT INTO actor (name) VALUES
    ('El pelado de duro de matar');

INSERT INTO genre (genre) VALUES
    ('Accion'), ('Navidenia');

INSERT INTO report (reporter, type, review_id) VALUES
    ('jorge', 'tipo', 2);

/* Relacionales */


INSERT INTO reviewable_actors (reviewable_id, actors_id) VALUES
    (1, 1), (2, 1), (3, 1);

INSERT INTO reviewable_genres (reviewable_id, genres_id) VALUES
    (1,1), (1,2), (2,1), (3 ,1);

