package ooo.jtc.interfaces;

import java.lang.System;

/**
 * IWithBlock.
 * Interface for entities with 'block'-block.
 * Used in BlockingTestTemplates for accessing aforementioned block
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Looo/jtc/interfaces/IWithBlock;", "", "block", "Looo/jtc/dictionaries/common/BlockingInfoDto;", "getBlock", "()Looo/jtc/dictionaries/common/BlockingInfoDto;", "setBlock", "(Looo/jtc/dictionaries/common/BlockingInfoDto;)V", "datamodels"})
public abstract interface IWithBlock {
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.dictionaries.common.BlockingInfoDto getBlock();
    
    public abstract void setBlock(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.common.BlockingInfoDto p0);
}