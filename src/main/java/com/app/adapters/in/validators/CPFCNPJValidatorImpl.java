package com.app.adapters.in.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFCNPJValidatorImpl implements ConstraintValidator<CPFCNPJValidator, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) {
            return true;
        }

        String digits = value.replaceAll("\\D", "");

        if (digits.length() == 11) {
            return isValidCpf(digits);
        } else if (digits.length() == 14) {
            return isValidCnpj(digits);
        }

        return false;
    }

    private static boolean isValidCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int firstDigit = 11 - (sum % 11);
        firstDigit = (firstDigit >= 10) ? 0 : firstDigit;

        if (firstDigit != Character.getNumericValue(cpf.charAt(9))) return false;

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        int secondDigit = 11 - (sum % 11);
        secondDigit = (secondDigit >= 10) ? 0 : secondDigit;

        return secondDigit == Character.getNumericValue(cpf.charAt(10));
    }

    private static boolean isValidCnpj(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")) return false;

        int[] weight1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] weight2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * weight1[i];
        }

        int firstDigit = sum % 11;
        firstDigit = (firstDigit < 2) ? 0 : 11 - firstDigit;

        if (firstDigit != Character.getNumericValue(cnpj.charAt(12))) return false;

        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * weight2[i];
        }

        int secondDigit = sum % 11;
        secondDigit = (secondDigit < 2) ? 0 : 11 - secondDigit;

        return secondDigit == Character.getNumericValue(cnpj.charAt(13));
    }
}
