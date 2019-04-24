public class Seq extends Prog {
	private Prog c1;
	private Prog c2;
	
	public Seq(Prog c1, Prog c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		if(!(c1 instanceof Skip)) {
			return new Seq((Prog) c1.smallStep(s), c2);
		}else {
			return c2;
		}
	}
	
	@Override
	public String toString() {
		return c1 + " ; " + c2;
	}
}
