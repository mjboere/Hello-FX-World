package observers;

public interface SpelbordObservable {
	public void register(SpelbordObserver observer);
	public void notifyAllObservers();
}
