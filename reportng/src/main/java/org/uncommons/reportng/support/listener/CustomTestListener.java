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

import org.apache.commons.lang.StringUtils;
import org.testng.*;

import javax.annotation.Resource;
import java.net.URL;
import java.util.Collection;
import java.util.Properties;

/**
 * CustomSuiteListener listens to the events related to a test suite.
 *
 * @author Bharat Mehta
 */
public class CustomTestListener implements ITestListener {

    /**
     * The method removes duplicate entries from list of passed tests and failed
     * tests. If a test is found in both passed and failed lists, we consider
     * the same as failed.
     */
    public void onFinish(ITestContext context) {
        IResultMap passedTests = context.getPassedTests();
        IResultMap failedTests = context.getFailedTests();

        Collection<ITestNGMethod> passedTestMethods = passedTests
                .getAllMethods();
        Collection<ITestNGMethod> failedTestMethods = failedTests
                .getAllMethods();
        for (ITestNGMethod method : failedTestMethods) {
            if (passedTestMethods.contains(method)) {
                passedTestMethods.remove(method);
            }
        }

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        URL res = Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println(res);
        System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox; default-src 'self'; img-src '*'; style-src '*' 'unsafe-inline';");
        System.getProperties().put("org.uncommons.reportng.stylesheet", res.toString()+"/css/custom.css");
//        System.getProperties().put("org.uncommons.reportng.title", "鱼骨测试");
//        Properties prop = System.getProperties();
//        String title = prop.get("org.uncommons.reportng.title").toString();
//        System.out.println("未设置:org.uncommons.reportng.title" + title);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult context) {
        // TODO Auto-generated method stub

    }

    public void onTestFailure(ITestResult context) {
        // TODO Auto-generated method stub

    }

    public void onTestSkipped(ITestResult context) {
        // TODO Auto-generated method stub

    }

    public void onTestStart(ITestResult context) {
//        System.out.println("准备测试环境onTestStart");
        // TODO Auto-generated method stub

    }

    public void onTestSuccess(ITestResult context) {
        // TODO Auto-generated method stub

    }

}