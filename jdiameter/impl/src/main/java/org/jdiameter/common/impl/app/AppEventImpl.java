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

package org.jdiameter.common.impl.app;

import static org.jdiameter.api.Avp.ORIGIN_HOST;
import static org.jdiameter.api.Avp.ORIGIN_REALM;

import org.jdiameter.api.Avp;
import org.jdiameter.api.AvpDataException;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.Message;
import org.jdiameter.api.app.AppEvent;

public class AppEventImpl implements AppEvent {

  private static final long serialVersionUID = 1L;
  protected Message message;

  public AppEventImpl(Message message) {
    this.message = message;
  }

  public int getCommandCode() {
    return message.getCommandCode();
  }

  public Message getMessage() throws InternalException {
    return message;
  }

  public String getOriginHost() throws AvpDataException {
    Avp originHostAvp = message.getAvps().getAvp(ORIGIN_HOST);
    if (originHostAvp != null) {
      return originHostAvp.getOctetString();
    }
    else {
      throw new AvpDataException("Avp ORIGIN_HOST not found");
    }
  }

  public String getOriginRealm() throws AvpDataException {
    Avp originRealmAvp = message.getAvps().getAvp(ORIGIN_REALM);
    if (originRealmAvp != null) {
      return originRealmAvp.getOctetString();
    }
    else {
      throw new AvpDataException("Avp ORIGIN_REALM not found");
    }
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AppEventImpl that = (AppEventImpl) o;

    return message.equals(that.message);
  }

  public int hashCode() {
    return message.hashCode();
  }

  public String toString() {
    return message != null ? message.toString() : "empty";
  }
}
