package ooo.jtc.dictionaries.lettertypefrombank;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class LetterTypeFromBankMapperImpl implements LetterTypeFromBankMapper {

    @Override
    public LetterTypeFromBank toDomainModel(LetterTypeFromBankDto dto) {
        if ( dto == null ) {
            return null;
        }

        LetterTypeFromBankBuilder letterTypeFromBank = LetterTypeFromBankBuilder.builder();

        letterTypeFromBank.setId( dto.getId() );
        letterTypeFromBank.setVersion( dto.getVersion() );
        letterTypeFromBank.setCode( dto.getCode() );
        letterTypeFromBank.setDescription( dto.getDescription() );

        return letterTypeFromBank.create();
    }

    @Override
    public LetterTypeFromBankDto toDto(LetterTypeFromBank domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        LetterTypeFromBankDtoBuilder letterTypeFromBankDto = LetterTypeFromBankDtoBuilder.builder();

        letterTypeFromBankDto.setId( domainModel.getId() );
        letterTypeFromBankDto.setVersion( domainModel.getVersion() );
        letterTypeFromBankDto.setCode( domainModel.getCode() );
        letterTypeFromBankDto.setDescription( domainModel.getDescription() );

        return letterTypeFromBankDto.create();
    }
}
