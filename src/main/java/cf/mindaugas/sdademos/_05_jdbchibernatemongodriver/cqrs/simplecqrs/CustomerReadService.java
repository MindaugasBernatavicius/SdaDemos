package cf.mindaugas.sdademos._05_jdbchibernatemongodriver.cqrs.simplecqrs;

public interface CustomerReadService {
    Customer getCustomer(long CustomerId);

    CustomerSet getCustomersWithName(String Name);

    CustomerSet getPreferredCustomers();
}
