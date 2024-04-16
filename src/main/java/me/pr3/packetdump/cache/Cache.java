package me.pr3.packetdump.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Cache<T> {

    private final Set<T> set;
    private final Consumer<Set<T>> onLimitReached;
    private final int size;


    public Cache(int size, Consumer<Set<T>> onLimitReached){
        this.size = size;
        this.set = new HashSet<>(this.size);
        this.onLimitReached = onLimitReached;
    }

    public void add(T t){
        this.set.add(t);
        if(set.size() >= size) onLimitReached();
    }

    public void addAll(Collection<T> ts){
        this.set.addAll(ts);
        if(set.size() >= size) onLimitReached();
    }

    private void onLimitReached() {
        Set<T> copy = Set.copyOf(set);
        set.clear();
        onLimitReached.accept(copy);
    }

}
