package com.cleancode.demo.dip.violation;
class Database {
    public void saveData(String data) {}
}

class Application {
    private Database database;

    public Application(Database database) {
        this.database = database;
    }

    public void processData(String data) {
        // Process data
        database.saveData(data);
    }
}
