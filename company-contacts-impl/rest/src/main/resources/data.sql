-- Addresses
INSERT INTO ADDRESS(ID, CITY, MUNICIPALITY, STREET_NAME, STREET_NUMBER)
VALUES (1, 'Brussels', 'Brussels', 'Rue Haute', '1A');
INSERT INTO ADDRESS(ID, CITY, MUNICIPALITY, STREET_NAME, STREET_NUMBER)
VALUES (2, 'Brussels', 'Uccle', 'Rue Stalle', '10');
INSERT INTO ADDRESS(ID, CITY, MUNICIPALITY, STREET_NAME, STREET_NUMBER)
VALUES (3, 'Brussels', 'Evere', 'Chaussée de Louvain', '900');
-- Contacts
INSERT INTO CONTACT(ID, FIRST_NAME, LAST_NAME, CONTACT_TYPE, VAT_NUMBER, ADDRESS_ID)
VALUES (1, 'John', 'Doe', 'EMPLOYEE', null, 1);
INSERT INTO CONTACT(ID, FIRST_NAME, LAST_NAME, CONTACT_TYPE, VAT_NUMBER, ADDRESS_ID)
VALUES (2, 'Jane', 'Doe', 'FREELANCE', 'BE1548632514', 2);
-- Companies
INSERT INTO COMPANY(ID, NAME, VAT_NUMBER, ADDRESS_ID)
VALUES (1, 'The Company', 'BE1235621547', 3);
-- Companies contacts
INSERT INTO COMPANY_CONTACT(COMPANY_ID, CONTACT_ID) VALUES (1, 1);
INSERT INTO COMPANY_CONTACT(COMPANY_ID, CONTACT_ID) VALUES (1, 2);