package api.examples.user_controller_pojo.create_user;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CreateUser {
    private String login;
    private String pass;
    private ArrayList<Games> games;
}

