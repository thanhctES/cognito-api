/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.model.transform;

import com.amazonaws.services.model.ListUserImportJobsResult;
import com.amazonaws.services.model.UserImportJobType;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.json.AwsJsonReader;

/**
 * JSON unmarshaller for response ListUserImportJobsResult
 */
public class ListUserImportJobsResultJsonUnmarshaller implements
        Unmarshaller<ListUserImportJobsResult, JsonUnmarshallerContext> {

    public ListUserImportJobsResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ListUserImportJobsResult listUserImportJobsResult = new ListUserImportJobsResult();

        AwsJsonReader reader = context.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("UserImportJobs")) {
                listUserImportJobsResult.setUserImportJobs(new ListUnmarshaller<UserImportJobType>(
                        UserImportJobTypeJsonUnmarshaller.getInstance()
                        )
                                .unmarshall(context));
            } else if (name.equals("PaginationToken")) {
                listUserImportJobsResult.setPaginationToken(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();

        return listUserImportJobsResult;
    }

    private static ListUserImportJobsResultJsonUnmarshaller instance;

    public static ListUserImportJobsResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ListUserImportJobsResultJsonUnmarshaller();
        return instance;
    }
}