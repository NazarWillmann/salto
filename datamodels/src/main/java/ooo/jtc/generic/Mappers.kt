package ooo.jtc.generic

import ooo.jtc.crypto.ProfileMapper
import ooo.jtc.dictionaries.account.AccountMapper
import ooo.jtc.dictionaries.accountype.AccountTypeMapper
import ooo.jtc.dictionaries.activitytype.ActivityTypeMapper
import ooo.jtc.dictionaries.agreement.AgreementMapper
import ooo.jtc.dictionaries.bankbic.BankBicMapper
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccountMapper
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionMapper
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionMapper
import ooo.jtc.dictionaries.bankinfo.BankInfoMapper
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrlMapper
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrlMapper
import ooo.jtc.dictionaries.bankrepresentative.BankRepresentativeMapper
import ooo.jtc.dictionaries.bankru.BankRuMapper
import ooo.jtc.dictionaries.branch.BranchMapper
import ooo.jtc.dictionaries.branchcustomer.BranchCustomerMapper
import ooo.jtc.dictionaries.branchindividual.BranchIndividualMapper
import ooo.jtc.dictionaries.branchrepresentative.BranchRepresentativeMapper
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusMapper
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusViewMapper
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeMapper
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeViewMapper
import ooo.jtc.dictionaries.codevo.CodeVOViewMapper
import ooo.jtc.dictionaries.codevo.CodeVoMapper
import ooo.jtc.dictionaries.common.extid.ExtIdMapper
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoMapper
import ooo.jtc.dictionaries.contractor.ContractorMapper
import ooo.jtc.dictionaries.contractorcontact.ContractorContactMapper
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentMapper
import ooo.jtc.dictionaries.controlcode.ControlCodeMapper
import ooo.jtc.dictionaries.country.CountryMapper
import ooo.jtc.dictionaries.currency.CurrencyMapper
import ooo.jtc.dictionaries.customer.CustomerMapper
import ooo.jtc.dictionaries.customerkpp.CustomerKppMapper
import ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeMapper
import ooo.jtc.dictionaries.customertype.CustomerTypeMapper
import ooo.jtc.dictionaries.gozcontract.GozContractMapper
import ooo.jtc.dictionaries.ground.GroundMapper
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentTypeMapper
import ooo.jtc.dictionaries.incometype.IncomeTypeMapper
import ooo.jtc.dictionaries.individual.IndividualMapper
import ooo.jtc.dictionaries.individualrepresentative.IndividualRepresentativeMapper
import ooo.jtc.dictionaries.kbk.KbkMapper
import ooo.jtc.dictionaries.kbk.KbkViewMapper
import ooo.jtc.dictionaries.lettertypefrombank.LetterTypeFromBankMapper
import ooo.jtc.dictionaries.lettertypetobank.LetterTypeToBankMapper
import ooo.jtc.dictionaries.locationtype.LocationTypeMapper
import ooo.jtc.dictionaries.ndscalculation.NdsCalculationMapper
import ooo.jtc.dictionaries.ndspercent.NdsPercentMapper
import ooo.jtc.dictionaries.okfs.OkfsMapper
import ooo.jtc.dictionaries.okopf.OkopfMapper
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityMapper
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityViewMapper
import ooo.jtc.dictionaries.paymenttype.PaymentTypeMapper
import ooo.jtc.dictionaries.paymenttype.PaymentTypeViewMapper
import ooo.jtc.dictionaries.person.PersonMapper
import ooo.jtc.dictionaries.region.RuRegionMapper
import ooo.jtc.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeMapper
import ooo.jtc.dictionaries.salaryemployee.SalaryEmployeeMapper
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentTypeMapper
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeMapper
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeViewMapper
import ooo.jtc.dictionaries.swift.SwiftMapper
import ooo.jtc.dictionaries.timezone.TimezoneMapper
import ooo.jtc.dictionaries.transferterm.TransferTermMapper
import ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTaxMapper
import ooo.jtc.dictionaries.uer.UerMapper
import ooo.jtc.letters.LetterFromBankViewMapper
import ooo.jtc.letters.LetterToBankViewMapper
import ooo.jtc.news.mailgroup.MailGroupMapper
import ooo.jtc.rolemodel.accessobject.AccessObjectMapper
import ooo.jtc.rolemodel.accessobjecttype.AccessObjectTypeMapper
import ooo.jtc.rolemodel.privilege.PrivilegeMapper
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupMapper
import ooo.jtc.rolemodel.product.ProductMapper
import ooo.jtc.rolemodel.role.RoleMapper
import ooo.jtc.rupayment.RuPaymentViewMapper
import ooo.jtc.uaa.application.mapper.ApplicationMapper
import ooo.jtc.uaa.catalog.mapper.CatalogMapper
import ooo.jtc.uaa.mfa.mapper.MfaMapper
import ooo.jtc.uaa.resource.mapper.ResourceMapper
import ooo.jtc.uaa.scope.mapper.ScopeMapper
import ooo.jtc.uaa.user.mapper.UaaUserMapper
import org.mapstruct.factory.Mappers.getMapper

