module sn.dev.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires TrayNotification;

    opens sn.dev.demojavafx to javafx.fxml;
    exports sn.dev.demojavafx;

    exports sn.dev.demojavafx.controller;
    opens sn.dev.demojavafx.controller to javafx.fxml;
}