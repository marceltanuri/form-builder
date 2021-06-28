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

import com.liferay.portal.kernel.util.Accessor;


/**
 * The extended model interface for the Forms service. Represents a row in the &quot;MTANURI_Forms&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FormsModel
 * @generated
 */
@ImplementationClassName("br.com.mtanuri.forms.model.impl.FormsImpl")
@ProviderType
public interface Forms extends FormsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>br.com.mtanuri.forms.model.impl.FormsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Forms, Long> FORM_ID_ACCESSOR =
		new Accessor<Forms, Long>() {

			@Override
			public Long get(Forms forms) {
				return forms.getFormId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Forms> getTypeClass() {
				return Forms.class;
			}

		};

}