package practice.project.euler.util.model;

/**
 * Created by IntelliJ IDEA.
 * User: ewagner
 * Date: 8/3/11
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tuple<T,U> {
    T value1;
    U value2;

    public Tuple(T value1, U value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getValue1() {
        return value1;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public U getValue2() {
        return value2;
    }

    public void setValue2(U value2) {
        this.value2 = value2;
    }
}
