//=============================================================================
// Copyright 2006-2010 Daniel W. Dyer
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//=============================================================================

package org.uncommons.reportng.support.listener;

import org.testng.*;

import java.util.List;
import java.util.Map;

/**
 * CustomSuiteListener listens to the events related to a test suite.
 *
 * @author Bharat Mehta
 */
public class CustomSuiteListener implements ISuiteListener {


    public void onStart(ISuite iSuite) {
        System.out.println("准备测试环境 iSuite " + iSuite.getClass().getName());

    }

    public void onFinish(ISuite iSuite) {
        System.out.println("=========================>>>>");
        Map<String, ISuiteResult> results = iSuite.getResults();
        for (ISuiteResult is : results.values()) {
            System.out.println(is.getTestContext().getFailedTests());
            System.out.println(is.getTestContext().getSkippedTests());
            System.out.println(is.getTestContext().getPassedTests());
        }
        System.out.println("=========================<<<<");
    }
}