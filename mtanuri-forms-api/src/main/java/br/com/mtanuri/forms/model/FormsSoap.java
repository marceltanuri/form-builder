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

package br.com.mtanuri.forms.model;

import br.com.mtanuri.forms.model.Forms;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FormsSoap implements Serializable {

	public static FormsSoap toSoapModel(Forms model) {
		FormsSoap soapModel = new FormsSoap();

		soapModel.setFormId(model.getFormId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setFormName(model.getFormName());
		soapModel.setCreateDateTime(model.getCreateDateTime());
		soapModel.setContent(model.getContent());
		soapModel.setFiles(model.getFiles());

		return soapModel;
	}

	public static FormsSoap[] toSoapModels(Forms[] models) {
		FormsSoap[] soapModels = new FormsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FormsSoap[][] toSoapModels(Forms[][] models) {
		FormsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FormsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FormsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FormsSoap[] toSoapModels(List<Forms> models) {
		List<FormsSoap> soapModels = new ArrayList<FormsSoap>(models.size());

		for (Forms model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FormsSoap[soapModels.size()]);
	}

	public FormsSoap() {
	}

	public long getPrimaryKey() {
		return _formId;
	}

	public void setPrimaryKey(long pk) {
		setFormId(pk);
	}

	public long getFormId() {
		return _formId;
	}

	public void setFormId(long formId) {
		_formId = formId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getFormName() {
		return _formName;
	}

	public void setFormName(String formName) {
		_formName = formName;
	}

	public long getCreateDateTime() {
		return _createDateTime;
	}

	public void setCreateDateTime(long createDateTime) {
		_createDateTime = createDateTime;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getFiles() {
		return _files;
	}

	public void setFiles(String files) {
		_files = files;
	}

	private long _formId;
	private long _groupId;
	private String _formName;
	private long _createDateTime;
	private String _content;
	private String _files;

}