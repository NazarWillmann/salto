package ooo.jtc.dictionaries.okfs;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class OkfsMapperImpl implements OkfsMapper {

    @Override
    public Okfs toDomainModel(OkfsDto dto) {
        if ( dto == null ) {
            return null;
        }

        OkfsBuilder okfs = OkfsBuilder.builder();

        okfs.setId( dto.getId() );
        okfs.setVersion( dto.getVersion() );
        okfs.setCode( dto.getCode() );
        okfs.setParentCode( dto.getParentCode() );
        okfs.setDescription( dto.getDescription() );

        return okfs.create();
    }

    @Override
    public OkfsDto toDto(Okfs domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        OkfsDtoBuilder okfsDto = OkfsDtoBuilder.builder();

        okfsDto.setId( domainModel.getId() );
        okfsDto.setVersion( domainModel.getVersion() );
        okfsDto.setCode( domainModel.getCode() );
        okfsDto.setParentCode( domainModel.getParentCode() );
        okfsDto.setDescription( domainModel.getDescription() );

        return okfsDto.create();
    }
}
