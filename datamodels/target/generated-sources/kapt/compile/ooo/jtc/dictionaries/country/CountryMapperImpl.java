package ooo.jtc.dictionaries.country;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country toDomainModel(CountryDto dto) {
        if ( dto == null ) {
            return null;
        }

        CountryBuilder country = CountryBuilder.builder();

        country.setId( dto.getId() );
        country.setVersion( dto.getVersion() );
        country.setDigitCode( dto.getDigitCode() );
        country.setShortName( dto.getShortName() );
        country.setFullName( dto.getFullName() );
        country.setIntNameIso( dto.getIntNameIso() );
        country.setAlpha2Code( dto.getAlpha2Code() );
        country.setAlpha3Code( dto.getAlpha3Code() );

        return country.create();
    }

    @Override
    public CountryDto toDto(Country domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        CountryDtoBuilder countryDto = CountryDtoBuilder.builder();

        countryDto.setId( domainModel.getId() );
        countryDto.setVersion( domainModel.getVersion() );
        countryDto.setDigitCode( domainModel.getDigitCode() );
        countryDto.setShortName( domainModel.getShortName() );
        countryDto.setFullName( domainModel.getFullName() );
        countryDto.setIntNameIso( domainModel.getIntNameIso() );
        countryDto.setAlpha2Code( domainModel.getAlpha2Code() );
        countryDto.setAlpha3Code( domainModel.getAlpha3Code() );

        return countryDto.create();
    }
}
