package ooo.jtc.dictionaries.bankinfo.socialurl;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BankInfoSocialUrlMapperImpl implements BankInfoSocialUrlMapper {

    @Override
    public BankInfoSocialUrl toDomainModel(BankInfoSocialUrlDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankInfoSocialUrlBuilder bankInfoSocialUrl = BankInfoSocialUrlBuilder.builder();

        bankInfoSocialUrl.setId( dto.getId() );
        bankInfoSocialUrl.setVersion( dto.getVersion() );
        bankInfoSocialUrl.setName( dto.getName() );
        bankInfoSocialUrl.setBankId( dto.getBankId() );
        bankInfoSocialUrl.setSocialType( dto.getSocialType() );
        bankInfoSocialUrl.setSocialUrl( dto.getSocialUrl() );
        bankInfoSocialUrl.setOrdering( dto.getOrdering() );

        return bankInfoSocialUrl.create();
    }

    @Override
    public BankInfoSocialUrlDto toDto(BankInfoSocialUrl domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankInfoSocialUrlDtoBuilder bankInfoSocialUrlDto = BankInfoSocialUrlDtoBuilder.builder();

        bankInfoSocialUrlDto.setId( domainModel.getId() );
        bankInfoSocialUrlDto.setVersion( domainModel.getVersion() );
        bankInfoSocialUrlDto.setName( domainModel.getName() );
        bankInfoSocialUrlDto.setBankId( domainModel.getBankId() );
        bankInfoSocialUrlDto.setSocialType( domainModel.getSocialType() );
        bankInfoSocialUrlDto.setSocialUrl( domainModel.getSocialUrl() );
        bankInfoSocialUrlDto.setOrdering( domainModel.getOrdering() );

        return bankInfoSocialUrlDto.create();
    }
}
