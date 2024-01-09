package object.day6;

public class CartMy {

    private String userid;
    private String[] producNames;
    private int[] prices;
    private int total_Money;

    // get
    public int[] getPrices() {
        return prices;
    }

    public String[] getProducNames() {
        return producNames;
    }

    

   

    public String getUserid() {
        return userid;
    }

    // ---------------------------------------------------
    // set
    public void setPrices(int[] prices) {
        this.prices = prices;
    }

    public void setProducNames(String[] producNames) {
        this.producNames = producNames;
    }

   

    public void setUserid(String userid) {
        this.userid = userid;
    }

    /*public void setTotal_Money(int total_Money) {
        this.total_Money = total_Money;
    } */

    // ---------------------------------------------------------------------
    // 구매한 가격의 총 가격
    public void total_Money(int[] select) {  //setter의 역할
        int sum =0;
        for (int i = 0; i < select.length; i++) {
            int temp = select[i];
            if(temp == -1) break ; //반복문 중지 
            sum += prices[temp];

        }
        this.total_Money = sum;
    }

    public int getTotal_Money() {
        return total_Money;
    }

    // 고객들이 장바구니 담기한 상품이름, 상품가격
    
    public void cartPrint() {
        System.out.println("장바구니에 담긴 상품의 이름 : " + producNames + "\n가격 : " + prices);
    }

}
