
public class Main {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		String test = "12345";
		System.out.println(test.toLowerCase());
		Spiller spiller1 = new Spiller("Borg", true);
		Spiller spiller2 = new Spiller("McEnroe", false);

		spiller1.SetModstander(spiller2);
		spiller2.SetModstander(spiller1);

		Thread spiller1Thread = new Thread((Runnable) spiller1);
		Thread spiller2Thread = new Thread((Runnable) spiller2);
		Thread scoreThread = new Thread((Runnable) new Score(spiller1,spiller2));

		spiller1Thread.start();
		spiller2Thread.start();
		scoreThread.start();
		
		

	}

}
