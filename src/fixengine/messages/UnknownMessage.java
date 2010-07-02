/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fixengine.messages;

import org.apache.commons.lang.CharUtils;

/**
 * @author Pekka Enberg
 */
public class UnknownMessage extends AbstractMessage {
    public UnknownMessage(String msgType) {
        super(new MessageHeader(msgType));
    }

    @Override
    public void apply(MessageVisitor visitor) {
        visitor.visit(this);
    }

    public boolean hasValidMsgType() {
        String msgType = getMsgType();
        if (msgType.length() == 1) {
            return isValidSingle(msgType);
        } else if (msgType.length() == 2) {
            return isValidWide(msgType);
        }
        return false;
    }

    private boolean isValidSingle(String msgType) {
        char first = msgType.charAt(0);
        return CharUtils.isAsciiAlphanumeric(first);
    }

    private boolean isValidWide(String msgType) {
        char first = msgType.charAt(0);
        if (first != 'A')
            return false;

        char second = msgType.charAt(1);
        if (!CharUtils.isAsciiAlphaUpper(second))
            return false;

        return second >= 'A' && second <= 'I';
    }
}
