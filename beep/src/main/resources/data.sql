INSERT INTO `Role` (name)
VALUES
    ('ROLE_ADMIN'),
    ('ROLE_DEVELOPER'),
    ('ROLE_STAFF'),
    ('ROLE_USER');

INSERT INTO `User` (email, firstName, lastName, password, username)
VALUES
    ('admin@cosmic.com', '어드민', '계정', '1234', 'admin'),
    ('developer@cosmic.com', '개발자', '계정', '1234', 'developer'),
    ('staff@cosmic.com', '관리자', '계정', '1234', 'staff');

INSERT INTO `user_role` (user_id, role_id)
VALUES
    ((SELECT id from `User` where username = 'admin'), (SELECT id from `Role` where name = 'ROLE_ADMIN')),
    ((SELECT id from `User` where username = 'developer'), (SELECT id from `Role` where name = 'ROLE_DEVELOPER')),
    ((SELECT id from `User` where username = 'staff'), (SELECT id from `Role` where name = 'ROLE_STAFF'));