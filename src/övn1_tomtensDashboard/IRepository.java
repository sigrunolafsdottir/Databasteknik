package övn1_tomtensDashboard;

import java.util.List;

public interface IRepository {

    int getNumberOfKids();
    int getRowCount(String tableName);
    List<Elf> getAllElfs();
    double getNicenessAverage();
}
