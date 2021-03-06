//=============================================================================
// Copyright 2006-2013 Daniel W. Dyer
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
package org.uncommons.reportng;

import org.testng.ITest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Locale;

/**
 * Unit test for the {@link ReportMetadata} class.
 *
 * @author Daniel Dyer
 */

public class ReportMetadataTest implements ITest {

    @BeforeSuite
    public void prepare() {
        System.setProperty("report.title", "私密相册自动化测试报告");
    }

    @Test(testName = "语言本地化默认测试", description = "测试语言默认本地化是否正确")
    public void testDefaultLocale() {
        // Unset any previously set property.
        System.getProperties().remove(ReportMetadata.LOCALE_KEY);
        // Make sure we know what the default locale is before we start.
        Locale.setDefault(new Locale("en", "GB"));

        ReportMetadata metadata = new ReportMetadata();
        String locale = metadata.getLocale().toString();
        assert locale.equals("en_GB2") : "Wrong locale: " + locale;
    }

    @Test(testName = "语言本地化", description = "测试语言能否本地化")
    public void testLocaleLanguageOnly() {
        // Unset any previously set property.
        System.setProperty(ReportMetadata.LOCALE_KEY, "fr");

        ReportMetadata metadata = new ReportMetadata();
        String locale = metadata.getLocale().toString();
        assert locale.equals("fr") : "Wrong locale: " + locale;
    }


    @Test(testName = "语言本地化默认测试", description = "测试语言默认本地化是否正确")
    public void testLocaleLanguageAndCountry() {
        // Unset any previously set property.
        System.setProperty(ReportMetadata.LOCALE_KEY, "fr_CA");

        ReportMetadata metadata = new ReportMetadata();
        String locale = metadata.getLocale().toString();
        assert locale.equals("fr_CA") : "Wrong locale: " + locale;
    }


    @Test(testName = "语言本地化默认测试", description = "测试语言默认本地化是否正确")
    public void testLocaleLanguageCountryAndVariant() {
        // Unset any previously set property.
        System.setProperty(ReportMetadata.LOCALE_KEY, "fr_CA_POSIX");

        ReportMetadata metadata = new ReportMetadata();
        String locale = metadata.getLocale().toString();
        assert locale.equals("fr_CA_POSIX") : "Wrong locale: " + locale;
    }

    public String getTestName() {
        return "本地化测试用例";
    }
}
