package com.epone.application.views.services;

import com.epone.application.EponePage;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Indonesian Maids")
@Route(value = "indo maids", layout = MainLayout.class)
public class Indo extends EponePage {
    private final String header = "<span style=\"color:green\">Indonesian</span><span> Maids</span>";
    private final String body = """
            They communicate mainly in Bahasa Indonesia, which bears similarity to Bahasa Melayu, a \
            language commonly spoken by elderly Singaporeans. Majority of the younger Indonesian helpers \
            can communicate in English fluently due to their educational system. Some are proficient in \
            Mandarin or even local dialects depending on their experience levels. \
            <br>
            <br>
            The cultural similarities shared between Indonesia and Singapore, including common traditions, \
            festivals, and culinary preferences, facilitate the seamless integration of Indonesian helpers into \
            Singaporean households.
            <br>
            <br>
            Moreover, Indonesian food traditions resonate well with most Singaporean families, with \
            popular dishes like Ayam Penyet, Nasi Goreng, Satay, and others being widely enjoyed across \
            the island.
                """;

    public Indo() {
        Image indoImage = GetImage("images/indo.png", "indonesian");
        indoImage.setHeight("800px");
        indoImage.setWidth("800px");

        add(GetH2Heading(header), createCard(GetParagraph(body), indoImage));
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
    }
}
