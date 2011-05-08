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

package org.jdiameter.common.impl.app.auth;

import static org.jdiameter.api.Avp.AUTH_APPLICATION_ID;
import static org.jdiameter.api.Avp.TERMINATION_CAUSE;

import org.jdiameter.api.Avp;
import org.jdiameter.api.AvpDataException;
import org.jdiameter.api.Message;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.auth.events.SessionTermRequest;
import org.jdiameter.common.impl.app.AppRequestEventImpl;

public class SessionTermRequestImpl extends AppRequestEventImpl implements SessionTermRequest {

  private static final long serialVersionUID = 1L;

  public SessionTermRequestImpl(AppSession session, int terminationCause, String destRealm, String destHost) {
    super(session.getSessions().get(0).createRequest(code, session.getSessionAppId(), destRealm, destHost));
    message.getAvps().addAvp(Avp.TERMINATION_CAUSE, terminationCause, true, false);
  }

  public SessionTermRequestImpl(Message message) {
    super(message);
  }

  public long getAuthApplicationId() throws AvpDataException {
    Avp authApplicationIdAvp = message.getAvps().getAvp(AUTH_APPLICATION_ID);
    if (authApplicationIdAvp != null) {
      return authApplicationIdAvp.getUnsigned32();
    }
    else {
      throw new AvpDataException("Avp AUTH_APPLICATION_ID not found");
    }
  }

  public int getTerminationCause() throws AvpDataException {
    Avp terminationCauseAvp = message.getAvps().getAvp(TERMINATION_CAUSE);
    if (terminationCauseAvp != null) {
      return terminationCauseAvp.getInteger32();
    }
    else {
      throw new AvpDataException("Avp TERMINATION_CAUSE not found");
    }
  }
}