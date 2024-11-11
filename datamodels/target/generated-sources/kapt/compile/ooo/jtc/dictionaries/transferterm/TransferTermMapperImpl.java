package ooo.jtc.dictionaries.transferterm;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class TransferTermMapperImpl implements TransferTermMapper {

    @Override
    public TransferTerm toDomainModel(TransferTermDto dto) {
        if ( dto == null ) {
            return null;
        }

        TransferTermBuilder transferTerm = TransferTermBuilder.builder();

        transferTerm.setId( dto.getId() );
        transferTerm.setVersion( dto.getVersion() );
        transferTerm.setCode( dto.getCode() );
        transferTerm.setDescription( dto.getDescription() );

        return transferTerm.create();
    }

    @Override
    public TransferTermDto toDto(TransferTerm domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        TransferTermDtoBuilder transferTermDto = TransferTermDtoBuilder.builder();

        transferTermDto.setId( domainModel.getId() );
        transferTermDto.setVersion( domainModel.getVersion() );
        transferTermDto.setCode( domainModel.getCode() );
        transferTermDto.setDescription( domainModel.getDescription() );

        return transferTermDto.create();
    }
}
