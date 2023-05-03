package d;


import model.Point;

import java.util.Collection;

public interface PointDao {
    Collection<Point> getAll();
    void get(Integer amount);
    Collection<Point> getAll(Integer time);

    void save(Point p);
    void delete(Integer amount);
    void update(Integer amount);
    Point add(Point p);






}
