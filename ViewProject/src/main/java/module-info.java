module ife_mp_lk.viewproject {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens ife_mp_lk.viewproject to javafx.fxml;
    exports ife_mp_lk.viewproject;
}