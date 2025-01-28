package com.epone.application.model.netmaid.netmaidall;

import java.util.ArrayList;

public class NetMaidAll {
    public int status;
    public ArrayList<Data> data;
    public int totalRows;

    public int getStatus() {
        return status;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public int getTotalRows() {
        return totalRows;
    }
}
