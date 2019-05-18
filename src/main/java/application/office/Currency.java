package application.office;

public enum Currency {

    USD("USD"),
    PLN("PLN"),
    EUR("EUR"),
    CUP("CUP");

    private String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
