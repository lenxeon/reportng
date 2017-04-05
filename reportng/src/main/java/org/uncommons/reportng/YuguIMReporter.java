package org.uncommons.reportng;

import com.google.common.collect.ImmutableBiMap;
import com.lenxeon.utils.httpclient.HttpClientUtils;
import com.lenxeon.utils.io.JsonUtils;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.xml.XmlSuite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;


public class YuguIMReporter implements IReporter {

    private static final Logger LOGGER = Logger.getLogger(YuguIMReporter.class.getName());

    private static final String reportHref = "http://jenkins.yugusoft.com/jenkins/job/%E7%A7%81%E5%AF%86%E7%9B%B8%E5%86%8C/ws/module-test/target/surefire-reports/html/overview.html";

    private static final String LOCALE_ARG = "locale";
    private static final String REPORT_TITLE_ARG = "report.title";
    private static final String DEFAULT_REPORT_TITLE = "Test results";

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.ENGLISH);
    private static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm z");

    private static final String IGNORE_SUITE = "Base suite";
    private static final String SUITES_TEMPLATE_VAR = "suites";
    private static final String REPORT_TITLE_TEMPLATE_VAR = "reportTitle";
    private static final String REPORT_DATE_TEMPLATE_VAR = "reportDate";
    private static final String TRANSLATE_VAR = "translate";

    private static final String REPORT_TEMPLATE = "templates/report.mustache";
    private static final String REPORT_OUTPUT = "html/report.html";

    private static final String RESOURCE_BUNDLE_PATH = "localization.report";

    @Override
    public void generateReport(final List<XmlSuite> xmlSuites, final List<ISuite> suites, final String outputDirectory) {
        int passed = 0;
        int skipped = 0;
        int failed = 0;
        for (ISuite suite : suites) {
            Collection<ISuiteResult> irs = suite.getResults().values();
            for (ISuiteResult ir : irs) {
                passed += ir.getTestContext().getPassedTests().size();
                skipped += ir.getTestContext().getSkippedTests().size();
                failed += ir.getTestContext().getFailedTests().size();
            }
        }
        String title = System.getProperty(REPORT_TITLE_ARG, DEFAULT_REPORT_TITLE);
        StringBuffer text = new StringBuffer(title);
        text.append("\r\n").append("通过:" + passed + "\t跳过:" + skipped + "\t失败:" + failed);
        text.append("\r\n").append("详情:\r\n" + reportHref);

        System.out.println(text);
        String href = "http://app02.yugusoft.com/openapi/msg/send";
        Map data = new LinkedHashMap();
        data.put("comp_id", "DbazTRK72RF1Beiqxx6SSQ");
        Map message = new LinkedHashMap();
        message.put("sender", "3VnEQorNz1L5tqUJivaZa8");
        message.put("text", text);
        message.put("receiver", ImmutableBiMap.of("type", "group", "id", "5cH8prdLW927yiTftAeSVk"));
        message.put("msg_type", "text");


        data.put("message", JsonUtils.toJson(message));
        HttpClientUtils.postString(href, data);
    }
}