package Nithin.SplitWise.dto;

import Nithin.SplitWise.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;


@Setter
@Getter
public class FriendListDTO {
    List<String> friend;
}
