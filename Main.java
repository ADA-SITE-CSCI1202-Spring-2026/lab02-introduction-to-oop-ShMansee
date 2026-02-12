import week03.invoice.Invoice;

public class Main {
    public static void main(String[] args) {

        Invoice inv = new Invoice("A123", "Hammer", 5, 10.5);

        System.out.println(inv.getPartNumber());
        System.out.println(inv.getPartDescription());
        System.out.println(inv.getQuantity());
        System.out.println(inv.getPricePerItem());
    }
}
