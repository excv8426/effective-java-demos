package serialization;

import java.util.concurrent.atomic.AtomicReference;

public class AbstractFoo {
	private int x,y;
	
	private enum State {NEW,INITIALIZING,INITIALIZED};
	
	private final AtomicReference<State> init=new AtomicReference<AbstractFoo.State>(State.NEW);
	
	protected final void initialize(int x,int y){
		if (init.compareAndSet(State.NEW, State.INITIALIZING)) {
			this.x=x;
			this.y=y;
			init.set(State.INITIALIZED);
		} else {
			throw new IllegalStateException("INITIALIZED");
		}
	}
	
	public AbstractFoo(int x,int y){
		initialize(x, y);
	}
	
	protected AbstractFoo(){}
	
	private void checkInit(){
		if (init.get()!=State.INITIALIZED) {
			throw new IllegalStateException("NOT INITIALIZED");
		}
	}

	public int getX() {
		checkInit();
		return x;
	}

	public int getY() {
		checkInit();
		return y;
	}
	
}
