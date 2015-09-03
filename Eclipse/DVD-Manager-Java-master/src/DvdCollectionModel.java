
/**
 *
 * @author Carl van der Smissen
 * @date Jun 20, 2012
 * @terminal 6
 */
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class DvdCollectionModel {

    private List<Dvd> ownedDvds;

    public DvdCollectionModel() {
        ownedDvds = new Vector<Dvd>();
    }

    public boolean addDvd(Dvd newDvd) {
        return ownedDvds.add(newDvd);
    }

    public boolean removeDvd(Dvd oldDvd) {
        if (!ownedDvds.isEmpty()) {
            for (int i = 0; i < ownedDvds.size(); i++) {
                if (oldDvd.equals(ownedDvds.get(i))) {
                    return ownedDvds.remove(ownedDvds.get(i));
                }
            }
        }
        return false;
    }

    public boolean contains(Dvd dvd) {
        if (!ownedDvds.isEmpty()) {
            for (int i = 0; i < ownedDvds.size(); i++) {
                if (dvd.equals(ownedDvds.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Dvd> getCollection() {
        return ownedDvds;
    }

    public List<Dvd> sortByTitle() {
        Collections.sort(ownedDvds, Dvd.byTitle);
        return ownedDvds;
    }

    public List<Dvd> sortByYear() {
        Collections.sort(ownedDvds, Dvd.byYear);
        return ownedDvds;
    }

    public boolean load() {
        try {
            if (ownedDvds != null) {
                ownedDvds.clear();
            }
            Scanner dataFile = new Scanner(new FileInputStream("datafile.txt"));
            while (dataFile.hasNextLine()) {
                String title = "", category = "", time = "", year = "", price = "";
                dataFile.useDelimiter("[,\\n]+");
                title = dataFile.next();
                category = dataFile.next();
                time = dataFile.next();
                year = dataFile.next();
                price = dataFile.next();
                time = time.substring(0, time.indexOf(' '));
                int theTime = Integer.parseInt(time);
                int theYear = Integer.parseInt(year);
                double thePrice = Double.parseDouble(price);
                if (!title.equals("")) {
                    addDvd(new Dvd(title, category, theTime, theYear, thePrice));
                }
            }
            dataFile.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean save() {
        if (!ownedDvds.isEmpty()) {
            PrintWriter dataFile = null;
            try {
                dataFile = new PrintWriter(new FileWriter("datafile.txt"));
                Collections.sort(ownedDvds, Dvd.byTitle);
                int i;
                for (i = 0; i < ownedDvds.size() - 1; i++) {
                    dataFile.println(ownedDvds.get(i).toString());
                }
                dataFile.print(ownedDvds.get(i).toString());
                dataFile.close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        }
        return false;
    }
}
