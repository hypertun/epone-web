package com.epone.application.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    public MainLayout() {
        Image sCompanyLogo = new Image("images/small-logo.png", "sCompanyLogo");
        // sCompanyLogo.setWidth("100px");
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
        contactButton.addClickListener(e -> contactButton.getUI().ifPresent(ui -> ui.navigate("contact")));

        navigation.add(sCompanyLogo, searchMaidsButton, homeButton, aboutButton, contactButton);
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

}
