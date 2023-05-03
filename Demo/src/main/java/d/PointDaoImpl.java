package d;

import model.Point;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PointDaoImpl implements PointDao {
    private static HashMap<Integer, Point> map = null;
    private static Integer pts = 2000;

    static{
        map = new HashMap<Integer, Point>();
        map.put(1, new Point(1000, 2014));


    }

    @Override
    public Collection<Point> getAll() {
        return null;
    }

    @Override
    public void get(Integer amount) {
        ;
    }

    @Override
    public Collection<Point> getAll(Integer time) {
        return null;
    }

    @Override
    public void save(Point p) {

    }

    @Override
    public void delete(Integer amount) {
        map.remove(amount);
    }

    @Override
    public void update(Integer amount) {



    }

    @Override
    public Point add(Point p) {
        map.put(p.getAmount(), p);

    }
}
