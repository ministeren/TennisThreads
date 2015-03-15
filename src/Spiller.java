import java.util.Random;



public class Spiller implements Runnable {

	private Spiller modstander;
	private String name;
	private boolean ball=false, alive=true;
	private int point=0,game=0,set=0;

	public Spiller(String name, boolean ball){
		this.name=name;
		this.ball=ball;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(alive){
			if(ball){
				Sleeper.sleepRandom(0.5);
				Random r = new Random();
				int hit = r.nextInt(100)+1;
				if(hit <= 30){
					ball=false;
					modstander.modtagBold();					
				} else {
					modstander.incPoint();
					if(modstander.getPoint()==4){
						modstander.incGame();
						modstander.resPoint();
						resPoint();
					}					
					ball=false;
					modstander.modtagBold();
				}

			} else {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void SetModstander(Spiller modstander){
		this.modstander=modstander;
	}

	public synchronized boolean isAlive(){
		return alive;
	}
	
	public synchronized void setAlive(boolean set){
		alive=set;
	}

	public synchronized void modtagBold(){
		this.ball=true;
	}
	
	public synchronized void incGame(){
		this.game++;
	}
	
	public synchronized void incSet(){
		this.set++;
	}
	
	public synchronized void incPoint(){
		this.point++;
	}
	
	public synchronized void resGame(){
		this.game=0;
	}
	
	public synchronized void resSet(){
		this.set=0;
	}
	
	public synchronized void resPoint(){
		this.point=0;
	}
	
	public synchronized String getName(){
		return name;
	}

	public synchronized int getGame(){
		return game;
	}
	
	public synchronized int getSet(){
		return set;
	}
	
	public synchronized int getPoint(){
		
		if(point==0){
			return 00;
		} else if(point==1){
			return 15;
		} else if(point==2){
			return 30;
		} else if(point==3){
			return 40;
		} else {
			return point;
		}
	}

}
