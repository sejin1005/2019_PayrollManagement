
public class Pay_calculator implements Pay_info {
       
        Pay_object po[];
        int result;
       
        public Pay_calculator() {
                po = new Pay_object[25];
                result = 0;
        }
 
        //기본급  :직책 + 호봉
        public int bs_c(String post, int year) {               
                if(post.equals("사원"))
                        result = STAFF * year;
                else if (post.equals("대리"))
                        result = AM * year;
                else if (post.equals("차장"))
                        result = AD * year;    
                else if (post.equals("부장"))
                        result = EM * year;
                else if (post.equals("사장"))
                        result = CEO * year;
                else
                        System.out.println("오류");
                return result;
        }
       
        //지급합계: (기본급+성과급)
        public int bi_c(int bs, int inst) {
                result = bs + inst;
                return result;
        }
       
        //공제합계: 지급합계 * 세금(10%)
        public int tax_c(int rs) {
                result = (int)(rs * 0.10);    
            return result;
        }
               
        //실지급액: 지급합계-공제합계
        public int rs_c(int bi, int tax) {
                result = bi - tax;
                return result;
        }
       
        //비정규직 월급: 일수 * 일당
        public int day_c(int day) {
                result = DPAY * day;
                return result;                 
        }
           
}