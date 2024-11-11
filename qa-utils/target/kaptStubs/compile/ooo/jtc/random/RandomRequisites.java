package ooo.jtc.random;

import java.lang.System;

/**
 * RandomRequisites - generators for account, inn, ogrn, kpp, etc.
 *
 * @author Aleksandr_Stykalin
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\n\u001a\u00020\u0004J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0004\u00a8\u0006$"}, d2 = {"Looo/jtc/random/RandomRequisites;", "", "()V", "calculateAccountKey", "", "bic", "number", "generateAccountNumber", "balanceAccount", "currency", "generateBic", "generateCorrAccountNumber", "corrAccount", "bicRkc", "generateEmail", "lowerLvlDomain", "rootDomain", "generateHeadSwift", "generateIdentityDocumentNumber", "generateIncorrectInnForIp", "generateIncorrectInnForUl", "generateInnForIp", "generateInnForUl", "generateInnPerson", "generateKio", "generateKpp", "generateOgrnIp", "generateOgrnUl", "generateOkfs", "generateOkopf", "generateOkpoForIp", "generateOkpoForUl", "generatePhoneNumber", "countryCode", "generateSnils", "generateSwift", "qa-utils"})
public final class RandomRequisites {
    public static final ooo.jtc.random.RandomRequisites INSTANCE = null;
    
    /**
     * Сгенерировать БИК РФ
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateBic() {
        return null;
    }
    
    /**
     * Сгенерировать случайный ОКПО для ИП
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateOkpoForIp() {
        return null;
    }
    
    /**
     * Сгенерировать случайный ОКПО для ЮЛ
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateOkpoForUl() {
        return null;
    }
    
    /**
     * Сгенерировать случайный номер Документа, удостоверяющего личность
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateIdentityDocumentNumber() {
        return null;
    }
    
    /**
     * Сгенерировать email по шаблону "<случайная строка>_at@[lowerLvlDomain].[rootDomain]"
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String lowerLvlDomain, @org.jetbrains.annotations.NotNull()
    java.lang.String rootDomain) {
        return null;
    }
    
    private final java.lang.String calculateAccountKey(java.lang.String bic, java.lang.String number) {
        return null;
    }
    
    /**
     * Сгенерировать номер телефона без маски с кодом страны, в формате +71234567890.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generatePhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String countryCode) {
        return null;
    }
    
    /**
     * Генерирует 20-ти значный расчетный счет с проверкой ключевания.
     *
     * @param balanceAccount - балансовый счет второго порядка (5 цифр).
     * @param currency       - международный код валюты (3 цифры). Для рублей - 810.
     * @param bic            - БИК банка, к которому привязан счет.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateAccountNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String balanceAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.Nullable()
    java.lang.String bic) {
        return null;
    }
    
    /**
     * Генерирует 20-ти значный корреспондентский счет банка с проверкой ключевания.
     *
     * @param corrAccount - корреспондентский счет второго порядка (5 цифр).
     * @param currency    - международный код валюты (3 цифры). Для рублей - 810.
     * @param bic         - БИК банка.
     * @param bicRkc      - БИК расчётно-кассового центра, в котором обслуживается банк. Для ЦБ РФ - 044536002.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateCorrAccountNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String corrAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.NotNull()
    java.lang.String bic, @org.jetbrains.annotations.Nullable()
    java.lang.String bicRkc) {
        return null;
    }
    
    /**
     * Сгенерировать 10-значный ИНН для ЮЛ.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateInnForUl() {
        return null;
    }
    
    /**
     * Сгенерировать невалидный 10-значный ИНН для ЮЛ.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateIncorrectInnForUl() {
        return null;
    }
    
    /**
     * Сгенерировать 12-значный ИНН для ИП.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateInnForIp() {
        return null;
    }
    
    /**
     * Сгенерировать 12-значный ИНН персоны.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateInnPerson() {
        return null;
    }
    
    /**
     * Сгенерировать невалидный 12-значный ИНН для ИП.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateIncorrectInnForIp() {
        return null;
    }
    
    /**
     * Сгенерировать 5-значный КИО для ЮЛ.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateKio() {
        return null;
    }
    
    /**
     * Сгенерировать 9-значный КПП для ЮЛ.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateKpp() {
        return null;
    }
    
    /**
     * Сгенерировать 13-значный ОГРН для ЮЛ.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateOgrnUl() {
        return null;
    }
    
    /**
     * Сгенерировать 15-значный ОГРНИП для ИП.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateOgrnIp() {
        return null;
    }
    
    /**
     * Сгенерировать 11-значный СНИЛС РФ.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateSnils() {
        return null;
    }
    
    /**
     * Сгенерировать 11-значный SWIFT
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateSwift() {
        return null;
    }
    
    /**
     * Сгенерировать 8-значный SWIFT
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateHeadSwift() {
        return null;
    }
    
    /**
     * Сгенерировать 5-значный ОКОПФ
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateOkopf() {
        return null;
    }
    
    /**
     * Сгенерировать 2-значный ОКФС
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateOkfs() {
        return null;
    }
    
    private RandomRequisites() {
        super();
    }
}