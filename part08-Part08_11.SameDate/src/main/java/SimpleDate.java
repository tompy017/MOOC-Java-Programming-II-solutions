
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }

    @Override
    public boolean equals(Object date) {
        // object passed is null of diferent class (SimpleDate)
        if (date == null || this.getClass() != date.getClass()) {
            return false;
        }
        if (this == date) {
            return true;
        }
        
        // convert the compared object passed as a parameter to a SimpleDate object
        SimpleDate compare = (SimpleDate) date;
        // check if day, month and year are the same
        if (this.day == compare.day &&
                this.month == compare.month &&
                this.year == compare.year) {
            return true;
        }
        
        return false;
    }

}
