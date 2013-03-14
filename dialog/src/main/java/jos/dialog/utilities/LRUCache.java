package jos.dialog.utilities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<TKey, TValue> /*where TValue : class, IDisposable*/ {

    public interface ISlotSizer<TVal> {
        public int size(TVal value);
    }

//    private static class LinkedListNode<T> {
//
//    }

    Map<TKey, TValue> dict;
    Map<TValue, TKey> revdict;
    LinkedList<TValue> list;
    int entryLimit, sizeLimit, currentSize;
    ISlotSizer<TValue> slotSizeFunc;

    public LRUCache (int entryLimit) {
        this (entryLimit, 0, null);
    }

    public LRUCache (int entryLimit, int sizeLimit, ISlotSizer<TValue> slotSizer)
    {
        list = new LinkedList<TValue> ();
        dict = new HashMap<TKey, TValue> ();
        revdict = new HashMap<TValue, TKey> ();

        if (sizeLimit != 0 && slotSizer == null)
            throw new IllegalArgumentException("If sizeLimit is set, the slotSizer must be provided");

        this.entryLimit = entryLimit;
        this.sizeLimit = sizeLimit;
        this.slotSizeFunc = slotSizer;
    }

    void Evict ()
    {
        TValue last = list.getLast();
        TKey key = revdict.get(last);

        if (sizeLimit > 0){
            int size = slotSizeFunc.size(last);
            currentSize -= size;
        }

        dict.remove(key);
        revdict.remove (last);
        list.removeLast ();
//        last.dispose ();
    }

    public void Purge ()
    {
//        for (TValue element : list)
//            element.Dispose ();

        dict.clear ();
        revdict.clear ();
        list.clear ();
        currentSize = 0;
    }

//    public TValue this [TKey key] {
    public TValue get(TKey key) {
        TValue node;

        node = dict.get(key);
        if (node != null){
            list.remove (node);
            list.add(0, node);

            return node;
        }
        return null;
    }

    public void put(TKey key, TValue value) {
        TValue node;
        int size = sizeLimit > 0 ? slotSizeFunc.size(value) : 0;

        node = dict.get(key);
        if (node != null){
            if (sizeLimit > 0 && node != null){
                int repSize = slotSizeFunc.size(node);
                currentSize -= repSize;
                currentSize += size;
            }

            // If we already have a key, move it to the front
            list.remove (node);
            list.add(0, node);

            // Remove the old value
//            if (node != null)
//                node.dispose ();
            node = value;
            while (sizeLimit > 0 && currentSize > sizeLimit && list.size() > 1)
                Evict ();
            return;
        }
        if (sizeLimit > 0){
            while (sizeLimit > 0 && currentSize + size > sizeLimit && list.size() > 0)
                Evict ();
        }
        if (dict.size() >= entryLimit)
            Evict ();
        // Adding new node
        node = value;
        list.add(0, node);
        dict.put(key, node);
        revdict.put(node, key);
        currentSize += size;
    }

    @Override
    public String toString ()
    {
        return String.format("LRUCache dict=%s revdict=%s list=%s",
                dict, revdict, list);
    }
}