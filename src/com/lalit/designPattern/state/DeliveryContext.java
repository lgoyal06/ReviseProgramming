package com.lalit.designPattern.state;

public class DeliveryContext {
    private PackageState currentState;

    private String packageId;

    public DeliveryContext(PackageState currentState, String packageId) {
        this.currentState = currentState;
        this.packageId = packageId;
        if (this.currentState == null) {
            this.currentState = Acknowledged.getInstance();
        }
    }

    public void updateState() {
        this.currentState.updateState(this);
    }

    public void setNextState(PackageState state) {
        this.currentState = state;
    }

}
