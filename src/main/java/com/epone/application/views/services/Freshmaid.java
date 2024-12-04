package com.epone.application.views.services;

import com.epone.application.EponePage;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Fresh Maids")
@Route(value = "fresh maids", layout = MainLayout.class)
public class Freshmaid extends EponePage {
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
        add(GetH2Heading(heading),
                GetImage("images/freshmaid.png", "fresh maid image"),
                GetParagraph(bodyStm1),GetParagraph(bodyStm2), GetParagraph(bodyStm3));
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
    }

}