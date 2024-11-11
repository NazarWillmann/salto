package ooo.jtc.dictionaries.bankinfo.applicationurl;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:42+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BankInfoApplicationUrlMapperImpl implements BankInfoApplicationUrlMapper {

    @Override
    public BankInfoApplicationUrl toDomainModel(BankInfoApplicationUrlDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankInfoApplicationUrlBuilder bankInfoApplicationUrl = BankInfoApplicationUrlBuilder.builder();

        bankInfoApplicationUrl.setId( dto.getId() );
        bankInfoApplicationUrl.setVersion( dto.getVersion() );
        bankInfoApplicationUrl.setBankId( dto.getBankId() );
        bankInfoApplicationUrl.setName( dto.getName() );
        bankInfoApplicationUrl.setAppType( dto.getAppType() );
        bankInfoApplicationUrl.setStoreType( dto.getStoreType() );
        bankInfoApplicationUrl.setDownloadUrl( dto.getDownloadUrl() );
        bankInfoApplicationUrl.setOrdering( dto.getOrdering() );

        return bankInfoApplicationUrl.create();
    }

    @Override
    public BankInfoApplicationUrlDto toDto(BankInfoApplicationUrl domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankInfoApplicationUrlDtoBuilder bankInfoApplicationUrlDto = BankInfoApplicationUrlDtoBuilder.builder();

        bankInfoApplicationUrlDto.setId( domainModel.getId() );
        bankInfoApplicationUrlDto.setVersion( domainModel.getVersion() );
        bankInfoApplicationUrlDto.setBankId( domainModel.getBankId() );
        bankInfoApplicationUrlDto.setName( domainModel.getName() );
        bankInfoApplicationUrlDto.setAppType( domainModel.getAppType() );
        bankInfoApplicationUrlDto.setStoreType( domainModel.getStoreType() );
        bankInfoApplicationUrlDto.setDownloadUrl( domainModel.getDownloadUrl() );
        bankInfoApplicationUrlDto.setOrdering( domainModel.getOrdering() );

        return bankInfoApplicationUrlDto.create();
    }
}
