package oop.interfacesAndAbstraction.borderControl;

public class Robot extends IdentifiableImpl {

    private String model;

    public Robot(String id, String model) {
        super(id);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

}
