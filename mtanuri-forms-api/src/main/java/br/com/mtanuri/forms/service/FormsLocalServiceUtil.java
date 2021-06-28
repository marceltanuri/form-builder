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
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Forms. This utility wraps
 * <code>br.com.mtanuri.forms.service.impl.FormsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FormsLocalService
 * @generated
 */
public class FormsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.mtanuri.forms.service.impl.FormsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static br.com.mtanuri.forms.model.Forms addForm(
		br.com.mtanuri.forms.model.Forms forms) {

		return getService().addForm(forms);
	}

	public static br.com.mtanuri.forms.model.Forms addForm(
		long groupId, String formName, String content) {

		return getService().addForm(groupId, formName, content);
	}

	public static br.com.mtanuri.forms.model.Forms addForm(
		long groupId, String formName, String content, String[] files) {

		return getService().addForm(groupId, formName, content, files);
	}

	/**
	 * Adds the forms to the database. Also notifies the appropriate model listeners.
	 *
	 * @param forms the forms
	 * @return the forms that was added
	 */
	public static br.com.mtanuri.forms.model.Forms addForms(
		br.com.mtanuri.forms.model.Forms forms) {

		return getService().addForms(forms);
	}

	/**
	 * Creates a new forms with the primary key. Does not add the forms to the database.
	 *
	 * @param formId the primary key for the new forms
	 * @return the new forms
	 */
	public static br.com.mtanuri.forms.model.Forms createForms(long formId) {
		return getService().createForms(formId);
	}

	/**
	 * Deletes the forms from the database. Also notifies the appropriate model listeners.
	 *
	 * @param forms the forms
	 * @return the forms that was removed
	 */
	public static br.com.mtanuri.forms.model.Forms deleteForms(
		br.com.mtanuri.forms.model.Forms forms) {

		return getService().deleteForms(forms);
	}

	/**
	 * Deletes the forms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms that was removed
	 * @throws PortalException if a forms with the primary key could not be found
	 */
	public static br.com.mtanuri.forms.model.Forms deleteForms(long formId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteForms(formId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static br.com.mtanuri.forms.model.Forms fetchForms(long formId) {
		return getService().fetchForms(formId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the forms with the primary key.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms
	 * @throws PortalException if a forms with the primary key could not be found
	 */
	public static br.com.mtanuri.forms.model.Forms getForms(long formId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getForms(formId);
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
	public static java.util.List<br.com.mtanuri.forms.model.Forms> getFormses(
		int start, int end) {

		return getService().getFormses(start, end);
	}

	/**
	 * Returns the number of formses.
	 *
	 * @return the number of formses
	 */
	public static int getFormsesCount() {
		return getService().getFormsesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the forms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param forms the forms
	 * @return the forms that was updated
	 */
	public static br.com.mtanuri.forms.model.Forms updateForms(
		br.com.mtanuri.forms.model.Forms forms) {

		return getService().updateForms(forms);
	}

	public static FormsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FormsLocalService, FormsLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FormsLocalService.class);

		ServiceTracker<FormsLocalService, FormsLocalService> serviceTracker =
			new ServiceTracker<FormsLocalService, FormsLocalService>(
				bundle.getBundleContext(), FormsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}