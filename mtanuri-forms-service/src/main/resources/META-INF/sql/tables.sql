create table MTANURI_Forms (
	formId LONG not null primary key,
	groupId LONG,
	formName VARCHAR(75) null,
	createDateTime LONG,
	content LONGTEXT null,
	files VARCHAR(4000) null
);