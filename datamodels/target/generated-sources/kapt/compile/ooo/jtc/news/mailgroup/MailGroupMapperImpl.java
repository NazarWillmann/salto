package ooo.jtc.news.mailgroup;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ooo.jtc.news.dto.ReceiverCustomerDto;
import ooo.jtc.news.dto.ReceiverCustomerDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class MailGroupMapperImpl implements MailGroupMapper {

    @Override
    public MailGroup toDomainModel(MailGroupDto dto) {
        if ( dto == null ) {
            return null;
        }

        MailGroupBuilder mailGroup = MailGroupBuilder.builder();

        mailGroup.setId( dto.getId() );
        mailGroup.setVersion( dto.getVersion() );
        mailGroup.setBranchId( dto.getBranchId() );
        mailGroup.setBranchName( dto.getBranchName() );
        mailGroup.setChannel( dto.getChannel() );
        mailGroup.setName( dto.getName() );
        mailGroup.setCreatedAt( dto.getCreatedAt() );
        mailGroup.setCreatedUserName( dto.getCreatedUserName() );
        mailGroup.setEditedAt( dto.getEditedAt() );
        mailGroup.setEditedUserName( dto.getEditedUserName() );
        mailGroup.setCustomers( receiverCustomerDtoListToMailGroupReceiverCustomerList( dto.getCustomers() ) );

        return mailGroup.create();
    }

    @Override
    public MailGroupDto toDto(MailGroup domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        MailGroupDtoBuilder mailGroupDto = MailGroupDtoBuilder.builder();

        mailGroupDto.setId( domainModel.getId() );
        mailGroupDto.setVersion( domainModel.getVersion() );
        mailGroupDto.setBranchId( domainModel.getBranchId() );
        mailGroupDto.setBranchName( domainModel.getBranchName() );
        mailGroupDto.setChannel( domainModel.getChannel() );
        mailGroupDto.setCreatedAt( domainModel.getCreatedAt() );
        mailGroupDto.setCreatedUserName( domainModel.getCreatedUserName() );
        mailGroupDto.setEditedAt( domainModel.getEditedAt() );
        mailGroupDto.setEditedUserName( domainModel.getEditedUserName() );
        mailGroupDto.setCustomers( mailGroupReceiverCustomerListToReceiverCustomerDtoList( domainModel.getCustomers() ) );
        mailGroupDto.setName( domainModel.getName() );

        return mailGroupDto.create();
    }

    protected MailGroupReceiverCustomer receiverCustomerDtoToMailGroupReceiverCustomer(ReceiverCustomerDto receiverCustomerDto) {
        if ( receiverCustomerDto == null ) {
            return null;
        }

        MailGroupReceiverCustomerBuilder mailGroupReceiverCustomer = MailGroupReceiverCustomerBuilder.builder();

        mailGroupReceiverCustomer.setId( receiverCustomerDto.getId() );
        mailGroupReceiverCustomer.setVersion( receiverCustomerDto.getVersion() );
        mailGroupReceiverCustomer.setCustomerId( receiverCustomerDto.getCustomerId() );
        mailGroupReceiverCustomer.setCustomerName( receiverCustomerDto.getCustomerName() );
        mailGroupReceiverCustomer.setInn( receiverCustomerDto.getInn() );

        return mailGroupReceiverCustomer.create();
    }

    protected List<MailGroupReceiverCustomer> receiverCustomerDtoListToMailGroupReceiverCustomerList(List<ReceiverCustomerDto> list) {
        if ( list == null ) {
            return null;
        }

        List<MailGroupReceiverCustomer> list1 = new ArrayList<MailGroupReceiverCustomer>( list.size() );
        for ( ReceiverCustomerDto receiverCustomerDto : list ) {
            list1.add( receiverCustomerDtoToMailGroupReceiverCustomer( receiverCustomerDto ) );
        }

        return list1;
    }

    protected ReceiverCustomerDto mailGroupReceiverCustomerToReceiverCustomerDto(MailGroupReceiverCustomer mailGroupReceiverCustomer) {
        if ( mailGroupReceiverCustomer == null ) {
            return null;
        }

        ReceiverCustomerDtoBuilder receiverCustomerDto = ReceiverCustomerDtoBuilder.builder();

        receiverCustomerDto.setId( mailGroupReceiverCustomer.getId() );
        receiverCustomerDto.setVersion( mailGroupReceiverCustomer.getVersion() );
        receiverCustomerDto.setCustomerId( mailGroupReceiverCustomer.getCustomerId() );
        receiverCustomerDto.setCustomerName( mailGroupReceiverCustomer.getCustomerName() );
        receiverCustomerDto.setInn( mailGroupReceiverCustomer.getInn() );

        return receiverCustomerDto.create();
    }

    protected List<ReceiverCustomerDto> mailGroupReceiverCustomerListToReceiverCustomerDtoList(List<MailGroupReceiverCustomer> list) {
        if ( list == null ) {
            return null;
        }

        List<ReceiverCustomerDto> list1 = new ArrayList<ReceiverCustomerDto>( list.size() );
        for ( MailGroupReceiverCustomer mailGroupReceiverCustomer : list ) {
            list1.add( mailGroupReceiverCustomerToReceiverCustomerDto( mailGroupReceiverCustomer ) );
        }

        return list1;
    }
}
