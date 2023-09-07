public class Product {

    private String name;
    private String description;
    private String ID;
    private double cost;
    static private int IDSeed = 1;


    public static int getIDSeed() {
        return IDSeed;
    }

    public static void setIDSeed(int IDSeed) {
        Product.IDSeed = IDSeed;
    }

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }
    public Product(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.ID = this.genIDNum();
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    private String genIDNum() {
        String newID = "" + IDSeed;
        while (newID.length() < 8)
            newID = "0" + newID;

        IDSeed++;

        return newID;

    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSVDataRecord() {
        return ID + ", " + name + ", " + description + ", " + cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", cost=" + cost +
                '}';
    }


}
