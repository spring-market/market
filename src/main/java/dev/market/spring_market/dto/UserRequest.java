package dev.market.spring_market.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Getter
public class UserRequest {
    @NotNull
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String userEmail;
    @NotNull
    private String password;
    @NotNull
    private String nickname;
    @NotNull
    @Size(max = 1)
    private char gender;
}
