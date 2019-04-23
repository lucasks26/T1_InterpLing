public class IntVal extends Aexp{
	int value;
	
	public IntVal(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		return this;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}