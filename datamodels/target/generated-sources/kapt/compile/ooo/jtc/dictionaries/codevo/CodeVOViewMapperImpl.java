package ooo.jtc.dictionaries.codevo;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class CodeVOViewMapperImpl implements CodeVOViewMapper {

    @Override
    public CodeVoView toView(CodeVoDto dto) {
        if ( dto == null ) {
            return null;
        }

        CodeVoView codeVoView = new CodeVoView();

        codeVoView.setCode( dto.getCode() );
        codeVoView.setDescription( dto.getDescription() );

        return codeVoView;
    }

    @Override
    public CodeVoDto toDto(CodeVoView view) {
        if ( view == null ) {
            return null;
        }

        CodeVoDtoBuilder codeVoDto = CodeVoDtoBuilder.builder();

        codeVoDto.setCode( view.getCode() );
        codeVoDto.setDescription( view.getDescription() );

        return codeVoDto.create();
    }
}
