package ooo.jtc.dictionaries.bankru;

import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.controlcode.ControlCode;
import ooo.jtc.dictionaries.controlcode.ControlCodeBuilder;
import ooo.jtc.dictionaries.controlcode.ControlCodeDto;
import ooo.jtc.dictionaries.controlcode.ControlCodeDtoBuilder;
import ooo.jtc.dictionaries.locationtype.LocationType;
import ooo.jtc.dictionaries.locationtype.LocationTypeBuilder;
import ooo.jtc.dictionaries.locationtype.LocationTypeDto;
import ooo.jtc.dictionaries.locationtype.LocationTypeDtoBuilder;
import ooo.jtc.dictionaries.uer.Uer;
import ooo.jtc.dictionaries.uer.UerBuilder;
import ooo.jtc.dictionaries.uer.UerDto;
import ooo.jtc.dictionaries.uer.UerDtoBuilder;
import ooo.jtc.generic.CustomConverter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BankRuMapperImpl implements BankRuMapper {

    private final CustomConverter customConverter = new CustomConverter();

    @Override
    public BankRuDto toDto(BankRu domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankRuDtoBuilder bankRuDto = BankRuDtoBuilder.builder();

        bankRuDto.setControlDate( customConverter.timestampToZonedDateTime( domainModel.getControlDate() ) );
        bankRuDto.setId( domainModel.getId() );
        bankRuDto.setVersion( domainModel.getVersion() );
        bankRuDto.setBic( domainModel.getBic() );
        bankRuDto.setBankName( domainModel.getBankName() );
        bankRuDto.setCorrAccount( domainModel.getCorrAccount() );
        bankRuDto.setAddress( domainModel.getAddress() );
        bankRuDto.setZip( domainModel.getZip() );
        bankRuDto.setLocation( domainModel.getLocation() );
        bankRuDto.setPhone( domainModel.getPhone() );
        bankRuDto.setRegNumber( domainModel.getRegNumber() );
        bankRuDto.setIdLocationType( domainModel.getIdLocationType() );
        bankRuDto.setIdControlCode( domainModel.getIdControlCode() );
        bankRuDto.setIdUer( domainModel.getIdUer() );
        bankRuDto.setLocationType( locationTypeToLocationTypeDto( domainModel.getLocationType() ) );
        bankRuDto.setControlCode( controlCodeToControlCodeDto( domainModel.getControlCode() ) );
        bankRuDto.setUer( uerToUerDto( domainModel.getUer() ) );

        return bankRuDto.create();
    }

    @Override
    public BankRu toDomainModel(BankRuDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankRuBuilder bankRu = BankRuBuilder.builder();

        bankRu.setControlDate( customConverter.zonedDateTimeToTimestamp( dto.getControlDate() ) );
        bankRu.setId( dto.getId() );
        bankRu.setVersion( dto.getVersion() );
        bankRu.setBic( dto.getBic() );
        bankRu.setBankName( dto.getBankName() );
        bankRu.setCorrAccount( dto.getCorrAccount() );
        bankRu.setAddress( dto.getAddress() );
        bankRu.setZip( dto.getZip() );
        bankRu.setLocation( dto.getLocation() );
        bankRu.setPhone( dto.getPhone() );
        bankRu.setRegNumber( dto.getRegNumber() );
        bankRu.setIdLocationType( dto.getIdLocationType() );
        bankRu.setIdControlCode( dto.getIdControlCode() );
        bankRu.setIdUer( dto.getIdUer() );
        bankRu.setLocationType( locationTypeDtoToLocationType( dto.getLocationType() ) );
        bankRu.setControlCode( controlCodeDtoToControlCode( dto.getControlCode() ) );
        bankRu.setUer( uerDtoToUer( dto.getUer() ) );

        return bankRu.create();
    }

    protected LocationTypeDto locationTypeToLocationTypeDto(LocationType locationType) {
        if ( locationType == null ) {
            return null;
        }

        LocationTypeDtoBuilder locationTypeDto = LocationTypeDtoBuilder.builder();

        locationTypeDto.setId( locationType.getId() );
        locationTypeDto.setVersion( locationType.getVersion() );
        locationTypeDto.setLocationType( locationType.getLocationType() );
        locationTypeDto.setName( locationType.getName() );
        locationTypeDto.setNameShort( locationType.getNameShort() );

        return locationTypeDto.create();
    }

    protected ControlCodeDto controlCodeToControlCodeDto(ControlCode controlCode) {
        if ( controlCode == null ) {
            return null;
        }

        ControlCodeDtoBuilder controlCodeDto = ControlCodeDtoBuilder.builder();

        controlCodeDto.setId( controlCode.getId() );
        controlCodeDto.setVersion( controlCode.getVersion() );
        controlCodeDto.setCode( controlCode.getCode() );
        controlCodeDto.setDescription( controlCode.getDescription() );

        return controlCodeDto.create();
    }

    protected UerDto uerToUerDto(Uer uer) {
        if ( uer == null ) {
            return null;
        }

        UerDtoBuilder uerDto = UerDtoBuilder.builder();

        uerDto.setId( uer.getId() );
        uerDto.setVersion( uer.getVersion() );
        uerDto.setUer( uer.getUer() );
        uerDto.setBankType( uer.getBankType() );
        uerDto.setDescription( uer.getDescription() );

        return uerDto.create();
    }

    protected LocationType locationTypeDtoToLocationType(LocationTypeDto locationTypeDto) {
        if ( locationTypeDto == null ) {
            return null;
        }

        LocationTypeBuilder locationType = LocationTypeBuilder.builder();

        locationType.setId( locationTypeDto.getId() );
        locationType.setVersion( locationTypeDto.getVersion() );
        locationType.setLocationType( locationTypeDto.getLocationType() );
        locationType.setName( locationTypeDto.getName() );
        locationType.setNameShort( locationTypeDto.getNameShort() );

        return locationType.create();
    }

    protected ControlCode controlCodeDtoToControlCode(ControlCodeDto controlCodeDto) {
        if ( controlCodeDto == null ) {
            return null;
        }

        ControlCodeBuilder controlCode = ControlCodeBuilder.builder();

        controlCode.setId( controlCodeDto.getId() );
        controlCode.setVersion( controlCodeDto.getVersion() );
        controlCode.setCode( controlCodeDto.getCode() );
        controlCode.setDescription( controlCodeDto.getDescription() );

        return controlCode.create();
    }

    protected Uer uerDtoToUer(UerDto uerDto) {
        if ( uerDto == null ) {
            return null;
        }

        UerBuilder uer = UerBuilder.builder();

        uer.setId( uerDto.getId() );
        uer.setVersion( uerDto.getVersion() );
        uer.setUer( uerDto.getUer() );
        uer.setBankType( uerDto.getBankType() );
        uer.setDescription( uerDto.getDescription() );

        return uer.create();
    }
}
