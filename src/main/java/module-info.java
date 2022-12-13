module com.nk1604h.lmsv3jvm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.nk1604h.lmsv3jvm to javafx.fxml;
    exports com.nk1604h.lmsv3jvm;
}