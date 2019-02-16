package pl.devfoundry.testing.account;


class Account {

    private boolean active;
    private Address defaultDeliveryAddress;

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

}