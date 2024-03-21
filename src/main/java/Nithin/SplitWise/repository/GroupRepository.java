package Nithin.SplitWise.repository;

import Nithin.SplitWise.entity.Group;
import Nithin.SplitWise.entity.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
