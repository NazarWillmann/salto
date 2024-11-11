package ooo.jtc.dictionaries.codevo;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class CodeVoMapperImpl implements CodeVoMapper {

    @Override
    public CodeVo toDomainModel(CodeVoDto dto) {
        if ( dto == null ) {
            return null;
        }

        CodeVoBuilder codeVo = CodeVoBuilder.builder();

        codeVo.setId( dto.getId() );
        codeVo.setVersion( dto.getVersion() );
        codeVo.setCode( dto.getCode() );
        codeVo.setDescription( dto.getDescription() );

        return codeVo.create();
    }

    @Override
    public CodeVoDto toDto(CodeVo domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        CodeVoDtoBuilder codeVoDto = CodeVoDtoBuilder.builder();

        codeVoDto.setId( domainModel.getId() );
        codeVoDto.setVersion( domainModel.getVersion() );
        codeVoDto.setCode( domainModel.getCode() );
        codeVoDto.setDescription( domainModel.getDescription() );

        return codeVoDto.create();
    }
}
