package com.epone.application.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    public MainLayout() {
        H1 title = new H1("EP One Manpower Pte Ltd");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("position", "relative");

        Image sCompanyLogo = new Image("images/small-logo.png", "sCompanyLogo");
        sCompanyLogo.setMaxWidth("50px");
        sCompanyLogo.getStyle().set("left","60px").set("position", "relative");

        VerticalLayout titleWithLogo = new VerticalLayout();
        titleWithLogo.add(title,sCompanyLogo);

        HorizontalLayout navigation = new HorizontalLayout();

        navigation.getElement();

        addToNavbar(titleWithLogo, navigation);

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
