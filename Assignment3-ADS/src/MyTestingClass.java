public class MyTestingClass {
    ;
    private String carModel;
    private int price;
    private int year;

    public MyTestingClass(int year, String carModel, int price) {
        this.price = price;
        this.year = year;
        this.carModel = carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) {
            return false;
        }
        if (!(o instanceof MyTestingClass)) {
            return false;
        }
        MyTestingClass car = (MyTestingClass) o;
        if (year != car.year) {
            return false;
        }
        if (price != car.price) {
            return false;
        }
        return carModel.equals(car.carModel);
    }


    @Override
    public int hashCode() {
        int result = 31;
        int strHash = 0;
        for (int i = 0; i < carModel.length(); i++) {
            strHash = 31 + strHash + carModel.charAt(i);
        }
        result = 31 * result + strHash;
        result = 31 * result + year;
        result = 31 * result + price;
        return result;
    }


    @Override
    public String toString(){
        return "Car model: " + carModel + "\nYear of manufacture: " + year + "\nPrice: " + price;
    }
}
