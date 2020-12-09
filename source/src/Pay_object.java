
public class Pay_object {
       
        private Full_emp fe; //정규직
        private Part_emp pe; //비정규직
       
        private int basicSalary; //기본급여
        private int bi; //지급합계
        private int realSalary; //실급여
        private int tax; //세금
        private int insentive; //성과금
           
        public Pay_object() {
                fe = new Full_emp();
                pe = new Part_emp();
            basicSalary = realSalary = tax = insentive = 0;
        }
           
        //정규직    
        public void setFeEcode(int ecode) {     fe.setEcode(ecode);}
        public void setFeName(String name) { fe.setName(name);}
        public void setDept(String dept) { fe.setDept(dept);}
        public void setPost(String post) {fe.setPost(post);}
       
       
        //비정규직
        public void setPeEcode(int ecode) { pe.setEcode(ecode);}
        public void setPeName(String name) { pe.setName(name);}
        public void setDay(int day) {pe.setDay(day);}
           
        //급여항목
        public void setBs(int basicSalary) { this.basicSalary = basicSalary;}
        public void setBI(int bi) { this.bi = bi;}
        public void setRs(int realSalary) { this.realSalary = realSalary;}
        public void setTax(int tax) { this.tax = tax;}
        public void setInst(int insentive) { this.insentive = insentive;}
           
           
        //정규직
        public int getFeEcode() { return fe.getEcode();}
        public String getFeName() { return fe.getName();}
        public String getDept() { return fe.getDept();}
        public String getPost() { return fe.getPost();}
           
        //비정규직
        public int getPeEcode() { return pe.getEcode();}
        public String getPeName() {return pe.getName();}
        public int getDay() { return pe.getDay();}
           
        //급여항목
        public int getBs() { return basicSalary;}
        public int getBI() { return  bi;}
        public int getRs() { return realSalary;}
        public int getTax() { return tax;}
        public int getInst() {return insentive;}
 
}