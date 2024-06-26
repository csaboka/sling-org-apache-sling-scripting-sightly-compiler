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

/**
 * This {@link Command} imposes a condition on the next rendering commands.
 */
public final class Conditional {

    public static final class Start implements Command {
        private String variable;
        private boolean expectedTruthValue;

        public Start(String variable, boolean expectedTruthValue) {
            this.variable = variable;
            this.expectedTruthValue = expectedTruthValue;
        }

        @Override
        public void accept(CommandVisitor visitor) {
            visitor.visit(this);
        }

        public String getVariable() {
            return variable;
        }

        public boolean getExpectedTruthValue() {
            return expectedTruthValue;
        }

        @Override
        public String toString() {
            return "Conditional.Start{" + "variable='"
                    + variable + '\'' + ", expectedTruthValue="
                    + expectedTruthValue + '}';
        }
    }

    public static final End END = new End();

    public static final class End implements Command {

        private End() {}

        @Override
        public void accept(CommandVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public String toString() {
            return "Conditional.End{}";
        }
    }
}
