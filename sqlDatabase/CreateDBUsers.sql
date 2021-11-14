CREATE USER 'cs363'@'%%' IDENTIFIED WITH mysql_native_password BY 'cs363Password';

GRANT SELECT ON group50.* TO 'cs363'@'%%';

GRANT SHOW VIEW ON group50.* TO 'cs363'@'%%';

GRANT DROP ON group50.* TO 'cs363'@'%%';

GRANT CREATE ON group50.* TO 'cs363'@'%%';

GRANT INSERT ON group50.* TO 'cs363'@'%%';

GRANT DELETE ON group50.* TO 'cs363'@'%%';

GRANT TRIGGER ON group50.* TO 'cs363'@'%%';