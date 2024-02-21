package C.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class Tbl_MenuVo {
 
    private String mcode;
    private String mname;
    private int mprice;
    @Override
    public String toString() {
        return "TblMenuVo [mcode=" + mcode + ", mname=" + mname + ", mpirce=" + mprice + "]";
    }
    
    
}
