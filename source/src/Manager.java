
import java.util.Scanner;
 
public class Manager {
           Pay_object pc1[]; //������
           Pay_object pc2[]; //��������
           Pay_calculator cal;
           private int countFe; // ������ �� ī����
           private int countPe; // �������� �� ī����
 
 
           public Manager() {
              countFe = 0;
              countPe = 0;
              pc1 = new Pay_object[25];
              pc2 = new Pay_object[25];
              cal = new Pay_calculator();
           }
 
           public int getCountFe() {
              return countFe;
           }
           public int getCountPe() {
              return countPe;
           }
 
           public void managemode() {// �����ڷ� �����ϴ� ���
              Scanner sc = new Scanner(System.in);
              int choice;
              while (true) {
                 System.out.println("���ϴ� ��ȣ�� �����ϼ���  1.��ü��� 2.����߰� 3.�������  4.���� 5.����");
                 choice = sc.nextInt();
                 switch (choice) {
                 case 1: {
                    fullPrint(); // ��ü���
                    break;
                 }
                 case 2: {
                    insertEm(sc); // ����߰�
                    break;
                 }
                 case 3: {
                    System.out.print("������ ����� �����ȣ�� �Է��ϼ��� :"); // �������
                    delete(sc.nextInt());
                    break;
                 }
                 case 4: {
                    System.out.print("������ ����� �����ȣ�� �Է��ϼ��� :"); // �����������
                    change(sc.nextInt(),sc);
                    break;
                 }
                 case 5: {
                    System.exit(-1);
                    break;
                 }
                 }
              }
           }
 
           public boolean isPe(int ecode){
              String str=Integer.toString(ecode);
              if(str.charAt(0)=='2'){
                 return true; //���������� ��� true ��ȯ
              }
              else {
                 return false; //�������� ��� false ��ȯ
              }
           }
           
           public void fullPrint() {// ��ü ��� ���
                   
              System.out.print("�����ȣ\t�̸�\t�ϴ� \n");
              for (int i = 0; i < countPe; i++) {
                 System.out.println(pc2[i].getPeEcode()+"\t"+pc2[i].getPeName()+"\t"+pc2[i].getBs()+"\n");
              }
             
              System.out.println("�����ȣ\t�̸�\t�μ�\t����\t�⺻��\t������\t�����հ�\t�����հ� \t�����޾� \n");
              for (int i = 0; i < countFe; i++) {
                  System.out.println(pc1[i].getFeEcode()+"\t"+pc1[i].getFeName()+"\t"+pc1[i].getDept()+"\t"
                                         +pc1[i].getPost()+"\t"+pc1[i].getBs()+"\t"+pc1[i].getInst()+"\t"+pc1[i].getBI()+"\t"
                                   +pc1[i].getTax()+"\t"+pc1[i].getRs()+"\t");
              }
           }  
           
           public void insertEm(Scanner sc) { // ������� �Է�
             
              System.out.print("�Է��� ��������� �Է��ϼ���  �����ȣ:");
              String no = sc.next();
              if (no.charAt(0) == '2') { // �����ȣ�� 2�� �����ϸ� ���������̹Ƿ� �̸�,�ٹ��ϼ��� ����
                 pc2[countPe] = new Pay_object();
                 pc2[countPe].setPeEcode(Integer.parseInt(no));
                 System.out.print("�߰��� ��������� �Է��ϼ���  �̸�:");
                 pc2[countPe].setPeName(sc.next());
                 System.out.println("�ٹ��� �ϼ��� �Է��ϼ���");
                 pc2[countPe].setBs(cal.day_c(sc.nextInt()));
                 
                 countPe++;
              } else {// �������� �̸�, �μ�, ����, �Ի������ �߰��� ����
                 pc1[countFe] = new Pay_object();
                 pc1[countFe].setFeEcode(Integer.parseInt(no));
                 System.out.print("�߰��� ��������� �Է��ϼ���  �̸�:");
                 pc1[countFe].setFeName(sc.next());
                 System.out.print("�߰��� ��������� �Է��ϼ���  �μ�:");
                 pc1[countFe].setDept(sc.next());
                 System.out.print("�߰��� ��������� �Է��ϼ���  ����:");
                 pc1[countFe].setPost(sc.next());
                 System.out.print("�߰��� ��������� �Է��ϼ���  �Ի����:");
                 pc1[countFe].setBs(cal.bs_c(pc1[countFe].getPost(), sc.nextInt())); //����� �⺻�� �ʱ�ȭ
                 pc1[countFe].setBI(cal.bi_c(pc1[countFe].getBs(), pc1[countFe].getInst())); //����� �����հ�(�⺻��+������) �ʱ�ȭ
                 pc1[countFe].setTax(cal.tax_c(pc1[countFe].getBI())); //����� ���� �ʱ�ȭ
                 pc1[countFe].setRs(cal.rs_c(pc1[countFe].getBI(), pc1[countFe].getTax())); //����� �Ǳ޿���(�����հ�-����) �ʱ�ȭ
 
                 countFe++;
              }    
           }
 
           // �����ȣ�� �޾� �ش����� ������Ŵ
           public void delete(int ecode) {
           
              if(isPe(ecode)){
                 for (int i = 0; i < countPe; i++) {
                    if (i == ecode) {
                       for (int j = i + 1; j < countPe; j++) {
                             pc2[j - 1] = pc2[j];
                       }
                          pc2[countPe- 1] = null;
                          countPe--;
                       }   return;
                 }  
              }
              else{
                 for (int i = 0; i < countFe; i++) {
                    if (i == ecode) {
                       for (int j = i + 1; j < countFe; j++) {
                             pc1[j - 1] = pc1[j];
                       }
                          pc1[countFe- 1] = null;
                          countFe--;
                       }   return;
                 }  
              }
                 
           }
 
           // �����ȣ�� �޾� �ش��� ���� ����
           public void change(int ecode,Scanner sc) {
                   if(isPe(ecode)==false){
                         int sub = 0;
                         while (sub != 2) {
                            System.out.println("�����ϰ��� �ϴ� �׸��� �Է��ϼ��� 1.������ 2.���� ����");
                            sub = sc.nextInt();
                            if (sub == 1) {
                               System.out.println(ecode+" �� �������� �Է��ϼ���");
                               pc1[countFe].setInst(sc.nextInt());//������ �Է� �Լ�
                            } else if (sub == 2) { System.out.println("������ �������ϴ�.");
                            } else { System.out.println("�ٽ� �Է��ϼ���");}
 
                         }      
                      }
           }
}