
public class TextViewer implements DrawingView{

	private DrawingModel m;

	public TextViewer(DrawingModel m){
		this.m = m;
	}
	
	public void display(){
		
		for(Shape s: m.getShapes()){
			System.out.println(s);
			
		}
	}

	@Override
	public void update(DrawingModel m) {
		// TODO Auto-generated method stub
		this.m = m;
	}
}
