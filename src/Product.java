import java.util.HashMap;
import java.util.Scanner;

public class Product extends Menu{
    float price;

    int productId;
    HashMap<Integer, Product> product = new HashMap<Integer, Product>();

//    public void addProduct(int menuId, int productId,String menuName,float price, String explanation){
//        Menu.menuId = menuId;
//        super.menuName = menuName;
//        super.explanation = explanation;
//        Product.productId = productId;
//        this.price = price;
//    }

    public void selectProduct(int productId){
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        String productName = product.get(productId).menuName;
        float price = product.get(productId).price;
        String explanation = product.get(productId).explanation;

        if(product.get(productId).menuId == 1){    /* <--이렇게도 가능--> if(productName.contains("피자"))*/
            Loop :
            while (true){
                System.out.println("---------------------------------------------------");
                System.out.printf("\t%d. %s | W %.1f | %s\n", menuNum,productName,price,explanation);
                System.out.println("    위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
                System.out.printf("\t1.기본(W %.1f)\t2.치즈 추가(+W 2.0)\t3.토핑 추가(+W 3.0)\n",price);
                int inputNum = sc.nextInt();
                if(inputNum<1 || 3<inputNum) {
                    numError();
                    continue;
                }
                switch (inputNum){
                    case 1 : productName+="(기본)     ";  break Loop;
                    case 2 : productName+="(치즈 추가)";    price+=2;    break Loop;
                    case 3 : productName+="(토핑 추가)";    price+=3;    break Loop;
                }
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("\t%d. %s | W %.1f | %s\n", menuNum,productName,price,explanation);
        System.out.println("\t위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("\t1.확인        2.취소");
        if(sc.nextInt()==1) {
            order.addOrder(productName, price, explanation);
            System.out.println("장바구니에 추가 되었습니다.");
        }
    }

    public void setInfo(int menuId,int productId,String menuName, float price, String explanation){
        product.get(productId).menuId = menuId;
        product.get(productId).productId = productId;
        product.get(productId).menuName=menuName;
        product.get(productId).price=price;
        product.get(productId).explanation=explanation;
    }
    public void setProduct(){
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        product.put(++productId, product1);
        product.put(++productId, product2);
        product.put(++productId, product3);
        product.put(++productId, product4);
    }
    public void selectMenu(int menuId){
        productId=0;
        switch (menuId){
            case 1 :
                setInfo(menuId,++productId,"햄피자    ",10.9f,"햄이 들어간 피자");
                setInfo(menuId,++productId,"치즈피자  ", 9.9f, "치즈가 들어간 피자");
                setInfo(menuId,++productId,"감자피자  ", 12.9f, "감자가 들어간 피자");
                setInfo(menuId,++productId,"고구마피자 ", 13.9f, "고구마가 들어간 피자");
                break;
            case 2 :
                setInfo(menuId,++productId,"감자튀킴            ", 4.9f, "구운 감자튀킴");
                setInfo(menuId,++productId,"너겟                ", 2.9f, "구운 너겟");
                setInfo(menuId,++productId,"크림스파게티         ", 8.9f, "크림소스가 들어간 스파게티");
                setInfo(menuId,++productId,"토마토스파게티        ", 7.9f, "토마토소스가 들어간 스파게티");
                break;
            case 3 :
                setInfo(menuId,++productId,"콜라                ", 2.9f, "코카콜라");
                setInfo(menuId,++productId,"사이다              ", 2.9f, "스프라이트");
                setInfo(menuId,++productId,"환타                ", 2.9f, "오렌지 환타");
                setInfo(menuId,++productId,"제로콜라            ", 2.9f, "제로 코카콜라");
                break;
        }
    }

    public void productScreen(){
        Scanner sc = new Scanner(System.in);
        Menu.menuNum = 1;
        System.out.println("---------------------------------------------------");
        System.out.println("[ 피자 메뉴 ]");
        for (int i=1;i<product.size()+1;i++) System.out.printf("%d %s \t  \t| W %.1f \t|\t%s\n", menuNum++,product.get(i).menuName,product.get(i).price,product.get(i).explanation);
        System.out.println();
        System.out.print("메뉴 번호 입력 : ");

        int productNum;
        while (true){
            productNum = sc.nextInt();
            if(0<productNum && productNum<=product.size()) break;
            else numError();
        }
        Menu.menuNum = productNum;
        if(product.containsKey(productNum))
            selectProduct(productNum);
    }
}
