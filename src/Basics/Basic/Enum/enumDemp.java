package Basics.Basic.Enum;

public class enumDemp {

    public enum Val{
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

    public static void main(String[] args) {
        for(Val v:Val.values()){
            System.out.println(v.getAge());
        }
    }
}