object Mappers {

    /* Dictionary mappers */
    val accountMapper: AccountMapper by lazy { getMapper(AccountMapper::class.java) }
    val accountTypeMapper: AccountTypeMapper by lazy { getMapper(AccountTypeMapper::class.java) }
    val activityTypeMapper: ActivityTypeMapper by lazy { getMapper(ActivityTypeMapper::class.java) }
    val bankBicMapper: BankBicMapper by lazy { getMapper(BankBicMapper::class.java) }
    val bankBicAccountMapper: BankBicAccountMapper by lazy { getMapper(BankBicAccountMapper::class.java) }
    val bankBicAccountRestrMapper: BankBicAccRestrictionMapper by lazy { getMapper(BankBicAccRestrictionMapper::class.java) }
    val bankBicRestrictionMapper: BankBicRestrictionMapper by lazy { getMapper(BankBicRestrictionMapper::class.java) }
    val bankInfoMapper: BankInfoMapper by lazy { getMapper(BankInfoMapper::class.java) }
    val bankInfoApplicationUrlMapper: BankInfoApplicationUrlMapper by lazy { getMapper(BankInfoApplicationUrlMapper::class.java) }
    val bankInfoSocialUrlMapper: BankInfoSocialUrlMapper by lazy { getMapper(BankInfoSocialUrlMapper::class.java) }
    val bankRepresentativeMapper: BankRepresentativeMapper by lazy { getMapper(BankRepresentativeMapper::class.java) }
    val bankRuMapper: BankRuMapper by lazy { getMapper(BankRuMapper::class.java) }
    val branchMapper: BranchMapper by lazy { getMapper(BranchMapper::class.java) }
    val agreementMapper: AgreementMapper by lazy { getMapper(AgreementMapper::class.java) }
    val branchCustomerMapper: BranchCustomerMapper by lazy { getMapper(BranchCustomerMapper::class.java) }
    val branchIndividualMapper: BranchIndividualMapper by lazy { getMapper(BranchIndividualMapper::class.java) }
    val branchRepresentativeMapper: BranchRepresentativeMapper by lazy { getMapper(BranchRepresentativeMapper::class.java) }
    val budgetPayerStatusMapper: BudgetPayerStatusMapper by lazy { getMapper(BudgetPayerStatusMapper::class.java) }
    val budgetReasonCodeMapper: BudgetReasonCodeMapper by lazy { getMapper(BudgetReasonCodeMapper::class.java) }
    val customerRepresentativeMapper: CustomerRepresentativeMapper by lazy { getMapper(CustomerRepresentativeMapper::class.java) }
    val codeVoMapper: CodeVoMapper by lazy { getMapper(CodeVoMapper::class.java) }
    val contractorMapper: ContractorMapper by lazy { getMapper(ContractorMapper::class.java) }
    val contractorContactMapper: ContractorContactMapper by lazy { getMapper(ContractorContactMapper::class.java) }
    val contractorPaymentMapper: ContractorPaymentMapper by lazy { getMapper(ContractorPaymentMapper::class.java) }
    val controlCodeMapper: ControlCodeMapper by lazy { getMapper(ControlCodeMapper::class.java) }
    val countryMapper: CountryMapper by lazy { getMapper(CountryMapper::class.java) }
    val currencyMapper: CurrencyMapper by lazy { getMapper(CurrencyMapper::class.java) }
    val customerMapper: CustomerMapper by lazy { getMapper(CustomerMapper::class.java) }
    val customerKppMapper: CustomerKppMapper by lazy { getMapper(CustomerKppMapper::class.java) }
    val customerTypeMapper: CustomerTypeMapper by lazy { getMapper(CustomerTypeMapper::class.java) }
    val individualMapper: IndividualMapper by lazy { getMapper(IndividualMapper::class.java) }
    val individualRepresentativeMapper: IndividualRepresentativeMapper by lazy { getMapper(IndividualRepresentativeMapper::class.java) }
    val gozContractMapper: GozContractMapper by lazy { getMapper(GozContractMapper::class.java) }
    val groundMapper: GroundMapper by lazy { getMapper(GroundMapper::class.java) }
    val identityDocTypeMapper: IdentityDocumentTypeMapper by lazy { getMapper(IdentityDocumentTypeMapper::class.java) }
    val incomeTypeMapper: IncomeTypeMapper by lazy { getMapper(IncomeTypeMapper::class.java) }
    val kbkMapper: KbkMapper by lazy { getMapper(KbkMapper::class.java) }
    val locationTypeMapper: LocationTypeMapper by lazy { getMapper(LocationTypeMapper::class.java) }
    val ndsCalculationMapper: NdsCalculationMapper by lazy { getMapper(NdsCalculationMapper::class.java) }
    val ndsPercentMapper: NdsPercentMapper by lazy { getMapper(NdsPercentMapper::class.java) }
    val okfsMapper: OkfsMapper by lazy { getMapper(OkfsMapper::class.java) }
    val okopfMapper: OkopfMapper by lazy { getMapper(OkopfMapper::class.java) }
    val paymentPriorityMapper: PaymentPriorityMapper by lazy { getMapper(PaymentPriorityMapper::class.java) }
    val paymentTypeMapper: PaymentTypeMapper by lazy { getMapper(PaymentTypeMapper::class.java) }
    val personMapper: PersonMapper by lazy { getMapper(PersonMapper::class.java) }
    val residencyPermitDocumentTypeMapper: ResidencyPermitDocumentTypeMapper by lazy { getMapper(ResidencyPermitDocumentTypeMapper::class.java) }
    val ruRegionMapper: RuRegionMapper by lazy { getMapper(RuRegionMapper::class.java) }
    val salaryEmployeeMapper: SalaryEmployeeMapper by lazy { getMapper(SalaryEmployeeMapper::class.java) }
    val salaryPaymentTypeMapper: SalaryPaymentTypeMapper by lazy { getMapper(SalaryPaymentTypeMapper::class.java) }
    val statementOperationTypeMapper: StatementOperationTypeMapper by lazy { getMapper(StatementOperationTypeMapper::class.java) }
    val swiftMapper: SwiftMapper by lazy { getMapper(SwiftMapper::class.java) }
    val timezoneMapper: TimezoneMapper by lazy { getMapper(TimezoneMapper::class.java) }
    val transferTermMapper: TransferTermMapper by lazy { getMapper(TransferTermMapper::class.java) }
    val treasuryAccountTaxMapper: TreasuryAccountTaxMapper by lazy { getMapper(TreasuryAccountTaxMapper::class.java) }
    val uerMapper: UerMapper by lazy { getMapper(UerMapper::class.java) }

