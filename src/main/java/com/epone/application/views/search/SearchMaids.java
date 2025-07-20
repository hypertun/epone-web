package com.epone.application.views.search;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.web.client.RestClient;

import com.epone.application.EponePage;
import com.epone.application.model.netmaid.netmaidall.Data;
import com.epone.application.model.netmaid.netmaidedit.NetMaidEdit;
import com.epone.application.repo.NetMaidCaller;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridLazyDataView;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Search Maids")
@Route(value = "searchmaids", layout = MainLayout.class)
public class SearchMaids extends EponePage {
        private static NetMaidCaller caller = new NetMaidCaller(RestClient.builder());

        public SearchMaids() {
                Grid<Data> grid = new Grid<>();

                caller.SetCookie();
                ArrayList<Data> allMaids = caller.GetNetMaidAllMaids().getData();
                grid.setDetailsVisibleOnClick(false);

                GridLazyDataView<Data> searchMaidsView = grid.setItems(
                                q -> {
                                        return allMaids.stream().skip(q.getOffset()).limit(q.getLimit());
                                },
                                q -> allMaids.size());

                grid.addComponentColumn(maid -> {
                        Image maidImage = new Image(caller.GetMaidPicture(maid.getId()).ImageP, "helper pic");
                        String imageUrl = maidImage.getSrc();

                        CompletableFuture.runAsync(() -> {
                                try {
                                        URL url = new URL(imageUrl);
                                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                                        connection.setRequestMethod("HEAD");
                                        int responseCode = connection.getResponseCode();

                                        if (responseCode == HttpURLConnection.HTTP_OK) {
                                                // Image URL is valid, apply blur
                                                getUI().ifPresent(ui -> ui.access(() -> {
                                                        maidImage.getStyle().set("filter", "blur(5px)");
                                                        maidImage.getStyle().set("cursor", "pointer");

                                                }));
                                        }
                                } catch (IOException e) {
                                        // Handle error, e.g., log it
                                        e.printStackTrace();
                                }
                        });

                        return maidImage;
                }).setHeader("Image")
                                .setFlexGrow(0).setFrozen(true);

                grid.addColumn(createToggleDetailsRenderer(grid)).setWidth("80px")
                                .setFlexGrow(0).setFrozen(true);
                grid.addColumn(Data::getCode).setHeader("Code")
                                .setComparator(Comparator.comparing(maid -> maid.getCode().trim().toLowerCase()));

                grid.addColumn(Data::getName).setHeader("Name")
                                .setComparator(Comparator.comparing(maid -> maid.getName().trim().toLowerCase()));

                grid.addColumn(Data::getNationality).setHeader("Nationality")
                                .setComparator(Comparator
                                                .comparing(maid -> maid.getNationality().trim().toLowerCase()));

                grid.addColumn(Data::getX_age).setHeader("Age")
                                .setComparator(Comparator.comparing(maid -> maid.getX_age()));

                grid.addColumn(Data::getMtype).setHeader("Type")
                                .setComparator(Comparator.comparing(maid -> maid.getMtype().trim().toLowerCase()));

                grid.setItemDetailsRenderer(createMaidDetailsRenderer());

                TextField searchField = new TextField();
                searchField.setWidth("30%");
                searchField.setPlaceholder("Search");
                searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
                searchField.setValueChangeMode(ValueChangeMode.EAGER);
                searchField.addValueChangeListener(e -> searchMaidsView.refreshAll());

                // searchMaidsView.addFilter(maid -> {
                // String searchTerm = searchField.getValue().trim();

                // if (searchTerm.isEmpty())
                // return true;

                // boolean matchesName = matches(maid.getName(),
                // searchTerm);
                // boolean matchesCode = matches(maid.getCode(), searchTerm);

                // return matchesName || matchesCode;
                // });

                grid.setHeight("700px");
                grid.setWidthFull();

                add(searchField, grid);
        }

