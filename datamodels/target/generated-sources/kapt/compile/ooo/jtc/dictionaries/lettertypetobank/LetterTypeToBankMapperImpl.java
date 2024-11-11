package ooo.jtc.dictionaries.lettertypetobank;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class LetterTypeToBankMapperImpl implements LetterTypeToBankMapper {

    @Override
    public LetterTypeToBank toDomainModel(LetterTypeToBankDto dto) {
        if ( dto == null ) {
            return null;
        }

        LetterTypeToBankBuilder letterTypeToBank = LetterTypeToBankBuilder.builder();

        letterTypeToBank.setId( dto.getId() );
        letterTypeToBank.setVersion( dto.getVersion() );
        letterTypeToBank.setCode( dto.getCode() );
        letterTypeToBank.setDescription( dto.getDescription() );

        return letterTypeToBank.create();
    }

    @Override
    public LetterTypeToBankDto toDto(LetterTypeToBank domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        LetterTypeToBankDtoBuilder letterTypeToBankDto = LetterTypeToBankDtoBuilder.builder();

        letterTypeToBankDto.setId( domainModel.getId() );
        letterTypeToBankDto.setVersion( domainModel.getVersion() );
        letterTypeToBankDto.setCode( domainModel.getCode() );
        letterTypeToBankDto.setDescription( domainModel.getDescription() );

        return letterTypeToBankDto.create();
    }
}
