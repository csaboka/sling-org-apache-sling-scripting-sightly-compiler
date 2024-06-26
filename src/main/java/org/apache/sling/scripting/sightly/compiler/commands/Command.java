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
package org.apache.sling.scripting.sightly.compiler.commands;

import org.osgi.annotation.versioning.ProviderType;

/**
 * A {@code Command} represents the type of instruction a certain HTL expression or block element should execute. Commands are immutable
 * and can only be processed through a {@link CommandVisitor}.
 */
@ProviderType
public interface Command {

    /**
     * Accept a visitor.
     *
     * @param visitor the visitor that will process this command
     */
    void accept(CommandVisitor visitor);
}
