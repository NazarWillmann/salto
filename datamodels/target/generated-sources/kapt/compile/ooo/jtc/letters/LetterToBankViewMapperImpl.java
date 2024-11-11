package ooo.jtc.letters;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ooo.jtc.generic.KJavaConverter;
import ooo.jtc.generic.ViewConverter;
import ooo.jtc.generic.attachments.AttachmentDto;
import ooo.jtc.letters.dto.LetterToBankDto;
import ooo.jtc.letters.dto.LetterToBankDtoBuilder;
import ooo.jtc.letters.model.LetterToBankStatus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class LetterToBankViewMapperImpl implements LetterToBankViewMapper {

    private final ViewConverter viewConverter = new ViewConverter();

    @Override
    public LetterToBankDto toDto(LetterToBankView view) {
        if ( view == null ) {
            return null;
        }

        LetterToBankDtoBuilder letterToBankDto = LetterToBankDtoBuilder.builder();

        if ( view.getDocumentDate() != null ) {
            letterToBankDto.setDocumentDate( LocalDate.parse( view.getDocumentDate() ) );
        }
        letterToBankDto.setBranchId( view.getBranchId() );
        List<AttachmentDto> list = view.getAttachments();
        if ( list != null ) {
            letterToBankDto.setAttachments( new ArrayList<AttachmentDto>( list ) );
        }
        letterToBankDto.setDocumentNumber( view.getDocumentNumber() );
        letterToBankDto.setContactName( view.getContactName() );
        letterToBankDto.setDocType( view.getDocType() );
        letterToBankDto.setBranchName( view.getBranchName() );
        letterToBankDto.setDocTypeDescription( view.getDocTypeDescription() );
        letterToBankDto.setCustomerName( view.getCustomerName() );
        letterToBankDto.setLetterFromBankId( view.getLetterFromBankId() );
        if ( view.getCreatedAt() != null ) {
            letterToBankDto.setCreatedAt( ZonedDateTime.parse( view.getCreatedAt() ) );
        }
        letterToBankDto.setDocText( view.getDocText() );
        letterToBankDto.setDocTheme( view.getDocTheme() );
        letterToBankDto.setCustomerId( view.getCustomerId() );
        letterToBankDto.setId( view.getId() );
        letterToBankDto.setContactPhone( view.getContactPhone() );
        letterToBankDto.setStatus( view.getStatusSystem() );
        letterToBankDto.setIsFavorites( view.isFavorites );
        letterToBankDto.setIsHasAttach( view.isHasAttach );

        return letterToBankDto.create();
    }

    @Override
    public LetterToBankView toView(LetterToBankDto dto) {
        if ( dto == null ) {
            return null;
        }

        LetterToBankViewBuilder letterToBankView = LetterToBankViewBuilder.builder();

        if ( dto.getDocumentDate() != null ) {
            letterToBankView.setDocumentDate( viewConverter.localDateToString( dto.getDocumentDate() ) );
        }
        else {
            letterToBankView.setDocumentDate( viewConverter.maskAccount( "" ) );
        }
        letterToBankView.setBranchId( dto.getBranchId() );
        List<AttachmentDto> list = dto.getAttachments();
        if ( list != null ) {
            letterToBankView.setAttachments( new ArrayList<AttachmentDto>( list ) );
        }
        if ( dto.getDocumentNumber() != null ) {
            letterToBankView.setDocumentNumber( dto.getDocumentNumber() );
        }
        else {
            letterToBankView.setDocumentNumber( "" );
        }
        if ( dto.getContactName() != null ) {
            letterToBankView.setContactName( dto.getContactName() );
        }
        else {
            letterToBankView.setContactName( "" );
        }
        if ( dto.getDocType() != null ) {
            letterToBankView.setDocType( dto.getDocType() );
        }
        else {
            letterToBankView.setDocType( "" );
        }
        if ( dto.getBranchName() != null ) {
            letterToBankView.setBranchName( dto.getBranchName() );
        }
        else {
            letterToBankView.setBranchName( "" );
        }
        if ( dto.getDocTypeDescription() != null ) {
            letterToBankView.setDocTypeDescription( dto.getDocTypeDescription() );
        }
        else {
            letterToBankView.setDocTypeDescription( "" );
        }
        if ( dto.getCustomerName() != null ) {
            letterToBankView.setCustomerName( dto.getCustomerName() );
        }
        else {
            letterToBankView.setCustomerName( "" );
        }
        letterToBankView.setLetterFromBankId( dto.getLetterFromBankId() );
        if ( dto.getCreatedAt() != null ) {
            letterToBankView.setCreatedAt( DateTimeFormatter.ISO_DATE_TIME.format( dto.getCreatedAt() ) );
        }
        else {
            letterToBankView.setCreatedAt( "" );
        }
        if ( dto.getDocText() != null ) {
            letterToBankView.setDocText( dto.getDocText() );
        }
        else {
            letterToBankView.setDocText( "" );
        }
        if ( dto.getDocTheme() != null ) {
            letterToBankView.setDocTheme( dto.getDocTheme() );
        }
        else {
            letterToBankView.setDocTheme( "" );
        }
        letterToBankView.setCustomerId( dto.getCustomerId() );
        if ( dto.getStatus() != null ) {
            letterToBankView.setStatusSystem( dto.getStatus() );
        }
        else {
            letterToBankView.setStatusSystem( "" );
        }
        letterToBankView.setId( dto.getId() );
        if ( dto.getContactPhone() != null ) {
            letterToBankView.setContactPhone( dto.getContactPhone() );
        }
        else {
            letterToBankView.setContactPhone( "" );
        }
        letterToBankView.setIsFavorites( dto.isFavorites );
        letterToBankView.setIsHasAttach( dto.isHasAttach );

        letterToBankView.setStatusBank( KJavaConverter.INSTANCE.convertToStatusBank(LetterToBankStatus.values(),dto.getStatus()) );
        letterToBankView.setStatusClient( KJavaConverter.INSTANCE.convertToStatusClient(LetterToBankStatus.values(),dto.getStatus()) );
        letterToBankView.setContactPhoneMasked( KJavaConverter.INSTANCE.getUiMaskedPhone(dto.getContactPhone()) );

        return letterToBankView.create();
    }
}
