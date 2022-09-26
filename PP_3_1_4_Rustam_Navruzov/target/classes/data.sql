INSERT INTO roles VALUES (1, 'ROLE_USER'),
                         (2, 'ROLE_ADMIN');

INSERT INTO users VALUES (1, 10, 'User', 'Userov', '$2a$12$RR6AWg7zJvVnb5ZjR3WgOeqUZNd2YZ/yNdtCNt9UNF8wpJxz6mnj6', 'user@mail.ru'),
                         (2, 20, 'Admin', 'Adminov', '$2a$12$fMOkFRqABvhb64ZFzj5rRe0quUZuPG.wZV29ElNdAOE.drtleYW3y', 'admin@mail.ru');

INSERT INTO users_roles VALUES (1, 1),
                               (2, 1),
                               (2, 2);