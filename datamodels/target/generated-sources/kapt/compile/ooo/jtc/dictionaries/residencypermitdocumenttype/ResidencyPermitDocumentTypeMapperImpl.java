package ooo.jtc.dictionaries.residencypermitdocumenttype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ResidencyPermitDocumentTypeMapperImpl implements ResidencyPermitDocumentTypeMapper {

    @Override
    public ResidencyPermitDocumentType toDomainModel(ResidencyPermitDocumentTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        ResidencyPermitDocumentTypeBuilder residencyPermitDocumentType = ResidencyPermitDocumentTypeBuilder.builder();

        residencyPermitDocumentType.setId( dto.getId() );
        residencyPermitDocumentType.setVersion( dto.getVersion() );
        residencyPermitDocumentType.setName( dto.getName() );
        residencyPermitDocumentType.setSystemName( dto.getSystemName() );

        return residencyPermitDocumentType.create();
    }

    @Override
    public ResidencyPermitDocumentTypeDto toDto(ResidencyPermitDocumentType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ResidencyPermitDocumentTypeDtoBuilder residencyPermitDocumentTypeDto = ResidencyPermitDocumentTypeDtoBuilder.builder();

        residencyPermitDocumentTypeDto.setId( domainModel.getId() );
        residencyPermitDocumentTypeDto.setVersion( domainModel.getVersion() );
        residencyPermitDocumentTypeDto.setName( domainModel.getName() );
        residencyPermitDocumentTypeDto.setSystemName( domainModel.getSystemName() );

        return residencyPermitDocumentTypeDto.create();
    }
}
