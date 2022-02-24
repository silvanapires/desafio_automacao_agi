package paginas;

import core.Core;
import org.openqa.selenium.By;

public class PaginaPesquisa extends Core {

    public By getLupa(){
        return getById("button[id='search-open-sticky']");
    }

    public By getBotaoPesquisar(){
        return getByCss(".search-submit > input");
    }

    public By getCampoPesquisar(){
        return getByCss(".search-field > input");
    }
}
