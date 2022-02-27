package oop;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;

import java.util.StringJoiner;

public class TestSetNullField {

    public static void main(String[] args) {
        TestObj testObj = new TestObj();
//        testObj.setIntField(null);
        testObj.setStrField(null);
        testObj.setObjField(null);
        System.out.println(testObj);
    }

    //    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @ToString
    private static class TestObj {

        private int intField;
        private String strField;
        private Student objField;

        public TestObj() {
        }

        public void setIntField(int intField) {
            this.intField = intField;
        }

        public void setStrField(String strField) {
            this.strField = strField;
        }

        public void setObjField(Student objField) {
            this.objField = objField;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", TestObj.class.getSimpleName() + "[", "]")
                    .add("intField=" + intField)
                    .add("strField='" + strField + "'")
                    .add("objField=" + objField)
                    .toString();
        }
    }
}
