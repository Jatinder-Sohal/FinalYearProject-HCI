package notes_application;

import java.io.IOException;
import javafx.fxml.FXML;

public class Main {
  @FXML
  private void switchToSecondary() throws IOException {
      App.setRoot("secondary");
  }
}
