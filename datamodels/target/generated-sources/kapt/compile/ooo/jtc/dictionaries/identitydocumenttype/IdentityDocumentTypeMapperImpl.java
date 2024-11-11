package ooo.jtc.dictionaries.identitydocumenttype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class IdentityDocumentTypeMapperImpl implements IdentityDocumentTypeMapper {

    @Override
    public IdentityDocumentType toDomainModel(IdentityDocumentTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        IdentityDocumentTypeBuilder identityDocumentType = IdentityDocumentTypeBuilder.builder();

        identityDocumentType.setId( dto.getId() );
        identityDocumentType.setVersion( dto.getVersion() );
        identityDocumentType.setName( dto.getName() );
        identityDocumentType.setSystemName( dto.getSystemName() );
        identityDocumentType.setUsageLimit( dto.getUsageLimit() );
        identityDocumentType.setTypeCode( dto.getTypeCode() );

        return identityDocumentType.create();
    }

    @Override
    public IdentityDocumentTypeDto toDto(IdentityDocumentType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        IdentityDocumentTypeDtoBuilder identityDocumentTypeDto = IdentityDocumentTypeDtoBuilder.builder();

        identityDocumentTypeDto.setId( domainModel.getId() );
        identityDocumentTypeDto.setVersion( domainModel.getVersion() );
        identityDocumentTypeDto.setTypeCode( domainModel.getTypeCode() );
        identityDocumentTypeDto.setName( domainModel.getName() );
        identityDocumentTypeDto.setSystemName( domainModel.getSystemName() );
        identityDocumentTypeDto.setUsageLimit( domainModel.getUsageLimit() );

        return identityDocumentTypeDto.create();
    }
}
