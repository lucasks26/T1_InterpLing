public class Skip extends Prog {

	public Skip() {}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		return this;
	}
	
	@Override
	public String toString() {
		return "skip";
	}
}
