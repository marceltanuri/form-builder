create table MTANURI_Forms (
	formId NUMERIC not null primary key,
	groupId NUMERIC,
    formName VARCHAR(75) null,
	subject VARCHAR(75) null,
	createDateTime NUMERIC,
	authorGivenName VARCHAR(75) null,
	authorEmailAddress VARCHAR(75) null,
	content CLOB null,
	userName VARCHAR(75) null,
	userId NUMERIC,
	files VARCHAR(1000) null
);