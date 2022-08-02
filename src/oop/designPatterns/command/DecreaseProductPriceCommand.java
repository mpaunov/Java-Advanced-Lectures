package command;

public class DecreaseProductPriceCommand implements Command {
    private final Product product;
    private final int amount;

    public DecreaseProductPriceCommand(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String executeAction() {
        this.product.decreasePrice(this.amount);
        return String.format("The price for the %s has been decreased by %d$.%n",
                this.product.getName(), this.amount);
    }
}

