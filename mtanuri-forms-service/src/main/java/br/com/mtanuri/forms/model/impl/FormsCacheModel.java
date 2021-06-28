/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.mtanuri.forms.model.impl;

import br.com.mtanuri.forms.model.Forms;
import br.com.mtanuri.forms.model.impl.FormsImpl;
import com.liferay.petra.string.StringBundler;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;



/**
 * The cache model class for representing Forms in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FormsCacheModel implements CacheModel<Forms>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FormsCacheModel)) {
			return false;
		}

		FormsCacheModel formsCacheModel = (FormsCacheModel)object;

		if (formId == formsCacheModel.formId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, formId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{formId=");
		sb.append(formId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", formName=");
		sb.append(formName);
		sb.append(", createDateTime=");
		sb.append(createDateTime);
		sb.append(", content=");
		sb.append(content);
		sb.append(", files=");
		sb.append(files);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Forms toEntityModel() {
		FormsImpl formsImpl = new FormsImpl();

		formsImpl.setFormId(formId);
		formsImpl.setGroupId(groupId);

		if (formName == null) {
			formsImpl.setFormName("");
		}
		else {
			formsImpl.setFormName(formName);
		}

		formsImpl.setCreateDateTime(createDateTime);

		if (content == null) {
			formsImpl.setContent("");
		}
		else {
			formsImpl.setContent(content);
		}

		if (files == null) {
			formsImpl.setFiles("");
		}
		else {
			formsImpl.setFiles(files);
		}

		formsImpl.resetOriginalValues();

		return formsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		formId = objectInput.readLong();

		groupId = objectInput.readLong();
		formName = objectInput.readUTF();

		createDateTime = objectInput.readLong();
		content = objectInput.readUTF();
		files = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(formId);

		objectOutput.writeLong(groupId);

		if (formName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(formName);
		}

		objectOutput.writeLong(createDateTime);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (files == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(files);
		}
	}

	public long formId;
	public long groupId;
	public String formName;
	public long createDateTime;
	public String content;
	public String files;

}