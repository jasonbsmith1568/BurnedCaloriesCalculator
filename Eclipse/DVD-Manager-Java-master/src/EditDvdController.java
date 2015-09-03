
/**
 *
 * @author Carl van der Smissen
 * @date Jun 20, 2012
 * @terminal 6
 */
class EditDvdController {

    private EditDvdView view;
    private DvdCollectionController parent;

    EditDvdController(DvdCollectionController pController) {
        parent = pController;
        view = new EditDvdView(this);
    }

    void show(final Dvd selectedDvd) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                view.loadValuesFromSelected(selectedDvd);
                view.setVisible(true);
                view.setLocationRelativeTo(null);
            }
        });
    }

    void editDvd(Dvd editedDvd) {
        parent.addDvd(editedDvd);
    }

    void remove(Dvd oldDvd) {
        parent.removePressed(oldDvd);
    }

    void exit() {
        view.setVisible(false);
        view = new EditDvdView(this);
    }
}
