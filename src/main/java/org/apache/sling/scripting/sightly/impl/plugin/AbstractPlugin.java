/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.scripting.sightly.impl.plugin;

public abstract class AbstractPlugin implements Plugin {

    protected int priority = 100;
    protected String name;

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int compareTo(Plugin o) {
        return this.priority - o.priority();
    }

    public String decodeVariableName(PluginCallInfo pluginCallInfo) {
        String[] args = pluginCallInfo.getArguments();
        if (args.length > 0) {
            return args[0];
        }
        return null;
    }
}
