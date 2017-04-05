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

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

/**
 * CustomSuiteListener listens to the events related to a test suite.
 *
 * @author Bharat Mehta
 */
public class CustomResultListener implements IResultListener {


    public void onTestStart(ITestResult iTestResult) {
        //System.out.println("onTestStart:"+iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        //System.out.println("onTestSuccess:"+iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        //System.out.println("onTestFailure:"+iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        //System.out.println("onTestSkipped:"+iTestResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //System.out.println("onTestFailedButWithinSuccessPercentage:"+iTestResult.getName());
    }

    public void onStart(ITestContext iTestContext) {
        //System.out.println("onStart:"+iTestContext.getName());
    }

    public void onFinish(ITestContext iTestContext) {
        //System.out.println("onFinish:"+iTestContext.getName());
    }

    public void onConfigurationSuccess(ITestResult iTestResult) {
        //System.out.println("onConfigurationSuccess:"+iTestResult.getName());
    }

    public void onConfigurationFailure(ITestResult iTestResult) {
        //System.out.println("onConfigurationFailure:"+iTestResult.getName());
    }

    public void onConfigurationSkip(ITestResult iTestResult) {
        //System.out.println("onConfigurationSkip:"+iTestResult.getName());
    }
}