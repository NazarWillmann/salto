package ooo.jtc.dictionaries.branchcustomer;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BranchCustomerMapperImpl implements BranchCustomerMapper {

    @Override
    public BranchCustomer toDomainModel(BranchCustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        BranchCustomerBuilder branchCustomer = BranchCustomerBuilder.builder();

        branchCustomer.setId( dto.getId() );
        branchCustomer.setVersion( dto.getVersion() );
        branchCustomer.setCustomerId( dto.getCustomerId() );
        branchCustomer.setBranchId( dto.getBranchId() );

        return branchCustomer.create();
    }

    @Override
    public BranchCustomerDto toDto(BranchCustomer domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BranchCustomerDtoBuilder branchCustomerDto = BranchCustomerDtoBuilder.builder();

        branchCustomerDto.setId( domainModel.getId() );
        branchCustomerDto.setVersion( domainModel.getVersion() );
        branchCustomerDto.setCustomerId( domainModel.getCustomerId() );
        branchCustomerDto.setBranchId( domainModel.getBranchId() );

        return branchCustomerDto.create();
    }
}
