
public class Employee {
 
        int ecode;   //�����ȣ
        String name; //����̸�
       
        public Employee(){
                ecode = 0;
                name = null;
        }
       
        public void setEcode(int ecode) {
                this.ecode = ecode;
        }
        public int getEcode() {
                return ecode;
        }
        public void setName(String name) {
                this.name = name;
        }
        public String getName() {
                return name;
        }
}