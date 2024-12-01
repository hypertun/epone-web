package com.epone.application.views.services;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Direct Hire Maids")
@Route(value = "direct hire maids", layout = MainLayout.class)
public class Directhiremaid extends VerticalLayout {
    String heading = "<span style=\"color:green\">Direct Hire Maids<span>";
    String bodyStm1 = """
        Direct hiring involves employers sourcing their own maids directly from their home countries.\
         These maids are typically discovered through the employer’s personal connections, such as recommendations from family, friends,\
          or former maids who have returned to their home countries. Although employers are able to interview and select a maid who fits their household requirements on their own,\
           the necessary paperwork required, both foreign and in Singapore may pose a challenge for employers. EP One Manpower can help to handle all required end-to-end documentation.
        """;

   
    public Directhiremaid() {
        add(getHeading(heading),
                getImage("images/directhiremaid.png", "direct hire image"),
                new Paragraph(bodyStm1));
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

    private Image getImage(String imageLoc, String imageName) {
        Image im = new Image(imageLoc, imageName);
        im.setHeight("300px");
        im.setWidth("300px");
        return im;
    }

}