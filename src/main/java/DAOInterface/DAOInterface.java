package DAOInterface;

import java.util.ArrayList;

public interface DAOInterface<T> {
	 public ArrayList<T> selectAll();
	 public T selectByID(T t);
	 public int insert(T t);
	 public int insertAll(ArrayList<T> arrlist);
	 public int delete(T t);
	 public int deleteAll(ArrayList<T> arrlist);
	 public int update(T t);
}
