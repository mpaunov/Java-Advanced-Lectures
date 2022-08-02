package command;

public class Main {
    public static void main(String[] args) {
        ModifyPrice modifyPrice = new ModifyPrice();
        Product product = new Product("Phone",500);

        execute(new IncreaseProductPriceCommand(product, 100));
        execute(new IncreaseProductPriceCommand(product, 50));
        execute(new DecreaseProductPriceCommand(product, 25));
        execute(new UpdateProductName(product, "Mobile Phone"));

        System.out.println(product);
    }
    private static void execute(Command productCommand){
        System.out.println(productCommand.executeAction());
    }
}


