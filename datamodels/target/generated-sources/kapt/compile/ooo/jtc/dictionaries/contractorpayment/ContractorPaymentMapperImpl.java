package ooo.jtc.dictionaries.contractorpayment;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ContractorPaymentMapperImpl implements ContractorPaymentMapper {

    @Override
    public ContractorPayment toDomainModel(ContractorPaymentDto dto) {
        if ( dto == null ) {
            return null;
        }

        ContractorPaymentBuilder contractorPayment = ContractorPaymentBuilder.builder();

        contractorPayment.setId( dto.getId() );
        contractorPayment.setVersion( dto.getVersion() );
        contractorPayment.setContractorId( dto.getContractorId() );
        contractorPayment.setBankName( dto.getBankName() );
        contractorPayment.setBankAddress( dto.getBankAddress() );
        contractorPayment.setCorrAccount( dto.getCorrAccount() );
        contractorPayment.setIsDefault( dto.isDefault );
        contractorPayment.setAccount( dto.getAccount() );
        contractorPayment.setBic( dto.getBic() );

        return contractorPayment.create();
    }

    @Override
    public ContractorPaymentDto toDto(ContractorPayment domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ContractorPaymentDtoBuilder contractorPaymentDto = ContractorPaymentDtoBuilder.builder();

        contractorPaymentDto.setId( domainModel.getId() );
        contractorPaymentDto.setVersion( domainModel.getVersion() );
        contractorPaymentDto.setContractorId( domainModel.getContractorId() );
        contractorPaymentDto.setAccount( domainModel.getAccount() );
        contractorPaymentDto.setBankName( domainModel.getBankName() );
        contractorPaymentDto.setBankAddress( domainModel.getBankAddress() );
        contractorPaymentDto.setCorrAccount( domainModel.getCorrAccount() );
        contractorPaymentDto.setBic( domainModel.getBic() );
        contractorPaymentDto.setIsDefault( domainModel.isDefault );

        return contractorPaymentDto.create();
    }
}
