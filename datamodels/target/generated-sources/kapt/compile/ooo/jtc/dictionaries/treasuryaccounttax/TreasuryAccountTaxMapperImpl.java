package ooo.jtc.dictionaries.treasuryaccounttax;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class TreasuryAccountTaxMapperImpl implements TreasuryAccountTaxMapper {

    @Override
    public TreasuryAccountTax toDomainModel(TreasuryAccountTaxDto dto) {
        if ( dto == null ) {
            return null;
        }

        TreasuryAccountTaxBuilder treasuryAccountTax = TreasuryAccountTaxBuilder.builder();

        treasuryAccountTax.setId( dto.getId() );
        treasuryAccountTax.setVersion( dto.getVersion() );
        treasuryAccountTax.setTofk( dto.getTofk() );
        treasuryAccountTax.setAccount( dto.getAccount() );
        treasuryAccountTax.setBankName( dto.getBankName() );
        treasuryAccountTax.setBic( dto.getBic() );
        treasuryAccountTax.setUtraAccount( dto.getUtraAccount() );
        treasuryAccountTax.setAccountType( dto.getAccountType() );

        return treasuryAccountTax.create();
    }

    @Override
    public TreasuryAccountTaxDto toDto(TreasuryAccountTax domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        TreasuryAccountTaxDtoBuilder treasuryAccountTaxDto = TreasuryAccountTaxDtoBuilder.builder();

        treasuryAccountTaxDto.setId( domainModel.getId() );
        treasuryAccountTaxDto.setVersion( domainModel.getVersion() );
        treasuryAccountTaxDto.setTofk( domainModel.getTofk() );
        treasuryAccountTaxDto.setAccount( domainModel.getAccount() );
        treasuryAccountTaxDto.setBankName( domainModel.getBankName() );
        treasuryAccountTaxDto.setBic( domainModel.getBic() );
        treasuryAccountTaxDto.setUtraAccount( domainModel.getUtraAccount() );
        treasuryAccountTaxDto.setAccountType( domainModel.getAccountType() );

        return treasuryAccountTaxDto.create();
    }
}
