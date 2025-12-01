package ExceptionHandelling;

public class e1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///example of null pointer exception
		dog s = null;
		try {
			System.out.println("the name of dog is " + s.name);
		}
		catch (NullPointerException es){
			System.out.println("Null pointer exception");
		}
		catch (Exception e){
			System.out.println(e);
		}

	}

	static class dog{
		String name ="heyyyyyy";
	}
}

