package Basics.Basic.Enum;

public class EnumDemo {

    public enum Val {
        RUPALI("24"),
        AANCHAL("23");
        String age;

        Val(String age) {
            this.age = age;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    enum Season {
        SPRING("Vasant", "February to March"),
        SUMMER("Grishma", "March to May"),
        MONSOON("Varsha", "June to September"),
        AUTUMN("Sharad", "October to November"),
        PREWINTER("Hemant", "December to January"),
        WINTER("Shishir", "January to February");

        String hindiName;
        String range;
        Season(String hindiName, String range) {
            this.hindiName = hindiName;
            this.range = range;
        }
    }


    public static void main(String[] args) {
        for (Val v : Val.values()) {
            System.out.println(v.getAge());
        }
        for (Season s:Season.values()){
            System.out.println(s.hindiName + "-" + s.range);
        }
        Season season= Season.AUTUMN;
        switch (season){
            case WINTER:
                System.out.println("its winter");
            case SPRING:
                System.out.println("Its Spring");
            case SUMMER:
                System.out.println("its summer");
            default:
                System.out.println("Its Fall");
        }

    }
}
