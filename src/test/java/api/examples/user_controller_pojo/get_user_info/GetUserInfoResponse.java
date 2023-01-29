package api.examples.user_controller_pojo.get_user_info;

import api.examples.user_controller_pojo.create_user.CreateUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GetUserInfoResponse extends CreateUser {
    private Integer id;

}
