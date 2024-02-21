package C.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode

public class Tbl_MembersVo {
  
    private String code;
    private String name;
    private String email;
    private String phone_number;
    private int age;
    
    @Override
    public String toString() {
        return "Tbl_MembersVo [code=" + code + ", name=" + name + ", emil=" + email + ", phone_number=" + phone_number
                + ", age=" + age + "]";
    }

    
}
