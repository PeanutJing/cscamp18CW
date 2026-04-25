
import java.util.Scanner;
public class Project {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("โปรดเลือกโหมด:\n1. คำนวณ BMI แล้วหาเมนูจากวัตถุดิบ\n2. หาเมนูจากวัตถุดิบ\nตัวเลือก: ");

        int choice = sc.nextInt();
        double bmi = 0;
        int rcal = 0;


        switch (choice) {
            case 1:
                bmi =  askBMI(sc);
                break;
        
            default:
                rcal = doCalFood(sc);
                break;
        }

        if(bmi>0) {
            if (bmi < 18.5) {
                System.out.println("เกณฑ์: 'น้ำหนักน้อย' - ");
                if (rcal < 500) {
                    System.out.println("อาหารมื้อนี้แคลอรีค่อนข้างน้อย");
                } else {
                    System.out.println("อาหารมื้อนี้กำลังพอดี");
                }
            } else if (bmi < 23) {
                System.out.println("เกณฑ์: 'น้ำหนักปกติ' - ");
                if (rcal > 400) {
                    System.out.println("อาหารมื้อนี้แคลอรีค่อนข้างสูง");
                } else {
                    System.out.println("อาหารมื้อนี้กำลังพอดี");
                }
            } else {
                System.out.println("เกณฑ์: 'น้ำหนักเกิน/อ้วน - ");
                if (rcal > 400) {
                    System.out.println("อาหารมื้อนี้แคลอรีค่อนข้างสูง");
                } else {
                    System.out.println("อาหารมื้อนี้กำลังพอดี");
                }
            }


        }


        sc.close();

    
    }

    public static int doCalFood(Scanner sc) {
        
        String[] ing = {"ไข่", "หมู", "มะเขือเทศ", "ไก่", "กระเทียม", "พริกหวาน", "ปลา", "นม"};
        int amount = 0;
        System.out.println("โปรดใส่จำนวนวัตถุดิบ");
        amount = sc.nextInt();

        if (amount > 10) {
            amount = 10;
        }
        
        String[] inp = new String[amount];

        System.out.printf("โปรดเลือกวัตถุดิบตามหัวข้อด้านล่าง%n");
        //display list
        for(int i = 0; i < ing.length; i++) {
            System.out.printf("%d. %s%n",i+1,ing[i]);
        }
        // get user choices
        for(int i = 0; i < (amount); i++) {
            System.out.printf("โปรดเลือกรายการที่ %d: ", i + 1);

            int choiceind = sc.nextInt();
            inp[i] = ing[choiceind-1];
            System.out.println();
        }
        String curmenu = getMenu(inp);

         System.out.println("อาหารที่แนะนำ: " + curmenu);

        int fresult = calCal(curmenu);
        System.out.printf("มีแคลลอรี่ประมาณ: %d กิโลแคลลอรี่", fresult);



        sc.close();
        return fresult;
    }

    public static String getMenu(String[] arr) {
        String[] menu = {"ไข่เจียวหมูสับ", "ไข่ผัดมะเขือเทศ", "ไข่ตุ๋นนม", "ไก่ทอดกระเทียม", "ไก่ผัดพริกหวาน", "ผัดผักรวม", "ต้มปลา"};
        String[][] fixin = {
            {"ไข่", "หมู"}, {"ไข่", "มะเขือเทศ"},{"ไข่", "นม"},{"ไก่", "กระเทียม"},{"ไก่", "พริกหวาน"},{"พริกหวาน", "มะเขือเทศ","กระเทียม"},{"ปลา", "กระเทียม"}
        };
        String selmens = "None";
        for(int i = 0; i < arr.length; i++){
            String curre = arr[i];
            
            for(int j = 0; j < fixin.length; j++) {
                for(int k = 0; k < fixin[j].length; k++) {
                    if (fixin[j][k].equals(curre)) {
                        selmens = menu[j];
                        
                        break;
                    }
                }
            }
        }
        return selmens;
    }

    public static int calCal(String arr) {
        int cal = 0;
            if (arr.equals("ไข่เจียวหมูสับ")) {
                cal += 180;
            } else if (arr.equals("ไข่ผัดมะเขือเทศ")) {
                cal += 180;
            } else if (arr.equals("ไข่ตุ๋นนม")) {
                cal += 150;
            } else if (arr.equals("ไก่ทอดกระเทียม")) {
                cal += 300;
            } else if (arr.equals("ไก่ผัดพริกหวาน")) {
                cal += 250;
            } else if (arr.equals("ผัดผักรวม")) {
                cal += 120;
            } else if (arr.equals("ต้มปลา")) {
                cal += 180;
            }
        
        
        return cal;
    }

    public static double askBMI(Scanner sc) {
        System.out.print("ระบุน้ำหนัก (กก.): ");
        double weight = sc.nextDouble();
        System.out.print("ระบุส่วนสูง (ซม.): ");
        double heightCm = sc.nextDouble();
        
        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);

        System.out.printf("ค่า BMI ของคุณ: %.2f%n",bmi);
         if (bmi < 18.5) {
            System.out.println("ผลลัพธ์: น้ำหนักน้อยเกินไป");
        } else if (bmi < 23) {
            System.out.println("ผลลัพธ์: น้ำหนักปกติ เหมาะสม");
        } else if (bmi < 25) {
            System.out.println("ผลลัพธ์: น้ำหนักเกิน");
        } else {
            System.out.println("ผลลัพธ์: อ้วน");
        }
        doCalFood(sc);

       


        return bmi;
    }



    
}

