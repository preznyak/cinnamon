package hu.preznyak.hotel.cinnamon.data;

public enum View {
    OCEAN("Ocean"), MOUNTAIN("Mountain"), COURT("Court"), STREET("Street"), GARDEN("Garden");
    private String label;

    private View(String label) {
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
