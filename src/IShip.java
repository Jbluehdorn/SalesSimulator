
public interface IShip extends Comparable<Ship> {
	void addListener(IObserver obs);
	void removeListener(IObserver obs);
	void notifyListeners();
}
