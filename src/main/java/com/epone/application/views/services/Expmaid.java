package com.epone.application.views.services;

import com.epone.application.EponePage;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Experienced Maids")
@Route(value = "exp maids", layout = MainLayout.class)
public class Expmaid extends EponePage {
    String heading = "<span style=\"color:green\">Experienced Maids<span>";
    String bodyStm1 = "Experienced maids typically require significantly less training and supervision" +
            " compared to new maids, as they come equipped with skills and knowledge acquired from their previous employment. Having gained valuable work experience abroad"
            +
            ", these maids are often more multilingual and/or possess greater language proficiency; those with experience in Taiwan and Hong Kong will likely be proficient in Mandarin and Cantonese respectively.";
    String bodyStm2 = "Since they are in their home country during the selection and application process, the waiting time for the maid to arrive at your home may vary between 3 to 8 weeks, depending on her nationality.";
    String bodyStm3 = "Due to their previous overseas work experience, experienced maids typically request higher salaries compared to new hires, with variations based on the duration of their previous employment and their language proficiency.";

    public Expmaid() {
        add(GetH2Heading(heading),
                GetImage("images/experiencedmaid.png", "exp maid image"),
                GetParagraph(bodyStm1), GetParagraph(bodyStm2), GetParagraph(bodyStm3));
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
    }
}
