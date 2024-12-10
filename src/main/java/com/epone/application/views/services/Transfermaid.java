package com.epone.application.views.services;

import com.epone.application.EponePage;
import com.epone.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Transfer Maids")
@Route(value = "transfer maids", layout = MainLayout.class)
public class Transfermaid extends EponePage {
    private final String heading = "<span style=\"color:green\">Transfer Maids<span>";
    private final String bodyStm1 = "Transfer maids, having recent experience in Singapore households" +
            ", typically require less supervision and are likely well-acquainted with the  culture and" +
            " lifestyle in Singapore. Being employed in Singapore, they may have picked up basic English" +
            " or Mandarin.  These are traits which may facilitate a more seamless integration" +
            " into your home and smoother communication as compared to new maids.";

    private final String bodyStm2 = """
               In most instances, transfer helpers can commence work within 3 to 4\
             working days once the change of employer has been approved by MOM.
            """;

    private final String bodyStm3 = """
            Depending on the duration and nature of domestic work of their past employment in Singapore,\
             transfer maids may request higher salaries compared to new hires.\
              Due to the shorter turnaround of local paperwork, transfer maids are often higher\
               in demand resulting in a limited pool being available.
                """;;

    public Transfermaid() {
        add(GetH2Heading(heading),
                GetImage("images/transfermaid.png", "tranfer maid image"),
                GetParagraph(bodyStm1),GetParagraph(bodyStm2), GetParagraph(bodyStm3));
        setPadding(true);
        getThemeList().add("spacing-l");
        getStyle().set("padding-left", "5%").set("padding-right", "5%");
    }

}