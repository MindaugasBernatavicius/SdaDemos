package cf.mindaugas.sdademos._03_design._01_solidprinciples._04_isp;

public interface Collection {
    void init();
    void get();
    void add();
    void addSeveral();
    void remove();
    void removeAll();
}

// ... what if we want to have immutable collections?
// ... it would be better to implement segregated interfaces
// ... (of course we need to have a criterion to segregate those interface by)

interface ImmutableCollection {
    void init();
    void get();
}

interface MutableCollection extends ImmutableCollection {
    void add();
    void addSeveral();
    void remove(); // remove(); does not fit for immutable collections this interface might be too broad
    void removeAll(); // removeAll(); does not fit for immutable collections this interface might be too broad
}

class ImmutableArrayList implements ImmutableCollection{
    @Override
    public void init() {

    }

    @Override
    public void get() {

    }
}

class ArrayList extends ImmutableArrayList implements MutableCollection {
    @Override
    public void add() {

    }

    @Override
    public void addSeveral() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void removeAll() {

    }
}
