package Nithin.SplitWise.repository;

import Nithin.SplitWise.entity.User;
import Nithin.SplitWise.entity.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Integer> {
}
