
public class Full_emp extends Employee{
 
        String dept;  //�μ�
        String post;  //����
       
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