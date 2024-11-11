package ooo.jtc.dictionaries.kbk;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class KbkMapperImpl implements KbkMapper {

    @Override
    public Kbk toDomainModel(KbkDto dto) {
        if ( dto == null ) {
            return null;
        }

        KbkBuilder kbk = KbkBuilder.builder();

        kbk.setId( dto.getId() );
        kbk.setVersion( dto.getVersion() );
        kbk.setCode( dto.getCode() );
        kbk.setDescription( dto.getDescription() );

        return kbk.create();
    }

    @Override
    public KbkDto toDto(Kbk domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        KbkDtoBuilder kbkDto = KbkDtoBuilder.builder();

        kbkDto.setId( domainModel.getId() );
        kbkDto.setVersion( domainModel.getVersion() );
        kbkDto.setCode( domainModel.getCode() );
        kbkDto.setDescription( domainModel.getDescription() );

        return kbkDto.create();
    }
}
