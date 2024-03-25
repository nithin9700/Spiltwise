package Nithin.SplitWise.service.Strategy;

import Nithin.SplitWise.entity.Enum.UserType;
import Nithin.SplitWise.entity.Expense;
import Nithin.SplitWise.entity.SettlementTransaction;
import Nithin.SplitWise.entity.User;
import Nithin.SplitWise.entity.UserExpense;
import Nithin.SplitWise.mapper.UserAmount;

import java.lang.constant.PackageDesc;
import java.util.*;

public class MinimumTranslationStrategy implements SettleUpStrategy{
    @Override

    public List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses) {
        HashMap<User, Double> outStandingBalance = getOutStandingBalance(expenses);
        PriorityQueue<UserAmount> maxHeap = new PriorityQueue<>(Comparator.comparing(UserAmount :: getBalance).reversed());
        PriorityQueue<UserAmount> minHeap = new PriorityQueue<>(Comparator.comparing(UserAmount :: getBalance));

        for (Map.Entry<User, Double> entry : outStandingBalance.entrySet()){
            if(entry.getValue() < 0){
                minHeap.add(new UserAmount(entry.getKey(), entry.getValue()));
            }else if(entry.getValue() > 0) maxHeap.add(new UserAmount(entry.getKey(), entry.getValue()));
        }
        List<SettlementTransaction> settlementTransactions = new ArrayList<>();
        while (!minHeap.isEmpty() && !maxHeap.isEmpty()){
            UserAmount lender = maxHeap.poll();
            UserAmount borrower = minHeap.poll();

            if(lender.getBalance() > Math.abs(borrower.getBalance())){
                lender.setBalance(lender.getBalance() - borrower.getBalance());
                maxHeap.offer(lender);
                SettlementTransaction settlementTransaction = new SettlementTransaction(
                                                                lender.getUser(),
                                                                borrower.getUser(),
                                                                Math.abs(borrower.getBalance())
                );
                settlementTransactions.add(settlementTransaction);
            }

            else if(lender.getBalance() < Math.abs(borrower.getBalance())){
                borrower.setBalance(borrower.getBalance() + lender.getBalance());
                minHeap.offer(borrower);
                SettlementTransaction settlementTransaction = new SettlementTransaction(
                        borrower.getUser(),
                        lender.getUser(),
                        lender.getBalance()
                );
                settlementTransactions.add(settlementTransaction);
            }
            else {
                SettlementTransaction settlementTransaction = new SettlementTransaction(
                        lender.getUser(),
                        borrower.getUser(),
                        lender.getBalance()
                );
                settlementTransactions.add(settlementTransaction);
            }
        }
        return settlementTransactions;
    }

    private HashMap<User, Double> getOutStandingBalance(List<Expense> expenses) {
        HashMap<User, Double> balance = new HashMap<>();
        for (Expense expense : expenses){
            List<UserExpense> userExpenses = expense.getUserExpenses();
            for (UserExpense userExpense : userExpenses){
                User user = userExpense.getUser();
                Double amount = userExpense.getAmount();
                if(userExpense.getUserType().equals(UserType.PAID))
                    balance.put(user, balance.getOrDefault(user, 0.0) + amount);
                else

                    balance.put(user, balance.getOrDefault(user, 0.0) - amount);
            }

        }
        return balance;
    }

}
