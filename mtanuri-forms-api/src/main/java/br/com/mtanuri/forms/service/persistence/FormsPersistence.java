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

import br.com.mtanuri.forms.exception.NoSuchFormsException;
import br.com.mtanuri.forms.model.Forms;



/**
 * The persistence interface for the forms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FormsUtil
 * @generated
 */
@ProviderType
public interface FormsPersistence extends BasePersistence<Forms> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormsUtil} to access the forms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the formses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching formses
	 */
	public java.util.List<Forms> findByGroupId(long groupId);

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
	public java.util.List<Forms> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Forms> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator);

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
	public java.util.List<Forms> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	public Forms findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Forms>
				orderByComparator)
		throws NoSuchFormsException;

	/**
	 * Returns the first forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms, or <code>null</code> if a matching forms could not be found
	 */
	public Forms fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator);

	/**
	 * Returns the last forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	public Forms findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Forms>
				orderByComparator)
		throws NoSuchFormsException;

	/**
	 * Returns the last forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms, or <code>null</code> if a matching forms could not be found
	 */
	public Forms fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator);

	/**
	 * Returns the formses before and after the current forms in the ordered set where groupId = &#63;.
	 *
	 * @param formId the primary key of the current forms
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next forms
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	public Forms[] findByGroupId_PrevAndNext(
			long formId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Forms>
				orderByComparator)
		throws NoSuchFormsException;

	/**
	 * Removes all the formses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of formses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching formses
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the formses where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @return the matching formses
	 */
	public java.util.List<Forms> findByG_F(long groupId, String formName);

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
	public java.util.List<Forms> findByG_F(
		long groupId, String formName, int start, int end);

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
	public java.util.List<Forms> findByG_F(
		long groupId, String formName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator);

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
	public java.util.List<Forms> findByG_F(
		long groupId, String formName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	public Forms findByG_F_First(
			long groupId, String formName,
			com.liferay.portal.kernel.util.OrderByComparator<Forms>
				orderByComparator)
		throws NoSuchFormsException;

	/**
	 * Returns the first forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms, or <code>null</code> if a matching forms could not be found
	 */
	public Forms fetchByG_F_First(
		long groupId, String formName,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator);

	/**
	 * Returns the last forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	public Forms findByG_F_Last(
			long groupId, String formName,
			com.liferay.portal.kernel.util.OrderByComparator<Forms>
				orderByComparator)
		throws NoSuchFormsException;

	/**
	 * Returns the last forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms, or <code>null</code> if a matching forms could not be found
	 */
	public Forms fetchByG_F_Last(
		long groupId, String formName,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator);

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
	public Forms[] findByG_F_PrevAndNext(
			long formId, long groupId, String formName,
			com.liferay.portal.kernel.util.OrderByComparator<Forms>
				orderByComparator)
		throws NoSuchFormsException;

	/**
	 * Removes all the formses where groupId = &#63; and formName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 */
	public void removeByG_F(long groupId, String formName);

	/**
	 * Returns the number of formses where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @return the number of matching formses
	 */
	public int countByG_F(long groupId, String formName);

	/**
	 * Caches the forms in the entity cache if it is enabled.
	 *
	 * @param forms the forms
	 */
	public void cacheResult(Forms forms);

	/**
	 * Caches the formses in the entity cache if it is enabled.
	 *
	 * @param formses the formses
	 */
	public void cacheResult(java.util.List<Forms> formses);

	/**
	 * Creates a new forms with the primary key. Does not add the forms to the database.
	 *
	 * @param formId the primary key for the new forms
	 * @return the new forms
	 */
	public Forms create(long formId);

	/**
	 * Removes the forms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms that was removed
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	public Forms remove(long formId) throws NoSuchFormsException;

	public Forms updateImpl(Forms forms);

	/**
	 * Returns the forms with the primary key or throws a <code>NoSuchFormsException</code> if it could not be found.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	public Forms findByPrimaryKey(long formId) throws NoSuchFormsException;

	/**
	 * Returns the forms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms, or <code>null</code> if a forms with the primary key could not be found
	 */
	public Forms fetchByPrimaryKey(long formId);

	/**
	 * Returns all the formses.
	 *
	 * @return the formses
	 */
	public java.util.List<Forms> findAll();

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
	public java.util.List<Forms> findAll(int start, int end);

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
	public java.util.List<Forms> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator);

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
	public java.util.List<Forms> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Forms>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the formses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of formses.
	 *
	 * @return the number of formses
	 */
	public int countAll();

}