    val extIdMapper: ExtIdMapper by lazy { getMapper(ExtIdMapper::class.java) }
    val phoneInfoMapper: PhoneInfoMapper by lazy { getMapper(PhoneInfoMapper::class.java) }

    val letterTypeToBankMapper: LetterTypeToBankMapper by lazy { getMapper(LetterTypeToBankMapper::class.java) }
    val letterTypeFromBankMapper: LetterTypeFromBankMapper by lazy { getMapper(LetterTypeFromBankMapper::class.java) }

    val mailGroupMapper: MailGroupMapper by lazy { getMapper(MailGroupMapper::class.java) }

    /* Dictionary view mappers */
    val paymentTypeViewMapper: PaymentTypeViewMapper by lazy { getMapper(PaymentTypeViewMapper::class.java) }
    val budgetReasonCodeViewMapper: BudgetReasonCodeViewMapper by lazy { getMapper(BudgetReasonCodeViewMapper::class.java) }
    val kbkViewMapper: KbkViewMapper by lazy { getMapper(KbkViewMapper::class.java) }
    val codeVoViewMapper: CodeVOViewMapper by lazy { getMapper(CodeVOViewMapper::class.java) }
    val budgetPayerStatusViewMapper: BudgetPayerStatusViewMapper by lazy { getMapper(BudgetPayerStatusViewMapper::class.java) }
    val paymentPriorityViewMapper: PaymentPriorityViewMapper by lazy { getMapper(PaymentPriorityViewMapper::class.java) }
    val statementOperationTypeViewMapper: StatementOperationTypeViewMapper by lazy { getMapper(StatementOperationTypeViewMapper::class.java) }


