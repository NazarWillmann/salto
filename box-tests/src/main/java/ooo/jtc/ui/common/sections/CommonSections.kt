package ooo.jtc.ui.common.sections

import ooo.jtc.ui.common.sections.modals.ModalConfirmRemoving
import ooo.jtc.ui.common.sections.modals.ModalExportDocument
import ooo.jtc.ui.common.sections.modals.ModalPrintDocument
import ooo.jtc.ui.common.sections.modals.ModalProcessDocument
import ooo.jtc.ui.common.sections.modals.ModalRecallDocument
import ooo.jtc.ui.common.sections.modals.ModalSendDocument
import ooo.jtc.ui.common.sections.modals.ModalUnSignDocument

object CommonSections {
    val modalSendDocument by lazy { ModalSendDocument() }
    val modalConfirmRemoving by lazy { ModalConfirmRemoving() }
    val modalPrintDocument by lazy { ModalPrintDocument() }
    val modalExportDocument by lazy { ModalExportDocument() }
    val modalRecallDocument by lazy { ModalRecallDocument() }
    val modalUnSignDocument by lazy { ModalUnSignDocument() }
    val modalProcessDocument by lazy { ModalProcessDocument() }
}
