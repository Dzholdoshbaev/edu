insert into authorities (authority)
values ('USER');

//qwe password
INSERT INTO users (name, surname, age, email, password, phone_number, enabled, authority_id)
VALUES
    ('Chyngyz', 'Dzholdoshbaev', 25, 'medzholdoshbaev@gmail.com', '$2a$12$nbJcXR6aa/XQZijdKOFWweOgFrZhlsFLk.lWSbpQAhNTlqnJF1y3W', '0555433444', true, (SELECT id FROM AUTHORITIES WHERE AUTHORITY = 'USER'));