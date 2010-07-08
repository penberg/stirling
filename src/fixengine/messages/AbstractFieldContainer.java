/*
 * Copyright 2010 the original author or authors.
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

import org.joda.time.DateTime;

public abstract class AbstractFieldContainer {
    protected final Fields fields = new Fields();

    protected void field(Tag<?> tag) {
        field(tag, Required.YES);
    }

    protected void field(Tag<?> tag, Required required) {
        fields.add(tag, required);
    }

    public boolean hasValue(Tag<?> tag) {
        Field field = fields.lookup(tag);
        return field.hasValue();
    }

    public void setString(Tag<StringField> tag, String value) {
        StringField field = (StringField) fields.lookup(tag);
        field.setValue(value);
    }

    public void setInteger(Tag<IntegerField> tag, Integer value) {
        IntegerField field = (IntegerField) fields.lookup(tag);
        field.setValue(value);
    }

    public void setBoolean(Tag<BooleanField> tag, Boolean value) {
        BooleanField field = (BooleanField) fields.lookup(tag);
        field.setValue(value);
    }

    public void setDateTime(Tag<UtcTimestampField> tag, DateTime value) {
        UtcTimestampField field = (UtcTimestampField) fields.lookup(tag);
        field.setValue(value);
    }

    public String getString(Tag<StringField> tag) {
        StringField field = (StringField) fields.lookup(tag);
        return field.getValue();
    }

    public Integer getInteger(Tag<IntegerField> tag) {
        IntegerField field = (IntegerField) fields.lookup(tag);
        return field.getValue();
    }

    public boolean getBoolean(Tag<BooleanField> tag) {
        BooleanField field = (BooleanField) fields.lookup(tag);
        Boolean result = field.getValue();
        if (result == null)
            result = Boolean.FALSE;
        return result;
    }

    public DateTime getDateTime(Tag<UtcTimestampField> tag) {
        UtcTimestampField field = (UtcTimestampField) fields.lookup(tag);
        return field.getValue();
    }
}