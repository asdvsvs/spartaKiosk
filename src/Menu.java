import java.util.HashMap;

public class Menu {
     String menuName;
     String explanation;
     static int menuNum;

    static HashMap<Integer, Menu> menu = new HashMap<Integer, Menu>();

    public Menu(String menuName, String explanation){
        this.menuName = menuName;
        this.explanation = explanation;
    }
    public static void numError(){
        try {
            System.out.println("##번호 입력 오류!##");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void setMenu(){
        Menu menu1 = new Menu("피자   ", "스파르타식 피자 (옵션 선택)");
        Menu menu2 = new Menu("사이드  ", "스파르타식 사이드");
        Menu menu3 = new Menu("음료   ", "스파르타식 음료");
        Menu menu4 = new Menu("주문   ", "장바구니를 확인 후 주문합니다.");
        Menu menu5 = new Menu("취소   ", "진행중인 주문을 취소합니다.");
        menu.put(1, menu1);
        menu.put(2, menu2);
        menu.put(3, menu3);
        menu.put(4, menu4);
        menu.put(5, menu5);
    }

    public void menuScreen(){
        Menu.menuNum = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("\"스파르타 피자 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ 스파르타 메뉴 ]");
        for (int i=1; i<menu.size()+1;i++){
            if(i==4) System.out.println("\n[ 오더 메뉴 ]");
            System.out.printf("%d %s  |  %s\n", menuNum++,menu.get(i).menuName,menu.get(i).explanation);
        }
        System.out.println();
        System.out.println("(0.총 판매), (-1. 키오스크 끄기)");
        System.out.print("메뉴 번호 입력 : ");

    }



}
