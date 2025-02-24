package com.hedera.mirror.importer.parser.record.transactionhandler;

/*-
 * ‌
 * Hedera Mirror Node
 * ​
 * Copyright (C) 2019 - 2021 Hedera Hashgraph, LLC
 * ​
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
 * ‍
 */

import com.hederahashgraph.api.proto.java.SystemDeleteTransactionBody;
import javax.inject.Named;

import com.hedera.mirror.importer.domain.EntityId;
import com.hedera.mirror.importer.parser.domain.RecordItem;

@Named
public class SystemDeleteTransactionHandler extends AbstractEntityCrudTransactionHandler {

    public SystemDeleteTransactionHandler() {
        super(EntityOperationEnum.DELETE);
    }

    @Override
    public EntityId getEntity(RecordItem recordItem) {
        SystemDeleteTransactionBody systemDelete = recordItem.getTransactionBody().getSystemDelete();
        if (systemDelete.hasContractID()) {
            return EntityId.of(systemDelete.getContractID());
        } else if (systemDelete.hasFileID()) {
            return EntityId.of(systemDelete.getFileID());
        }
        return null;
    }
}
