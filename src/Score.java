
public class Score implements Runnable{
	
	Spiller spiller1,spiller2;
	private boolean game = true;
	
	public Score(Spiller spiller1,Spiller spiller2){
		this.spiller1=spiller1;
		this.spiller2=spiller2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		do{
			System.out.println("*****************************");
			System.out.println("* "+spiller1.getName()+"    - S: "+spiller1.getSet()+" G: "+spiller1.getGame()+" P: "+spiller1.getPoint()+" *");
			System.out.println("* "+spiller2.getName()+" - S: "+spiller2.getSet()+" G: "+spiller2.getGame()+" P: "+spiller2.getPoint()+" *");
			System.out.println("*****************************");
			if((spiller1.getGame()>=6 || spiller2.getGame()>=6) && Math.abs(spiller1.getGame()-spiller2.getGame())>=2){
				if(spiller1.getGame()>spiller2.getGame()){
					spiller1.incSet();
				} else {
					spiller2.incSet();
				}
				spiller1.resGame();
				spiller2.resGame();
			}
			
			if(spiller1.getSet()==3 || spiller2.getSet()==3){
				System.out.println("*****************************");
				System.out.println("* "+spiller1.getName()+"    - S: "+spiller1.getSet()+" G: "+spiller1.getGame()+" P: "+spiller1.getPoint()+" *");
				System.out.println("* "+spiller2.getName()+" - S: "+spiller2.getSet()+" G: "+spiller2.getGame()+" P: "+spiller2.getPoint()+" *");
				System.out.println("*****************************");
				spiller1.setAlive(false);
				spiller2.setAlive(false);
				game=false;
				if(spiller1.getSet()==3){					
					System.out.println("Game, Set og Match! "+spiller1.getName()+" vinder kampen!");
				} else {					
					System.out.println("Game, Set og Match! "+spiller2.getName()+" vinder kampen!");
				}
				
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		while(game);
	}

}
