
public class Employee {
 
        int ecode;   //사원번호
        String name; //사원이름
       
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