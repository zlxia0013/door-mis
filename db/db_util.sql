--insert role authority of admin
DELETE FROM t_role_authority
WHERE role = 'ADMIN';

INSERT INTO t_role_authority(role, authority)
SELECT 'ADMIN', NAME
FROM t_authority
WHERE for_all=0;