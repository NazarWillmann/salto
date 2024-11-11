package ooo.jtc.dictionaries.controlcode;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ControlCodeMapperImpl implements ControlCodeMapper {

    @Override
    public ControlCode toDomainModel(ControlCodeDto dto) {
        if ( dto == null ) {
            return null;
        }

        ControlCodeBuilder controlCode = ControlCodeBuilder.builder();

        controlCode.setId( dto.getId() );
        controlCode.setVersion( dto.getVersion() );
        controlCode.setCode( dto.getCode() );
        controlCode.setDescription( dto.getDescription() );

        return controlCode.create();
    }

    @Override
    public ControlCodeDto toDto(ControlCode domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ControlCodeDtoBuilder controlCodeDto = ControlCodeDtoBuilder.builder();

        controlCodeDto.setId( domainModel.getId() );
        controlCodeDto.setVersion( domainModel.getVersion() );
        controlCodeDto.setCode( domainModel.getCode() );
        controlCodeDto.setDescription( domainModel.getDescription() );

        return controlCodeDto.create();
    }
}
