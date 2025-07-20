package com.epone.application.views.services;

import com.epone.application.EponePage;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Direct Hire Maids")
@Route(value = "direct hire maids", layout = MainLayout.class)
public class Directhiremaid extends EponePage {
    private final String heading = "<span style=\"color:green\">Direct Hire Maids<span>";
    private final String bodyStm1 = """
            Direct hiring involves employers sourcing their own maids directly from their home countries.\
             These maids are typically discovered through the employer’s personal connections, such as recommendations from family, friends,\
              or former maids who have returned to their home countries. Although employers are able to interview and select a maid who fits their household requirements on their own,\
               the necessary paperwork required, both foreign and in Singapore may pose a challenge for employers. EP One Manpower can help to handle all required end-to-end documentation.
            """;

    public Directhiremaid() {
        add(GetH2Heading(heading),
        createCard( GetImage("images/directhiremaid.png", "direct hire image"),
                GetParagraph(bodyStm1)));
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
    }

}