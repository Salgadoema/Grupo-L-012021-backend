
INSERT INTO content (title_type, primary_title, original_title, start_year) VALUES
    ('Movie', 'Duro de matar', 'Die hard', 1988),
    ('Movie', 'Duro de matar 2', 'Die hard 2', 1990),
    ('Movie', 'Duro de matar 3', 'Die hard 3', 1992),
    ('Series', 'Una serie', 'Una serie original', 1990),
    ('Episode', 'Un episodio', 'Un episodio original', 1990);

INSERT INTO review (review_type, preview, full_review, rating, date_of_publish, platform_origin, username_on_platform,
                    language, contains_spoilers, likes, dislikes, content_id) VALUES
    ('Public', 'this is a premium preview', 'this is a full review', 4.5, '2020-5-28', 'netfli', 'juanito22',
     'castellano', 0, 0, 0, 1),
    ('Public', 'this is a public preview', 'this is a public review', 5, '2020-6-15', 'amazo', 'juanito22',
     'castellano', 0, 0, 0, 1),
('Premium', 'this is a public preview', 'this is a public review', 5, '2020-6-15', 'amazo', 'juanito22',
    'castellano', null, 0, 0, 2);



INSERT INTO crew_member (name) VALUES
    ('El pelado de duro de matar');

INSERT INTO users (firstname, surname, username, password, platform) VALUES
('juan','perez', 'popi', '81dc9bdb52d04dc20036dbd8313ed055', 'nefli'),
('carlos','lopez', 'pepi', '81dc9bdb52d04dc20036dbd8313ed055', 'hvo'),
('claudia','gomez', 'pupi', '81dc9bdb52d04dc20036dbd8313ed055', 'amazo');

INSERT INTO genre (genre) VALUES
    ('Accion'), ('Navidenia');

INSERT INTO report (reporter, type, review_id) VALUES
    ('jorge', 'tipo', 2);

/* Relacionales */


INSERT INTO content_crew_members (content_id, crew_members_id) VALUES
    (1, 1), (2, 1), (3, 1);

INSERT INTO content_genres (content_id, genres_id) VALUES
    (1,1), (1,2), (2,1), (3 ,1);

