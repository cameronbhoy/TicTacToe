public class IndividualBox {
    private String boxLabel;
    private boolean hasBeenChosen;
    public IndividualBox(String boxLabel_in) {
        boxLabel = boxLabel_in;
        hasBeenChosen = false;
    }

    public String getBoxLabel()
    {
        return boxLabel;
    }

    public void selectThisBox(String marker) {
        boxLabel = "*" + marker + "*";
        markBoxAsSelected();
    }

    private void markBoxAsSelected() {
        hasBeenChosen = true;
    }
}
