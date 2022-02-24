package paginas;

import core.Core;
import org.openqa.selenium.By;

public class PaginaPesquisa extends Core {

    public By getLupa(){
        return getById("search-open");
    }

    public By getPesquisar(){
        return getByCss(".search-submit");
    }

    public By getCampoPesquisar(){
        return getByCss(".search-field");
    }

    public By getTitulo(){
        return getByCss(".entry-title");
    }

    public By getRetornoPesquisa(){
        return getByCss("h2[class='entry-title']");
    }
}
