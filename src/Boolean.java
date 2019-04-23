public class Boolean extends Bexp {
	boolean bool;
	
	public Boolean(boolean bool) {
		this.bool = bool;
	}
	
	public boolean getValue() {
		return bool;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		return this;
	}
	
	@Override
	public String toString() {
		return String.valueOf(bool);
	}
}
