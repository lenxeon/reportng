package org.uncommons.reportng.support.listener;

import org.apache.commons.lang.StringUtils;
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;
import org.testng.internal.TestResult;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Interceptor extends TestListenerAdapter implements IMethodInterceptor {

    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        int methCount = methods.size();

        for (int i = 0; i < methCount; i++) {
            IMethodInstance instns = methods.get(i);
            Test test = instns.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
            System.out.println(test.testName() + "\t" + test.description());
        }

        return methods;
    }

    @Override
    public void onTestStart(ITestResult tr) {
        setTestNameInXml(tr);
        super.onTestSuccess(tr);
    }

    private void setTestNameInXml(ITestResult tr) {
        try {
            Method method = tr.getMethod().getConstructorOrMethod().getMethod();
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                String name = test.testName();
                if (StringUtils.isBlank(name)) {
                    name = tr.getMethod().getMethodName();
                }
                Field mMethod = TestResult.class.getDeclaredField("m_method");
                mMethod.setAccessible(true);
                mMethod.set(tr, tr.getMethod().clone());
                Field methodName = BaseTestMethod.class.getDeclaredField("m_methodName");
                methodName.setAccessible(true);
                methodName.set(tr.getMethod(), name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}