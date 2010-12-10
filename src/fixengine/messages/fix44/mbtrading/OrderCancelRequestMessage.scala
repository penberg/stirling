/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
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
package fixengine.messages.fix44.mbtrading

import fixengine.messages.AbstractMessage
import fixengine.messages.MessageHeader
import fixengine.messages.MessageVisitor
import fixengine.messages.Required
import fixengine.messages.{OrderCancelRequestMessage => OrderCancelRequestMessageTrait}
import fixengine.tags.ClOrdID
import fixengine.tags.OrigClOrdID
import fixengine.tags.Symbol
import fixengine.tags.TransactTime
import fixengine.tags.fix42.Side
import fixengine.tags.fix44.Username

class OrderCancelRequestMessage(header: MessageHeader) extends AbstractMessage(header) with OrderCancelRequestMessageTrait {
  field(ClOrdID.TAG)
  field(OrigClOrdID.TAG)
  field(Side.Tag)
  field(Symbol.TAG)
  field(TransactTime.TAG)
  field(Username.TAG)
  override def apply(visitor: MessageVisitor) = visitor.visit(this)
}