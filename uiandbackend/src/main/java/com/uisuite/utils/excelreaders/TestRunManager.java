package com.uisuite.utils.excelreaders;

import com.creditdatamw.zerocell.annotation.Column;
import io.github.sskorol.data.Sheet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Sheet(name="TESTRUNMANAGER")
public class TestRunManager {
    @Column(name="TestCase", index = 0)
    private String testCase;

    @Column(name="Execute", index=1, converterClass = StringToBooleanConverter.class)
    private Boolean execute;
}
