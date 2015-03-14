
public class Spiller implements Runnable {

	private Spiller modstander;
	private String name;
	private boolean ball=false;
	
	public Spiller(String name, boolean ball){
		this.name=name;
		this.ball=ball;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void SetModstander(Spiller modstander){
		this.modstander=modstander;
	}
	
	public void modtagBold(){
		this.ball=true;
	}
	
}
