package com.epone.application.views.search;

import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.web.client.RestClient;

import com.epone.application.EponePage;
import com.epone.application.model.NetMaidAllData;
import com.epone.application.repo.NetMaidCaller;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Search Maids")
@Route(value = "searchmaids", layout = MainLayout.class)
public class SearchMaids extends EponePage {
    NetMaidCaller caller = new NetMaidCaller(RestClient.builder());

    public SearchMaids() {
        Grid<NetMaidAllData> grid = new Grid<>();

        caller.SetCookie();
        ArrayList<NetMaidAllData> allMaids = caller.GetNetMaidAllMaids().getData();
        grid.setItems(allMaids);

        grid.addColumn(NetMaidAllData::getCode).setHeader("Code")
                .setComparator(Comparator.comparing(maid -> maid.getCode().trim().toLowerCase()));

        grid.addColumn(NetMaidAllData::getName).setHeader("Name")
                .setComparator(Comparator.comparing(maid -> maid.getName().trim().toLowerCase()));

        grid.addColumn(NetMaidAllData::getNationality).setHeader("Nationality")
                .setComparator(Comparator.comparing(maid -> maid.getNationality().trim().toLowerCase()));

        grid.addColumn(NetMaidAllData::getX_age).setHeader("Age")
                .setComparator(Comparator.comparing(maid -> maid.getX_age()));

        grid.addColumn(NetMaidAllData::getMtype).setHeader("Type")
                .setComparator(Comparator.comparing(maid -> maid.getMtype().trim().toLowerCase()));

        add(grid);
    }
}