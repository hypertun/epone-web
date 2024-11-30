package com.epone.application.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    public MainLayout() {
        Image sCompanyLogo = new Image("images/small-logo.png", "sCompanyLogo");
        // sCompanyLogo.setWidth("100px");
        sCompanyLogo.setHeight("100px");
        sCompanyLogo.getStyle().set("padding-right", "5%");

        MenuBar menuBar = new MenuBar();

        HorizontalLayout navigation = new HorizontalLayout();
        navigation.setWidth("100%");
        navigation.setAlignItems(FlexComponent.Alignment.CENTER);
        navigation.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        menuBar.addItem("Seach Maids", e -> {
            UI.getCurrent().getPage().setLocation("https://epone.netmaid.com.sg/searchmaid");
        });

        menuBar.addItem("Home", clickListenerToPage("home"));
        menuBar.addItem("About Us", clickListenerToPage("about"));

        MenuItem servicesSubItem = menuBar.addItem("Services");
        servicesSubItem.addClassNames(LumoUtility.Background.PRIMARY,
        LumoUtility.TextColor.PRIMARY_CONTRAST);
        SubMenu servicesSubMenu = servicesSubItem.getSubMenu();
        SubMenu typesOfHelpersMenu = servicesSubMenu.addItem("Types Of Helpers").getSubMenu();
        typesOfHelpersMenu.addItem("Fresh Maids", clickListenerToPage("fresh maids"));
        typesOfHelpersMenu.addItem("Experienced Maids", clickListenerToPage("exp maids"));

        menuBar.addItem("Contact Us", clickListenerToPage("contact"));

        navigation.add(sCompanyLogo, menuBar);
        navigation.getElement();

        Image whatsappImage = new Image("images/WhatsAppButtonGreenSmall.png", "whatsappButton");
        whatsappImage.setHeight("50px");

        // Construct the WhatsApp link with your desired phone number and message
        String phoneNumber = "+6591269010"; // Replace with the actual phone number
        String message = "Hello! I'm interested in a helper!"; // Replace with your message
        String whatsappLink = "https://wa.me/" + phoneNumber + "?text=" + message;

        // Create an Anchor component that opens the WhatsApp link in a new tab
        Anchor whatsAppButton = new Anchor(whatsappLink, whatsappImage);
        whatsAppButton.getStyle().set("padding-right", "1%");
        whatsAppButton.setTarget("_blank"); // Open link in a new tab

        addToNavbar(navigation, whatsAppButton);

    }

    private ComponentEventListener<ClickEvent<MenuItem>> clickListenerToPage(String pageAlias) {
        return e -> getUI().ifPresent(ui -> ui.navigate(pageAlias));
    }

}
