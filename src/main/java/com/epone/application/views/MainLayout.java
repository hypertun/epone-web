package com.epone.application.views;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

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
    private String selectPage = "Home";
    private List<MenuItem> allMenuItems = new ArrayList<MenuItem>();

    private final String homePage = "Home";
    private final String aboutPage = "About Us";
    private final String servicesPage = "Services";
    private final String trainingPage = "Training";
    private final String faqPage = "FAQs";
    private final String contactPage = "Contact Us";

    public MainLayout() {
        initialSetPage();

        Image sCompanyLogo = new Image("images/small-logo.png", "sCompanyLogo");
        sCompanyLogo.setHeight("100px");
        sCompanyLogo.getStyle().set("padding-right", "5%");

        MenuBar menuBar = new MenuBar();
        menuBar.setOpenOnHover(true);

        HorizontalLayout navigation = new HorizontalLayout();
        navigation.setWidth("100%");
        navigation.setAlignItems(FlexComponent.Alignment.CENTER);
        navigation.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        menuBar.addItem("Seach Maids", e -> {
            UI.getCurrent().getPage().setLocation("https://epone.netmaid.com.sg/searchmaid");
        });

        this.allMenuItems.add(menuBar.addItem(homePage, clickListenerToPage("home")));
        this.allMenuItems.add(menuBar.addItem(aboutPage, clickListenerToPage("about")));

        MenuItem servicespageMenuBar = menuBar.addItem(servicesPage);
        SubMenu servicesSubMenu = servicespageMenuBar.getSubMenu();
        servicesSubMenu.addItem("Hiring A Maid", clickListenerToPage("hiring maids"));
        SubMenu typesOfHelpersMenu = servicesSubMenu.addItem("Types Of Helpers").getSubMenu();
        typesOfHelpersMenu.addItem("Fresh Maids", clickListenerToPage("fresh maids"));
        typesOfHelpersMenu.addItem("Experienced Maids", clickListenerToPage("exp maids"));
        typesOfHelpersMenu.addItem("Transfer Maids", clickListenerToPage("transfer maids"));
        typesOfHelpersMenu.addItem("Direct Hire Maids", clickListenerToPage("direct hire maids"));

        SubMenu nationalitiesMenu = servicesSubMenu.addItem("Nationalities of Helpers").getSubMenu();
        nationalitiesMenu.addItem("Indonesian Maids", clickListenerToPage("indo maids"));
        nationalitiesMenu.addItem("Myanmar Maids", clickListenerToPage("myam maids"));
        nationalitiesMenu.addItem("Philippines Maids", clickListenerToPage("phil maids"));

        this.allMenuItems.add(servicespageMenuBar);

        this.allMenuItems.add(menuBar.addItem(trainingPage, clickListenerToPage("training maids")));

        this.allMenuItems.add(menuBar.addItem(faqPage, clickListenerToPage("faq")));

        this.allMenuItems.add(menuBar.addItem(contactPage, clickListenerToPage("contact")));

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
        return e -> {
            setSelectedPage(e.getSource());
            setSelectedPageMenuBar();
            getUI().ifPresent(ui -> ui.navigate(pageAlias));
        };
    }

    private void setSelectedPage(MenuItem menuItem) {
        String[] allPagesString = { homePage, aboutPage, servicesPage, trainingPage, faqPage, contactPage };
        String menuText = menuItem.getText();

        Boolean found = false;
        if (ArrayUtils.contains(allPagesString, menuText)) {
            found = true;
        }

        if (!found) {
            this.selectPage = servicesPage;
            return;
        }

        this.selectPage = menuText;
    }

    private void setSelectedPageMenuBar() {
        for (MenuItem menuItem : this.allMenuItems) {
            if (menuItem.getText().equals(this.selectPage)) {
                menuItem.addClassNames(LumoUtility.Background.PRIMARY,
                        LumoUtility.TextColor.PRIMARY_CONTRAST);
                continue;
            }

            menuItem.removeClassNames(LumoUtility.Background.PRIMARY,
                    LumoUtility.TextColor.PRIMARY_CONTRAST);
        }
    }

    private void initialSetPage() {
        UI.getCurrent().getPage().fetchCurrentURL(currentURL -> {
            String currentURLString = currentURL.toString();

            if (currentURLString.charAt(currentURLString.length() - 1) == '/') {
                setSelectedPageMenuBar();
                return;
            }

            String[] urlSplit = currentURLString.split("/");
            String path = urlSplit[urlSplit.length - 1];

            switch (path) {
                case "home":
                    this.selectPage = homePage;
                    break;
                case "about":
                    this.selectPage = aboutPage;
                    break;
                case "faq":
                    this.selectPage = faqPage;
                    break;
                case "training%20maids":
                    this.selectPage = trainingPage;
                    break;
                case "contact":
                    this.selectPage = contactPage;
                    break;
                default:
                    this.selectPage = servicesPage;
            }

            setSelectedPageMenuBar();
        });
    }

}
