package ooo.jtc.dictionaries.ground;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class GroundMapperImpl implements GroundMapper {

    @Override
    public Ground toDomainModel(GroundDto dto) {
        if ( dto == null ) {
            return null;
        }

        GroundBuilder ground = GroundBuilder.builder();

        ground.setId( dto.getId() );
        ground.setVersion( dto.getVersion() );
        ground.setCustomerId( dto.getCustomerId() );
        ground.setContractorId( dto.getContractorId() );
        ground.setDescription( dto.getDescription() );

        return ground.create();
    }

    @Override
    public GroundDto toDto(Ground domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        GroundDtoBuilder groundDto = GroundDtoBuilder.builder();

        groundDto.setId( domainModel.getId() );
        groundDto.setVersion( domainModel.getVersion() );
        groundDto.setCustomerId( domainModel.getCustomerId() );
        groundDto.setContractorId( domainModel.getContractorId() );
        groundDto.setDescription( domainModel.getDescription() );

        return groundDto.create();
    }
}
