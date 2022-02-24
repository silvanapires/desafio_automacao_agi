package paginas;

import core.Core;
import org.openqa.selenium.By;

public class PaginaGeral extends Core {

    public String getUrlPagina(){
        return "https://blogdoagi.com.br/";
    }

    public By getMensagemValidacao() {
        return getByClassName("alert-danger");
    }

   public By getResultadoPagina(){
        return getByCss(".archive-title");
    }

}
