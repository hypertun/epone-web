package com.epone.application.views.services;

import com.epone.application.EponePage;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Philippines Maids")
@Route(value = "phil maids", layout = MainLayout.class)
public class Phil extends EponePage {
    private final String header = "<span style=\"color:green\">Philippines</span><span> Maids</span>";
    private final String body = """
            Filipinos are famous for their nurturing and compassionate behaviour, making them \
            exceptionally well-suited for the care of infants and children. They often forge deep connections \
            with the families they serve, treating them as their own.
            <br>
            <br>
            The majority of Filipino helpers are Catholic and hold strong family values. They typically spend \
            their days off attending church or bonding with close friends and relatives in Singapore. \
            With English being the second official language in the Philippines, communication with Filipino \
            helpers is effortlessly facilitated. This language proficiency enables them to quickly adapt to \
            your household with minimal guidance.
            <br>
            <br>
            Filipino cuisine boasts a rich diversity of flavours, ranging from sweet and sour to savoury. Rice \
            serves as the primary staple, accompanied by a variety of meat, fish, and vegetable dishes.
                        """;

    public Phil() {
        Image indoImage = GetImage("images/Phil.jpg", "philiphino");
        indoImage.setHeight("800px");
        indoImage.setWidth("800px");

        add(GetH2Heading(header), createCard(GetParagraph(body), indoImage));
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
    }

}
