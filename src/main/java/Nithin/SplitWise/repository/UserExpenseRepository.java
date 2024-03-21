package Nithin.SplitWise.repository;

import Nithin.SplitWise.entity.User;
import Nithin.SplitWise.entity.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepository extends JpaRepository<UserExpense, Integer> {
}
