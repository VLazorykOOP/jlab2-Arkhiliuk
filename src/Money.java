import java.util.InputMismatchException;
import java.util.Scanner;

public class Money {
    private long grn;
    private byte kop;

    public Money() {
        this.grn = 0;
        this.kop = 0;
    }

    public Money(long grn, byte kop) {
        this.grn = grn + (kop / 100);
        this.kop = (byte) (kop % 100);
    }

    public Money(double value) {
        long grn = (long) value;
        byte kop = (byte) ((value - grn) * 100);
        this.grn = grn + (kop / 100);
        this.kop = (byte) (kop % 100);
    }

    public long getGrn() {
        return grn;
    }

    public byte getKop() {
        return kop;
    }

    public Money add(Money other) {
        long sumGrn = this.grn + other.grn;
        byte sumKop = (byte) (this.kop + other.kop);
        if (sumKop >= 100) {
            sumGrn += sumKop / 100;
            sumKop %= 100;
        }
        return new Money(sumGrn, sumKop);
    }

    public Money subtract(Money other) {
        long diffGrn = this.grn - other.grn;
        byte diffKop = (byte) (this.kop - other.kop);
        if (diffKop < 0) {
            diffGrn -= 1;
            diffKop += 100;
        }
        return new Money(diffGrn, diffKop);
    }


    public Money divide(double value) {
        if (value == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        double totalKop = (this.grn * 100 + this.kop) / value;
        return new Money(totalKop / 100);
    }

    public Money divide(long value) {
        if (value == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        long quotientGrn = this.grn / value;
        byte quotientKop = (byte) ((this.grn % value * 100 + this.kop) / value);
        return new Money(quotientGrn, quotientKop);
    }

    public boolean greaterThan(Money other) {
        if (this.grn > other.grn) {
            return true;
        } else if (this.grn == other.grn && this.kop > other.kop) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lessThan(Money other) {
        if (this.grn < other.grn) {
            return true;
        } else if (this.grn == other.grn && this.kop < other.kop) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Money other) {
        if (this.grn == other.grn && this.kop == other.kop) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%d,%02d", this.grn, this.kop);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Money)) {
            return false;
        }
        Money other = (Money) obj;
        return this.grn == other.grn && this.kop == other.kop;
    }

    public static void main(String[] args) {


        System.out.println("Enter the first amount in format <grn> <kop>: ");
        long grn1=-1;
        byte kop1=-1;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                grn1 = scanner.nextLong();
                kop1 = scanner.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }while(grn1==-1 || kop1==-1);

        Money money1 = new Money(grn1, kop1);

        Money money2 = new Money(75, (byte) 25);
        Money money3 = new Money(100, (byte) 50);
        Money money4 = new Money(120, (byte) 0);
        Money money5 = new Money();

        System.out.println("Money 1: " + money1);
        System.out.println("Money 2: " + money2);
        System.out.println("Money 3: " + money3);
        System.out.println("Money 4: " + money4);
        System.out.println("Money 5: " + money5);

        System.out.println("Addition: " + money1.add(money2));
        System.out.println("Subtraction: " + money2.subtract(money1));
        System.out.println("Division 1: " + money1.divide(2));
        try {
            System.out.println("Division 2: " + money1.divide(0));
        } catch (IllegalArgumentException e) {
            System.out.println("Can't divide by zero");
        }
        System.out.println("Division 3: " + money2.divide(3.0));
        System.out.println("Greater than: " + money2.greaterThan(money1));
        System.out.println("Less than: " + money1.lessThan(money4));
        System.out.println("Equal: " + money3.equals(money4));
    }
}