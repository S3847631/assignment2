package sample;

import javafx.scene.control.cell.TextFieldTableCell;

public class CareHomeException {

    static class TimeErrorException extends Exception{
        public TimeErrorException(){

        }

        public TimeErrorException(String Message){
            super(Message);
        }
    }

    static class AddResidentException extends Exception{
        public AddResidentException(){

        }
        public AddResidentException(String Message) {
            super(Message);
        }
    }

    static class OperationException extends Exception{
        public OperationException(){

        }
        public OperationException(String Message) {
            super(Message);
        }
    }

}
