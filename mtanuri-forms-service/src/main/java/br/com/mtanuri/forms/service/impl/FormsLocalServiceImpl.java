/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.mtanuri.forms.service.impl;

import br.com.mtanuri.forms.model.Forms;
import br.com.mtanuri.forms.model.impl.FormsImpl;
import br.com.mtanuri.forms.service.FormsLocalService;
import br.com.mtanuri.forms.service.base.FormsLocalServiceBaseImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the forms local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>br.com.mtanuri.forms.service.FormsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author marceltanuri
 * @see FormsLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=br.com.mtanuri.forms.model.Forms",
        service = AopService.class
)
public class FormsLocalServiceImpl extends FormsLocalServiceBaseImpl {

    public Forms addForm(long groupId, String formName, String content) {
        return this.addForm(groupId, formName, content, null);
    }

    public Forms addForm(long groupId, String formName, String content, String[] files) {
        Forms forms = new FormsImpl();
        forms.setFormName(formName);
        forms.setCreateDateTime(System.currentTimeMillis());
        forms.setGroupId(groupId);
        forms.setContent(content);
        if (files != null && files.length > 0) {
            forms.setFiles(String.join(";", files));
        }
        return this.addForm(forms);
    }

    public Forms addForm(Forms forms) {
        forms.setFormId(counterLocalService.increment());
        _log.debug(JSONFactoryUtil.looseSerializeDeep(forms));
        return this.formsPersistence.update(forms);
    }

    private Log _log = LogFactoryUtil.getLog(FormsLocalService.class);


}