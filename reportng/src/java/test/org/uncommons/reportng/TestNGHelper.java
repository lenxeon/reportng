////=============================================================================
//// Copyright 2006-2010 Daniel W. Dyer
////
//// Licensed under the Apache License, Version 2.0 (the "License");
//// you may not use this file except in compliance with the License.
//// You may obtain a copy of the License at
////
////     http://www.apache.org/licenses/LICENSE-2.0
////
//// Unless required by applicable law or agreed to in writing, software
//// distributed under the License is distributed on an "AS IS" BASIS,
//// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//// See the License for the specific language governing permissions and
//// limitations under the License.
////=============================================================================
//
//package org.uncommons.reportng;
//
//import org.testng.TestNG;
//import org.uncommons.reportng.listener.CustomTestListener;
//import org.uncommons.reportng.listener.CustomSuiteListener;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Contains helper methods for TestNG
// *
// * @author Kanika Agarwal
// */
//public class TestNGHelper {
//
//    static {
//        List<Class> classesList = new ArrayList<Class>();
//        classesList.add(CustomTestListener.class);
//        classesList.add(CustomSuiteListener.class);
//        classesList.add(org.uncommons.reportng.HTMLReporter.class);
//        classesList.add(org.uncommons.reportng.JUnitXMLReporter.class);
//        classesList.add(org.testng.reporters.XMLReporter.class);
//        testNG.setListenerClasses(classesList);
//    }
//
//    /**
//     * Sets the title for TestNG reports and configures other properties
//     * required for the report ng
//     *
//     * @param reportTitle Report title
//     */
//    private static void configureReportNG(String reportTitle) {
//
//        System.getProperties().put("org.uncommons.reportng.stylesheet", "resources" + File.separator + "hudsonesque.css");
//        System.getProperties().put("org.uncommons.reportng.title", reportTitle);
//
//    }
//
//    /**
//     * Configures the listeners for TestNG for reporting
//     *
//     * @param testNG TestNG
//     */
//    @SuppressWarnings("rawtypes")
//    private static void configureListenersForTestNG(TestNG testNG) {
//        List<Class> classesList = new ArrayList<Class>();
//        classesList.add(CustomTestListener.class);
//        classesList.add(CustomSuiteListener.class);
//        classesList.add(org.uncommons.reportng.HTMLReporter.class);
//        classesList.add(org.uncommons.reportng.JUnitXMLReporter.class);
//        classesList.add(org.testng.reporters.XMLReporter.class);
//        testNG.setListenerClasses(classesList);
//    }
//
//}