    /* Uaa mappers */
    val applicationMapper: ApplicationMapper by lazy { getMapper(ApplicationMapper::class.java) }
    val resourceMapper: ResourceMapper by lazy { getMapper(ResourceMapper::class.java) }
    val scopeMapper: ScopeMapper by lazy { getMapper(ScopeMapper::class.java) }
    val catalogMapper: CatalogMapper by lazy { getMapper(CatalogMapper::class.java) }
    val mfaMapper: MfaMapper by lazy { getMapper(MfaMapper::class.java) }
    val userMapper: UaaUserMapper by lazy { getMapper(UaaUserMapper::class.java) }

    /* Domain-controller mappers */
    val productMapper: ProductMapper by lazy { getMapper(ProductMapper::class.java) }
    val accessObjectMapper: AccessObjectMapper by lazy { getMapper(AccessObjectMapper::class.java) }
    val accessObjectTypeMapper: AccessObjectTypeMapper by lazy { getMapper(AccessObjectTypeMapper::class.java) }
    val privilegeMapper: PrivilegeMapper by lazy { getMapper(PrivilegeMapper::class.java) }
    val privilegeGroupMapper: PrivilegeGroupMapper by lazy { getMapper(PrivilegeGroupMapper::class.java) }
    val roleMapper: RoleMapper by lazy { getMapper(RoleMapper::class.java) }

    /* Crypto mappers*/
    val profileMapper: ProfileMapper by lazy { getMapper(ProfileMapper::class.java) }


    /* Document mappers*/
    //val ruPaymentMapper: RuPaymentMapper by lazy { getMapper(RuPaymentMapper::class.java) }

    /* Document View mappers*/
    val ruPaymentViewMapper: RuPaymentViewMapper by lazy { getMapper(RuPaymentViewMapper::class.java) }
    val letterToBankViewMapper: LetterToBankViewMapper by lazy { getMapper(LetterToBankViewMapper::class.java) }
    val letterFromBankViewMapper: LetterFromBankViewMapper by lazy { getMapper(LetterFromBankViewMapper::class.java) }

}