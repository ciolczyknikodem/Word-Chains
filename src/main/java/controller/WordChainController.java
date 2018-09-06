package controller;

import model.ChainPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WordChainController {

    private ChainPath chainPath = new ChainPath();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexView() {
        return "index";
    }

}
