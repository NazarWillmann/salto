package ooo.jtc.dictionaries.bankbic.acc.restr;

import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BankBicAccRestrictionMapperImpl implements BankBicAccRestrictionMapper {

    @Override
    public BankBicAccRestrictionDto toDto(BankBicAccRestriction domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankBicAccRestrictionDtoBuilder bankBicAccRestrictionDto = BankBicAccRestrictionDtoBuilder.builder();

        bankBicAccRestrictionDto.setId( domainModel.getId() );
        bankBicAccRestrictionDto.setVersion( domainModel.getVersion() );
        bankBicAccRestrictionDto.setRestrictionDate( domainModel.getRestrictionDate() );

        bankBicAccRestrictionDto.setRestrictionCode( BankBicAccRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()) );

        return bankBicAccRestrictionDto.create();
    }

    @Override
    public BankBicAccRestriction toDomainModel(BankBicAccRestrictionDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankBicAccRestrictionBuilder bankBicAccRestriction = BankBicAccRestrictionBuilder.builder();

        bankBicAccRestriction.setRestrictionCode( dtoRestrictionCodeValue( dto ) );
        bankBicAccRestriction.setId( dto.getId() );
        bankBicAccRestriction.setVersion( dto.getVersion() );
        bankBicAccRestriction.setRestrictionDate( dto.getRestrictionDate() );

        return bankBicAccRestriction.create();
    }

    private String dtoRestrictionCodeValue(BankBicAccRestrictionDto bankBicAccRestrictionDto) {
        if ( bankBicAccRestrictionDto == null ) {
            return null;
        }
        ValDescIEnumDto restrictionCode = bankBicAccRestrictionDto.getRestrictionCode();
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
