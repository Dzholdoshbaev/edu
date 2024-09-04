package dzholdoshbaev.laboratory.constant;

public enum Status {

    PRE_ORDER("PRE_ORDER"),
    ORDERED("ORDERED"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED");


    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getAuthority() {
        return status;
    }
}
