
import java.util.*;
 
public class PayManagement {
   private Manager mg;  
   
   public PayManagement(){
      mg=new Manager();
   }  
   public void printSelf(int ecode){//����ڷ� �����ϴ� ��� , �����ȣ�� �̿��� �޿������� ���
              if(mg.isPe(ecode)){
                 for(int i=0;i<mg.getCountPe();i++){
                    if(ecode==mg.getCountPe()){
                       System.out.println("�����ȣ\t�̸�\t���� \n");
                       System.out.println(mg.pc2[i].getPeEcode()+"\t"+mg.pc2[i].getPeName()+"\t"+mg.pc2[i].getBs());
                    }
                    else{
                       System.out.println(ecode+"�� ����� �����ϴ�.");
                    }
                 }
              }
              else{
                 for(int i=0;i<mg.getCountFe();i++){
                    if(ecode==mg.getCountFe()){
                       System.out.println("�����ȣ\t�̸�\t�μ�\t����\t�⺻��\t������\t�����հ�\t�����հ� \t�����޾� \n");
                       System.out.println(mg.pc1[i].getFeEcode()+"\t"+mg.pc1[i].getFeName()+"\t"+mg.pc1[i].getDept()+"\t"
                                         +mg.pc1[i].getPost()+"\t"+mg.pc1[i].getBs()+"\t"+mg.pc1[i].getInst()+mg.pc1[i].getBI()+"\t"
                                   +mg.pc1[i].getTax()+"\t"+mg.pc1[i].getRs()+"\t");
                    }
                    else{
                       System.out.println(ecode+"�� ����� �����ϴ�.");
                    }
                 }
              }
             
           }  
   //���α׷� ����
    public void run(){
       Scanner ssc=new Scanner(System.in);
        int menu;
        int ecode;
        while(true){ //���α׷� �̿��ڴ� �����ڿ� ����ڷ� ����. ���Ḧ �����ϱ� ������ ��� �ݺ�
           System.out.println("���ϴ� ��ȣ�� �����ϼ���  1.������  2.�����(���� ���� ���) 3.����");
            menu=ssc.nextInt();
            if(menu==1){//������
               mg.managemode();
            }
            else if(menu==2){ //����� ����
               System.out.print("�����ȣ�� �Է��ϼ���");
               ecode=ssc.nextInt();          
               printSelf(ecode); //�ش� �����ȣ�� �޿����� ���                            
            }
            else if(menu==3){ //���α׷� ����
               System.out.println("�޿� ���� ���α׷��� �����մϴ�.");
               System.exit(-1);
            }
            else{
               System.out.println("�߸��Է��߽��ϴ�.");
            }
        }      
    }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      PayManagement pm=new PayManagement();
      pm.run(); //����
   
   }
}