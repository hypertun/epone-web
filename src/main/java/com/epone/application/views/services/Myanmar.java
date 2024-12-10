package com.epone.application.views.services;

import com.epone.application.EponePage;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Myanmar Maids")
@Route(value = "myam maids", layout = MainLayout.class)
public class Myanmar extends EponePage {
    String header = "<span style=\"color:green\">Myanmar</span><span> Maids</span>";
    String body = """
            The traditional culture of Myanmar highlights the significance of family unity, compassion, and \
            reciprocal assistance. These ingrained values often improve Myanmar helpers’ naturally \
            empathetic and attentive caregivers.
            <br>
            <br>
            Families seeking caregivers for their elderly relatives often opt for Myanmar maids due to their \
            reputation for warmth, patience, and willingness to acquire new skills.
            <br>
            <br>
            Myanmar cuisine reflects influences from neighbouring nations like China, India, and Thailand, \
            similar to Singapore’s culinary scene. Notably, seafood features obviously in Myanmar cuisine \
            owing to its coastal geography.
                    """;

    public Myanmar() {
        Image indoImage = GetImage("images/myam.jpg", "myanmar");
        indoImage.setHeight("800px");
        indoImage.setWidth("800px");

        add(GetH2Heading(header), GetParagraph(body), indoImage);
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
    }

}
