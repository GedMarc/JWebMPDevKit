/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates and others.
 * All rights reserved.
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.servlet.jsp.tagext;

import java.io.InputStream;

/**
 * Translation-time information on a JSP page. The information corresponds to the XML view of the JSP page.
 *
 * <p>
 * Objects of this type are generated by the JSP translator, e.g. when being pased to a TagLibraryValidator instance.
 */
abstract public class PageData {

    /**
     * Sole constructor. (For invocation by subclass constructors, typically implicit.)
     */
    public PageData() {
    }

    /**
     * Returns an input stream on the XML view of a JSP page. The stream is encoded in UTF-8. Recall tht the XML view of
     * a JSP page has the include directives expanded.
     * 
     * @return An input stream on the document.
     */
    abstract public InputStream getInputStream();
}
