package ordering_system.Services;

public interface OrderServiceObservable {
    public void notifyObservers(int totalProfit, int totalOrders);
    public void subscribe(OrderServiceObserver o);
}
