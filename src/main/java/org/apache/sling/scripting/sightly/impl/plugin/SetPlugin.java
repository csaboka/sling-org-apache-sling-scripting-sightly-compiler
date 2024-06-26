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

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.scripting.sightly.compiler.SightlyCompilerException;
import org.apache.sling.scripting.sightly.compiler.commands.VariableBinding;
import org.apache.sling.scripting.sightly.compiler.expression.Expression;
import org.apache.sling.scripting.sightly.impl.compiler.PushStream;
import org.apache.sling.scripting.sightly.impl.compiler.frontend.CompilerContext;

/**
 * Implementation for the {@code data-sly-set} plugin
 */
public class SetPlugin extends AbstractPlugin {

    public SetPlugin() {
        name = "set";
        priority = 1;
    }

    @Override
    public PluginInvoke invoke(
            final Expression expressionNode, final PluginCallInfo callInfo, final CompilerContext compilerContext) {

        final String variableName = decodeVariableName(callInfo);
        if (StringUtils.isEmpty(variableName)) {
            throw new SightlyCompilerException("Identifier name was not provided.");
        }

        return new DefaultPluginInvoke() {

            @Override
            public void beforeElement(PushStream stream, String tagName) {
                stream.write(new VariableBinding.Global(variableName, expressionNode.getRoot()));
            }
        };
    }
}
