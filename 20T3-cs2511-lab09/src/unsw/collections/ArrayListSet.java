/**
 *
 */
package unsw.collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of Set that uses an ArrayList to store the elements.
 *
 * @invariant All e in elements occur only once
 *
 * @author Robert Clifton-Everest
 *
 */
public class ArrayListSet<E> implements Set<E> {

    private ArrayList<E> elements;

    public ArrayListSet() {
        elements = new ArrayList<>();
    }

    @Override
    public void add(E e) {
        if(this.elements.contains(e)){
            return;
        }
        else{
            this.elements.add(e);
        }
    }

    @Override
    public void remove(E e) {
        elements.remove(e);
    }

    @Override
    public boolean contains(Object e) {
        return elements.contains(e);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean subsetOf(Set<?> other) {
        for(E e: this.elements){
            if(!other.contains(e)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return this.elements.iterator();
    }

    @Override
    public Set<E> union(Set<? extends E> other) {
        ArrayListSet<E> result = new ArrayListSet<E>();
        for(E e: other){
           result.add(e);
        }
        for(E f: this){
            result.add(f);
        }
        return result;
    }

    @Override
    public Set<E> intersection(Set<? extends E> other) {
        ArrayListSet<E> result = new ArrayListSet<E>();
        for(E e: this){
            if(other.contains(e)){
                result.add(e);
            }
         }
         return result;
    }

    /**
     * For this method, it should be possible to compare all other possible sets
     * for equality with this set. For example, if an ArrayListSet<Fruit> and a
     * LinkedListSet<Fruit> both contain the same elements they are equal.
     * Similarly, if a Set<Apple> contains the same elements as a Set<Fruit>
     * they are also equal.
     */
    @Override
    public boolean equals(Object other) {
        if(other == null){
            return false;
        }
        else if(other == this){
            return true;
        }
        else if(!(other instanceof Set)){
            return false;
        }
        Set<?> temp = (Set<?>) other;

        if(temp.size() != this.size()){
            return false;
        }
        else if(!temp.subsetOf(this)){
            return false;
        }
        else if(!this.subsetOf(temp)){
            return false;
        }
        return true;
    }

}
