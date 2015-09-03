
/**
 *
 * @author Carl van der Smissen
 * @date Jun 20, 2012
 * @terminal 6
 */
class AddDvdController {

    private AddDvdView view;
    private DvdCollectionController parent;

    AddDvdController(DvdCollectionController pController) {
        parent = pController;
        view = new AddDvdView(this);

    }

    void show() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                view.setVisible(true);
            }
        });
    }

    void exit() {
        view.setVisible(false);
        view = new AddDvdView(this);
    }

    void addDvd(Dvd newDvd) {
        parent.addDvd(newDvd);
    }
}
