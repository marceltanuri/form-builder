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

package br.com.mtanuri.forms.service.persistence;

import br.com.mtanuri.forms.model.Forms;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;





/**
 * The persistence utility for the forms service. This utility wraps <code>br.com.mtanuri.forms.service.persistence.impl.FormsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormsPersistence
 * @generated
 */
public class FormsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Forms forms) {
		getPersistence().clearCache(forms);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Forms> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Forms> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Forms> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Forms> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Forms> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Forms update(Forms forms) {
		return getPersistence().update(forms);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Forms update(Forms forms, ServiceContext serviceContext) {
		return getPersistence().update(forms, serviceContext);
	}

	/**
	 * Returns all the formses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching formses
	 */
	public static List<Forms> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the formses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @return the range of matching formses
	 */
	public static List<Forms> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the formses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching formses
	 */
	public static List<Forms> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Forms> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the formses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching formses
	 */
	public static List<Forms> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Forms> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	public static Forms findByGroupId_First(
			long groupId, OrderByComparator<Forms> orderByComparator)
		throws br.com.mtanuri.forms.exception.NoSuchFormsException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms, or <code>null</code> if a matching forms could not be found
	 */
	public static Forms fetchByGroupId_First(
		long groupId, OrderByComparator<Forms> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	public static Forms findByGroupId_Last(
			long groupId, OrderByComparator<Forms> orderByComparator)
		throws br.com.mtanuri.forms.exception.NoSuchFormsException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms, or <code>null</code> if a matching forms could not be found
	 */
	public static Forms fetchByGroupId_Last(
		long groupId, OrderByComparator<Forms> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the formses before and after the current forms in the ordered set where groupId = &#63;.
	 *
	 * @param formId the primary key of the current forms
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next forms
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	public static Forms[] findByGroupId_PrevAndNext(
			long formId, long groupId,
			OrderByComparator<Forms> orderByComparator)
		throws br.com.mtanuri.forms.exception.NoSuchFormsException {

		return getPersistence().findByGroupId_PrevAndNext(
			formId, groupId, orderByComparator);
	}

	/**
	 * Removes all the formses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of formses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching formses
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the formses where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @return the matching formses
	 */
	public static List<Forms> findByG_F(long groupId, String formName) {
		return getPersistence().findByG_F(groupId, formName);
	}

	/**
	 * Returns a range of all the formses where groupId = &#63; and formName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @return the range of matching formses
	 */
	public static List<Forms> findByG_F(
		long groupId, String formName, int start, int end) {

		return getPersistence().findByG_F(groupId, formName, start, end);
	}

	/**
	 * Returns an ordered range of all the formses where groupId = &#63; and formName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching formses
	 */
	public static List<Forms> findByG_F(
		long groupId, String formName, int start, int end,
		OrderByComparator<Forms> orderByComparator) {

		return getPersistence().findByG_F(
			groupId, formName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the formses where groupId = &#63; and formName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching formses
	 */
	public static List<Forms> findByG_F(
		long groupId, String formName, int start, int end,
		OrderByComparator<Forms> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_F(
			groupId, formName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	public static Forms findByG_F_First(
			long groupId, String formName,
			OrderByComparator<Forms> orderByComparator)
		throws br.com.mtanuri.forms.exception.NoSuchFormsException {

		return getPersistence().findByG_F_First(
			groupId, formName, orderByComparator);
	}

	/**
	 * Returns the first forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms, or <code>null</code> if a matching forms could not be found
	 */
	public static Forms fetchByG_F_First(
		long groupId, String formName,
		OrderByComparator<Forms> orderByComparator) {

		return getPersistence().fetchByG_F_First(
			groupId, formName, orderByComparator);
	}

	/**
	 * Returns the last forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	public static Forms findByG_F_Last(
			long groupId, String formName,
			OrderByComparator<Forms> orderByComparator)
		throws br.com.mtanuri.forms.exception.NoSuchFormsException {

		return getPersistence().findByG_F_Last(
			groupId, formName, orderByComparator);
	}

	/**
	 * Returns the last forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms, or <code>null</code> if a matching forms could not be found
	 */
	public static Forms fetchByG_F_Last(
		long groupId, String formName,
		OrderByComparator<Forms> orderByComparator) {

		return getPersistence().fetchByG_F_Last(
			groupId, formName, orderByComparator);
	}

	/**
	 * Returns the formses before and after the current forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param formId the primary key of the current forms
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next forms
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	public static Forms[] findByG_F_PrevAndNext(
			long formId, long groupId, String formName,
			OrderByComparator<Forms> orderByComparator)
		throws br.com.mtanuri.forms.exception.NoSuchFormsException {

		return getPersistence().findByG_F_PrevAndNext(
			formId, groupId, formName, orderByComparator);
	}

	/**
	 * Removes all the formses where groupId = &#63; and formName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 */
	public static void removeByG_F(long groupId, String formName) {
		getPersistence().removeByG_F(groupId, formName);
	}

	/**
	 * Returns the number of formses where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @return the number of matching formses
	 */
	public static int countByG_F(long groupId, String formName) {
		return getPersistence().countByG_F(groupId, formName);
	}

	/**
	 * Caches the forms in the entity cache if it is enabled.
	 *
	 * @param forms the forms
	 */
	public static void cacheResult(Forms forms) {
		getPersistence().cacheResult(forms);
	}

	/**
	 * Caches the formses in the entity cache if it is enabled.
	 *
	 * @param formses the formses
	 */
	public static void cacheResult(List<Forms> formses) {
		getPersistence().cacheResult(formses);
	}

	/**
	 * Creates a new forms with the primary key. Does not add the forms to the database.
	 *
	 * @param formId the primary key for the new forms
	 * @return the new forms
	 */
	public static Forms create(long formId) {
		return getPersistence().create(formId);
	}

	/**
	 * Removes the forms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms that was removed
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	public static Forms remove(long formId)
		throws br.com.mtanuri.forms.exception.NoSuchFormsException {

		return getPersistence().remove(formId);
	}

	public static Forms updateImpl(Forms forms) {
		return getPersistence().updateImpl(forms);
	}

	/**
	 * Returns the forms with the primary key or throws a <code>NoSuchFormsException</code> if it could not be found.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	public static Forms findByPrimaryKey(long formId)
		throws br.com.mtanuri.forms.exception.NoSuchFormsException {

		return getPersistence().findByPrimaryKey(formId);
	}

	/**
	 * Returns the forms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms, or <code>null</code> if a forms with the primary key could not be found
	 */
	public static Forms fetchByPrimaryKey(long formId) {
		return getPersistence().fetchByPrimaryKey(formId);
	}

	/**
	 * Returns all the formses.
	 *
	 * @return the formses
	 */
	public static List<Forms> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the formses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @return the range of formses
	 */
	public static List<Forms> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the formses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of formses
	 */
	public static List<Forms> findAll(
		int start, int end, OrderByComparator<Forms> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the formses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of formses
	 * @param end the upper bound of the range of formses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of formses
	 */
	public static List<Forms> findAll(
		int start, int end, OrderByComparator<Forms> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the formses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of formses.
	 *
	 * @return the number of formses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FormsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FormsPersistence, FormsPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FormsPersistence.class);

		ServiceTracker<FormsPersistence, FormsPersistence> serviceTracker =
			new ServiceTracker<FormsPersistence, FormsPersistence>(
				bundle.getBundleContext(), FormsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}