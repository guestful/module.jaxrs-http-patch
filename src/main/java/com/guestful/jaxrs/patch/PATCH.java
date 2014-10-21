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
import javax.ws.rs.NameBinding;
import java.lang.annotation.*;


/**
 * HTTP "PATCH" method annotation.
 * <p>
 * The annotation acts at the same time as JAX-RS filter/interceptor {@link javax.ws.rs.NameBinding "named binder"},
 * i.e. it can be applied to custom filter/interceptor that implements the PATCH support and JAX-RS runtime will
 * take care of automatically associating the filter/interceptor with the {@code &#64;PATCH}-annotated resource method.
 * </p>
 *
 * @author Gerard Davison (gerard.davison at oracle.com)
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@HttpMethod("PATCH")
@Documented
@NameBinding
public @interface PATCH {
}
