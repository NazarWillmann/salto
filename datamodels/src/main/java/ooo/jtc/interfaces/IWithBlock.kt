package ooo.jtc.interfaces

import ooo.jtc.dictionaries.common.BlockingInfoDto

/**
 * IWithBlock.
 * Interface for entities with 'block'-block.
 * Used in BlockingTestTemplates for accessing aforementioned block
 */
interface IWithBlock {
    var block: BlockingInfoDto
}