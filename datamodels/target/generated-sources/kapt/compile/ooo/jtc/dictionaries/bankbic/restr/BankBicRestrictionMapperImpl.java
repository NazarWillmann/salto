package ooo.jtc.dictionaries.bankbic.restr;

import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BankBicRestrictionMapperImpl implements BankBicRestrictionMapper {

    @Override
    public BankBicRestrictionDto toDto(BankBicRestriction domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankBicRestrictionDtoBuilder bankBicRestrictionDto = BankBicRestrictionDtoBuilder.builder();

        bankBicRestrictionDto.setId( domainModel.getId() );
        bankBicRestrictionDto.setVersion( domainModel.getVersion() );
        bankBicRestrictionDto.setRestrictionDate( domainModel.getRestrictionDate() );

        bankBicRestrictionDto.setRestrictionCode( BankBicRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()) );

        return bankBicRestrictionDto.create();
    }

    @Override
    public BankBicRestriction toDomainModel(BankBicRestrictionDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankBicRestrictionBuilder bankBicRestriction = BankBicRestrictionBuilder.builder();

        bankBicRestriction.setRestrictionCode( dtoRestrictionCodeValue( dto ) );
        bankBicRestriction.setId( dto.getId() );
        bankBicRestriction.setVersion( dto.getVersion() );
        bankBicRestriction.setRestrictionDate( dto.getRestrictionDate() );

        return bankBicRestriction.create();
    }

    private String dtoRestrictionCodeValue(BankBicRestrictionDto bankBicRestrictionDto) {
        if ( bankBicRestrictionDto == null ) {
            return null;
        }
        ValDescIEnumDto restrictionCode = bankBicRestrictionDto.getRestrictionCode();
        if ( restrictionCode == null ) {
            return null;
        }
        String value = restrictionCode.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }
}
