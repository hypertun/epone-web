package com.epone.application.views.services;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Philippines Maids")
@Route(value = "phil maids", layout = MainLayout.class)
public class Phil extends VerticalLayout {
    String header = "<span style=\"color:green\">Philippines</span><span> Maids</span>";
    String body = """
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
        Image indoImage = new Image("images/Phil.jpg", "philiphino");
        indoImage.setHeight("800px");
        indoImage.setWidth("800px");

        Paragraph bodypara = new Paragraph(body);
        bodypara.getElement().setProperty("innerHTML", body);

        add(getHeading(header), bodypara, indoImage);
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
    }

    private H2 getHeading(String html) {
        H2 heading = new H2();
        heading.getElement().setProperty("innerHTML", html);
        heading.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        return heading;
    }
}
