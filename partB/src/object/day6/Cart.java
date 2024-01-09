package object.day6;

public class Cart {

    // 필드
    private String userid;
    private String[] proudctNames;
    private int[] prices;
    private int total_Money;

    // 추가적인 인스턴스 메소드 : 해결방법 ????
    // 구매한 가격의 총 가격
    public void total_Money(int[] select) { // setter 역할
        int sum = 0;
        for (int i = 0; i < select.length; i++) {
            int temp = select[i];  //안에 있는 값을 넘겨줌
            if (temp == -1)
                break; // 반복문 중지
            sum += prices[temp]; //여기선 인덱스로 사용됨
        }
        this.total_Money = sum;
        // return sum ;
    }

    public int getTotal_Money() {
        return total_Money;
    }

    /*
     * public void setTotal_Money(int total_Money) {
     * this.total_Money = total_Money;
     * }
     */

    // getter
    public String getUserid() {
        return userid;
    }

    public String[] getProudctNames() {
        return proudctNames;
    }

    public int[] getPrices() {
        return prices;
    }

    // setter
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setProudctNames(String[] proudctNames) {
        this.proudctNames = proudctNames;
    }

    public void setPrices(int[] prices) {
        this.prices = prices;
    }

}
