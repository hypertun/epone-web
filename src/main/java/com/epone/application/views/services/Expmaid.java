package com.epone.application.views.services;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Experienced Maids")
@Route(value = "exp maids", layout = MainLayout.class)
public class Expmaid extends VerticalLayout {
    String heading = "<span style=\"color:green\">Experienced Maids<span>";
    String bodyStm1 = "Experienced maids typically require significantly less training and supervision" +
            " compared to new maids, as they come equipped with skills and knowledge acquired from their previous employment. Having gained valuable work experience abroad"
            +
            ", these maids are often more multilingual and/or possess greater language proficiency; those with experience in Taiwan and Hong Kong will likely be proficient in Mandarin and Cantonese respectively.";
    String bodyStm2 = "Since they are in their home country during the selection and application process, the waiting time for the maid to arrive at your home may vary between 3 to 8 weeks, depending on her nationality.";
    String bodyStm3 = "Due to their previous overseas work experience, experienced maids typically request higher salaries compared to new hires, with variations based on the duration of their previous employment and their language proficiency.";

    public Expmaid() {
        add(getHeading(heading),
                getImage("images/experiencedmaid.png", "exp maid image"),
                new Paragraph(bodyStm1), new Paragraph(bodyStm2), new Paragraph(bodyStm3));
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
