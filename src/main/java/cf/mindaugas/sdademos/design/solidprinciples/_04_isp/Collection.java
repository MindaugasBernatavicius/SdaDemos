package cf.mindaugas.sdademos.design.solidprinciples._04_isp;

public interface Collection {
    void init();
    void get();
    void add();
    void addSeveral();
    void remove();
    void removeAll();
}

// ... what if we want to have immutable collections?
// ... it would be better to implement segragated interfaces

interface ImmutableCollection {
    void init();
    void get();
}

interface MutableCollection extends ImmutableCollection {
    void add();
    void addSeveral();
    void remove(); // remove(); does not fit for immutable collections thisinterface might be too broad
    void removeAll(); // removeAll(); does not fit for immutable collections thisinterface might be too broad
}