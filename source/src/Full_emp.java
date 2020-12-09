
public class Full_emp extends Employee{
 
        String dept;  //부서
        String post;  //직급
       
        public Full_emp() {
                dept = null;
                post = null;
        }
        public void setDept(String dept) {
                this.dept = dept;
        }
        public String getDept() {
                return dept;
        }
        public void setPost(String post) {
                this.post = post;
        }
        public String getPost() {
                return post;
        }
}