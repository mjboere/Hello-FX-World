package observers;

import models.Spelbord;

public abstract class SpelbordObserver {
	protected Spelbord spelbord;
	public abstract void update(Spelbord sb);
}
