package ooo.jtc.dictionaries.ndscalculation;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:42+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class NdsCalculationMapperImpl implements NdsCalculationMapper {

    @Override
    public NdsCalculation toDomainModel(NdsCalculationDto dto) {
        if ( dto == null ) {
            return null;
        }

        NdsCalculationBuilder ndsCalculation = NdsCalculationBuilder.builder();

        ndsCalculation.setId( dto.getId() );
        ndsCalculation.setVersion( dto.getVersion() );
        ndsCalculation.setCode( dto.getCode() );
        ndsCalculation.setDescription( dto.getDescription() );
        ndsCalculation.setTemplate( dto.getTemplate() );
        ndsCalculation.setIsDefaultRuPayment( dto.isDefaultRuPayment );

        return ndsCalculation.create();
    }

    @Override
    public NdsCalculationDto toDto(NdsCalculation domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        NdsCalculationDtoBuilder ndsCalculationDto = NdsCalculationDtoBuilder.builder();

        ndsCalculationDto.setId( domainModel.getId() );
        ndsCalculationDto.setVersion( domainModel.getVersion() );
        ndsCalculationDto.setCode( domainModel.getCode() );
        ndsCalculationDto.setDescription( domainModel.getDescription() );
        ndsCalculationDto.setTemplate( domainModel.getTemplate() );
        ndsCalculationDto.setIsDefaultRuPayment( domainModel.isDefaultRuPayment );

        return ndsCalculationDto.create();
    }
}
