
import java.util.*;
 
public class PayManagement {
   private Manager mg;  
   
   public PayManagement(){
      mg=new Manager();
   }  
   public void printSelf(int ecode){//사용자로 접속하는 경우 , 사원번호를 이용해 급여명세서를 출력
              if(mg.isPe(ecode)){
                 for(int i=0;i<mg.getCountPe();i++){
                    if(ecode==mg.getCountPe()){
                       System.out.println("사원번호\t이름\t월급 \n");
                       System.out.println(mg.pc2[i].getPeEcode()+"\t"+mg.pc2[i].getPeName()+"\t"+mg.pc2[i].getBs());
                    }
                    else{
                       System.out.println(ecode+"인 사원이 없습니다.");
                    }
                 }
              }
              else{
                 for(int i=0;i<mg.getCountFe();i++){
                    if(ecode==mg.getCountFe()){
                       System.out.println("사원번호\t이름\t부서\t직위\t기본급\t성과금\t지급합계\t공제합계 \t실지급액 \n");
                       System.out.println(mg.pc1[i].getFeEcode()+"\t"+mg.pc1[i].getFeName()+"\t"+mg.pc1[i].getDept()+"\t"
                                         +mg.pc1[i].getPost()+"\t"+mg.pc1[i].getBs()+"\t"+mg.pc1[i].getInst()+mg.pc1[i].getBI()+"\t"
                                   +mg.pc1[i].getTax()+"\t"+mg.pc1[i].getRs()+"\t");
                    }
                    else{
                       System.out.println(ecode+"인 사원이 없습니다.");
                    }
                 }
              }
             
           }  
   //프로그램 실행
    public void run(){
       Scanner ssc=new Scanner(System.in);
        int menu;
        int ecode;
        while(true){ //프로그램 이용자는 관리자와 사용자로 나뉨. 종료를 선택하기 전까지 계속 반복
           System.out.println("원하는 번호를 선택하세요  1.관리자  2.사용자(월급 명세서 출력) 3.종료");
            menu=ssc.nextInt();
            if(menu==1){//관리자
               mg.managemode();
            }
            else if(menu==2){ //사용자 선택
               System.out.print("사원번호를 입력하세요");
               ecode=ssc.nextInt();          
               printSelf(ecode); //해당 사원번호의 급여명세서 출력                            
            }
            else if(menu==3){ //프로그램 종료
               System.out.println("급여 관리 프로그램을 종료합니다.");
               System.exit(-1);
            }
            else{
               System.out.println("잘못입력했습니다.");
            }
        }      
    }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      PayManagement pm=new PayManagement();
      pm.run(); //실행
   
   }
}