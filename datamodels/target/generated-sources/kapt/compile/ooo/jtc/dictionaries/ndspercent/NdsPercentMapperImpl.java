package ooo.jtc.dictionaries.ndspercent;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class NdsPercentMapperImpl implements NdsPercentMapper {

    @Override
    public NdsPercent toDomainModel(NdsPercentDto dto) {
        if ( dto == null ) {
            return null;
        }

        NdsPercentBuilder ndsPercent = NdsPercentBuilder.builder();

        ndsPercent.setId( dto.getId() );
        ndsPercent.setVersion( dto.getVersion() );
        ndsPercent.setPercent( dto.getPercent() );
        ndsPercent.setIsDefaultRuPayment( dto.isDefaultRuPayment );

        return ndsPercent.create();
    }

    @Override
    public NdsPercentDto toDto(NdsPercent domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        NdsPercentDtoBuilder ndsPercentDto = NdsPercentDtoBuilder.builder();

        ndsPercentDto.setId( domainModel.getId() );
        ndsPercentDto.setVersion( domainModel.getVersion() );
        ndsPercentDto.setPercent( domainModel.getPercent() );
        ndsPercentDto.setIsDefaultRuPayment( domainModel.isDefaultRuPayment );

        return ndsPercentDto.create();
    }
}
