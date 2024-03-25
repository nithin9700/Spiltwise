package Nithin.SplitWise.service.Strategy;

import Nithin.SplitWise.entity.Expense;
import Nithin.SplitWise.entity.SettlementTransaction;
import Nithin.SplitWise.entity.UserExpense;

import java.util.ArrayList;
import java.util.List;

public interface SettleUpStrategy {

    List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses);

}
