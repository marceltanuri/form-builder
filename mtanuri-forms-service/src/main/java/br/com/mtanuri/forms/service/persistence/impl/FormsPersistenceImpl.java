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

package br.com.mtanuri.forms.service.persistence.impl;

import br.com.mtanuri.forms.exception.NoSuchFormsException;
import br.com.mtanuri.forms.model.Forms;
import br.com.mtanuri.forms.model.impl.FormsImpl;
import br.com.mtanuri.forms.model.impl.FormsModelImpl;
import br.com.mtanuri.forms.service.persistence.FormsPersistence;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.util.OrderByComparator;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.sql.DataSource;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;







/**
 * The persistence implementation for the forms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FormsPersistence.class)
public class FormsPersistenceImpl
	extends BasePersistenceImpl<Forms> implements FormsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FormsUtil</code> to access the forms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FormsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the formses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching formses
	 */
	@Override
	public List<Forms> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Forms> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Forms> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Forms> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Forms> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Forms> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Forms> list = null;

		if (useFinderCache) {
			list = (List<Forms>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Forms forms : list) {
					if (groupId != forms.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FORMS_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Forms>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	@Override
	public Forms findByGroupId_First(
			long groupId, OrderByComparator<Forms> orderByComparator)
		throws NoSuchFormsException {

		Forms forms = fetchByGroupId_First(groupId, orderByComparator);

		if (forms != null) {
			return forms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchFormsException(sb.toString());
	}

	/**
	 * Returns the first forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms, or <code>null</code> if a matching forms could not be found
	 */
	@Override
	public Forms fetchByGroupId_First(
		long groupId, OrderByComparator<Forms> orderByComparator) {

		List<Forms> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms
	 * @throws NoSuchFormsException if a matching forms could not be found
	 */
	@Override
	public Forms findByGroupId_Last(
			long groupId, OrderByComparator<Forms> orderByComparator)
		throws NoSuchFormsException {

		Forms forms = fetchByGroupId_Last(groupId, orderByComparator);

		if (forms != null) {
			return forms;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchFormsException(sb.toString());
	}

	/**
	 * Returns the last forms in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms, or <code>null</code> if a matching forms could not be found
	 */
	@Override
	public Forms fetchByGroupId_Last(
		long groupId, OrderByComparator<Forms> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Forms> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Forms[] findByGroupId_PrevAndNext(
			long formId, long groupId,
			OrderByComparator<Forms> orderByComparator)
		throws NoSuchFormsException {

		Forms forms = findByPrimaryKey(formId);

		Session session = null;

		try {
			session = openSession();

			Forms[] array = new FormsImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, forms, groupId, orderByComparator, true);

			array[1] = forms;

			array[2] = getByGroupId_PrevAndNext(
				session, forms, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Forms getByGroupId_PrevAndNext(
		Session session, Forms forms, long groupId,
		OrderByComparator<Forms> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FORMS_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FormsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(forms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Forms> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the formses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Forms forms :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(forms);
		}
	}

	/**
	 * Returns the number of formses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching formses
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FORMS_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"forms.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_F;
	private FinderPath _finderPathWithoutPaginationFindByG_F;
	private FinderPath _finderPathCountByG_F;

	/**
	 * Returns all the formses where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @return the matching formses
	 */
	@Override
	public List<Forms> findByG_F(long groupId, String formName) {
		return findByG_F(
			groupId, formName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Forms> findByG_F(
		long groupId, String formName, int start, int end) {

		return findByG_F(groupId, formName, start, end, null);
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
	@Override
	public List<Forms> findByG_F(
		long groupId, String formName, int start, int end,
		OrderByComparator<Forms> orderByComparator) {

		return findByG_F(
			groupId, formName, start, end, orderByComparator, true);
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
	@Override
	public List<Forms> findByG_F(
		long groupId, String formName, int start, int end,
		OrderByComparator<Forms> orderByComparator, boolean useFinderCache) {

		formName = Objects.toString(formName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_F;
				finderArgs = new Object[] {groupId, formName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_F;
			finderArgs = new Object[] {
				groupId, formName, start, end, orderByComparator
			};
		}

		List<Forms> list = null;

		if (useFinderCache) {
			list = (List<Forms>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Forms forms : list) {
					if ((groupId != forms.getGroupId()) ||
						!formName.equals(forms.getFormName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_FORMS_WHERE);

			sb.append(_FINDER_COLUMN_G_F_GROUPID_2);

			boolean bindFormName = false;

			if (formName.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_F_FORMNAME_3);
			}
			else {
				bindFormName = true;

				sb.append(_FINDER_COLUMN_G_F_FORMNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindFormName) {
					queryPos.add(formName);
				}

				list = (List<Forms>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Forms findByG_F_First(
			long groupId, String formName,
			OrderByComparator<Forms> orderByComparator)
		throws NoSuchFormsException {

		Forms forms = fetchByG_F_First(groupId, formName, orderByComparator);

		if (forms != null) {
			return forms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", formName=");
		sb.append(formName);

		sb.append("}");

		throw new NoSuchFormsException(sb.toString());
	}

	/**
	 * Returns the first forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching forms, or <code>null</code> if a matching forms could not be found
	 */
	@Override
	public Forms fetchByG_F_First(
		long groupId, String formName,
		OrderByComparator<Forms> orderByComparator) {

		List<Forms> list = findByG_F(
			groupId, formName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Forms findByG_F_Last(
			long groupId, String formName,
			OrderByComparator<Forms> orderByComparator)
		throws NoSuchFormsException {

		Forms forms = fetchByG_F_Last(groupId, formName, orderByComparator);

		if (forms != null) {
			return forms;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", formName=");
		sb.append(formName);

		sb.append("}");

		throw new NoSuchFormsException(sb.toString());
	}

	/**
	 * Returns the last forms in the ordered set where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching forms, or <code>null</code> if a matching forms could not be found
	 */
	@Override
	public Forms fetchByG_F_Last(
		long groupId, String formName,
		OrderByComparator<Forms> orderByComparator) {

		int count = countByG_F(groupId, formName);

		if (count == 0) {
			return null;
		}

		List<Forms> list = findByG_F(
			groupId, formName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Forms[] findByG_F_PrevAndNext(
			long formId, long groupId, String formName,
			OrderByComparator<Forms> orderByComparator)
		throws NoSuchFormsException {

		formName = Objects.toString(formName, "");

		Forms forms = findByPrimaryKey(formId);

		Session session = null;

		try {
			session = openSession();

			Forms[] array = new FormsImpl[3];

			array[0] = getByG_F_PrevAndNext(
				session, forms, groupId, formName, orderByComparator, true);

			array[1] = forms;

			array[2] = getByG_F_PrevAndNext(
				session, forms, groupId, formName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Forms getByG_F_PrevAndNext(
		Session session, Forms forms, long groupId, String formName,
		OrderByComparator<Forms> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FORMS_WHERE);

		sb.append(_FINDER_COLUMN_G_F_GROUPID_2);

		boolean bindFormName = false;

		if (formName.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_F_FORMNAME_3);
		}
		else {
			bindFormName = true;

			sb.append(_FINDER_COLUMN_G_F_FORMNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FormsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindFormName) {
			queryPos.add(formName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(forms)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Forms> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the formses where groupId = &#63; and formName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 */
	@Override
	public void removeByG_F(long groupId, String formName) {
		for (Forms forms :
				findByG_F(
					groupId, formName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(forms);
		}
	}

	/**
	 * Returns the number of formses where groupId = &#63; and formName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param formName the form name
	 * @return the number of matching formses
	 */
	@Override
	public int countByG_F(long groupId, String formName) {
		formName = Objects.toString(formName, "");

		FinderPath finderPath = _finderPathCountByG_F;

		Object[] finderArgs = new Object[] {groupId, formName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMS_WHERE);

			sb.append(_FINDER_COLUMN_G_F_GROUPID_2);

			boolean bindFormName = false;

			if (formName.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_F_FORMNAME_3);
			}
			else {
				bindFormName = true;

				sb.append(_FINDER_COLUMN_G_F_FORMNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindFormName) {
					queryPos.add(formName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_F_GROUPID_2 =
		"forms.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_F_FORMNAME_2 =
		"forms.formName = ?";

	private static final String _FINDER_COLUMN_G_F_FORMNAME_3 =
		"(forms.formName IS NULL OR forms.formName = '')";

	public FormsPersistenceImpl() {
		setModelClass(Forms.class);

		setModelImplClass(FormsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the forms in the entity cache if it is enabled.
	 *
	 * @param forms the forms
	 */
	@Override
	public void cacheResult(Forms forms) {
		entityCache.putResult(
			entityCacheEnabled, FormsImpl.class, forms.getPrimaryKey(), forms);

		forms.resetOriginalValues();
	}

	/**
	 * Caches the formses in the entity cache if it is enabled.
	 *
	 * @param formses the formses
	 */
	@Override
	public void cacheResult(List<Forms> formses) {
		for (Forms forms : formses) {
			if (entityCache.getResult(
					entityCacheEnabled, FormsImpl.class,
					forms.getPrimaryKey()) == null) {

				cacheResult(forms);
			}
			else {
				forms.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all formses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FormsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the forms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Forms forms) {
		entityCache.removeResult(
			entityCacheEnabled, FormsImpl.class, forms.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Forms> formses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Forms forms : formses) {
			entityCache.removeResult(
				entityCacheEnabled, FormsImpl.class, forms.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, FormsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new forms with the primary key. Does not add the forms to the database.
	 *
	 * @param formId the primary key for the new forms
	 * @return the new forms
	 */
	@Override
	public Forms create(long formId) {
		Forms forms = new FormsImpl();

		forms.setNew(true);
		forms.setPrimaryKey(formId);

		return forms;
	}

	/**
	 * Removes the forms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms that was removed
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	@Override
	public Forms remove(long formId) throws NoSuchFormsException {
		return remove((Serializable)formId);
	}

	/**
	 * Removes the forms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the forms
	 * @return the forms that was removed
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	@Override
	public Forms remove(Serializable primaryKey) throws NoSuchFormsException {
		Session session = null;

		try {
			session = openSession();

			Forms forms = (Forms)session.get(FormsImpl.class, primaryKey);

			if (forms == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(forms);
		}
		catch (NoSuchFormsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Forms removeImpl(Forms forms) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(forms)) {
				forms = (Forms)session.get(
					FormsImpl.class, forms.getPrimaryKeyObj());
			}

			if (forms != null) {
				session.delete(forms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (forms != null) {
			clearCache(forms);
		}

		return forms;
	}

	@Override
	public Forms updateImpl(Forms forms) {
		boolean isNew = forms.isNew();

		if (!(forms instanceof FormsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(forms.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(forms);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in forms proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Forms implementation " +
					forms.getClass());
		}

		FormsModelImpl formsModelImpl = (FormsModelImpl)forms;

		Session session = null;

		try {
			session = openSession();

			if (forms.isNew()) {
				session.save(forms);

				forms.setNew(false);
			}
			else {
				forms = (Forms)session.merge(forms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {formsModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				formsModelImpl.getGroupId(), formsModelImpl.getFormName()
			};

			finderCache.removeResult(_finderPathCountByG_F, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_F, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((formsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					formsModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {formsModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((formsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_F.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					formsModelImpl.getOriginalGroupId(),
					formsModelImpl.getOriginalFormName()
				};

				finderCache.removeResult(_finderPathCountByG_F, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_F, args);

				args = new Object[] {
					formsModelImpl.getGroupId(), formsModelImpl.getFormName()
				};

				finderCache.removeResult(_finderPathCountByG_F, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_F, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, FormsImpl.class, forms.getPrimaryKey(), forms,
			false);

		forms.resetOriginalValues();

		return forms;
	}

	/**
	 * Returns the forms with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the forms
	 * @return the forms
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	@Override
	public Forms findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormsException {

		Forms forms = fetchByPrimaryKey(primaryKey);

		if (forms == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return forms;
	}

	/**
	 * Returns the forms with the primary key or throws a <code>NoSuchFormsException</code> if it could not be found.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms
	 * @throws NoSuchFormsException if a forms with the primary key could not be found
	 */
	@Override
	public Forms findByPrimaryKey(long formId) throws NoSuchFormsException {
		return findByPrimaryKey((Serializable)formId);
	}

	/**
	 * Returns the forms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formId the primary key of the forms
	 * @return the forms, or <code>null</code> if a forms with the primary key could not be found
	 */
	@Override
	public Forms fetchByPrimaryKey(long formId) {
		return fetchByPrimaryKey((Serializable)formId);
	}

	/**
	 * Returns all the formses.
	 *
	 * @return the formses
	 */
	@Override
	public List<Forms> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Forms> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Forms> findAll(
		int start, int end, OrderByComparator<Forms> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Forms> findAll(
		int start, int end, OrderByComparator<Forms> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Forms> list = null;

		if (useFinderCache) {
			list = (List<Forms>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FORMS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FORMS;

				sql = sql.concat(FormsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Forms>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the formses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Forms forms : findAll()) {
			remove(forms);
		}
	}

	/**
	 * Returns the number of formses.
	 *
	 * @return the number of formses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FORMS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "formId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FORMS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FormsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the forms persistence.
	 */
	@Activate
	public void activate() {
		FormsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		FormsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FormsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FormsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FormsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FormsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			FormsModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FormsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_F",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, FormsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_F",
			new String[] {Long.class.getName(), String.class.getName()},
			FormsModelImpl.GROUPID_COLUMN_BITMASK |
			FormsModelImpl.FORMNAME_COLUMN_BITMASK);

		_finderPathCountByG_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_F",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(FormsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = MTANURIPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.br.com.mtanuri.forms.model.Forms"),
			true);
	}

	@Override
	@Reference(
		target = MTANURIPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MTANURIPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FORMS =
		"SELECT forms FROM Forms forms";

	private static final String _SQL_SELECT_FORMS_WHERE =
		"SELECT forms FROM Forms forms WHERE ";

	private static final String _SQL_COUNT_FORMS =
		"SELECT COUNT(forms) FROM Forms forms";

	private static final String _SQL_COUNT_FORMS_WHERE =
		"SELECT COUNT(forms) FROM Forms forms WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "forms.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Forms exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Forms exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FormsPersistenceImpl.class);

	static {
		try {
			Class.forName(MTANURIPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}