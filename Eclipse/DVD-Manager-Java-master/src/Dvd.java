
import java.util.Comparator;

/**
 *
 * @author Carl van der Smissen
 * @date Jun 20, 2012
 * @terminal 6
 */
public class Dvd implements Comparator<Dvd>, Comparable<Dvd> {

    private String title, category;
    private int runningTime, yearReleased;
    private double price;
    public static Comparator<Dvd> byYear = new Comparator<Dvd>() {

        public int compare(Dvd t, Dvd t1) {
            return t.yearReleased - t1.yearReleased;
        }
    };
    public static Comparator<Dvd> byTitle = new Comparator<Dvd>() {

        public int compare(Dvd t, Dvd t1) {
            return t.title.compareToIgnoreCase(t1.title);
        }
    };

    public Dvd() {
        title = "";
        category = "";
        runningTime = yearReleased = 0;
        price = 0.00;
    }

    public Dvd(String newTitle, String newCategory, int newTime, int newYear, double newPrice) {
        title = newTitle;
        category = newCategory;
        runningTime = newTime;
        yearReleased = newYear;
        price = newPrice;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory(String newCategory) {
        category = newCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setRunningTime(int newTime) {
        runningTime = newTime;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setYearReleased(int newYear) {
        yearReleased = newYear;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title + "," + category + "," + runningTime + " Mins.," + yearReleased + "," + price;
    }

    public boolean equals(Dvd d2) {
        boolean equal = false;
        switch (this.compareTo(d2)) {
            case 1:
                equal = true;
                break;
            default:
                equal = false;
                break;
        }
        return equal;
    }

    public int compareTo(Dvd d2) {
        int i = 0;
        if ((this.title.equalsIgnoreCase(d2.title)) && (this.category.equalsIgnoreCase(d2.category)) && (this.runningTime == d2.runningTime) && (this.yearReleased == d2.yearReleased)) {
            i = 1;
        }
        return i;
    }

    public int compare(Dvd d1, Dvd d2) {
        return d1.compareTo(d2);
    }
}
