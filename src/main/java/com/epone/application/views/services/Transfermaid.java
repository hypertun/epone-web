package com.epone.application.views.services;

import com.epone.application.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Transfer Maids")
@Route(value = "transfer maids", layout = MainLayout.class)
public class Transfermaid extends VerticalLayout {
    String heading = "<span style=\"color:green\">Transfer Maids<span>";
    String bodyStm1 = "Transfer maids, having recent experience in Singapore households" +
            ", typically require less supervision and are likely well-acquainted with the  culture and" +
            " lifestyle in Singapore. Being employed in Singapore, they may have picked up basic English" +
            " or Mandarin.  These are traits which may facilitate a more seamless integration" +
            " into your home and smoother communication as compared to new maids.";

    String bodyStm2 = """
               In most instances, transfer helpers can commence work within 3 to 4\
             working days once the change of employer has been approved by MOM.
            """;

    String bodyStm3 = """
            Depending on the duration and nature of domestic work of their past employment in Singapore,\
             transfer maids may request higher salaries compared to new hires.\
              Due to the shorter turnaround of local paperwork, transfer maids are often higher\
               in demand resulting in a limited pool being available.
                """;;

    public Transfermaid() {
        add(getHeading(heading),
                getImage("images/transfermaid.png", "tranfer maid image"),
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