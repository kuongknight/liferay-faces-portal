/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.portal.render.internal;

import javax.faces.render.Renderer;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;


/**
 * This abstract class provides a compatibility layer for different versions of Liferay
 *
 * @author  Juan Gonzalez
 */
public abstract class PortalTagRendererCompat extends Renderer {

	private HttpServletRequest _getHttpServletRequest(PortletRequest portletRequest) {
		LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(portletRequest);

		return liferayPortletRequest.getHttpServletRequest();
	}

	protected HttpServletRequest getHttpServletRequest(PortletRequest portletRequest) {
		return new HttpServletRequestTagSafeImpl(_getHttpServletRequest(portletRequest));
	}
}