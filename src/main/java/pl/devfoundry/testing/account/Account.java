package pl.devfoundry.testing.account;


class Account {

    private boolean active;
    private Address defaultDeliveryAddress;
    private String email;

    Account() {
        this.active = false;
    }

    Account(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
        if(defaultDeliveryAddress != null) {
            activate();
        } else {
            this.active = false;
        }
    }

    void activate() {
        this.active = true;
    }

    boolean isActive() {
        return this.active;
    }

    Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }

    public void setEmail(String email) {

        if(email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Wrong email format");
        }

    }
}