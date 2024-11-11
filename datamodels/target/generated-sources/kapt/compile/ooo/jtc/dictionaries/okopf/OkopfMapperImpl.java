package ooo.jtc.dictionaries.okopf;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class OkopfMapperImpl implements OkopfMapper {

    @Override
    public Okopf toDomainModel(OkopfDto dto) {
        if ( dto == null ) {
            return null;
        }

        OkopfBuilder okopf = OkopfBuilder.builder();

        okopf.setId( dto.getId() );
        okopf.setVersion( dto.getVersion() );
        okopf.setCode( dto.getCode() );
        okopf.setDescription( dto.getDescription() );

        return okopf.create();
    }

    @Override
    public OkopfDto toDto(Okopf domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        OkopfDtoBuilder okopfDto = OkopfDtoBuilder.builder();

        okopfDto.setId( domainModel.getId() );
        okopfDto.setVersion( domainModel.getVersion() );
        okopfDto.setCode( domainModel.getCode() );
        okopfDto.setDescription( domainModel.getDescription() );

        return okopfDto.create();
    }
}
