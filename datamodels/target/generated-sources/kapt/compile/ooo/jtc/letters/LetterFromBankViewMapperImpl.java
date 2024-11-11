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
import ooo.jtc.letters.dto.LetterFromBankDto;
import ooo.jtc.letters.dto.LetterFromBankDtoBuilder;
import ooo.jtc.letters.model.LetterFromBankStatus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class LetterFromBankViewMapperImpl implements LetterFromBankViewMapper {

    private final ViewConverter viewConverter = new ViewConverter();

    @Override
    public LetterFromBankDto toDto(LetterFromBankView view) {
        if ( view == null ) {
            return null;
        }

        LetterFromBankDtoBuilder letterFromBankDto = LetterFromBankDtoBuilder.builder();

        if ( view.getDocumentDate() != null ) {
            letterFromBankDto.setDocumentDate( LocalDate.parse( view.getDocumentDate() ) );
        }
        letterFromBankDto.setBranchId( view.getBranchId() );
        letterFromBankDto.setDocumentNumber( view.getDocumentNumber() );
        letterFromBankDto.setContactName( view.getContactName() );
        letterFromBankDto.setDocType( view.getDocType() );
        letterFromBankDto.setBranchName( view.getBranchName() );
        letterFromBankDto.setDocTypeDescription( view.getDocTypeDescription() );
        letterFromBankDto.setCustomerName( view.getCustomerName() );
        letterFromBankDto.setLetterToBankId( view.getLetterToBankId() );
        if ( view.getCreatedAt() != null ) {
            letterFromBankDto.setCreatedAt( ZonedDateTime.parse( view.getCreatedAt() ) );
        }
        letterFromBankDto.setDocText( view.getDocText() );
        letterFromBankDto.setDocTheme( view.getDocTheme() );
        letterFromBankDto.setCustomerId( view.getCustomerId() );
        letterFromBankDto.setId( view.getId() );
        letterFromBankDto.setContactPhone( view.getContactPhone() );
        letterFromBankDto.setStatus( view.getStatusSystem() );
        letterFromBankDto.setIsFavorites( view.isFavorites );
        letterFromBankDto.setIsHasAttach( view.isHasAttach );
        List<AttachmentDto> list = view.getAttachments();
        if ( list != null ) {
            letterFromBankDto.setAttachments( new ArrayList<AttachmentDto>( list ) );
        }

        return letterFromBankDto.create();
    }

    @Override
    public LetterFromBankView toView(LetterFromBankDto dto) {
        if ( dto == null ) {
            return null;
        }

        LetterFromBankViewBuilder letterFromBankView = LetterFromBankViewBuilder.builder();

        if ( dto.getDocumentDate() != null ) {
            letterFromBankView.setDocumentDate( viewConverter.localDateToString( dto.getDocumentDate() ) );
        }
        else {
            letterFromBankView.setDocumentDate( viewConverter.maskAccount( "" ) );
        }
        letterFromBankView.setBranchId( dto.getBranchId() );
        if ( dto.getDocumentNumber() != null ) {
            letterFromBankView.setDocumentNumber( dto.getDocumentNumber() );
        }
        else {
            letterFromBankView.setDocumentNumber( "" );
        }
        if ( dto.getContactName() != null ) {
            letterFromBankView.setContactName( dto.getContactName() );
        }
        else {
            letterFromBankView.setContactName( "" );
        }
        if ( dto.getDocType() != null ) {
            letterFromBankView.setDocType( dto.getDocType() );
        }
        else {
            letterFromBankView.setDocType( "" );
        }
        if ( dto.getBranchName() != null ) {
            letterFromBankView.setBranchName( dto.getBranchName() );
        }
        else {
            letterFromBankView.setBranchName( "" );
        }
        if ( dto.getDocTypeDescription() != null ) {
            letterFromBankView.setDocTypeDescription( dto.getDocTypeDescription() );
        }
        else {
            letterFromBankView.setDocTypeDescription( "" );
        }
        if ( dto.getCustomerName() != null ) {
            letterFromBankView.setCustomerName( dto.getCustomerName() );
        }
        else {
            letterFromBankView.setCustomerName( "" );
        }
        letterFromBankView.setLetterToBankId( dto.getLetterToBankId() );
        if ( dto.getCreatedAt() != null ) {
            letterFromBankView.setCreatedAt( DateTimeFormatter.ISO_DATE_TIME.format( dto.getCreatedAt() ) );
        }
        else {
            letterFromBankView.setCreatedAt( "" );
        }
        if ( dto.getDocText() != null ) {
            letterFromBankView.setDocText( dto.getDocText() );
        }
        else {
            letterFromBankView.setDocText( "" );
        }
        if ( dto.getDocTheme() != null ) {
            letterFromBankView.setDocTheme( dto.getDocTheme() );
        }
        else {
            letterFromBankView.setDocTheme( "" );
        }
        letterFromBankView.setCustomerId( dto.getCustomerId() );
        if ( dto.getStatus() != null ) {
            letterFromBankView.setStatusSystem( dto.getStatus() );
        }
        else {
            letterFromBankView.setStatusSystem( "" );
        }
        letterFromBankView.setId( dto.getId() );
        if ( dto.getContactPhone() != null ) {
            letterFromBankView.setContactPhone( dto.getContactPhone() );
        }
        else {
            letterFromBankView.setContactPhone( "" );
        }
        letterFromBankView.setIsFavorites( dto.isFavorites );
        letterFromBankView.setIsHasAttach( dto.isHasAttach );
        List<AttachmentDto> list = dto.getAttachments();
        if ( list != null ) {
            letterFromBankView.setAttachments( new ArrayList<AttachmentDto>( list ) );
        }

        letterFromBankView.setStatusBank( KJavaConverter.INSTANCE.convertToStatusBank(LetterFromBankStatus.values(),dto.getStatus()) );
        letterFromBankView.setStatusClient( KJavaConverter.INSTANCE.convertToStatusClient(LetterFromBankStatus.values(),dto.getStatus()) );

        return letterFromBankView.create();
    }
}
