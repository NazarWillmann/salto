package ooo.jtc.rupayment;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import ooo.jtc.generic.KJavaConverter;
import ooo.jtc.generic.ViewConverter;
import ooo.jtc.rupayment.dto.BankDto;
import ooo.jtc.rupayment.dto.BudgetDto;
import ooo.jtc.rupayment.dto.PayerDto;
import ooo.jtc.rupayment.dto.PaymentGroundDto;
import ooo.jtc.rupayment.dto.ReceiverDto;
import ooo.jtc.rupayment.dto.RuPaymentDto;
import ooo.jtc.rupayment.dto.RuPaymentDtoBuilder;
import ooo.jtc.rupayment.model.RuPaymentStatus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class RuPaymentViewMapperImpl implements RuPaymentViewMapper {

    private final ViewConverter viewConverter = new ViewConverter();

    @Override
    public RuPaymentDto toDto(RuPaymentView view) {
        if ( view == null ) {
            return null;
        }

        RuPaymentDtoBuilder ruPaymentDto = RuPaymentDtoBuilder.builder();

        ruPaymentDto.setId( view.getId() );
        ruPaymentDto.setDocumentNumber( view.getDocumentNumber() );
        if ( view.getDocumentDate() != null ) {
            ruPaymentDto.setDocumentDate( LocalDate.parse( view.getDocumentDate() ) );
        }
        ruPaymentDto.setCustomerId( view.getCustomerId() );
        if ( view.getAmount() != null ) {
            ruPaymentDto.setAmount( new BigDecimal( view.getAmount() ) );
        }
        ruPaymentDto.setPriority( view.getPriority() );
        ruPaymentDto.setUserPaymentType( view.getUserPaymentType() );
        ruPaymentDto.setBudgetType( view.getBudgetType() );

        return ruPaymentDto.create();
    }

    @Override
    public RuPaymentView toView(RuPaymentDto dto) {
        if ( dto == null ) {
            return null;
        }

        RuPaymentViewBuilder ruPaymentView = RuPaymentViewBuilder.builder();

        if ( dto.getDocumentDate() != null ) {
            ruPaymentView.setDocumentDate( viewConverter.localDateToString( dto.getDocumentDate() ) );
        }
        else {
            ruPaymentView.setDocumentDate( viewConverter.maskAccount( "" ) );
        }
        ruPaymentView.setBudgetType( dto.getBudgetType() );
        if ( dtoBudgetBudgetField107( dto ) != null ) {
            ruPaymentView.setBudgetBudgetField107( dtoBudgetBudgetField107( dto ) );
        }
        else {
            ruPaymentView.setBudgetBudgetField107( "" );
        }
        if ( dtoReceiverBankName( dto ) != null ) {
            ruPaymentView.setReceiverBankName( dtoReceiverBankName( dto ) );
        }
        else {
            ruPaymentView.setReceiverBankName( "" );
        }
        if ( dtoReceiverAccount( dto ) != null ) {
            ruPaymentView.setReceiverAccount( dtoReceiverAccount( dto ) );
        }
        else {
            ruPaymentView.setReceiverAccount( "" );
        }
        if ( dtoReceiverBankCorrAccount( dto ) != null ) {
            ruPaymentView.setReceiverBankCorrAccount( dtoReceiverBankCorrAccount( dto ) );
        }
        else {
            ruPaymentView.setReceiverBankCorrAccount( "" );
        }
        if ( dtoReceiverKpp( dto ) != null ) {
            ruPaymentView.setReceiverKpp( dtoReceiverKpp( dto ) );
        }
        else {
            ruPaymentView.setReceiverKpp( "" );
        }
        if ( dtoPayerAccount( dto ) != null ) {
            ruPaymentView.setPayerMaskedAccount( viewConverter.maskAccount( dtoPayerAccount( dto ) ) );
        }
        else {
            ruPaymentView.setPayerMaskedAccount( viewConverter.maskAccount( "" ) );
        }
        if ( dtoPaymentGroundDescription( dto ) != null ) {
            ruPaymentView.setPaymentGroundDescription( dtoPaymentGroundDescription( dto ) );
        }
        else {
            ruPaymentView.setPaymentGroundDescription( "" );
        }
        if ( dtoBudgetReasonDocumentNumber( dto ) != null ) {
            ruPaymentView.setBudgetReasonDocumentNumber( dtoBudgetReasonDocumentNumber( dto ) );
        }
        else {
            ruPaymentView.setBudgetReasonDocumentNumber( "" );
        }
        if ( dtoReceiverInn( dto ) != null ) {
            ruPaymentView.setReceiverInn( dtoReceiverInn( dto ) );
        }
        else {
            ruPaymentView.setReceiverInn( "" );
        }
        if ( dtoPayerName( dto ) != null ) {
            ruPaymentView.setPayerName( dtoPayerName( dto ) );
        }
        else {
            ruPaymentView.setPayerName( "" );
        }
        if ( dto.getStatus() != null ) {
            ruPaymentView.setStatusSystem( dto.getStatus() );
        }
        else {
            ruPaymentView.setStatusSystem( "" );
        }
        ruPaymentView.setUserPaymentType( dto.getUserPaymentType() );
        ruPaymentView.setId( dto.getId() );
        if ( dto.getAmount() != null ) {
            ruPaymentView.setAmount( viewConverter.amountToString( dto.getAmount() ) );
        }
        else {
            ruPaymentView.setAmount( viewConverter.maskAccount( "" ) );
        }
        if ( dtoReceiverBankCorrAccount( dto ) != null ) {
            ruPaymentView.setReceiverBankMaskedCorrAccount( viewConverter.maskAccount( dtoReceiverBankCorrAccount( dto ) ) );
        }
        else {
            ruPaymentView.setReceiverBankMaskedCorrAccount( viewConverter.maskAccount( "" ) );
        }
        if ( dtoBudgetPayerStatus( dto ) != null ) {
            ruPaymentView.setBudgetPayerStatus( dtoBudgetPayerStatus( dto ) );
        }
        else {
            ruPaymentView.setBudgetPayerStatus( "" );
        }
        if ( dtoReceiverName( dto ) != null ) {
            ruPaymentView.setReceiverName( dtoReceiverName( dto ) );
        }
        else {
            ruPaymentView.setReceiverName( "" );
        }
        if ( dtoPayerKpp( dto ) != null ) {
            ruPaymentView.setPayerKpp( dtoPayerKpp( dto ) );
        }
        else {
            ruPaymentView.setPayerKpp( "" );
        }
        if ( dtoPayerInn( dto ) != null ) {
            ruPaymentView.setPayerInn( dtoPayerInn( dto ) );
        }
        else {
            ruPaymentView.setPayerInn( "" );
        }
        if ( dtoBudgetReasonDocumentDate( dto ) != null ) {
            ruPaymentView.setBudgetReasonDocumentDate( dtoBudgetReasonDocumentDate( dto ) );
        }
        else {
            ruPaymentView.setBudgetReasonDocumentDate( "" );
        }
        if ( dto.getPriority() != null ) {
            ruPaymentView.setPriority( dto.getPriority() );
        }
        else {
            ruPaymentView.setPriority( "" );
        }
        if ( dtoPayerAccount( dto ) != null ) {
            ruPaymentView.setPayerAccount( dtoPayerAccount( dto ) );
        }
        else {
            ruPaymentView.setPayerAccount( "" );
        }
        if ( dtoBudgetOktmo( dto ) != null ) {
            ruPaymentView.setBudgetOktmo( dtoBudgetOktmo( dto ) );
        }
        else {
            ruPaymentView.setBudgetOktmo( "" );
        }
        if ( dtoReceiverBankBic( dto ) != null ) {
            ruPaymentView.setReceiverBankBic( dtoReceiverBankBic( dto ) );
        }
        else {
            ruPaymentView.setReceiverBankBic( "" );
        }
        if ( dtoBudgetReasonCode( dto ) != null ) {
            ruPaymentView.setBudgetReasonCode( dtoBudgetReasonCode( dto ) );
        }
        else {
            ruPaymentView.setBudgetReasonCode( "" );
        }
        if ( dtoPaymentGroundNds( dto ) != null ) {
            ruPaymentView.setNds( viewConverter.amountToString( dtoPaymentGroundNds( dto ) ) );
        }
        else {
            ruPaymentView.setNds( viewConverter.maskAccount( "" ) );
        }
        if ( dtoBudgetKbk( dto ) != null ) {
            ruPaymentView.setBudgetKbk( dtoBudgetKbk( dto ) );
        }
        else {
            ruPaymentView.setBudgetKbk( "" );
        }
        if ( dtoReceiverAccount( dto ) != null ) {
            ruPaymentView.setReceiverMaskedAccount( viewConverter.maskAccount( dtoReceiverAccount( dto ) ) );
        }
        else {
            ruPaymentView.setReceiverMaskedAccount( viewConverter.maskAccount( "" ) );
        }
        ruPaymentView.setCustomerId( dto.getCustomerId() );
        ruPaymentView.setDocumentNumber( dto.getDocumentNumber() );

        ruPaymentView.setStatusBank( KJavaConverter.INSTANCE.convertToStatusBank(RuPaymentStatus.values(),dto.getStatus()) );
        ruPaymentView.setStatusClient( KJavaConverter.INSTANCE.convertToStatusClient(RuPaymentStatus.values(),dto.getStatus()) );
        ruPaymentView.setAmountMasked( KJavaConverter.INSTANCE.amountToMaskedString(dto.getAmount()) );
        ruPaymentView.setAmountAntie( KJavaConverter.INSTANCE.amountToMaskedAntieString(dto.getAmount()) );
        ruPaymentView.setPayerHiddenMaskedAccount( KJavaConverter.INSTANCE.hiddenMaskAccount(dto.getPayer().getAccount()) );

        return ruPaymentView.create();
    }

    private String dtoBudgetBudgetField107(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        BudgetDto budget = ruPaymentDto.getBudget();
        if ( budget == null ) {
            return null;
        }
        String budgetField107 = budget.getBudgetField107();
        if ( budgetField107 == null ) {
            return null;
        }
        return budgetField107;
    }

    private String dtoReceiverBankName(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        ReceiverDto receiver = ruPaymentDto.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        BankDto bank = receiver.getBank();
        if ( bank == null ) {
            return null;
        }
        String name = bank.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String dtoReceiverAccount(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        ReceiverDto receiver = ruPaymentDto.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        String account = receiver.getAccount();
        if ( account == null ) {
            return null;
        }
        return account;
    }

    private String dtoReceiverBankCorrAccount(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        ReceiverDto receiver = ruPaymentDto.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        BankDto bank = receiver.getBank();
        if ( bank == null ) {
            return null;
        }
        String corrAccount = bank.getCorrAccount();
        if ( corrAccount == null ) {
            return null;
        }
        return corrAccount;
    }

    private String dtoReceiverKpp(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        ReceiverDto receiver = ruPaymentDto.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        String kpp = receiver.getKpp();
        if ( kpp == null ) {
            return null;
        }
        return kpp;
    }

    private String dtoPayerAccount(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        PayerDto payer = ruPaymentDto.getPayer();
        if ( payer == null ) {
            return null;
        }
        String account = payer.getAccount();
        if ( account == null ) {
            return null;
        }
        return account;
    }

    private String dtoPaymentGroundDescription(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        PaymentGroundDto paymentGround = ruPaymentDto.getPaymentGround();
        if ( paymentGround == null ) {
            return null;
        }
        String description = paymentGround.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private String dtoBudgetReasonDocumentNumber(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        BudgetDto budget = ruPaymentDto.getBudget();
        if ( budget == null ) {
            return null;
        }
        String reasonDocumentNumber = budget.getReasonDocumentNumber();
        if ( reasonDocumentNumber == null ) {
            return null;
        }
        return reasonDocumentNumber;
    }

    private String dtoReceiverInn(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        ReceiverDto receiver = ruPaymentDto.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        String inn = receiver.getInn();
        if ( inn == null ) {
            return null;
        }
        return inn;
    }

    private String dtoPayerName(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        PayerDto payer = ruPaymentDto.getPayer();
        if ( payer == null ) {
            return null;
        }
        String name = payer.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String dtoBudgetPayerStatus(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        BudgetDto budget = ruPaymentDto.getBudget();
        if ( budget == null ) {
            return null;
        }
        String payerStatus = budget.getPayerStatus();
        if ( payerStatus == null ) {
            return null;
        }
        return payerStatus;
    }

    private String dtoReceiverName(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        ReceiverDto receiver = ruPaymentDto.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        String name = receiver.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String dtoPayerKpp(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        PayerDto payer = ruPaymentDto.getPayer();
        if ( payer == null ) {
            return null;
        }
        String kpp = payer.getKpp();
        if ( kpp == null ) {
            return null;
        }
        return kpp;
    }

    private String dtoPayerInn(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        PayerDto payer = ruPaymentDto.getPayer();
        if ( payer == null ) {
            return null;
        }
        String inn = payer.getInn();
        if ( inn == null ) {
            return null;
        }
        return inn;
    }

    private String dtoBudgetReasonDocumentDate(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        BudgetDto budget = ruPaymentDto.getBudget();
        if ( budget == null ) {
            return null;
        }
        String reasonDocumentDate = budget.getReasonDocumentDate();
        if ( reasonDocumentDate == null ) {
            return null;
        }
        return reasonDocumentDate;
    }

    private String dtoBudgetOktmo(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        BudgetDto budget = ruPaymentDto.getBudget();
        if ( budget == null ) {
            return null;
        }
        String oktmo = budget.getOktmo();
        if ( oktmo == null ) {
            return null;
        }
        return oktmo;
    }

    private String dtoReceiverBankBic(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        ReceiverDto receiver = ruPaymentDto.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        BankDto bank = receiver.getBank();
        if ( bank == null ) {
            return null;
        }
        String bic = bank.getBic();
        if ( bic == null ) {
            return null;
        }
        return bic;
    }

    private String dtoBudgetReasonCode(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        BudgetDto budget = ruPaymentDto.getBudget();
        if ( budget == null ) {
            return null;
        }
        String reasonCode = budget.getReasonCode();
        if ( reasonCode == null ) {
            return null;
        }
        return reasonCode;
    }

    private BigDecimal dtoPaymentGroundNds(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        PaymentGroundDto paymentGround = ruPaymentDto.getPaymentGround();
        if ( paymentGround == null ) {
            return null;
        }
        BigDecimal nds = paymentGround.getNds();
        if ( nds == null ) {
            return null;
        }
        return nds;
    }

    private String dtoBudgetKbk(RuPaymentDto ruPaymentDto) {
        if ( ruPaymentDto == null ) {
            return null;
        }
        BudgetDto budget = ruPaymentDto.getBudget();
        if ( budget == null ) {
            return null;
        }
        String kbk = budget.getKbk();
        if ( kbk == null ) {
            return null;
        }
        return kbk;
    }
}
