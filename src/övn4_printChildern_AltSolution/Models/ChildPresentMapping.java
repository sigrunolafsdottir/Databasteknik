package övn4_printChildern_AltSolution.Models;

public class ChildPresentMapping {

    Child child;

    Present present;



    public ChildPresentMapping() {}

    public ChildPresentMapping(Child child, Present present) {
        this.child = child;
        this.present = present;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Present getPresent() {
        return present;
    }

    public void setPresent(Present present) {
        this.present = present;
    }

}
