package ooo.jtc.dictionaries.uer;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class UerMapperImpl implements UerMapper {

    @Override
    public Uer toDomainModel(UerDto dto) {
        if ( dto == null ) {
            return null;
        }

        UerBuilder uer = UerBuilder.builder();

        uer.setId( dto.getId() );
        uer.setVersion( dto.getVersion() );
        uer.setUer( dto.getUer() );
        uer.setBankType( dto.getBankType() );
        uer.setDescription( dto.getDescription() );

        return uer.create();
    }

    @Override
    public UerDto toDto(Uer domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        UerDtoBuilder uerDto = UerDtoBuilder.builder();

        uerDto.setId( domainModel.getId() );
        uerDto.setVersion( domainModel.getVersion() );
        uerDto.setUer( domainModel.getUer() );
        uerDto.setBankType( domainModel.getBankType() );
        uerDto.setDescription( domainModel.getDescription() );

        return uerDto.create();
    }
}
