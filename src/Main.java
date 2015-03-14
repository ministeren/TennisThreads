
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Spiller spiller1 = new Spiller("Borg", true);
		Spiller spiller2 = new Spiller("McEnroe", false);
		
		spiller1.SetModstander(spiller2);
		spiller2.SetModstander(spiller1);
		
		Thread spiller1Thread = new Thread((Runnable) spiller1);
		Thread spiller2Thread = new Thread((Runnable) spiller2);
		
		spiller1Thread.start();
		spiller2Thread.start();
		
	}

}
