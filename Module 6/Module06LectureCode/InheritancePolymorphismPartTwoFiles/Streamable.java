
public interface Streamable {

	// by definition, constants in an interface are public static final 
	// so often these modifiers are left off
	String STREAMING_RATE = "4G";
	
	// by definition, methods in an interface are public and abstract
	// so often these modifiers are left off
	void stream();
}
