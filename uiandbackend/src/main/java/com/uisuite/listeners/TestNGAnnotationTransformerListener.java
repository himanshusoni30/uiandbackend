package com.uisuite.listeners;

import com.uisuite.utils.excelreaders.TestRunManager;
import io.github.sskorol.core.IAnnotationTransformerInterceptor;
import io.github.sskorol.data.XlsxReader;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static io.github.sskorol.data.TestDataReader.use;

public class TestNGAnnotationTransformerListener implements IAnnotationTransformerInterceptor {
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){
        use(XlsxReader.class)
                .withTarget(TestRunManager.class)
                .withSource("TestData.xlsx")
                .read()
                .filter(test -> testMethod.getName().equalsIgnoreCase(test.getTestCase()))
                .forEach(test -> {
                    annotation.setEnabled(test.getExecute());
                });
    }
}
