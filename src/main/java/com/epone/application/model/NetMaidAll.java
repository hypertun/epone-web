package com.epone.application.model;

import java.util.ArrayList;

public class NetMaidAll {
    public int status;
    public ArrayList<NetMaidAllData> data;
    public int totalRows;

    public int getStatus() {
        return status;
    }

    public ArrayList<NetMaidAllData> getData() {
        return data;
    }

    public int getTotalRows() {
        return totalRows;
    }
}
