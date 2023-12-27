package org.example.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankAccount {

    @Setter
    private final String registeredBankAccountId;

    @Setter
    private final String membershipId;

    @Setter
    private final String bankName;

    @Setter
    private final String bankAccountNumber;

    @Setter
    private final boolean linkedStatus;

    public static RegisteredBankAccount generateRegisteredBankAccount(
            RegisteredBankAccountId registeredBankAccountId,
            MembershipId membershipId,
            BankName bankName,
            BankAccountNumber bankAccountNumber,
            LinkedStatusIsValid linkedStatusIsValid
    ) {
        return new RegisteredBankAccount(
                registeredBankAccountId.registeredBankAccountId,
                membershipId.membershipId,
                bankName.bankName,
                bankAccountNumber.bankAccountNumber,
                linkedStatusIsValid.linkedStatusIsValid
        );
    }

    @Value
    public static class RegisteredBankAccountId {
        public RegisteredBankAccountId(String registeredBankAccountId) {
            this.registeredBankAccountId = registeredBankAccountId;
        }

        String registeredBankAccountId;
    }

    @Value
    public static class MembershipId {
        public MembershipId(String membershipId) {
            this.membershipId = membershipId;
        }

        String membershipId;
    }

    @Value
    public static class BankName {
        public BankName(String bankName) {
            this.bankName = bankName;
        }

        String bankName;
    }

    @Value
    public static class BankAccountNumber {
        public BankAccountNumber(String bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
        }

        String bankAccountNumber;
    }

    @Value
    public static class LinkedStatusIsValid {
        public LinkedStatusIsValid(boolean linkedStatusIsValid) {
            this.linkedStatusIsValid = linkedStatusIsValid;
        }

        boolean linkedStatusIsValid;
    }

}
