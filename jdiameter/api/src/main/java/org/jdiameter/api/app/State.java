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

package org.jdiameter.api.app;

/**
 * This interface must be extended by any class that should implement a certain state in the state machine.
 * @version 1.5.1 Final
 */

public interface State {

    /**
     *  Action that should be taken each time this state is entered
     */
    void entryAction();

    /**
     * Action that should be taken each time this state is exited
     */
    void exitAction();

    /**
     * This method processed received event.
     * @param event the event to process.
     * @return true if event is processed
     */
    boolean processEvent(StateEvent event);
}
