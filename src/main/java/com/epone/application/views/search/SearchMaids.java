package com.epone.application.views.search;

import java.util.ArrayList;

import org.springframework.web.client.RestClient;

import com.epone.application.EponePage;
import com.epone.application.model.NetMaidAllData;
import com.epone.application.repo.NetMaidCaller;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Search Maids")
@Route(value = "searchmaids", layout = MainLayout.class)
public class SearchMaids extends EponePage {
    NetMaidCaller caller = new NetMaidCaller(RestClient.builder());

    public SearchMaids() {  
        Grid<NetMaidAllData> grid = new Grid<>();
        grid.setDataProvider(getDataProvider());
        grid.addColumn(NetMaidAllData::getName);
        grid.addColumn(NetMaidAllData::getNationality);
        grid.addColumn(NetMaidAllData::getAvailability);


        add(grid);
    }

    private DataProvider<NetMaidAllData, Void> getDataProvider() {
        caller.SetCookie();

        DataProvider<NetMaidAllData, Void> dataProvider =
         DataProvider.fromCallbacks(
        // First callback fetches items based on a query
        query -> {
            // The index of the first item to load
            int offset = query.getOffset();

            // The number of items to load
            int limit = query.getLimit();

            ArrayList<NetMaidAllData> allMaids = caller.GetNetMaidAllMaids(offset, limit).getData();

            return allMaids.stream();
        },
        // Second callback fetches the total number of items currently in the Grid.
        // The grid can then use it to properly adjust the scrollbars.
        query -> caller.GetNetMaidAllMaids(0,999).getTotalRows());

        return dataProvider;
    }

}
