INSERT INTO roleuser
(id, namerole)
SELECT 1, 'CUSTOMER'
    WHERE
    NOT EXISTS (
            SELECT id FROM roleuser WHERE id = 1
        );

INSERT INTO roleuser
(id, namerole)
SELECT 2, 'ADMIN'
    WHERE
    NOT EXISTS (
            SELECT id FROM roleuser WHERE id = 2
        );

INSERT INTO roleuser
(id, namerole)
SELECT 3, 'MODERATOR'
    WHERE
    NOT EXISTS (
            SELECT id FROM roleuser WHERE id = 3
        );