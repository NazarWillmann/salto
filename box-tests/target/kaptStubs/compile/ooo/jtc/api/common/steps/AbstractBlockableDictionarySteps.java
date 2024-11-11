package ooo.jtc.api.common.steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B-\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0015\u001a\u00020\u0013H\u0007J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0015\u001a\u00020\u0013H\u0007\u00a8\u0006\u0018"}, d2 = {"Looo/jtc/api/common/steps/AbstractBlockableDictionarySteps;", "T", "Looo/jtc/interfaces/IEntityDto;", "U", "Looo/jtc/interfaces/UpdateIEntityDto;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "user", "Looo/jtc/uaa/User;", "service", "Looo/jtc/testdata/Service;", "entity", "Ljava/lang/Class;", "dictionaryName", "", "(Looo/jtc/uaa/User;Looo/jtc/testdata/Service;Ljava/lang/Class;Ljava/lang/String;)V", "block", "Looo/jtc/generic/GenericListResponseDto;", "ids", "", "Ljava/util/UUID;", "blockSingle", "id", "unblock", "unblockSingle", "box-tests"})
public abstract class AbstractBlockableDictionarySteps<T extends ooo.jtc.interfaces.IEntityDto, U extends ooo.jtc.interfaces.UpdateIEntityDto<T>> extends ooo.jtc.api.common.steps.AbstractDictionarySteps<T, U> {
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0417\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c \'{this.entityName}\'")
    public final ooo.jtc.generic.GenericListResponseDto<T> blockSingle(@org.jetbrains.annotations.NotNull()
    java.util.UUID id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0417\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \'{this.entityName}\'")
    public final ooo.jtc.generic.GenericListResponseDto<T> block(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> ids) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0420\u0430\u0437\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c \'{this.entityName}\'")
    public final ooo.jtc.generic.GenericListResponseDto<T> unblockSingle(@org.jetbrains.annotations.NotNull()
    java.util.UUID id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0420\u0430\u0437\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \'{this.entityName}\'")
    public final ooo.jtc.generic.GenericListResponseDto<T> unblock(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> ids) {
        return null;
    }
    
    public AbstractBlockableDictionarySteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.testdata.Service service, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> entity, @org.jetbrains.annotations.NotNull()
    java.lang.String dictionaryName) {
        super(null, null, null, null);
    }
}