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

package br.com.mtanuri.forms.service;

import br.com.mtanuri.forms.service.FormsLocalService;

/**
 * Provides a wrapper for {@link FormsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FormsLocalService
 * @generated
 */
public class FormsLocalServiceWrapper
	implements FormsLocalService, ServiceWrapper<FormsLocalService> {

	public FormsLocalServiceWrapper(FormsLocalService formsLocalService) {
		_formsLocalService = formsLocalService;
	}

	@Override
	public br.com.mtanuri.forms.model.Forms addForm(
		br.com.mtanuri.forms.model.Forms forms) {

		return _formsLocalService.addForm(forms);
	}

	@Override
	public br.com.mtanuri.forms.model.Forms addForm(
		long groupId, String formName, String content) {

		return _formsLocalService.addForm(groupId, formName, content);
	}

	@Override
	public br.com.mtanuri.forms.model.Forms addForm(
		long groupId, String formName, String content, String[] files) {

		return _formsLocalService.addForm(groupId, formName, content, files);
	}

	/**
	 * Adds the forms to the database. Also notifies the appropriate model listeners.
	 *
	 * @param forms the forms
	 * @return the forms that was added
	 */
	@Override
	public br.com.mtanuri.forms.model.Forms addForms(
		br.com.mtanuri.forms.model.Forms forms) {

		return _formsLocalService.addForms(forms);
	}

	/**
	 * Creates a new forms with the primary key. Does not add the forms to the database.
	 *
	 * @param formId the primary key for the new forms
	 * @return the new forms
	 */
	@Override
	public br.com.mtanuri.forms.model.Forms createForms(long formId) {
		return _formsLocalService.createForms(formId);
	}

	/**
	 * Deletes the forms from the database. Also notifies the appropriate model listeners.
	 *
	 * @param forms the forms
	 * @return the forms that was removed
	 */
	@Override
	public br.com.mtanuri.forms.model.Forms deleteForms(
		br.com.mtanuri.forms.model.Forms forms) {

		return _formsLocalService.deleteForms(forms);
	}

	/**
	 * Deletes the forms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms that was removed
	 * @throws PortalException if a forms with the primary key could not be found
	 */
	@Override
	public br.com.mtanuri.forms.model.Forms deleteForms(long formId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formsLocalService.deleteForms(formId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _formsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _formsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.mtanuri.forms.model.impl.FormsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _formsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.mtanuri.forms.model.impl.FormsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _formsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _formsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _formsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.mtanuri.forms.model.Forms fetchForms(long formId) {
		return _formsLocalService.fetchForms(formId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _formsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the forms with the primary key.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms
	 * @throws PortalException if a forms with the primary key could not be found
	 */
	@Override
	public br.com.mtanuri.forms.model.Forms getForms(long formId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formsLocalService.getForms(formId);
	}

	/**
	 * Returns a range of all the formses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.mtanuri.forms.model.impl.FormsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @return the range of formses
	 */
	@Override
	public java.util.List<br.com.mtanuri.forms.model.Forms> getFormses(
		int start, int end) {

		return _formsLocalService.getFormses(start, end);
	}

	/**
	 * Returns the number of formses.
	 *
	 * @return the number of formses
	 */
	@Override
	public int getFormsesCount() {
		return _formsLocalService.getFormsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _formsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _formsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _formsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the forms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param forms the forms
	 * @return the forms that was updated
	 */
	@Override
	public br.com.mtanuri.forms.model.Forms updateForms(
		br.com.mtanuri.forms.model.Forms forms) {

		return _formsLocalService.updateForms(forms);
	}

	@Override
	public FormsLocalService getWrappedService() {
		return _formsLocalService;
	}

	@Override
	public void setWrappedService(FormsLocalService formsLocalService) {
		_formsLocalService = formsLocalService;
	}

	private FormsLocalService _formsLocalService;

}