package ooo.jtc.dictionaries.kbk;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class KbkViewMapperImpl implements KbkViewMapper {

    @Override
    public KbkView toView(KbkDto dto) {
        if ( dto == null ) {
            return null;
        }

        KbkView kbkView = new KbkView();

        kbkView.setCode( dto.getCode() );
        kbkView.setDescription( dto.getDescription() );

        return kbkView;
    }

    @Override
    public KbkDto toDto(KbkView view) {
        if ( view == null ) {
            return null;
        }

        KbkDtoBuilder kbkDto = KbkDtoBuilder.builder();

        kbkDto.setCode( view.getCode() );
        kbkDto.setDescription( view.getDescription() );

        return kbkDto.create();
    }
}
