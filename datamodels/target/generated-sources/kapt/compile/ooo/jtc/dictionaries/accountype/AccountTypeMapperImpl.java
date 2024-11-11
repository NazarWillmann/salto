package ooo.jtc.dictionaries.accountype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class AccountTypeMapperImpl implements AccountTypeMapper {

    @Override
    public AccountType toDomainModel(AccountTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        AccountTypeBuilder accountType = AccountTypeBuilder.builder();

        accountType.setId( dto.getId() );
        accountType.setVersion( dto.getVersion() );
        accountType.setFullName( dto.getFullName() );
        accountType.setShortName( dto.getShortName() );
        accountType.setSystemName( dto.getSystemName() );
        accountType.setDescription( dto.getDescription() );
        accountType.setClientType( dto.getClientType() );

        return accountType.create();
    }

    @Override
    public AccountTypeDto toDto(AccountType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        AccountTypeDtoBuilder accountTypeDto = AccountTypeDtoBuilder.builder();

        accountTypeDto.setId( domainModel.getId() );
        accountTypeDto.setVersion( domainModel.getVersion() );
        accountTypeDto.setFullName( domainModel.getFullName() );
        accountTypeDto.setShortName( domainModel.getShortName() );
        accountTypeDto.setSystemName( domainModel.getSystemName() );
        accountTypeDto.setClientType( domainModel.getClientType() );
        accountTypeDto.setDescription( domainModel.getDescription() );

        return accountTypeDto.create();
    }
}
