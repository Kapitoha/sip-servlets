/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012. 
 * and individual contributors
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
package org.mobicents.as7;

import org.apache.catalina.Engine;
import org.jboss.as.clustering.registry.Registry;
import org.jboss.as.clustering.registry.Registry.RegistryEntryProvider;
import org.jboss.msc.service.AbstractService;
import org.jboss.msc.value.Value;

/**
 * @author Paul Ferraro
 */
public class JvmRouteRegistryEntryProviderService extends AbstractService<Registry.RegistryEntryProvider<String, Void>> {
    private final Value<SipServer> server;

    public JvmRouteRegistryEntryProviderService(Value<SipServer> server) {
        this.server = server;
    }

    @Override
    public RegistryEntryProvider<String, Void> getValue() {
        return new JvmRouteRegistryEntryProvider((Engine) this.server.getValue().getService().getContainer());
    }

    class JvmRouteRegistryEntryProvider implements Registry.RegistryEntryProvider<String, Void> {
        private final Engine engine;

        JvmRouteRegistryEntryProvider(Engine engine) {
            this.engine = engine;
        }

        @Override
        public String getKey() {
            return this.engine.getJvmRoute();
        }

        @Override
        public Void getValue() {
            return null;
        }
    }
}
