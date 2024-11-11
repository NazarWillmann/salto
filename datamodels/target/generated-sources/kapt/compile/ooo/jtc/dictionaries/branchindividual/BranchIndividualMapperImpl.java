package ooo.jtc.dictionaries.branchindividual;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BranchIndividualMapperImpl implements BranchIndividualMapper {

    @Override
    public BranchIndividual toDomainModel(BranchIndividualDto dto) {
        if ( dto == null ) {
            return null;
        }

        BranchIndividualBuilder branchIndividual = BranchIndividualBuilder.builder();

        branchIndividual.setId( dto.getId() );
        branchIndividual.setVersion( dto.getVersion() );
        branchIndividual.setBranchId( dto.getBranchId() );
        branchIndividual.setIndividualId( dto.getIndividualId() );

        return branchIndividual.create();
    }

    @Override
    public BranchIndividualDto toDto(BranchIndividual domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BranchIndividualDtoBuilder branchIndividualDto = BranchIndividualDtoBuilder.builder();

        branchIndividualDto.setId( domainModel.getId() );
        branchIndividualDto.setVersion( domainModel.getVersion() );
        branchIndividualDto.setIndividualId( domainModel.getIndividualId() );
        branchIndividualDto.setBranchId( domainModel.getBranchId() );

        return branchIndividualDto.create();
    }
}
