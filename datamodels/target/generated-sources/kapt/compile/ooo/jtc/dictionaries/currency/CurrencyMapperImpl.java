package ooo.jtc.dictionaries.currency;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class CurrencyMapperImpl implements CurrencyMapper {

    @Override
    public Currency toDomainModel(CurrencyDto dto) {
        if ( dto == null ) {
            return null;
        }

        CurrencyBuilder currency = CurrencyBuilder.builder();

        currency.setId( dto.getId() );
        currency.setVersion( dto.getVersion() );
        currency.setDigitCode( dto.getDigitCode() );
        currency.setAlphaCode( dto.getAlphaCode() );
        currency.setName( dto.getName() );
        currency.setNameInOkv( dto.getNameInOkv() );
        currency.setMinorUnitCount( dto.getMinorUnitCount() );

        return currency.create();
    }

    @Override
    public CurrencyDto toDto(Currency domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        CurrencyDtoBuilder currencyDto = CurrencyDtoBuilder.builder();

        currencyDto.setId( domainModel.getId() );
        currencyDto.setVersion( domainModel.getVersion() );
        currencyDto.setDigitCode( domainModel.getDigitCode() );
        currencyDto.setAlphaCode( domainModel.getAlphaCode() );
        currencyDto.setName( domainModel.getName() );
        currencyDto.setNameInOkv( domainModel.getNameInOkv() );
        currencyDto.setMinorUnitCount( domainModel.getMinorUnitCount() );

        return currencyDto.create();
    }
}
