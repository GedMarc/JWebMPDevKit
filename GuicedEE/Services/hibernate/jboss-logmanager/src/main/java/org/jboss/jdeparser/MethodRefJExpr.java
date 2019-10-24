/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
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

package org.jboss.jdeparser;

import java.io.IOException;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
class MethodRefJExpr extends AbstractJExpr {

    private final AbstractJType type;
    private final String name;

    MethodRefJExpr(final AbstractJType type, final String name) {
        super(0);
        this.type = type;
        this.name = name;
    }

    public void write(final SourceFileWriter writer) throws IOException {
        writer.write(type);
        writer.write(Tokens.$PUNCT.BINOP.DBL_COLON);
        writer.writeEscapedWord(name);
    }
}
