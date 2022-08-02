package command;

public class UpdateProductName implements Command {

    private Product product;
    private String newName;

    public UpdateProductName(Product product, String newName) {
        this.product = product;
        this.newName = newName;
    }

    @Override
    public String executeAction() {
        String oldName = product.getName();
        product.setName(newName);
        return "Product name updated from " + oldName + " to " + newName;
    }

}
