//package optionInterface;
import java.util.ArrayList;
import java.util.Arrays;
public interface optionInterface{
  public abstract void remove(String name);
  public abstract void addDepartment(String name);
  public abstract void update(String name, String newName);
  public abstract ArrayList<String> display();
}
