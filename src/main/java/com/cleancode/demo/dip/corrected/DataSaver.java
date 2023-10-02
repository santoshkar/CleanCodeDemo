package com.cleancode.demo.dip.corrected;
interface DataSaver {
    void saveData(String data);
}

class Database implements DataSaver {
    @Override
    public void saveData(String data) {
        // Code to save data to a database
    }
}

class Application {
    private DataSaver dataSaver;

    public Application(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    public void processData(String data) {
        // Process data
        dataSaver.saveData(data);
    }
}
