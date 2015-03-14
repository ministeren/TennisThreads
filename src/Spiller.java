import java.util.Random;



public class Spiller implements Runnable {

	private Spiller modstander;
	private String name;
	private boolean ball=false, alive=true;

	public Spiller(String name, boolean ball){
		this.name=name;
		this.ball=ball;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(alive){
			if(ball && modstander.isAlive()){
				Sleeper.sleepRandom(2);
				Random r = new Random();
				int hit = r.nextInt(100)+1;
				if(hit <= 80){
					modstander.modtagBold();
				} else {
					alive=false;
				}

			} else if(modstander.isAlive()) {
				Sleeper.sleepRandom(2);
			} else {
				System.out.println(name+" vinder runden!");
				alive=false;
			}
		}
	}

	public void SetModstander(Spiller modstander){
		this.modstander=modstander;
	}

	public synchronized boolean isAlive(){
		return alive;
	}

	public synchronized void modtagBold(){
		this.ball=true;
	}

}
