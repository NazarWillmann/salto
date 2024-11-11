package ooo.jtc.dictionaries.person;

import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDto toDto(Person domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        PersonDtoBuilder personDto = PersonDtoBuilder.builder();

        personDto.setPersonalData( personToPersonalDataDto( domainModel ) );
        personDto.setConfirmedEmail( domainModel.getEmailConfirmed() );
        personDto.setConfirmedMobilePhone( domainModel.getPhoneConfirmed() );
        personDto.setId( domainModel.getId() );
        personDto.setVersion( domainModel.getVersion() );
        personDto.setDescription( domainModel.getDescription() );
        personDto.setCategory( domainModel.getCategory() );

        return personDto.create();
    }

    @Override
    public Person toDomainModel(PersonDto dto) {
        if ( dto == null ) {
            return null;
        }

        PersonBuilder person = PersonBuilder.builder();

        person.setLastName( dtoPersonalDataLastName( dto ) );
        person.setFirstName( dtoPersonalDataFirstName( dto ) );
        person.setBirthdate( dtoPersonalDataBirthdate( dto ) );
        person.setEmailConfirmed( dto.getConfirmedEmail() );
        person.setMobilePhone( dtoPersonalDataMobilePhone( dto ) );
        person.setSex( dtoPersonalDataSex( dto ) );
        person.setMiddleName( dtoPersonalDataMiddleName( dto ) );
        person.setPhoneConfirmed( dto.getConfirmedMobilePhone() );
        person.setEmail( dtoPersonalDataEmail( dto ) );
        person.setId( dto.getId() );
        person.setVersion( dto.getVersion() );
        person.setDescription( dto.getDescription() );
        person.setCategory( dto.getCategory() );

        return person.create();
    }

    protected PersonalDataDto personToPersonalDataDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonalDataDtoBuilder personalDataDto = PersonalDataDtoBuilder.builder();

        personalDataDto.setLastName( person.getLastName() );
        personalDataDto.setBirthdate( person.getBirthdate() );
        personalDataDto.setMobilePhone( person.getMobilePhone() );
        personalDataDto.setSex( person.getSex() );
        personalDataDto.setFirstName( person.getFirstName() );
        personalDataDto.setMiddleName( person.getMiddleName() );
        personalDataDto.setEmail( person.getEmail() );

        return personalDataDto.create();
    }

    private String dtoPersonalDataLastName(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }
        PersonalDataDto personalData = personDto.getPersonalData();
        if ( personalData == null ) {
            return null;
        }
        String lastName = personalData.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String dtoPersonalDataFirstName(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }
        PersonalDataDto personalData = personDto.getPersonalData();
        if ( personalData == null ) {
            return null;
        }
        String firstName = personalData.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private LocalDate dtoPersonalDataBirthdate(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }
        PersonalDataDto personalData = personDto.getPersonalData();
        if ( personalData == null ) {
            return null;
        }
        LocalDate birthdate = personalData.getBirthdate();
        if ( birthdate == null ) {
            return null;
        }
        return birthdate;
    }

    private String dtoPersonalDataMobilePhone(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }
        PersonalDataDto personalData = personDto.getPersonalData();
        if ( personalData == null ) {
            return null;
        }
        String mobilePhone = personalData.getMobilePhone();
        if ( mobilePhone == null ) {
            return null;
        }
        return mobilePhone;
    }

    private String dtoPersonalDataSex(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }
        PersonalDataDto personalData = personDto.getPersonalData();
        if ( personalData == null ) {
            return null;
        }
        String sex = personalData.getSex();
        if ( sex == null ) {
            return null;
        }
        return sex;
    }

    private String dtoPersonalDataMiddleName(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }
        PersonalDataDto personalData = personDto.getPersonalData();
        if ( personalData == null ) {
            return null;
        }
        String middleName = personalData.getMiddleName();
        if ( middleName == null ) {
            return null;
        }
        return middleName;
    }

    private String dtoPersonalDataEmail(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }
        PersonalDataDto personalData = personDto.getPersonalData();
        if ( personalData == null ) {
            return null;
        }
        String email = personalData.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }
}
