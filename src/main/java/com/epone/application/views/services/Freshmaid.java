package com.epone.application.views.services;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Fresh Maids")
@Route(value = "fresh maids", layout = MainLayout.class)
public class Freshmaid extends VerticalLayout {
    String heading = "<span style=\"color:green\">Fresh Maids<span>";
    String bodyStm1 = "Fresh maids who have not worked abroad might require extra patience" +
            " and guidance when they first start on a job." +
            " But they are a clean slate which is an advantage if you would like to teach them to perform tasks in specific ways that you prefer."
            +
            " Many new maids from Indonesia and Myanmar might not speak much English but with proper support and mentoring, they can learn while on the job if they are given a chance.";

    String bodyStm2 = "Since they are in their home country when selected, it can take anywhere from 3 to 8 weeks," +
            " depending on their nationality, to complete local paperwork before they can come to your home.";

    String bodyStm3 = "New maids usually earn less than experienced ones. Still, they are not necessarily worse at their job because they have been trained.";

    public Freshmaid() {
        add(getHeading(heading),
                getImage("images/freshmaid.png", "fresh maid image"),
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