
public class Pay_calculator implements Pay_info {
       
        Pay_object po[];
        int result;
       
        public Pay_calculator() {
                po = new Pay_object[25];
                result = 0;
        }
 
        //�⺻��  :��å + ȣ��
        public int bs_c(String post, int year) {               
                if(post.equals("���"))
                        result = STAFF * year;
                else if (post.equals("�븮"))
                        result = AM * year;
                else if (post.equals("����"))
                        result = AD * year;    
                else if (post.equals("����"))
                        result = EM * year;
                else if (post.equals("����"))
                        result = CEO * year;
                else
                        System.out.println("����");
                return result;
        }
       
        //�����հ�: (�⺻��+������)
        public int bi_c(int bs, int inst) {
                result = bs + inst;
                return result;
        }
       
        //�����հ�: �����հ� * ����(10%)
        public int tax_c(int rs) {
                result = (int)(rs * 0.10);    
            return result;
        }
               
        //�����޾�: �����հ�-�����հ�
        public int rs_c(int bi, int tax) {
                result = bi - tax;
                return result;
        }
       
        //�������� ����: �ϼ� * �ϴ�
        public int day_c(int day) {
                result = DPAY * day;
                return result;                 
        }
           
}