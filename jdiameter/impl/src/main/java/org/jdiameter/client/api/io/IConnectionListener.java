/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jdiameter.client.api.io;

import org.jdiameter.client.api.IMessage;

import java.util.List;

/**
 * <P>
 * An object that registers to be notified of events generated by a
 * <code>IConnection</code> object.
 * <P>
 * The <code>ConnectionListener</code> interface is implemented by a
 * PCB component.
 */

public interface IConnectionListener {

    /**
     * Notifies that connection is created
     * @param connKey identifier of created connection
     */  
    void connectionOpened(String connKey);

    /**
     * Notifies that connection is closed
     * @param connKey identifier of closed connection
     * @param notSended array of not sended messages
     */
    void connectionClosed(String connKey, List notSended);

    /**
     * Notifies that connection is received incoming message
     * @param connKey identifier of connection
     * @param message received incoming message
     */
    void messageReceived(String connKey, IMessage message);

    /**
     * Notifies that connection is generated excpetion
     * @param connKey identifier of connection
     * @param message  the message from that failed
     * @param cause generated exceptions
     */
    void internalError(String connKey, IMessage message, TransportException cause);
}
