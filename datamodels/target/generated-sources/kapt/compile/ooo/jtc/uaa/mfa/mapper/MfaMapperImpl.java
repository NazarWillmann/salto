package ooo.jtc.uaa.mfa.mapper;

import javax.annotation.processing.Generated;
import ooo.jtc.uaa.mfa.dto.MfaDto;
import ooo.jtc.uaa.mfa.dto.MfaDtoBuilder;
import ooo.jtc.uaa.mfa.model.Mfa;
import ooo.jtc.uaa.mfa.model.MfaBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class MfaMapperImpl implements MfaMapper {

    @Override
    public Mfa toDomainModel(MfaDto dto) {
        if ( dto == null ) {
            return null;
        }

        MfaBuilder mfa = MfaBuilder.builder();

        mfa.setId( dto.getId() );
        mfa.setVersion( dto.getVersion() );
        mfa.setMfaType( dto.getMfaType() );
        mfa.setName( dto.getName() );
        mfa.setTitle( dto.getTitle() );
        mfa.setDescription( dto.getDescription() );

        return mfa.create();
    }

    @Override
    public MfaDto toDto(Mfa domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        MfaDtoBuilder mfaDto = MfaDtoBuilder.builder();

        mfaDto.setId( domainModel.getId() );
        mfaDto.setVersion( domainModel.getVersion() );
        mfaDto.setMfaType( domainModel.getMfaType() );
        mfaDto.setName( domainModel.getName() );
        mfaDto.setTitle( domainModel.getTitle() );
        mfaDto.setDescription( domainModel.getDescription() );

        return mfaDto.create();
    }
}
