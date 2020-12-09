
import java.util.Scanner;
 
public class Manager {
           Pay_object pc1[]; //정규직
           Pay_object pc2[]; //비정규직
           Pay_calculator cal;
           private int countFe; // 정규직 수 카운팅
           private int countPe; // 비정규직 수 카운팅
 
 
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
 
           public void managemode() {// 관리자로 접속하는 경우
              Scanner sc = new Scanner(System.in);
              int choice;
              while (true) {
                 System.out.println("원하는 번호를 선택하세요  1.전체출력 2.사원추가 3.사원삭제  4.수정 5.종료");
                 choice = sc.nextInt();
                 switch (choice) {
                 case 1: {
                    fullPrint(); // 전체출력
                    break;
                 }
                 case 2: {
                    insertEm(sc); // 사원추가
                    break;
                 }
                 case 3: {
                    System.out.print("삭제할 사원의 사원번호를 입력하세요 :"); // 사원삭제
                    delete(sc.nextInt());
                    break;
                 }
                 case 4: {
                    System.out.print("수정할 사원의 사원번호를 입력하세요 :"); // 사원정보수정
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
                 return true; //비정규직일 경우 true 반환
              }
              else {
                 return false; //정규직일 경우 false 반환
              }
           }
           
           public void fullPrint() {// 전체 사원 출력
                   
              System.out.print("사원번호\t이름\t일당 \n");
              for (int i = 0; i < countPe; i++) {
                 System.out.println(pc2[i].getPeEcode()+"\t"+pc2[i].getPeName()+"\t"+pc2[i].getBs()+"\n");
              }
             
              System.out.println("사원번호\t이름\t부서\t직위\t기본급\t성과금\t지급합계\t공제합계 \t실지급액 \n");
              for (int i = 0; i < countFe; i++) {
                  System.out.println(pc1[i].getFeEcode()+"\t"+pc1[i].getFeName()+"\t"+pc1[i].getDept()+"\t"
                                         +pc1[i].getPost()+"\t"+pc1[i].getBs()+"\t"+pc1[i].getInst()+"\t"+pc1[i].getBI()+"\t"
                                   +pc1[i].getTax()+"\t"+pc1[i].getRs()+"\t");
              }
           }  
           
           public void insertEm(Scanner sc) { // 사원정보 입력
             
              System.out.print("입력할 사원정보를 입력하세요  사원번호:");
              String no = sc.next();
              if (no.charAt(0) == '2') { // 사원번호가 2로 시작하면 비정규직이므로 이름,근무일수만 받음
                 pc2[countPe] = new Pay_object();
                 pc2[countPe].setPeEcode(Integer.parseInt(no));
                 System.out.print("추가할 사원정보를 입력하세요  이름:");
                 pc2[countPe].setPeName(sc.next());
                 System.out.println("근무한 일수를 입력하세요");
                 pc2[countPe].setBs(cal.day_c(sc.nextInt()));
                 
                 countPe++;
              } else {// 정규직은 이름, 부서, 직위, 입사년차를 추가로 받음
                 pc1[countFe] = new Pay_object();
                 pc1[countFe].setFeEcode(Integer.parseInt(no));
                 System.out.print("추가할 사원정보를 입력하세요  이름:");
                 pc1[countFe].setFeName(sc.next());
                 System.out.print("추가할 사원정보를 입력하세요  부서:");
                 pc1[countFe].setDept(sc.next());
                 System.out.print("추가할 사원정보를 입력하세요  직위:");
                 pc1[countFe].setPost(sc.next());
                 System.out.print("추가할 사원정보를 입력하세요  입사년차:");
                 pc1[countFe].setBs(cal.bs_c(pc1[countFe].getPost(), sc.nextInt())); //사원별 기본급 초기화
                 pc1[countFe].setBI(cal.bi_c(pc1[countFe].getBs(), pc1[countFe].getInst())); //사원별 지급합계(기본금+성과금) 초기화
                 pc1[countFe].setTax(cal.tax_c(pc1[countFe].getBI())); //사원별 세금 초기화
                 pc1[countFe].setRs(cal.rs_c(pc1[countFe].getBI(), pc1[countFe].getTax())); //사원별 실급여액(지급합계-세금) 초기화
 
                 countFe++;
              }    
           }
 
           // 사원번호를 받아 해당사원을 삭제시킴
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
 
           // 사원번호를 받아 해당사원 정보 수정
           public void change(int ecode,Scanner sc) {
                   if(isPe(ecode)==false){
                         int sub = 0;
                         while (sub != 2) {
                            System.out.println("수정하고자 하는 항목을 입력하세요 1.성과급 2.수정 종료");
                            sub = sc.nextInt();
                            if (sub == 1) {
                               System.out.println(ecode+" 의 성과급을 입력하세요");
                               pc1[countFe].setInst(sc.nextInt());//성과급 입력 함수
                            } else if (sub == 2) { System.out.println("수정이 끝났습니다.");
                            } else { System.out.println("다시 입력하세요");}
 
                         }      
                      }
           }
}