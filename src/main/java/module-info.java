module com.mycompany.waktuku {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    opens com.mycompany.waktuku to javafx.fxml;
    exports com.mycompany.waktuku;
}
