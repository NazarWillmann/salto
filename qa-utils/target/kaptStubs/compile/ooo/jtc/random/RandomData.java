package ooo.jtc.random;

import java.lang.System;

/**
 * Wrapper for a random generating data by [Generex].
 * Used for handling generated data.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J4\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003J.\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001a"}, d2 = {"Looo/jtc/random/RandomData;", "", "regex", "", "(Ljava/lang/String;)V", "generex", "Lcom/mifmif/common/regex/Generex;", "(Lcom/mifmif/common/regex/Generex;)V", "getGenerex", "()Lcom/mifmif/common/regex/Generex;", "getGenerationLength", "", "requiredLength", "prefix", "postfix", "hugeString", "desiredMaxLength", "wordLength", "stringStart", "stringEnd", "wordDelimiter", "random", "minLength", "maxLength", "length", "Companion", "qa-utils"})
public final class RandomData {
    @org.jetbrains.annotations.NotNull()
    private final com.mifmif.common.regex.Generex generex = null;
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.random.RandomData allAllowedChars = null;
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.random.RandomData digits = null;
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.random.RandomData invalidChars = null;
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.random.RandomData latinWord = null;
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.random.RandomData ruWords = null;
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.random.RandomData regexWord = null;
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.random.RandomData regexWords = null;
    public static final ooo.jtc.random.RandomData.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String random(int length, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, @org.jetbrains.annotations.NotNull()
    java.lang.String postfix) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String random(int minLength, int maxLength, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, @org.jetbrains.annotations.NotNull()
    java.lang.String postfix) {
        return null;
    }
    
    private final int getGenerationLength(int requiredLength, java.lang.String prefix, java.lang.String postfix) {
        return 0;
    }
    
    /**
     * Prepare a big string without postgres formatting. Result string will be a concatenation of
     * multiple substrings. Each substring is [wordLength] symbols.
     *
     * @param desiredMaxLength  max string length. Result length may be less, but it won't be lesser than
     * [desiredMaxLength] - [wordLength]
     * @param wordLength        length of generated substrings of specified [this.generex]
     * @param stringStart       generated string will begin with these symbols. Default - <empty string>
     * @param stringEnd         generated string will end with these symbols. Default - <empty string>
     * @param wordDelimiter     generated substrings will be concatenated via these symbols. Default - ' ' (space)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String hugeString(int desiredMaxLength, int wordLength, @org.jetbrains.annotations.NotNull()
    java.lang.String stringStart, @org.jetbrains.annotations.NotNull()
    java.lang.String stringEnd, @org.jetbrains.annotations.NotNull()
    java.lang.String wordDelimiter) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mifmif.common.regex.Generex getGenerex() {
        return null;
    }
    
    public RandomData(@org.jetbrains.annotations.NotNull()
    com.mifmif.common.regex.Generex generex) {
        super();
    }
    
    public RandomData(@org.jetbrains.annotations.NotNull()
    java.lang.String regex) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Looo/jtc/random/RandomData$Companion;", "", "()V", "allAllowedChars", "Looo/jtc/random/RandomData;", "getAllAllowedChars", "()Looo/jtc/random/RandomData;", "digits", "getDigits", "invalidChars", "getInvalidChars", "latinWord", "getLatinWord", "regexWord", "getRegexWord", "regexWords", "getRegexWords", "ruWords", "getRuWords", "builder", "Looo/jtc/random/RandomData$Companion$Builder;", "getEmptyString", "", "length", "", "Builder", "qa-utils"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.random.RandomData getAllAllowedChars() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.random.RandomData getDigits() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.random.RandomData getInvalidChars() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.random.RandomData getLatinWord() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.random.RandomData getRuWords() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.random.RandomData getRegexWord() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.random.RandomData getRegexWords() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEmptyString(int length) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.random.RandomData.Companion.Builder builder() {
            return null;
        }
        
        private Companion() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0000R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/random/RandomData$Companion$Builder;", "", "()V", "chars", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "appendIfNotPresent", "", "build", "Looo/jtc/random/RandomData;", "withAllAllowedCharacters", "withDigits", "withLatinAlphabet", "withLatinCapitalLetters", "withLatinSmallLetters", "withRussianAlphabet", "withRussianCapitalLetters", "withRussianSmallLetters", "withSpecialCharacters", "Companion", "qa-utils"})
        public static final class Builder {
            private java.lang.StringBuilder chars;
            private static final java.lang.String latinCapitalLetters = "A-Z";
            private static final java.lang.String latinSmallLetters = "a-z";
            private static final java.lang.String latinAlphabet = null;
            private static final java.lang.String russianCapitalLetters = "\u0410-\u042f";
            private static final java.lang.String russianSmallLetters = "\u0430-\u044f";
            private static final java.lang.String russianAlphabet = null;
            private static final java.lang.String digits = "0-9";
            private static final java.lang.String specialCharacters = "\\ \\!\\\"\\#\\$\\%\\&\\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\=\\>\\?\\@\\[\\]\\^\\_\\`\\{\\|\\}\\~\\\u2116";
            private static final java.lang.String allCharacters = null;
            
            private final ooo.jtc.random.RandomData.Companion.Builder appendIfNotPresent(java.lang.String chars) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData.Companion.Builder withLatinAlphabet() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData.Companion.Builder withLatinCapitalLetters() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData.Companion.Builder withLatinSmallLetters() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData.Companion.Builder withRussianAlphabet() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData.Companion.Builder withRussianCapitalLetters() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData.Companion.Builder withRussianSmallLetters() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData.Companion.Builder withDigits() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData.Companion.Builder withSpecialCharacters() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData.Companion.Builder withAllAllowedCharacters() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.random.RandomData build() {
                return null;
            }
            
            public Builder() {
                super();
            }
        }
    }
}