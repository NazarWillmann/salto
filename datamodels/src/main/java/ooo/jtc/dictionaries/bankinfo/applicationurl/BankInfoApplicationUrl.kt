package ooo.jtc.dictionaries.bankinfo.applicationurl

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.util.UUID

@KotlinBuilder
data class BankInfoApplicationUrl(
    override var id: UUID?,
    @NotRequiredForTest @JsonIgnore override var version: Int = 0,
    @JsonProperty("id_bank") var bankId: UUID?,
    var name: String,
    @JsonProperty("app_type") var appType: String,      //ApplicationType
    @JsonProperty("store_type") var storeType: String,  //ApplicationStoreType
    @JsonProperty("download_url") var downloadUrl: String,
    var ordering: Int?
): ITransferEntity {
    @NotRequiredForTest @JsonIgnore override val entityName: String = "Ссылка на мобильное приложение"

    override fun toDto(): BankInfoApplicationUrlDto = Mappers.bankInfoApplicationUrlMapper.toDto(this)
}