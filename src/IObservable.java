
public interface IObservable {
	void addListener();
	void removeListener();
	void notifyListeners();
}
