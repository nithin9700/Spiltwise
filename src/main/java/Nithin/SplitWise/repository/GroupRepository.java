package Nithin.SplitWise.repository;

import Nithin.SplitWise.entity.Group;
import Nithin.SplitWise.entity.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
