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
package fixengine.messages.fix42;

import fixengine.messages.AbstractMessage;
import fixengine.messages.MessageHeader;
import fixengine.messages.MessageVisitor;
import fixengine.messages.Required;
import fixengine.tags.fix42.Account;
import fixengine.tags.fix42.ClOrdID;
import fixengine.tags.fix42.ClientID;
import fixengine.tags.fix42.ExecBroker;
import fixengine.tags.fix42.IDSource;
import fixengine.tags.fix42.MaturityMonthYear;
import fixengine.tags.fix42.OrderID;
import fixengine.tags.fix42.SecurityExchange;
import fixengine.tags.fix42.SecurityID;
import fixengine.tags.fix42.SecurityType;
import fixengine.tags.fix42.Side;
import fixengine.tags.fix42.Symbol;

public class OrderStatusRequestMessage extends AbstractMessage {
    public OrderStatusRequestMessage(MessageHeader header) {
        super(header);

        fields();
    }

    @Override public void apply(MessageVisitor visitor) {
        visitor.visit(this);
    }

    protected void fields() {
        field(OrderID.Tag(), Required.NO);
        field(ClOrdID.Tag());
        field(ClientID.Tag(), Required.NO);
        field(Account.Tag(), Required.NO);
        field(ExecBroker.Tag(), Required.NO);
        field(Symbol.Tag());
        /* SymbolSfx(65) */
        field(SecurityID.Tag(), Required.NO);
        field(IDSource.Tag(), Required.NO);
        field(SecurityType.Tag(), Required.NO);
        field(MaturityMonthYear.Tag(), Required.NO);
        /* MaturityDay(205) */
        /* PutOrCall(201) */
        /* StrikePrice(202) */
        /* OptAttribute(206) */
        /* ContractMultiplier(201) */
        /* CouponRate(223) */
        field(SecurityExchange.Tag(), Required.NO);
        /* Issuer(106) */
        /* EncodedIssuerLen(348) */
        /* EncodedIssuer(349) */
        /* SecurityDesc(107) */
        /* EncodedSecurityDescLen(350) */
        /* EncodedSecurityDesc(351) */
        field(Side.Tag());
    }
}
