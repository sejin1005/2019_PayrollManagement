
public class Pay_object {
       
        private Full_emp fe; //������
        private Part_emp pe; //��������
       
        private int basicSalary; //�⺻�޿�
        private int bi; //�����հ�
        private int realSalary; //�Ǳ޿�
        private int tax; //����
        private int insentive; //������
           
        public Pay_object() {
                fe = new Full_emp();
                pe = new Part_emp();
            basicSalary = realSalary = tax = insentive = 0;
        }
           
        //������    
        public void setFeEcode(int ecode) {     fe.setEcode(ecode);}
        public void setFeName(String name) { fe.setName(name);}
        public void setDept(String dept) { fe.setDept(dept);}
        public void setPost(String post) {fe.setPost(post);}
       
       
        //��������
        public void setPeEcode(int ecode) { pe.setEcode(ecode);}
        public void setPeName(String name) { pe.setName(name);}
        public void setDay(int day) {pe.setDay(day);}
           
        //�޿��׸�
        public void setBs(int basicSalary) { this.basicSalary = basicSalary;}
        public void setBI(int bi) { this.bi = bi;}
        public void setRs(int realSalary) { this.realSalary = realSalary;}
        public void setTax(int tax) { this.tax = tax;}
        public void setInst(int insentive) { this.insentive = insentive;}
           
           
        //������
        public int getFeEcode() { return fe.getEcode();}
        public String getFeName() { return fe.getName();}
        public String getDept() { return fe.getDept();}
        public String getPost() { return fe.getPost();}
           
        //��������
        public int getPeEcode() { return pe.getEcode();}
        public String getPeName() {return pe.getName();}
        public int getDay() { return pe.getDay();}
           
        //�޿��׸�
        public int getBs() { return basicSalary;}
        public int getBI() { return  bi;}
        public int getRs() { return realSalary;}
        public int getTax() { return tax;}
        public int getInst() {return insentive;}
 
}