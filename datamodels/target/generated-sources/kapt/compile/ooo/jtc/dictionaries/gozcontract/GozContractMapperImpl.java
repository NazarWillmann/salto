package ooo.jtc.dictionaries.gozcontract;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class GozContractMapperImpl implements GozContractMapper {

    @Override
    public GozContract toDomainModel(GozContractDto dto) {
        if ( dto == null ) {
            return null;
        }

        GozContractBuilder gozContract = GozContractBuilder.builder();

        gozContract.setId( dto.getId() );
        gozContract.setVersion( dto.getVersion() );
        gozContract.setNumber( dto.getNumber() );
        gozContract.setDate( dto.getDate() );
        gozContract.setIdentity( dto.getIdentity() );
        gozContract.setContractNumber( dto.getContractNumber() );
        gozContract.setContractDate( dto.getContractDate() );

        return gozContract.create();
    }

    @Override
    public GozContractDto toDto(GozContract domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        GozContractDtoBuilder gozContractDto = GozContractDtoBuilder.builder();

        gozContractDto.setId( domainModel.getId() );
        gozContractDto.setVersion( domainModel.getVersion() );
        gozContractDto.setNumber( domainModel.getNumber() );
        gozContractDto.setDate( domainModel.getDate() );
        gozContractDto.setIdentity( domainModel.getIdentity() );
        gozContractDto.setContractNumber( domainModel.getContractNumber() );
        gozContractDto.setContractDate( domainModel.getContractDate() );

        return gozContractDto.create();
    }
}
