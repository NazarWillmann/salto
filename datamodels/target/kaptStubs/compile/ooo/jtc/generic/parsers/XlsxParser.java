package ooo.jtc.generic.parsers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0015R\u001b\u0010\u0003\u001a\u00020\u00048VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/generic/parsers/XlsxParser;", "Looo/jtc/generic/parsers/FormatParser;", "()V", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "getDataFromSheet", "", "", "sheet", "Lorg/apache/poi/xssf/usermodel/XSSFSheet;", "getDateCellValueInFormat", "cell", "Lorg/apache/poi/ss/usermodel/Cell;", "parse", "byteArray", "", "datamodels"})
public final class XlsxParser extends ooo.jtc.generic.parsers.FormatParser {
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    public static final ooo.jtc.generic.parsers.XlsxParser INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.slf4j.Logger getLog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u043c\u043e\u0435 XLS \u043a\u0430\u043a \u0441\u043f\u0438\u0441\u043e\u043a \u0441\u0442\u0440\u043e\u043a")
    protected java.util.List<java.lang.String> parse(@org.jetbrains.annotations.NotNull()
    byte[] byteArray) {
        return null;
    }
    
    private final java.util.List<java.lang.String> getDataFromSheet(org.apache.poi.xssf.usermodel.XSSFSheet sheet) {
        return null;
    }
    
    private final java.lang.String getDateCellValueInFormat(org.apache.poi.ss.usermodel.Cell cell) {
        return null;
    }
    
    private XlsxParser() {
        super();
    }
}