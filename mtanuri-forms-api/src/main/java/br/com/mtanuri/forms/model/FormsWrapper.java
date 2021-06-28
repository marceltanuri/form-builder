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
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * This class is a wrapper for {@link Forms}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Forms
 * @generated
 */
public class FormsWrapper
	extends BaseModelWrapper<Forms> implements Forms, ModelWrapper<Forms> {

	public FormsWrapper(Forms forms) {
		super(forms);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formId", getFormId());
		attributes.put("groupId", getGroupId());
		attributes.put("formName", getFormName());
		attributes.put("createDateTime", getCreateDateTime());
		attributes.put("content", getContent());
		attributes.put("files", getFiles());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String formName = (String)attributes.get("formName");

		if (formName != null) {
			setFormName(formName);
		}

		Long createDateTime = (Long)attributes.get("createDateTime");

		if (createDateTime != null) {
			setCreateDateTime(createDateTime);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String files = (String)attributes.get("files");

		if (files != null) {
			setFiles(files);
		}
	}

	/**
	 * Returns the content of this forms.
	 *
	 * @return the content of this forms
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the create date time of this forms.
	 *
	 * @return the create date time of this forms
	 */
	@Override
	public long getCreateDateTime() {
		return model.getCreateDateTime();
	}

	/**
	 * Returns the files of this forms.
	 *
	 * @return the files of this forms
	 */
	@Override
	public String getFiles() {
		return model.getFiles();
	}

	/**
	 * Returns the form ID of this forms.
	 *
	 * @return the form ID of this forms
	 */
	@Override
	public long getFormId() {
		return model.getFormId();
	}

	/**
	 * Returns the form name of this forms.
	 *
	 * @return the form name of this forms
	 */
	@Override
	public String getFormName() {
		return model.getFormName();
	}

	/**
	 * Returns the group ID of this forms.
	 *
	 * @return the group ID of this forms
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this forms.
	 *
	 * @return the primary key of this forms
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the content of this forms.
	 *
	 * @param content the content of this forms
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the create date time of this forms.
	 *
	 * @param createDateTime the create date time of this forms
	 */
	@Override
	public void setCreateDateTime(long createDateTime) {
		model.setCreateDateTime(createDateTime);
	}

	/**
	 * Sets the files of this forms.
	 *
	 * @param files the files of this forms
	 */
	@Override
	public void setFiles(String files) {
		model.setFiles(files);
	}

	/**
	 * Sets the form ID of this forms.
	 *
	 * @param formId the form ID of this forms
	 */
	@Override
	public void setFormId(long formId) {
		model.setFormId(formId);
	}

	/**
	 * Sets the form name of this forms.
	 *
	 * @param formName the form name of this forms
	 */
	@Override
	public void setFormName(String formName) {
		model.setFormName(formName);
	}

	/**
	 * Sets the group ID of this forms.
	 *
	 * @param groupId the group ID of this forms
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this forms.
	 *
	 * @param primaryKey the primary key of this forms
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected FormsWrapper wrap(Forms forms) {
		return new FormsWrapper(forms);
	}

}