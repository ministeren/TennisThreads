
public class Score implements Runnable{

	Spiller spiller1,spiller2;
	private boolean game = true;
	private int winSet=3,parti=1;
	private int p1s1,p1s2,p1s3,p1s4,p1s5;
	private int p2s1,p2s2,p2s3,p2s4,p2s5;

	public Score(Spiller spiller1,Spiller spiller2){
		this.spiller1=spiller1;
		this.spiller2=spiller2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		do{
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("******************************************************"+"******************************************");
			System.out.println("*                                                    *"+"  Set 1"+"   Set 2"+"   Set 3"+"   Set 4"+"   Set 5"+"  *");
			System.out.println("*  "+spiller1.getName()+"    | Set: "+spiller1.getSet()+" | Game: "+spiller1.getGame()+" | Point: "+spiller1.printPoint()+" | Serv: "+spiller1.hasBall()+"  *"+"    "+p1s1+"   |"+"   "+p1s2+"   |"+"   "+p1s3+"   |"+"   "+p1s4+"   |"+"   "+p1s5+"    *");
			System.out.println("*                                                    *"+"                                         *");
			System.out.println("* -------------------------------------------------  *"+"  -------------------------------------  *");
			System.out.println("*                                                    *"+"                                         *");
			System.out.println("*  "+spiller2.getName()+" | Set: "+spiller2.getSet()+" | Game: "+spiller2.getGame()+" | Point: "+spiller2.printPoint()+" | Serv: "+spiller2.hasBall()+"  *"+"    "+p2s1+"   |"+"   "+p2s2+"   |"+"   "+p2s3+"   |"+"   "+p2s4+"   |"+"   "+p2s5+"    *");
			System.out.println("*                                                    *"+"                                         *");
			System.out.println("******************************************************"+"******************************************");
			if((spiller1.getGame()>=6 || spiller2.getGame()>=6) && Math.abs(spiller1.getGame()-spiller2.getGame())>=2){
				if(spiller1.getGame()>spiller2.getGame()){
					spiller1.incSet();
				} else {
					spiller2.incSet();
				}
				switch(parti){
				case 1: p1s1=spiller1.getGame();
						p2s1=spiller2.getGame();
						break;
				case 2: p1s2=spiller1.getGame();
						p2s2=spiller2.getGame();
						break;
				case 3: p1s3=spiller1.getGame();
						p2s3=spiller2.getGame();
						break;
				case 4: p1s4=spiller1.getGame();
						p2s4=spiller2.getGame();
						break;
				case 5: p1s5=spiller1.getGame();
						p2s5=spiller2.getGame();
						break;
				}
				spiller1.resGame();
				spiller2.resGame();
				parti++;
			} else if(spiller1.getGame()==6 && spiller2.getGame()==6){
				int r = (int) ((Math.random()*2)+1);
				if(r==1){
					spiller1.incGame();
					spiller1.incSet();					
				} else if(r==2) {
					spiller2.incGame();
					spiller2.incSet();
				}
				switch(parti){
				case 1: p1s1=spiller1.getGame();
						p2s1=spiller2.getGame();
						break;
				case 2: p1s2=spiller1.getGame();
						p2s2=spiller2.getGame();
						break;
				case 3: p1s3=spiller1.getGame();
						p2s3=spiller2.getGame();
						break;
				case 4: p1s4=spiller1.getGame();
						p2s4=spiller2.getGame();
						break;
				case 5: p1s5=spiller1.getGame();
						p2s5=spiller2.getGame();
						break;
				}
				spiller1.resGame();
				spiller2.resGame();
				parti++;
			}

			if(spiller1.getSet()==winSet || spiller2.getSet()==winSet){
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("******************************************************"+"******************************************");
				System.out.println("*                                                    *"+"  Set 1"+"   Set 2"+"   Set 3"+"   Set 4"+"   Set 5"+"  *");
				System.out.println("*  "+spiller1.getName()+"    | Set: "+spiller1.getSet()+" | Game: "+spiller1.getGame()+" | Point: "+spiller1.printPoint()+" | Serv: "+spiller1.hasBall()+"  *"+"    "+p1s1+"   |"+"   "+p1s2+"   |"+"   "+p1s3+"   |"+"   "+p1s4+"   |"+"   "+p1s5+"    *");
				System.out.println("*                                                    *"+"                                         *");
				System.out.println("* -------------------------------------------------  *"+"  -------------------------------------  *");
				System.out.println("*                                                    *"+"                                         *");
				System.out.println("*  "+spiller2.getName()+" | Set: "+spiller2.getSet()+" | Game: "+spiller2.getGame()+" | Point: "+spiller2.printPoint()+" | Serv: "+spiller2.hasBall()+"  *"+"    "+p2s1+"   |"+"   "+p2s2+"   |"+"   "+p2s3+"   |"+"   "+p2s4+"   |"+"   "+p2s5+"    *");
				System.out.println("*                                                    *"+"                                         *");
				System.out.println("******************************************************"+"******************************************");
				spiller1.setAlive(false);
				spiller2.setAlive(false);
				game=false;
				if(spiller1.getSet()==3){
					System.out.println();
					System.out.println("  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * ");
					System.out.println("*                  Game, Set og Match! "+spiller1.getName()+" vinder kampen!                  *");
					System.out.println("  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * ");
				} else {
					System.out.println();
					System.out.println("  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * ");
					System.out.println("*                  Game, Set og Match! "+spiller2.getName()+" vinder kampen!                  *");
					System.out.println("  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * ");
				}

			} else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		while(game);
	}

}
