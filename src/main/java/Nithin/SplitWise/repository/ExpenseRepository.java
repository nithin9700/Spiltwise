package Nithin.SplitWise.repository;

import Nithin.SplitWise.entity.Expense;
import Nithin.SplitWise.entity.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
