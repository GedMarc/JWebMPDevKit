/*
 * Copyright (c) 2018 Oracle and/or its affiliates and others.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package javax.websocket;

import java.nio.ByteBuffer;

/**
 * The PongMessage interface represents a web socket pong. PongMessages may be received by using a
 * {@code MessageHandler.Basic<PongMessage>}. The payload of the PongMessage is the application data sent by the peer.
 *
 * @author dannycoward
 */
public interface PongMessage {

    /**
     * The application data inside the pong message from the peer.
     *
     * @return the application data.
     */
    ByteBuffer getApplicationData();
}
