public class Main {
    public static void main(String[] args) {
        Product chips = new Product("BBQ Chips", "These are bbq chips", 2.34);
        Product cookies = new Product("Snickerdoodle", "These are cookies", 1.00);

        System.out.println(chips.toCSVDataRecord());
        System.out.println(cookies.toCSVDataRecord());
    }
}