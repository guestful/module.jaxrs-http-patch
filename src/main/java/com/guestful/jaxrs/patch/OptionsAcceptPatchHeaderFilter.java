/**
 * Copyright (C) 2013 Guestful (info@guestful.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.guestful.jaxrs.patch;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

/**
 * A JAX-RS container response filter that applies {@value #ACCEPT_PATCH_HEADER} header
 * to any response to an {@value HttpMethod#OPTIONS} request.
 *
 * @author Gerard Davison (gerard.davison at oracle.com)
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
public class OptionsAcceptPatchHeaderFilter implements ContainerResponseFilter {

    private static final String ACCEPT_PATCH_HEADER = "Accept-Patch";

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        if (HttpMethod.OPTIONS.equals(requestContext.getMethod())) {
            final MultivaluedMap<String, Object> headers = responseContext.getHeaders();
            if (!headers.containsKey(ACCEPT_PATCH_HEADER)) {
                headers.putSingle(ACCEPT_PATCH_HEADER, MediaType.APPLICATION_JSON);
            }
        }
    }
}
