package C.vo;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Tbl_Buy_MenuVo {

    private int buy_index;
    private String custom_id;
    private String menu_id;
    private int menu_quantity;
    private Timestamp buy_date;
    
    @Override
    public String toString() {
        return "TbLl_Buy_MenuVo [buy_index=" + buy_index + ", custom_id=" + custom_id + ", menu_id=" + menu_id
                + ", menu_quantity=" + menu_quantity + ", buy_date=" + buy_date + "]";
    }

    
}
