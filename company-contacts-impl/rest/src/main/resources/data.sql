-- Addresses
INSERT INTO ADDRESS VALUES (1, 'Brussels', 'Brussels', 'Rue Haute', '1A');
INSERT INTO ADDRESS VALUES (2, 'Brussels', 'Jette', 'Rue de la Victoire', '10');
-- Contacts
INSERT INTO CONTACT VALUES (1, 'John', 'Doe', 'EMPLOYEE', null, 1);
INSERT INTO CONTACT VALUES (2, 'Jane', 'Doe', 'FREELANCE', 'BE1548632514', 1);
-- Companies
INSERT INTO COMPANY VALUES (1, 'The Company', 'BE1235621547', 2);
-- Companies contacts
INSERT INTO COMPANY_CONTACT VALUES (1, 1);
INSERT INTO COMPANY_CONTACT VALUES (1, 2);