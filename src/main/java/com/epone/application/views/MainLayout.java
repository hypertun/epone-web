package com.epone.application.views;

import org.checkerframework.checker.units.qual.s;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    public MainLayout() {
        Image sCompanyLogo = new Image("images/small-logo.png", "sCompanyLogo");
        sCompanyLogo.setWidth("100px");
        sCompanyLogo.setHeight("100px");
        sCompanyLogo.getStyle().set("padding-right", "5%");

        HorizontalLayout navigation = new HorizontalLayout();
        navigation.setWidth("100%");
        navigation.setPadding(true);
        navigation.setAlignItems(FlexComponent.Alignment.CENTER);
        navigation.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        Button searchMaidsButton = new Button("Search Maids", e -> {
            UI.getCurrent().getPage().setLocation("https://epone.netmaid.com.sg/searchmaid");
        });

        Button homeButton = new Button("Home");
        homeButton.addClickListener(e -> homeButton.getUI().ifPresent(ui -> ui.navigate("home")));

        Button aboutButton = new Button("About Us");
        aboutButton.addClickListener(e -> aboutButton.getUI().ifPresent(ui -> ui.navigate("about")));

        Button contactButton = new Button("Contact Us");

        navigation.add(sCompanyLogo, searchMaidsButton, homeButton, aboutButton, contactButton);
        navigation.getElement();

        addToNavbar(navigation);

    }

    // private H1 viewTitle;

    // public MainLayout() {
    // setPrimarySection(Section.DRAWER);
    // addDrawerContent();
    // addHeaderContent();
    // }

    // private void addHeaderContent() {
    // DrawerToggle toggle = new DrawerToggle();
    // toggle.setAriaLabel("Menu toggle");

    // viewTitle = new H1();
    // viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

    // addToNavbar(true, toggle, viewTitle);
    // }

    // private void addDrawerContent() {
    // Span appName = new Span("My App");
    // appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD,
    // LumoUtility.FontSize.LARGE);
    // Header header = new Header(appName);

    // Scroller scroller = new Scroller(createNavigation());

    // addToDrawer(header, scroller, createFooter());
    // }

    // private SideNav createNavigation() {
    // SideNav nav = new SideNav();

    // nav.addItem(new SideNavItem("Hello World", HelloWorldView.class,
    // LineAwesomeIcon.GLOBE_SOLID.create()));
    // nav.addItem(new SideNavItem("About", AboutView.class,
    // LineAwesomeIcon.FILE.create()));

    // return nav;
    // }

    // private Footer createFooter() {
    // Footer layout = new Footer();

    // return layout;
    // }

    // @Override
    // protected void afterNavigation() {
    // super.afterNavigation();
    // viewTitle.setText(getCurrentPageTitle());
    // }

    // private String getCurrentPageTitle() {
    // PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
    // return title == null ? "" : title.value();
    // }
}