        private boolean matches(String value, String searchTerm) {
                return searchTerm == null || searchTerm.isEmpty()
                                || value.toLowerCase().contains(searchTerm.toLowerCase());
        }

        private static Renderer<Data> createToggleDetailsRenderer(
                        Grid<Data> grid) {

                return LitRenderer
                                .<Data>of(
                                                """
                                                                    <vaadin-button
                                                                        theme="tertiary icon"
                                                                        aria-label="Toggle details"
                                                                        aria-expanded="${model.detailsOpened ? 'true' : 'false'}"
                                                                        @click="${handleClick}"
                                                                    >
                                                                        <vaadin-icon
                                                                        .icon="${model.detailsOpened ? 'lumo:angle-down' : 'lumo:angle-right'}"
                                                                        ></vaadin-icon>
                                                                    </vaadin-button>
                                                                """)
                                .withFunction("handleClick",
                                                maid -> grid.setDetailsVisible(maid,
                                                                !grid.isDetailsVisible(maid)));
        }

        private static ComponentRenderer<MaidDetailsFormLayout, Data> createMaidDetailsRenderer() {
                return new ComponentRenderer<>(MaidDetailsFormLayout::new,
                                MaidDetailsFormLayout::setMaid);
        }

        private static class MaidDetailsFormLayout extends FormLayout {
                private final TextField nationalityField = new TextField("Nationality");
                private final TextField birthdateField = new TextField("Date Of Birth");
                private final TextField siblingsField = new TextField("Siblings");
                private final TextField heightField = new TextField("Height");
                private final TextField weightField = new TextField("Weight");
                private final TextField martialField = new TextField("Martial Status");
                private final TextField childrenField = new TextField("No. Of Children");
                private final TextField eduField = new TextField("Education");
                private final Paragraph introField = new Paragraph();
                // LanguageSkills
                // Aptitudes
                // OtherInformations
                // WorkingExperiences

                public MaidDetailsFormLayout() {
                        Stream.of(nationalityField, birthdateField, siblingsField, heightField, weightField,
                                        martialField, childrenField, eduField).forEach(field -> {
                                                field.setReadOnly(true);
                                                add(field);
                                        });
                        add(introField);

                        setResponsiveSteps(new ResponsiveStep("0", 3));
                        setColspan(nationalityField, 3);
                        setColspan(birthdateField, 3);
                        setColspan(siblingsField, 3);
                        setColspan(heightField, 3);
                        setColspan(weightField, 3);
                        setColspan(martialField, 3);
                        setColspan(childrenField, 3);
                        setColspan(eduField, 3);
                        setColspan(introField, 3);
                }

                public void setMaid(Data maid) {
                        final NetMaidEdit maidData = caller.GetNetMaidEdit(maid.getId());

                        nationalityField.setValue(maid.getNationality());
                        birthdateField.setValue(maidData.getBirthdate());
                        siblingsField.setValue(maidData.getSiblings());
                        heightField.setValue(String.valueOf(maidData.getHeight()));
                        weightField.setValue(String.valueOf(maidData.getWeight()));

                        switch (maidData.getMarital()) {
                                case "20":
                                        martialField.setValue("Married");
                                        break;
                                case "30":
                                        martialField.setValue("Widowed");
                                        break;
                                case "40":
                                        martialField.setValue("Divorced");
                                        break;
                                case "50":
                                        martialField.setValue("Separated");
                                        break;
                                case "60":
                                        martialField.setValue("Single Parent");
                                        break;
                                default:
                                        martialField.setValue("Single");
                                        break;
                        }

                        childrenField.setValue(String.valueOf(maidData.getChildren()));

                        switch (maidData.getEdu_level()) {
                                case "10":
                                        eduField.setValue("Secondary");
                                        break;
                                case "30":
                                        eduField.setValue("High School");
                                        break;
                                case "40":
                                        eduField.setValue("College/Degree");
                                        break;
                                default:
                                        eduField.setValue("Others");
                                        break;
                        }

                        introField.getElement().setProperty("innerHTML", maidData.getIntroduction());
                }
        }
}