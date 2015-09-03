
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Carl van der Smissen
 * @date Jun 20, 2012
 * @terminal 6
 */
public class DvdCollectionController {

    private DvdCollectionModel model;
    private DvdCollectionView view;
    private AddDvdController addWindow;
    private EditDvdController editWindow;

    public DvdCollectionController() {
        model = new DvdCollectionModel();
        view = new DvdCollectionView(this);
        addWindow = new AddDvdController(this);
        editWindow = new EditDvdController(this);
    }

    public void show() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                view.setTitle("DVD Management System");
                view.setVisible(true);
                view.setLocationRelativeTo(null);
            }
        });
    }

    public void exit() {
        view.setVisible(false);
        addWindow.exit();
        editWindow.exit();
        System.exit(0);
    }

    public void loadFilePressed() {
        model.load();
        List<Dvd> data = model.getCollection();
        view.reloadTable(data);
    }

    public void saveFilePressed() {
        model.save();
    }

    public void listAllByTitlePressed() {
        model.sortByTitle();
        List<Dvd> data = model.getCollection();
        view.reloadTable(data);
    }

    public void listAllByYearPressed() {
        model.sortByYear();
        List<Dvd> data = model.getCollection();
        view.reloadTable(data);
    }

    public void addPressed() {
        addWindow.show();
    }

    public void removePressed(Dvd oldDvd) {
        model.removeDvd(oldDvd);
        listAllByTitlePressed();
    }

    public void editPressed() {
        Dvd selectedDvd = view.getSelectedDvd();
        editWindow.show(selectedDvd);
    }

    public void searchPressed() {
        List<Dvd> data = model.getCollection();
        List<Dvd> results = new Vector<Dvd>();
        if (!data.isEmpty()) {
            String str = view.getSearchTerm().toLowerCase();
            for (Dvd current : data) {
                if (current.getTitle().toLowerCase().contains(str.subSequence(0, str.length()))) {
                    results.add(current);
                }
            }
            view.reloadTable(results);
        }

    }

    public void addDvd(Dvd newDvd) {
        model.addDvd(newDvd);
        listAllByTitlePressed();
    }
}
